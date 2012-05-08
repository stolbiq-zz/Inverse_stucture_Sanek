package grafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class MyTable extends JPanel {
	private boolean DEBUG = false;
	
	public MyTable() {
		super(new GridLayout(1,0));
		String[] columnNames = {"Matter",
                                "Probability"};
 
		Object[][] data = {
        		{"Nikel", "98"},
        		{"Cobalt", "69"},
        		{"Magniy", "54"},
        		{"Margonets", "45"}
        };
		final JTable table = new JTable(data, columnNames);
       
		table.setEnabled(false);
        
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
 
		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}
 
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
 
	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();
 
		System.out.println("Value of data: ");
		for (int i=0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j=0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}