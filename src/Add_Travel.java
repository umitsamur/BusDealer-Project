
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Add_Travel extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterSource;
	private JTextField txtEnterDestination;
	private JTextField txtEnterTime;
	private JTextField txtEnterDate;
	private JTextField txtPrice;
	private JLabel lblNewLabel_5;
	private JComboBox cmbBusType;

	public Add_Travel(Company company) {
		super("Add Travel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(450, 300);
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

		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Travel t1 = new Travel(new City(txtEnterSource.getText()), new City(txtEnterDestination.getText()),
						txtEnterTime.getText(), txtEnterDate.getText(), company.getCompany_Name(),
						Integer.parseInt(txtPrice.getText()), cmbBusType.getSelectedItem().toString());
				try {
					int busSeat = 0;
					FileWriter myWriter = new FileWriter("Travel.txt", true);
					myWriter.append(t1.getSource().getCity_Name() + "\t" + t1.getDestination().getCity_Name() + "\t"
							+ t1.getTime() + "\t" + t1.getDate() + "\t" + company.getCompany_Name() + "\t"
							+ txtPrice.getText() + "\t" + cmbBusType.getSelectedItem() + "\t");
					
					
					if (cmbBusType.getSelectedItem().toString().equals("2+1")) {
						 busSeat = 18;
					} else if (cmbBusType.getSelectedItem().toString().equals("2+2")) {
						 busSeat = 24;
					}
					for (int i = 0; i < busSeat; i++) {
						if (i != busSeat-1) {
							myWriter.append("F-");
						} else {
							myWriter.append("F");
						}
					}
					myWriter.append("\n");
					myWriter.close();
					setVisible(false);
					Company_Management cpm = new Company_Management(company);
					cpm.setVisible(true);
					System.out.println("Successfully wrote to the file.");
				} catch (IOException ex) {
					System.out.println("An error occurred.");
					ex.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(205, 227, 89, 23);
		cust.customButton(btnNewButton);
		contentPane.add(btnNewButton);

	}
}
