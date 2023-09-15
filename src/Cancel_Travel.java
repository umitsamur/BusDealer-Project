
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Cancel_Travel extends JFrame {

	private boolean isTravelExist = false;
	private JPanel contentPane;
	private JTextField txtEnterSource;
	private JTextField txtEnterDestination;
	private JTextField txtEnterTime;
	private JTextField txtEnterDate;
	private JTextField txtPrice;
	private JLabel lblNewLabel_5;
	private JComboBox cmbBusType;


	public Cancel_Travel(Company company) {
		super("Cancel Travel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(450,300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(214, 219, 223));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Source :");
		lblNewLabel.setBounds(54, 26, 100, 22);
		contentPane.add(lblNewLabel);
		
		txtEnterSource = new JTextField();
		txtEnterSource.setBounds(200, 27, 105, 20);
		contentPane.add(txtEnterSource);
		txtEnterSource.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Destination :");
		lblNewLabel_1.setBounds(54, 59, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEnterDestination = new JTextField();
		txtEnterDestination.setBounds(200, 56, 105, 20);
		contentPane.add(txtEnterDestination);
		txtEnterDestination.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Time :");
		lblNewLabel_2.setBounds(54, 86, 100, 22);
		contentPane.add(lblNewLabel_2);
		
		txtEnterTime = new JTextField();
		txtEnterTime.setBounds(200, 87, 105, 20);
		contentPane.add(txtEnterTime);
		txtEnterTime.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Date :");
		lblNewLabel_3.setBounds(54, 115, 100, 27);
		contentPane.add(lblNewLabel_3);
		
		txtEnterDate = new JTextField();
		txtEnterDate.setBounds(200, 118, 105, 20);
		contentPane.add(txtEnterDate);
		txtEnterDate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Number of seat:");
		lblNewLabel_4.setBounds(54, 185, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Price: ");
		lblNewLabel_5.setBounds(54, 153, 105, 14);
		contentPane.add(lblNewLabel_5);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(200, 149, 105, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		cmbBusType = new JComboBox(Bus.getBusType());
		cmbBusType.setBounds(200, 181, 105, 22);
		contentPane.add(cmbBusType);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> arr = new ArrayList<>();
				Travel t1 = new Travel(
						new City(txtEnterSource.getText()), 
						new City(txtEnterDestination.getText()), 
						txtEnterTime.getText(), 
						txtEnterDate.getText(),
						company.getCompany_Name(),
						Integer.parseInt( txtPrice.getText()),
						cmbBusType.getSelectedItem().toString());
				try {
				      File myObj = new File("Travel.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				    	  String data1 = myReader.nextLine();
				    	String data[] = data1.split("	");
				    	
				        if(txtEnterSource.getText().equalsIgnoreCase(data[0]) && txtEnterDestination.getText().equalsIgnoreCase(data[1]) && 
				        		txtEnterTime.getText().equalsIgnoreCase(data[2]) && txtEnterDate.getText().equalsIgnoreCase(data[3]) && 
				        		company.getCompany_Name().equalsIgnoreCase(data[4]) && txtPrice.getText().equalsIgnoreCase(data[5]) && 
				        		cmbBusType.getSelectedItem().equals(data[6])) {}
				        else {
				        	arr.add(data1);
				        }
				      }
				      FileWriter myWriter = new FileWriter("Travel.txt");
				      
				      for(String str : arr) {
						myWriter.append(str + "\n");
					}				      
				      myReader.close();
				      myWriter.close();
				    } catch (FileNotFoundException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		btnNewButton.setBounds(205, 227, 89, 23);
		cust.customButton(btnNewButton);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
