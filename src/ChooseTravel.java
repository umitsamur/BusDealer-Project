import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

public class ChooseTravel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel tablePane;
	private JButton btnBack;
	
	
	public ChooseTravel(ArrayList<Travel> list) {
		super("Choose Travel");
		
		Customizer cust = Customizer.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(750,400);
		cust.centreWindow(this);
		contentPane = new JPanel();
		tablePane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tablePane.setBounds(0,0,500,400);
		tablePane.setLayout(new FlowLayout());
		cust.customPanel(tablePane);
		contentPane.setLayout(null);
		cust.customPanel(contentPane);
		contentPane.add(tablePane);
		
		PriorityQueue<Travel> pq = new PriorityQueue<Travel>(list.size(),Comparator.comparingDouble(o -> Double.parseDouble(o.getTime())));
		for (int i = 0; i < list.size(); i++) {
			pq.add(list.get(i));
		}
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		table = new JTable();
		String columns[] = new String[] {"From","To","Time","Date","Company","Price","Bus-Type"};
		tableModel.setColumnIdentifiers(columns);
		
		for (int i = 0; i < list.size(); i++) {
			/*
			String rows[] = new String[] {list.get(i).getSource().getCity_Name(),list.get(i).getDestination().getCity_Name(),list.get(i).getTime(),
					list.get(i).getDate(),list.get(i).getCompany(), String.valueOf(list.get(i).getPrice()),
							list.get(i).getBusType().toString()
			};*/
			
			String rows[] = new String[] {pq.peek().getSource().getCity_Name(),
										pq.peek().getDestination().getCity_Name(),
										pq.peek().getTime(),
										pq.peek().getDate(),
										pq.peek().getCompany(),
										String.valueOf(pq.peek().getPrice()).toString(),
										pq.peek().getBusType().toString()};
			tableModel.addRow(rows);
			pq.remove();
		}
		
		cust.tableCellCenter(table);
		table.setModel(tableModel);
		
		//contentPane.add(table);
		tablePane.add(table);
		tablePane.add(new JScrollPane(table));
		setContentPane(contentPane);
		
		
		
		String tableCells[] = new String[columns.length];
		JButton btnBuyTicket = new JButton("Bilet Al");
		btnBuyTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (table.getSelectedRow() >= 0) {
					for (int i = 0; i < columns.length; i++) {
						//İSMİ DEĞİŞECEK
						tableCells[i] = String.valueOf(table.getValueAt(row, i)).toString();
					}
					if (table.getValueAt(row, 6).equals("2+1")) {
						Bus2plus1 bus2plus1 = new Bus2plus1(tableCells);
						bus2plus1.setVisible(true);
						setVisible(false);
					}
					else if (table.getValueAt(row, 6).equals("2+2")) {
						Bus2plus2 bus2plus2 = new Bus2plus2(tableCells);
						bus2plus2.setVisible(true);
						setVisible(false);
					}
				}
				else if(table.getSelectedRow() < 0) {
					System.out.println("Bir işlem seçin");
				}
				
			}
		});
		btnBuyTicket.setBounds(541, 84, 89, 23);
		contentPane.add(btnBuyTicket);
		cust.customButton(btnBuyTicket);
		
		btnBack = new JButton("<-- Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketForm tf = new TicketForm();
				tf.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(541, 168, 89, 23);
		cust.customBackButton(btnBack);
		contentPane.add(btnBack);
	}
}
