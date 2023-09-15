import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.awt.Color;

public class TravelList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public TravelList() {
		super("Travel List");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450, 300);
		cust.centreWindow(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		
		table = new JTable() ;
		String columns[] = new String[] {"From","To","Time","Date","Company"};
		tableModel.setColumnIdentifiers(columns);
		
		
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("Travel.txt"),"UTF8"));
			String input, str[];
			while((input = reader.readLine()) != null) {
				str = input.split("\t");
				String rows[] = new String[] {str[0],str[1],str[2],str[3],str[4]};
				tableModel.addRow(rows);
				
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		table.setModel(tableModel);
		contentPane.add(table);
		getContentPane().add(new JScrollPane(table));
		pack();
	}

}
