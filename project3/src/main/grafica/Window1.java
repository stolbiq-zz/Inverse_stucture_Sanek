package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window1 {
	private static JFrame frame;
	private MyTable table;
	public Diagram applet;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenList openList = new OpenList();
					openList.createOpenWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Window1() {
		frame = new JFrame("Output Data");
		frame.setBounds(400, 100,  665, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table = new MyTable(this);
		applet = new Diagram();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.add(applet);
		table.setOpaque(true);
		MyJList list = new MyJList(new OpenList().getFileName());
		panel.add(table);
		panel.add(list);
		frame.getContentPane().add("South", panel);
		frame.setVisible(true);
	}

	public void secondWindow(){
		applet.setBackground(Color.black);
		frame.getContentPane().add("Center",applet);
		applet.repaint();
	}
	
}