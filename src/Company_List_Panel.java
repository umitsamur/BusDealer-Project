import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Company_List_Panel extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public Company_List_Panel() {
		super("Company List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable();
		table.setBounds(22, 11, 391, 282);
		String columns[] = new String[] {"Name","Sifre"};
		tableModel.setColumnIdentifiers(columns);
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("company.txt"),"UTF8"));
			String input, str[];
			while((input = reader.readLine()) != null) {
				str = input.split("\t");
				String rows[] = new String[] {str[0],str[1]};
				tableModel.addRow(rows);
				
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		table.setModel(tableModel);
		contentPane.add(table);
		add(new JScrollPane(table));
		pack();
		
		
	}

}
