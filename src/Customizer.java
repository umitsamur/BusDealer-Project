import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class Customizer {
	
	private static Customizer instance;
	
	private Customizer() {}
	
	public static Customizer getInstance() {
		if (instance == null) {
			instance = new Customizer();
		}
		return instance;
	}
	
	public void customPanel(JPanel panel) {
		panel.setBackground(new Color(214, 219, 223));
	}
	
	public void customButton(JButton button) {
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(52,73,94));
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				 button.setBackground(new Color(214, 219, 223));
				 button.setForeground(new Color(52,73,94));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				button.setBackground(new Color(52,73,94));
				button.setForeground(Color.WHITE);
			}
		});
	}
	public void customBackButton(JButton button) {
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(30, 132, 73));
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				 button.setBackground(new Color(125, 206, 160));
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				button.setBackground(new Color(30, 132, 73));
			}
		});
	}
	
	public void customBusButton(JButton button) {
		button.setForeground(new Color(251, 252, 252));
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				 
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
			}
		});
	}
	
	
	public void customLabel(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
	
	
	
	public void focusTextField(JTextField textfield, JLabel label) {
		textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setVisible(false);
			}
		});
	}
	public void focusTextField(JPasswordField passField, JLabel label) {
		passField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setVisible(false);
			}
		});
	}
	
	
	public void tableCellCenter(JTable table) {
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);
	}
	
	public void centreWindow(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		//final int width = (int)dimension.getWidth() / 2;
		//final int height = (int)dimension.getHeight() / 2;
		//frame.setSize(width, height);
		int x = ((int) ((dimension.getWidth() - frame.getWidth()) / 2));
		int y = ((int) ((dimension.getHeight() - frame.getHeight()) / 2));
		frame.setLocation(x,y);
		/*
		System.out.println("max-width: " + (int)dimension.getWidth() + "\nmax-height: " + (int)dimension.getHeight());
		System.out.println("x: " + (int) ((dimension.getWidth() - frame.getWidth()) / 2) 
				+"\ny: " + (int) ((dimension.getHeight() - frame.getHeight()) / 2));
		*/
		
	}
	
}
