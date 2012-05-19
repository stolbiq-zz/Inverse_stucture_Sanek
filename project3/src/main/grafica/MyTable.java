package grafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
/** 
 * TableDemo is just like SimpleTableDemo, except that it
 * uses a custom TableModel.
 */
public class MyTable extends JPanel {
	private Window1 parent;
    public MyTable(Window1 creator) {
        super(new GridLayout(1,0));

    	parent = creator;
        
    	TableColumn column;
    	JButton b = new JButton();
    	b.setEnabled(true);
    	b.setIcon(new ImageIcon("D:\\Informatics\\Projecto\\nixus-preview1.gif"));
    	final String[] columnNames = {"D",
				"Matter",
                "E%"};
		final Object[][] data = {
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
				{b, "Magny", new Integer(5)},
		};
        final JTable table = new JTable(new DefaultTableModel(data, columnNames){
        	public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
                public boolean isCellEditable(int row, int col) {
                    return false;
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
        
        b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				int a = parent.applet.getSignal();
				if (a == -1){
					parent.applet.setSignal(1);
				} else{
					parent.applet.setSignal(-1);
				}
				parent.applet.repaint();
				
			}
		});
        
        table.addMouseListener(new MouseListener() {
            private void dispatchEvent(MouseEvent e) {
                final int column = table.getColumnModel().getColumnIndexAtX(
                        e.getX());
                final int row = e.getY() / table.getRowHeight();
                if (row >= table.getRowCount() || row < 0
                        || column >= table.getColumnCount() || column < 0)
                    return;
                final Object value = table.getValueAt(row, column);
                if (!(value instanceof JButton))
                    return;
                final JButton button = (JButton) value;
                final MouseEvent buttonEvent = SwingUtilities
                        .convertMouseEvent(table, e, button);
                button.dispatchEvent(buttonEvent);
                if (e.getID() == MouseEvent.MOUSE_CLICKED) {
                    final ActionEvent ae = new ActionEvent(button,
                            ActionEvent.ACTION_PERFORMED, button.getText());
                    for (final ActionListener l : button.getActionListeners())
                        l.actionPerformed(ae);
                }
                table.repaint();
            }

            public void mouseClicked(MouseEvent e) {
                dispatchEvent(e);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }
        });
    }
}    