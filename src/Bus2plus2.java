import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bus2plus2 extends JFrame {

	private JPanel contentPane, panel;
	private String bus_seat[] = new String[24];
	
	
	
	public Bus2plus2(String tableCells[]) {
		super("2+2 Bus");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 400);
		cust.centreWindow(this);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 270, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		int btnX=10, btnY=19;
		for (int i = 0; i < 24; i++) {
			
			if (i%2==0 && i!=0) {
				if (i%4!=0) {
					btnX+=35;
				}
				else {
					btnY += 51;
					btnX= 10;
				}
			}
			
			
			JButton btn = new JButton(String.valueOf(i+1));
			btn.setBounds(btnX,btnY,50,50);
			panel.add(btn);
			buttons.add(btn);
			cust.customBusButton(btn);
			btnX+=57;
		}
		
		
		
		
		Color busRed = new Color(231, 76, 60);
		Color busGreen = new Color(46,204,113);
		
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("Travel.txt"), StandardCharsets.UTF_8));
			String input,str[];
			while ((input = reader.readLine()) != null) {
				str = input.split("\t");
				if (str[0].equals(tableCells[0]) && str[1].equals(tableCells[1]) && str[2].equals(tableCells[2]) && str[3].equals(tableCells[3]) 
						&& str[4].equals(tableCells[4]) && str[5].equals(tableCells[5])
						&& str[6].equals(tableCells[6])) {
					bus_seat = str[str.length-1].split("-");
				}
			}
			reader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < bus_seat.length; i++) {
			cust.customBusButton(buttons.get(i));
			if (bus_seat[i].equals("F")) {
				buttons.get(i).setBackground(busGreen);
			}
			else {
				buttons.get(i).setBackground(busRed);
				buttons.get(i).setEnabled(false);
				
			}
		}
		
		for (JButton button : buttons) {
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if (button.getBackground().equals(busGreen) && !button.getBackground().equals(busRed)) {
						button.setBackground(new Color(241, 196, 15));
					}
					else if (button.getBackground().equals(busRed)) {
						button.setEnabled(false);
					}
					else {
						button.setBackground(busGreen);
					}
				}
			});
		}
		
		
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for (JButton button : buttons) {
					if (button.getBackground().equals(new Color(241, 196, 15))) {
						arr.add(Integer.parseInt(button.getText()));
					}
				}
				if (arr.size() > 0) {
					Payment_Panel pp = new Payment_Panel(tableCells,arr,bus_seat);
					pp.setVisible(true);
				}
				else {
					System.out.println("İşleme devam edebilmek için koltuk seçmeniz gerekmektedir.");
				}
			}
		});
		btnBuy.setBounds(391, 99, 89, 23);
		cust.customButton(btnBuy);
		contentPane.add(btnBuy);
		
		JButton btnBack = new JButton("<-- Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketForm tf = new TicketForm();
				tf.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(391, 195, 89, 23);
		cust.customBackButton(btnBack);
		contentPane.add(btnBack);
	}
}
