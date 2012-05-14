package grafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class OpenList extends JPanel
                      implements ListSelectionListener {
	private static double WAVE;
	private static String[] ELEMENTS;
    private JList list;
    private DefaultListModel listModel;
    private static JFrame frame;
 
    private static final String hireString = "Add";
    private static final String fireString = "Delete";
    private JButton fireButton;
    private JTextField matterName;
    private JButton searchButton;
    private JPanel panel_1;
    private JTextField textField;
    private JLabel lblNewLabel;
    public OpenList() {
        super(new BorderLayout());
        
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        add(listScrollPane, BorderLayout.CENTER);
        
        searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchListener());
        searchButton.setEnabled(true);
        
               JButton hireButton = new JButton(hireString);
               HireListener hireListener = new HireListener(hireButton);
               hireButton.setActionCommand(hireString);
               hireButton.addActionListener(hireListener);
               hireButton.setEnabled(false);
               
               
               fireButton = new JButton(fireString);
               fireButton.setActionCommand(fireString);
               fireButton.addActionListener(new FireListener());
               fireButton.setEnabled(false);
               
               matterName = new JTextField(10);
               matterName.addActionListener(hireListener);
               matterName.getDocument().addDocumentListener(hireListener);
               
                       JPanel buttonPane = new JPanel();
                       buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
                       buttonPane.add(fireButton);
                       buttonPane.add(Box.createHorizontalStrut(5));
                       buttonPane.add(matterName);
                       buttonPane.add(Box.createHorizontalStrut(5));
                       buttonPane.add(hireButton);
                       buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
                       buttonPane.add(Box.createHorizontalStrut(5));
                       buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
                       buttonPane.add(Box.createHorizontalStrut(5));
                       buttonPane.add(searchButton);
                       add(buttonPane, BorderLayout.PAGE_END);
                       
                       panel_1 = new JPanel();
                       add(panel_1, BorderLayout.NORTH);
                       
                       lblNewLabel = new JLabel("Wave Length(nM):");
                       panel_1.add(lblNewLabel);
                       
                       textField = new JTextField();
                       panel_1.add(textField);
                       textField.setColumns(8);
    }
   
	class SearchListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if (listModel.getSize() != 0){
    			String wave = textField.getText();
    			if (testWave(wave)==false){
		    		new Window1();
		    		frame.setEnabled(false);
		    		WAVE = Double.parseDouble(wave);
		    		int t = listModel.getSize();
		    		ELEMENTS = 	new String[t];
		    		for (int i = 0; i<t; i++){
		    			String name = listModel.getElementAt(i).toString();
		    			ELEMENTS[i] = name;
		    		}
    			}else{
    				JOptionPane.showMessageDialog(null,
    			    		"You haven't typed Wave Length or did it incorrectly!",
    			    		"Fatal Error",
    			    	    JOptionPane.PLAIN_MESSAGE);
    			}
    		}
    	}
    	 private boolean testWave(String wave){
    	    	return textField.getText().equals("");
    	    }
    }
    class FireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	int index = list.getSelectedIndex();
            listModel.remove(index);
            int size = listModel.getSize();
            if (size == 0) {
                fireButton.setEnabled(false);
            } else { 
                if (index == listModel.getSize()) {
                    index--;
                }
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }
 
    //This listener is shared by the text field and the hire button.
    class HireListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;
 
        public HireListener(JButton button) {
            this.button = button;
        }
       
 
        //ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = matterName.getText();
     
            if (name.equals("") || alreadyInList(name)) { //Checking for a new name
                Toolkit.getDefaultToolkit().beep();
                matterName.requestFocusInWindow();
                matterName.selectAll();
                return;
            }
            MatterList matterList = new MatterList();
            if (matterList.correctMatter(name) == true){
	            int index = list.getSelectedIndex(); //get selected index
	            if (index == -1) { 
	            	index = 0;
	            } else {           
	            	index++;
	            }
	 
	            listModel.insertElementAt(matterName.getText(), index);
	 
	            matterName.requestFocusInWindow(); //reset the textField
	            matterName.setText("");
	 
	            list.setSelectedIndex(index);
	            list.ensureIndexIsVisible(index);
	    }
        else {
        	 JOptionPane.showMessageDialog(null,
		    		"This input element from Mendeleev Table doesn't exist!",
		    		"Fatal Error",
		    	    JOptionPane.PLAIN_MESSAGE);}

        }
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }
 
        //DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }
 
        //DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }
 
        //DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }
 
        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }
 
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }
    
 
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
                fireButton.setEnabled(false);
 
            } else {
                fireButton.setEnabled(true);
            }
        }
    }
 

    public void createOpenWindow() {
        frame = new JFrame("Input Matter");
        frame.setBounds(100, 100, 400, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JComponent jList = new OpenList();
        jList.setOpaque(true);
        frame.getContentPane().add(panel, "North");
        panel.add(jList, "Center");
        frame.pack();
        frame.setVisible(true);
    }
}