import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CompanyList extends JFrame {

	private JPanel contentPane;
	private JPanel tablePane;
	private JTable table;
	
	
	public CompanyList() {
		super("Company List");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 500);
		cust.centreWindow(this);
		contentPane = new JPanel();
		tablePane = new JPanel();
		tablePane.setLayout(new FlowLayout());
		tablePane.setBounds(0,0,700,500);
		contentPane.setLayout(null);
		cust.customPanel(contentPane);
		contentPane.add(tablePane);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable();
		String columns[] = {"Company"};
		tableModel.setColumnIdentifiers(columns);
		tableModel.setColumnCount(1);
		
		
		BufferedReader reader;
		
		
		
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("company.txt"), StandardCharsets.UTF_8));
			String input,rows[];
			
			while ((input = reader.readLine())!=null) {
				rows = input.toUpperCase().split("\t");
				tableModel.addRow(rows);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		cust.tableCellCenter(table);
        
		
		table.setModel(tableModel);
		tablePane.add(table);
		tablePane.add(new JScrollPane(table));
		setContentPane(contentPane);
	}

}
