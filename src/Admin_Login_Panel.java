import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Admin_Login_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Admin admins[] = new Admin[4];
	private boolean isExistAdmin = false;
	
	private Admin_Panel admin_panel;
	private JLabel lblWarning;
	private JButton btnBack;
	
	
	public Admin_Login_Panel() {
		super("Admin Login Panel");
		Admin admin1= new Admin("alper", "boyraz", "male", "march", "izmir", "alpercan");
		Admin admin2= new Admin("admin", "admin", "male", "march", "izmir", "admin");
		Admin admin3= new Admin("hüseyin", "koçlar", "male", "march", "izmir", "goçlar");
		Admin admin4= new Admin("ümit", "samur", "male", "march", "izmir", "samur");
		
		Customizer cust = Customizer.getInstance();
		
		admins[0] = admin1;
		admins[1] = admin2;
		admins[2] = admin3;
		admins[3] = admin4;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cust.customPanel(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(110, 77, 94, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(110, 113, 124, 23);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(214, 81, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 117, 120, 20);
		passwordField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		contentPane.add(passwordField);
		
		lblWarning = new JLabel();
		lblWarning.setBounds(214, 230, 170, 20);
		lblWarning.setVisible(false);
		contentPane.add(lblWarning);
		
		cust.focusTextField(textField, lblWarning);
		cust.focusTextField(passwordField, lblWarning);
		
		JButton btnNewButton = new JButton("Login");
		cust.customButton(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton.setBounds(230, 160, 89, 23);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Algerian", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(52,73,94));
		
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("<-- Back");
		cust.customBackButton(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lg = new LoginForm();
				lg.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(230, 196, 89, 23);
		contentPane.add(btnBack);
		
		
	}
	
	public void login() {
		
		if (textField.getText().equals("") || passwordField.getText().equals("")) {
			lblWarning.setText("You must be filled in textfield");
			lblWarning.setForeground(Color.red);
			lblWarning.setVisible(true);
		}
		
		else {
			for (int i = 0; i < admins.length; i++) {
				if(textField.getText().equals((Object)admins[i].getName()) && passwordField.getText().equals((Object)admins[i].getPassword()) ) {
					admin_panel = new Admin_Panel();
	                admin_panel.setVisible(true);
	                isExistAdmin = true;
	                setVisible(false);
				}
			}
			if (!isExistAdmin) {
				lblWarning.setText("Admin has been not found");
				lblWarning.setForeground(Color.red);
				lblWarning.setVisible(true);
			}
		}
		
	
	}
}
