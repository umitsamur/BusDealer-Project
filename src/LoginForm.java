import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {
	private JFrame frame;
	private JPanel contentPane;
	
	private TicketForm tf ;
	private Admin_Login_Panel admin_login ;
	private Company_Panel company_panel ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					LoginForm frame = new LoginForm();
					frame.setVisible(true);*/
					LoginForm lgform = new LoginForm();
					lgform.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public LoginForm() {
		Customizer cust = Customizer.getInstance();
		frame = new JFrame();
		frame.setTitle("Login Form");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		cust.centreWindow(frame);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(214, 219, 223));
		
		JButton btnBuyTicket = new JButton("Buy Ticket");
		btnBuyTicket.setBackground(new Color(52,73,94));
		btnBuyTicket.setForeground(Color.WHITE);
		//btnBuyTicket.setFont(new Font("Algerian", Font.BOLD, 12));
		btnBuyTicket.setBounds(152, 60, 116, 30);
		
		btnBuyTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tf = new TicketForm();
                tf.setVisible(true);
                frame.setVisible(false);
                
			}
		});
		cust.customButton(btnBuyTicket);
		
		
		
		contentPane.add(btnBuyTicket);
		
		JButton btnContact = new JButton("Contact");
		btnContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Contact_Panel cp = new Contact_Panel();
				cp.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnContact.setForeground(Color.WHITE);
		//btnContact.setFont(new Font("Algerian", Font.BOLD, 12));
		btnContact.setBackground(new Color(52,73,94));
		btnContact.setBounds(152, 120, 116, 30);
		cust.customButton(btnContact);
		contentPane.add(btnContact);
		
		JLabel lblAdmin = new JLabel("Admin");
		cust.customLabel(lblAdmin);
		lblAdmin.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				admin_login = new Admin_Login_Panel();
                admin_login.setVisible(true);
                frame.setVisible(false);
			}
		});
		lblAdmin.setBounds(345, 221, 90, 29);
		lblAdmin.setFont(new Font("Algerian", Font.BOLD,18));
		contentPane.add(lblAdmin);
		
		JLabel lblCompany = new JLabel("Company");
		cust.customLabel(lblCompany);
		lblCompany.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				company_panel = new Company_Panel();
                company_panel.setVisible(true);
                frame.setVisible(false);
			}
		});
		lblCompany.setBounds(30, 221, 90, 29);
		lblCompany.setFont(new Font("Algerian", Font.BOLD,18));
		contentPane.add(lblCompany);
		
	}
	
	
	
	public JFrame getFrame() {
		return frame;
	}
	
}
