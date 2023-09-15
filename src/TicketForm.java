import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.ArrayList;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class TicketForm extends JFrame {

	private JPanel contentPane;
	private boolean isTravelExist = false;
	private JButton btnBack;
	
	
	public TicketForm() {
		super("Bilet Satın Al");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(450, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//contentPane.setBackground(new Color(227, 233, 238));
		cust.customPanel(contentPane);
		setContentPane(contentPane);
		
		
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(211, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDestination = new JLabel("To");
		lblDestination.setBounds(211, 103, 46, 14);
		contentPane.add(lblDestination);
		
		JComboBox source = new JComboBox(City.getTurkeyCities());
		source.setBounds(250, 58, 110, 22);
		contentPane.add(source);
		
		JComboBox destination = new JComboBox(City.getTurkeyCities());
		destination.setBounds(250, 99, 110, 22);
		contentPane.add(destination);
		
		
		
		JButton btnNewButton = new JButton("Buy Ticket");
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(61, 58, 118, 20);
		
		
		btnNewButton.setBounds(250, 141, 110, 22);
		cust.customButton(btnNewButton);
		contentPane.add(btnNewButton);
		
		contentPane.add(dateChooser);
		
		JLabel lblWarning = new JLabel("New label");
		lblWarning.setBounds(250, 200, 120, 14);
		contentPane.add(lblWarning);
		lblWarning.setVisible(false);
		 
		ArrayList<Travel> travel_list = new ArrayList<Travel>();
		ArrayList<Travel> choosen_travel = new ArrayList<Travel>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("Travel.txt"),StandardCharsets.UTF_8));
			String input, str[];
			while((input = reader.readLine()) != null) {
				str = input.split("\t");
				travel_list.add(new Travel(new City(str[0]),new City(str[1]),str[2],str[3],str[4],Integer.parseInt(str[5]), str[6]));
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateChooser.getDate() == null) {
					lblWarning.setText("Lütfen tarih seçiniz");
					lblWarning.setForeground(Color.red);
					lblWarning.setVisible(true);
					
				}
				String date[] = dateChooser.getDate().toString().split(" ");
				
				String my_date =date[2]+"."+change_date(date) +"."+date[5];
				
				
				for (int i = 0; i < travel_list.size(); i++) {
				
					if(source.getSelectedItem().toString().equalsIgnoreCase(travel_list.get(i).getSource().getCity_Name()) 
							&& destination.getSelectedItem().toString().equalsIgnoreCase(travel_list.get(i).getDestination().getCity_Name()) && my_date.equalsIgnoreCase(travel_list.get(i).getDate())) {
						choosen_travel.add(travel_list.get(i));
						isTravelExist=true;
					}
				}
				
				
					if(isTravelExist) {
						ChooseTravel choose_travel = new ChooseTravel(choosen_travel);
						choose_travel.setVisible(true);
						setVisible(false);
					}
					else {
						lblWarning.setText("Yolculuk bulunamadı");
						lblWarning.setForeground(Color.red);
						lblWarning.setVisible(true);
					}
				
			}
		});
		
		btnBack = new JButton("<-- Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lf = new LoginForm();
				lf.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(250, 168, 89, 23);
		cust.customBackButton(btnBack);
		contentPane.add(btnBack);
		
	}
	public String change_date(String[] date) {
		//Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec
		if(date[1].equals("Jan")) {
			return "01";
		}
		else if(date[1].equals("Feb")) {
			return "02";
		}
		else if(date[1].equals("Mar")) {
			return "03";
		}
		else if(date[1].equals("Apr")) {
			return "04";
		}
		else if(date[1].equals("May")) {
			return "05";
		}
		else if(date[1].equals("Jun")) {
			return "06";
		}
		else if(date[1].equals("Jul")) {
			return "07";
		}
		else if(date[1].equals("Aug")) {
			return "08";
		}
		else if(date[1].equals("Sep")) {
			return "09";
		}
		else if(date[1].equals("Oct")) {
			return "10";
		}
		else if(date[1].equals("Nov")) {
			return "11";
		}
		else if(date[1].equals("Dec")) {
			return "12";
		}
		return "";
	}
}
