package grafica;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Window1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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
		initialize();
	}

	public void initialize() {
		frame = new JFrame("Output Data");
		frame.setBounds(400, 100,  665, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyTable table = new MyTable();
		table.setOpaque(true);
		JApplet applet = new Diagram();
		applet.setBackground(Color.black);
		MyJList list = new MyJList(new OpenList().getFileName());
		JPanel panel = new JPanel();
		frame.getContentPane().add("South", panel);
		panel.add("West", table);
		panel.add("East", list);
		frame.getContentPane().add("Center",applet);
		frame.setVisible(true);
	}

}
