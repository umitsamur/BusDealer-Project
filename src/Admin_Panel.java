import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Admin_Panel extends JFrame {

	private JPanel contentPane;
	private add_Company_Panel add_company;
	
	
	
	public Admin_Panel() {
		super("Admin Panel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,300);
		
		cust.centreWindow(this);
		contentPane = new JPanel();
		cust.customPanel(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Company");
		
		cust.customButton(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_company = new add_Company_Panel();
                add_company.setVisible(true);
                
				
			}
		});
		btnNewButton.setBounds(151, 88, 150, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTravelDisplay = new JButton("Travel Display");
		cust.customButton(btnTravelDisplay);
		
		btnTravelDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TravelList tlist = new TravelList();
				tlist.setVisible(true);
				
			}
		});
		btnTravelDisplay.setBounds(151, 127, 150, 23);
		
		contentPane.add(btnTravelDisplay);
		
		JButton companyDisplay = new JButton("Company Display");
		companyDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CompanyList cl = new CompanyList();
				cl.setVisible(true);
			}
		});
		companyDisplay.setBounds(151, 165, 150, 23);
		cust.customButton(companyDisplay);
		contentPane.add(companyDisplay);
		
		JButton btnBack = new JButton("<-- Back");
		cust.customBackButton(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lg = new LoginForm();
				lg.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
