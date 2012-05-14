package grafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
 
/** 
 * TableDemo is just like SimpleTableDemo, except that it
 * uses a custom TableModel.
 */
public class MyTable extends JPanel {
 
    public MyTable() {
        super(new GridLayout(1,0));
    	TableColumn column;
    	JButton b = new JButton();
    	b.setIcon(new ImageIcon("D:\\Informatics\\Projecto\\nixus-preview1.gif"));
    	final String[] columnNames = {"",
				"Matter",
                "E%"};
		final Object[][] data = {
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
		};
        JTable table = new JTable(new DefaultTableModel(data, columnNames){
        	public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
                public boolean isCellEditable(int row, int col) {
                    //Note that the data/cell address is constant,
                    //no matter where the cell appears onscreen.
                    if (col == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
        });
        table.setEnabled(false);
        table.setPreferredScrollableViewportSize(new Dimension(220, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        for (int i = 0; i < 3; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20);
            } if (i == 1){
                column.setPreferredWidth(150);
            } if (i == 2){
        		column.setPreferredWidth(50);
        	}
    	}
        
        table.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                return (Component) value;
            }
        });
    }    
}