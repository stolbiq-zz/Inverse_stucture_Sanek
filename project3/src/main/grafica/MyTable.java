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

import cardsPackage.Start;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
 
public class MyTable extends JPanel {
	private Window1 parent;
	private JTable table;
	int row1;
	
	Object[][] data;
	//private ArrayList<Cards> mainlist;
    
	public MyTable(Window1 creator, Start arg1) {
        super(new GridLayout(1,0));
        //mainlist = 
    	parent = creator;
        
    	TableColumn column;
    	JButton b = new JButton();
    	b.setEnabled(true);
    	b.setIcon(new ImageIcon("D:\\Informatics\\Projecto\\nixus-preview1.gif"));
    	final String[] columnNames = {"D",
				"Matter",
                "E%"};
    	data = new Object[5][3];
		for (int i = 0; i<5; i++){
			data[i][1] = arg1.getName(i);
			data[i][0] = b;
			data[i][2] = arg1.getFom(i);
		}
		System.out.println(data[0][1]);
        table = new JTable(new DefaultTableModel(data, columnNames){
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
				int a = parent.getApplet().getSignal();
				if (a == -1){
					parent.getApplet().setSignal(row1);
				} else{
					parent.getApplet().setSignal(-1);
				}
				parent.getApplet().repaint();
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
                row1 = row; 
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