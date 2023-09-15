import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

public class Bus2plus1 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private String bus_seat[] = new String[18];

	public Bus2plus1(String[] tableCells) {
		super("2+1 Bus");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 400);
		cust.centreWindow(this);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ArrayList<JButton> buttons = new ArrayList<>();

		panel = new JPanel();
		panel.setBounds(10, 10, 236, 343);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton s1 = new JButton("1");
		s1.setBounds(10, 19, 50, 50);
		panel.add(s1);

		JButton s2 = new JButton("2");
		s2.setBounds(119, 19, 50, 50);
		panel.add(s2);

		JButton s3 = new JButton("3");
		s3.setBounds(176, 19, 50, 50);
		panel.add(s3);

		JButton s4 = new JButton("4");
		s4.setBounds(10, 70, 50, 50);
		panel.add(s4);

		JButton s5 = new JButton("5");
		s5.setBounds(119, 70, 50, 50);
		panel.add(s5);

		JButton s6 = new JButton("6");
		s6.setBounds(176, 70, 50, 50);
		panel.add(s6);

		JButton s7 = new JButton("7");
		s7.setBounds(10, 121, 50, 50);
		panel.add(s7);

		JButton s8 = new JButton("8");
		s8.setBounds(119, 121, 50, 50);
		panel.add(s8);

		JButton s9 = new JButton("9");
		s9.setBounds(176, 121, 50, 50);
		panel.add(s9);

		JButton s10 = new JButton("10");
		s10.setBounds(10, 172, 50, 50);
		panel.add(s10);

		JButton s11 = new JButton("11");
		s11.setBounds(119, 172, 50, 50);
		panel.add(s11);

		JButton s12 = new JButton("12");
		s12.setBounds(176, 172, 50, 50);
		panel.add(s12);

		JButton s13 = new JButton("13");
		s13.setBounds(10, 223, 50, 50);
		panel.add(s13);

		JButton s14 = new JButton("14");
		s14.setBounds(119, 223, 50, 50);
		panel.add(s14);

		JButton s15 = new JButton("15");
		s15.setBounds(176, 223, 50, 50);
		panel.add(s15);

		JButton s16 = new JButton("16");
		s16.setBounds(10, 274, 50, 50);
		panel.add(s16);

		JButton s17 = new JButton("17");
		s17.setBounds(119, 274, 50, 50);
		panel.add(s17);

		JButton s18 = new JButton("18");
		s18.setBounds(176, 274, 50, 50);
		panel.add(s18);

		buttons.add(s1);
		buttons.add(s2);
		buttons.add(s3);
		buttons.add(s4);
		buttons.add(s5);
		buttons.add(s6);
		buttons.add(s7);
		buttons.add(s8);
		buttons.add(s9);
		buttons.add(s10);
		buttons.add(s11);
		buttons.add(s12);
		buttons.add(s13);
		buttons.add(s14);
		buttons.add(s15);
		buttons.add(s16);
		buttons.add(s17);
		buttons.add(s18);

		Color busRed = new Color(231, 76, 60);
		Color busGreen = new Color(46, 204, 113);

		BufferedReader reader;
		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("Travel.txt"), StandardCharsets.UTF_8));
			String input, str[];
			int i = 0;
			while ((input = reader.readLine()) != null) {
				str = input.split("\t");
				if (str[0].equals(tableCells[0]) && str[1].equals(tableCells[1]) && str[2].equals(tableCells[2])
						&& str[3].equals(tableCells[3]) && str[4].equals(tableCells[4]) && str[5].equals(tableCells[5])
						&& str[6].equals(tableCells[6])) {
					bus_seat = str[str.length - 1].split("-");
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
			} else {
				buttons.get(i).setBackground(busRed);
				buttons.get(i).setEnabled(false);

			}
		}

		for (JButton btnBack : buttons) {
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					if (btnBack.getBackground().equals(busGreen) && !btnBack.getBackground().equals(busRed)) {
						btnBack.setBackground(new Color(241, 196, 15));
					} else if (btnBack.getBackground().equals(busRed)) {
						btnBack.setEnabled(false);
					} else {
						btnBack.setBackground(busGreen);
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
					Payment_Panel pp = new Payment_Panel(tableCells, arr, bus_seat);
					pp.setVisible(true);
				} else {
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
