import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;

public class Payment_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField txtFullName;
	private JTextField txtCardNumber;
	private JTextField txtExpDate;
	private JTextField txtCVV;
	

	public Payment_Panel(String tableCells[],ArrayList<Integer> arr,String gelen[]) {
		super("Payment Panel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		setContentPane(contentPane);
		cust.customPanel(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullName = new JLabel("Name Surname");
		lblFullName.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblFullName.setBounds(45, 39, 98, 28);
		contentPane.add(lblFullName);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblCardNumber.setBounds(45, 93, 98, 28);
		contentPane.add(lblCardNumber);
		
		JLabel lblExpDate = new JLabel("Expiration Date");
		lblExpDate.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblExpDate.setBounds(45, 152, 98, 17);
		contentPane.add(lblExpDate);
		
		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblCVV.setBounds(45, 205, 98, 17);
		contentPane.add(lblCVV);
		
		txtFullName = new JTextField();
		txtFullName.setBounds(176, 41, 86, 20);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(176, 95, 86, 20);
		contentPane.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		txtExpDate = new JTextField();
		txtExpDate.setBounds(176, 148, 86, 20);
		contentPane.add(txtExpDate);
		txtExpDate.setColumns(10);
		
		txtCVV = new JTextField();
		txtCVV.setBounds(176, 201, 86, 20);
		contentPane.add(txtCVV);
		txtCVV.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("<html>Thank you for <br/>\r\nyour purchase</html>");
		lblNewLabel_4.setFont(new Font("Calibri Light", Font.BOLD, 16));
		lblNewLabel_4.setBounds(286, 150, 138, 100);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		
		JLabel lblWarning = new JLabel("New label");
		lblWarning.setBounds(210, 236, 214, 14);
		contentPane.add(lblWarning);
		lblWarning.setVisible(false);
		
		
		JButton btnBuy = new JButton("BUY");
		cust.customButton(btnBuy);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtFullName.getText().equals("") || txtExpDate.getText().equals("") || txtCardNumber.getText().equals("") || txtCVV.getText().equals("")) {
					lblWarning.setVisible(true);
					lblWarning.setText("Lütfen tüm alanları doldurunuz");
					lblWarning.setForeground(Color.red);
					
					
				}
				else {
					lblNewLabel_4.setVisible(true);
					
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Travel.txt"),StandardCharsets.UTF_8));
						
						for (int i = 0; i < arr.size(); i++) {
							gelen[arr.get(i)-1] = "T";
						}
						
						
						String input,str[];
						String busssss[];
						ArrayList<String> field = new ArrayList<String>();
						while ((input = reader.readLine()) != null) {
							str = input.split("\t");
							if (tableCells[0].equals(str[0]) && tableCells[1].equals(str[1]) && tableCells[2].equals(str[2]) && tableCells[3].equals(str[3]) &&
									tableCells[4].equals(str[4]) && tableCells[5].equals(str[5]) &&  tableCells[6].equals(str[6])) {
								busssss = str[7].split("-");
								for (int i = 0; i < busssss.length; i++) {
									busssss[i] = gelen[i];
								}
								String abc = str[0]+"\t"+str[1]+"\t"+str[2]+"\t"+str[3]+"\t"+str[4]+"\t"+str[5]+"\t"+str[6]+"\t";
								
								for (int j = 0; j < gelen.length; j++) {
									if (j == gelen.length-1) {
										abc += gelen[j];
									}
									else {
										abc += gelen[j]+"-";
									}
								}
								
								field.add(abc);
							}
							else {
								field.add(input);
							}
						}
						reader.close();
						
						FileWriter myWriter = new FileWriter("Travel.txt");
						
					      for(String str1 : field) {
							myWriter.append(str1 + "\n");
						}				     
					      myWriter.close();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					LoginForm lg = new LoginForm();
					lg.getFrame().setVisible(true);
					setVisible(false);
				}
				
			}
		});
		
		
		btnBuy.setBounds(300, 112, 110, 36);
		contentPane.add(btnBuy);
		
		
		
		
	}
}
