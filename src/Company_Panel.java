
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Company_Panel extends JFrame {

	private JPanel contentPane;
	private JTextField txtCompanyName;
	private Company_Management company_management;
	private String companyName;
	private JPasswordField txtCompanyPassword;
	private JLabel lblWarning;
	private boolean isExistCompany=false;
	private JButton btnBack;

	public Company_Panel() {
		super("Company Login Panel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cust.customPanel(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCompanyName = new JLabel("Company Name :");
		lblCompanyName.setBounds(45, 69, 170, 23);
		lblCompanyName.setFont(new Font("Algerian", Font.PLAIN,14));
		contentPane.add(lblCompanyName);
		
		JLabel lblCompanyPassword = new JLabel("Company Password :");
		lblCompanyPassword.setBounds(45, 103, 170, 23);
		lblCompanyPassword.setFont(new Font("Algerian", Font.PLAIN,14));
		contentPane.add(lblCompanyPassword);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setBounds(217, 70, 140, 20);
		contentPane.add(txtCompanyName);
		txtCompanyName.setColumns(10);
		txtCompanyName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblWarning.setVisible(false);
			}
		});
		
		
		txtCompanyPassword = new JPasswordField();
		txtCompanyPassword.setBounds(217, 103, 140, 20);
		contentPane.add(txtCompanyPassword);
		txtCompanyPassword.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		
		JButton btnSubmit = new JButton("Enter");
		cust.customButton(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login();
					
			
			}
		});
		btnSubmit.setBounds(217, 153, 140, 35);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(52,73,94));
		btnSubmit.setFont(new Font("Algerian", Font.BOLD, 14));
		
		contentPane.add(btnSubmit);
		
		lblWarning = new JLabel("New label");
		lblWarning.setBounds(217, 236, 180, 14);
		lblWarning.setVisible(false);
		contentPane.add(lblWarning);
		
		btnBack = new JButton("<-- Back");
		cust.customBackButton(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lg = new LoginForm();
				lg.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(249, 199, 89, 23);
		contentPane.add(btnBack);
		
		
	}
	
	public void login() {
		try {
		      File myObj = new File("company.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] word = data.split("\t");
		        
		        if(word[0].equals(txtCompanyName.getText()) && word[1].equals(txtCompanyPassword.getText())) {
		        	company_management = new Company_Management(new Company(txtCompanyName.getText(), txtCompanyPassword.getText()));
	                company_management.setVisible(true);
	                isExistCompany = true;
	                setVisible(false);
		        }
		        else if(txtCompanyName.getText().equals("") || txtCompanyPassword.getText().equals("")) {
		        	lblWarning.setForeground(Color.RED);
		        	lblWarning.setText("Enter your personal info");
		        	lblWarning.setVisible(true);
		        }
		        
		         System.out.println(data);
		      }
		      myReader.close();
		      if (!isExistCompany) {
		    	lblWarning.setForeground(Color.RED);
		        lblWarning.setText("Account has been not found");
		        lblWarning.setVisible(true);
				
		      }
		    } catch (FileNotFoundException ex) {
		      System.out.println("An error occurred.");
		      ex.printStackTrace();
		    }
			
	
	}
}

