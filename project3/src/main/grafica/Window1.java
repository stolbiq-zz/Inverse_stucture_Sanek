package grafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import cardsPackage.*;

public class Window1 {
	private JFrame frame;
	private MyTable table;
	private Diagram diagram;
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
	
	public Diagram getApplet(){
		return diagram;
	}
	public Window1(OpenList arg, Start arg1) {
		frame = new JFrame("Output Data");
		frame.setBounds(100, 100, 710, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.white);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		MyJList list = new MyJList(arg.getFileName());
		list.setBounds(564, 372, 129, 140);
		desktopPane.add(list);
		
		table = new MyTable(this, arg1);
		table.setBounds(234, 347, 330, 165);
		desktopPane.add(table);
		
		diagram = new Diagram(arg, arg1);
		diagram.setBounds(0, 0, 693, 346);
		desktopPane.add(diagram);
		System.out.println(arg1.getLatticeType(0));
		
		
		
		if (arg1.getLatticeType(0).equals("D ") == true){
			Tetragon kubick = new Tetragon(arg1, this);
			kubick.setBounds(0, 347, 235, 165);
			desktopPane.add(kubick);
			kubick.setLayout(new CardLayout(0, 0));
		}else{
		if (arg1.getLatticeType(0).equals("D3") == true){
			Trigon kubick = new Trigon();
			kubick.setBounds(0, 347, 235, 165);
			desktopPane.add(kubick);
			kubick.setLayout(new CardLayout(0, 0));
		}else{
		if (arg1.getLatticeType(0).equals("D4") == true){
			VolCenter kubick = new VolCenter();
			kubick.setBounds(0, 347, 235, 165);
			desktopPane.add(kubick);
			kubick.setLayout(new CardLayout(0, 0));
		}else{
			JLabel lblNoData = new JLabel("No Data");
			lblNoData.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNoData.setBounds(88, 414, 69, 25);
			desktopPane.add(lblNoData);
		}
		}
		}
		JLabel lblDataFromFile = new JLabel("Data from File");
		lblDataFromFile.setBounds(574, 347, 88, 25);
		desktopPane.add(lblDataFromFile);
		
		frame.setVisible(true);
	}	
}