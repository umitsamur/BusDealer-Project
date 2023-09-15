import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class add_Company_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField txtCompanyName;
	private JTextField txtCompanyPassword;
	private JLabel lblWarning;

	
	
	public add_Company_Panel() {
		super("Add Company Panel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		cust.customPanel(contentPane);
		cust.centreWindow(this);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Company Name :");
		lblNewLabel.setBounds(71, 80, 136, 23);
		contentPane.add(lblNewLabel);

		JLabel lblEnterCompanyPassword = new JLabel("Enter Company Password :");
		lblEnterCompanyPassword.setBounds(71, 114, 170, 23);
		contentPane.add(lblEnterCompanyPassword);
		
		lblWarning = new JLabel("New label");
		lblWarning.setBounds(246, 203, 180, 14);
		lblWarning.setVisible(false);
		contentPane.add(lblWarning);

		txtCompanyName = new JTextField();
		txtCompanyName.setBounds(246, 81, 120, 20);
		contentPane.add(txtCompanyName);
		txtCompanyName.setColumns(10);
		cust.focusTextField(txtCompanyName, lblWarning);

		txtCompanyPassword = new JTextField();
		txtCompanyPassword.setBounds(246, 115, 120, 20);
		contentPane.add(txtCompanyPassword);
		txtCompanyPassword.setColumns(10);
		cust.focusTextField(txtCompanyPassword, lblWarning);
		

		JButton btnNewButton = new JButton("Apply");
		cust.customButton(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCompanyName.getText().equals("") || txtCompanyPassword.getText().equals("")) {
					lblWarning.setVisible(true);
					lblWarning.setForeground(Color.red);
					lblWarning.setText("You must be fill in textbox");
				} else {
					Company c1 = new Company(txtCompanyName.getText(), txtCompanyPassword.getText());
					try {
						FileWriter myWriter = new FileWriter("company.txt", true);
						myWriter.append(c1.getCompany_Name() + "\t" + c1.getPassword() + "\n");
						myWriter.close();
						System.out.println("Successfully wrote to the file.");
					} catch (IOException ex) {
						System.out.println("An error occurred.");
						ex.printStackTrace();
					}
					
				}

				txtCompanyName.setText("");
				txtCompanyPassword.setText("");
			}

		});
		btnNewButton.setBounds(263, 161, 86, 23);
		contentPane.add(btnNewButton);
		
		
	}

}
