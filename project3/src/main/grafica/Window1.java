package grafica;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
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
					Window1 window = new Window1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,  665, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyTable table = new MyTable();
		JApplet applet = new Diagram();
		applet.setBackground(new Color(255, 250, 250));
		MyJList list = new MyJList();
		JPanel panel = new JPanel();
		frame.getContentPane().add("South", panel);
		panel.add("West", table);
		panel.add("East", list);
		frame.getContentPane().add("Center",applet);
	}

}
