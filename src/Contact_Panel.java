import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contact_Panel extends JFrame {

	private JPanel contentPane;

	
	public Contact_Panel() {
		super("Contact");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ümit Samur 2018510098 umit.samur@ceng.deu.edu.tr");
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 414, 84);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alper Can Boyraz 2018510096 alpercan.boyraz@ceng.deu.edu.tr");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 99, 414, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Muhammed Huseyin Koclar 2018510046 muhammedhuseyin.koclar@ceng.deu.edu.tr");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 170, 527, 66);
		contentPane.add(lblNewLabel_2);
		
		JButton btnBack = new JButton("<-- Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lg = new LoginForm();
				lg.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		cust.customBackButton(btnBack);
		btnBack.setBounds(425, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
