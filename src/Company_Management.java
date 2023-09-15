import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Company_Management extends JFrame {

	private JPanel contentPane;
	private Add_Travel add_travel;

	
	public Company_Management(Company company) {
		super("Company Management");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cust.customPanel(contentPane);
		//contentPane.setBackground(new Color(214, 219, 223));
		
		JButton btnAddTravel = new JButton("Add Travel");
		btnAddTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_travel = new Add_Travel(company);
                add_travel.setVisible(true);
                setVisible(false);
			}
		});
		
		
		btnAddTravel.setBackground(new Color(52,73,94));
		btnAddTravel.setForeground(Color.WHITE);
		btnAddTravel.setFont(new Font("Algerian", Font.BOLD, 12));
		btnAddTravel.setBounds(159, 75, 129, 31);
		cust.customButton(btnAddTravel);
		contentPane.add(btnAddTravel);
		
		JButton btnCancelTravel = new JButton("Cancel Travel");
		btnCancelTravel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cancel_Travel ct = new Cancel_Travel(company);
				ct.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelTravel.setBackground(new Color(52,73,94));
		btnCancelTravel.setForeground(Color.WHITE);
		btnCancelTravel.setFont(new Font("Algerian", Font.BOLD, 12));
		btnCancelTravel.setBounds(159, 135, 129, 31);
		cust.customButton(btnCancelTravel);
		contentPane.add(btnCancelTravel);
		
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
