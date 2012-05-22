package grafica;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import cardsPackage.ChemComposition;
 
public class OpenList extends JPanel
                      implements ListSelectionListener {
	protected static double WAVE;
	protected static String FILENAME;
	protected static String[] ELEMENTS;
    private JList list;
    private DefaultListModel listModel;
    private static JFrame frame;
 
    private static final String hireString = "Add";
    private static final String fireString = "Delete";
    private JButton fireButton;
    private JTextField matterName;
    private JButton searchButton;
    private JTextField waveNumber;
    private JButton openFile;
    private JTextField fileName;
    
    public OpenList() {
        super(new BorderLayout());
        
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setToolTipText("The list of Elements");
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        searchButton = new JButton("Search");
        searchButton.setToolTipText("Push to get the result");
        searchButton.addActionListener(new SearchListener(this));
        searchButton.setEnabled(true);
        
        JButton hireButton = new JButton(hireString);
        HireListener hireListener = new HireListener(hireButton);
        hireButton.setActionCommand(hireString);
        hireButton.addActionListener(hireListener);
        hireButton.setEnabled(false);
               
        fireButton = new JButton(fireString);
        fireButton.setHorizontalAlignment(SwingConstants.LEFT);
        fireButton.setActionCommand(fireString);
        fireButton.addActionListener(new FireListener());
        fireButton.setEnabled(false);
               
        matterName = new JTextField(10);
        matterName.setToolTipText("Type the element from Mendeleev Table");
        matterName.setHorizontalAlignment(SwingConstants.LEFT);
        matterName.addActionListener(hireListener);
        matterName.getDocument().addDocumentListener(hireListener);
               
        openFile = new JButton("Open");
        openFile.setToolTipText("Choose the file to scan the data");
        openFile.addActionListener(new OpenFile());
///
    		
    	JDesktopPane desktopPane = new JDesktopPane();
    	add(desktopPane);
    	desktopPane.setBackground(Color.WHITE);

    		
    	listScrollPane.setBounds(22, 69, 253, 82);
    	desktopPane.add(listScrollPane);
    		
    	openFile.setBounds(22, 24, 89, 23);
    	desktopPane.add(openFile);
    		
    	searchButton.setBounds(22, 233, 89, 28);
    	desktopPane.add(searchButton);
    		
    	fileName = new JTextField();
    	fileName.setEditable(false);
    	fileName.setToolTipText("Name of the selected file");
    	fileName.setBounds(117, 25, 158, 20);
    	desktopPane.add(fileName);
    	fileName.setColumns(10);
    		
    	fireButton.setBounds(22, 157, 78, 23);
    	desktopPane.add(fireButton);
    		
    	matterName.setBounds(104, 158, 109, 20);
    	desktopPane.add(matterName);
    	matterName.setColumns(10);
    	
    	hireButton.setBounds(218, 157, 57, 23);
    	desktopPane.add(hireButton);
    		
    	JLabel lableWave = new JLabel("Wave Length (nM):");
    	lableWave.setBounds(22, 191, 120, 20);
    	desktopPane.add(lableWave);
    		
    	waveNumber = new JTextField();
    	waveNumber.setToolTipText("Type the wave length");
    	waveNumber.setBounds(141, 191, 86, 20);
    	desktopPane.add(waveNumber);
    	waveNumber.setColumns(10);
                       
    }
    
    class OpenFile implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		JButton source = (JButton) (e.getSource());
    		JFileChooser fileopen = new JFileChooser();	
    		ExtFileFilter ff1 = new ExtFileFilter("dat", "*.dat");
    		ExtFileFilter ff2 = new ExtFileFilter("txt", "*.txt");
    		fileopen.addChoosableFileFilter(ff2);
    		fileopen.addChoosableFileFilter(ff1);    		
    		int ret = fileopen.showDialog(null, "Open"); 
    		if (ret ==	JFileChooser.APPROVE_OPTION){ 
	    		String file = fileopen.getSelectedFile().getPath();
	    		fileName.setText(file);
    		}
    	}
    	
    }
    
    public String getFileName(){
    	return FILENAME;
    }
   
	class SearchListener implements ActionListener{
		private OpenList par;
		public SearchListener(OpenList arg1){
			par = arg1;
		}
    	public void actionPerformed(ActionEvent e){
    		if (fileName.getText().equals("") != true){
	    		if (listModel.getSize() != 0){
	    			String wave = waveNumber.getText();
	    			if (testWave(wave)==false){
	    				FILENAME = fileName.getText();
			    		frame.setEnabled(false);
			    		WAVE = Double.parseDouble(wave);
			    		int t = listModel.getSize();
			    		ELEMENTS = 	new String[t];
			    		for (int i = 0; i<t; i++){
			    			String name = listModel.getElementAt(i).toString();
			    			ELEMENTS[i] = name;
			    		}
			    		//new Searching(par);
			    		new ChemComposition(par);
	    			}else{
	    				JOptionPane.showMessageDialog(null,
	    			    		"You haven't typed Wave Length or did it incorrectly!",
	    			    		"Warning",
	    			    	    JOptionPane.PLAIN_MESSAGE);
	    				}
	    		}
	    	}else{
	    		JOptionPane.showMessageDialog(null,
			    		"You haven't chosen the file!",
			    		"Warning",
			    	    JOptionPane.PLAIN_MESSAGE);
	    	}
    	}
    	 private boolean testWave(String wave){
    		 final Pattern pattern=Pattern.compile("([0-9]{1,3}+.[0-9]{1,3})|([0-9]{1,5})");
    		 Matcher matcher=pattern.matcher(wave);
    		 if(matcher.matches()){
    			return false;
    		 }
    		 else{
    			 return true;
    		 }
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
        	if (listModel.getSize() < 5){
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
		 
		            listModel.insertElementAt(matterName.getText().trim(), index);
		 
		            matterName.requestFocusInWindow(); //reset the textField
		            matterName.setText("");
		 
		            list.setSelectedIndex(index);
		            list.ensureIndexIsVisible(index);
		    } else {
		    	System.out.println(matterList.correctMatter(name));
	        	 JOptionPane.showMessageDialog(null,
			    		"This input element from Mendeleev Table is absent in our database!",
			    		"Warning",
			    	    JOptionPane.PLAIN_MESSAGE);}
        }else{
        	JOptionPane.showMessageDialog(null,
		    		"The number of Elements can's overrun 5!",
		    		"Warning",
		    	    JOptionPane.PLAIN_MESSAGE);}
        }
        protected boolean alreadyInList(String name) {
            return listModel.contains(name.trim());
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
   		frame = new JFrame("Input Defraction Data");
		frame.setBounds(100, 100, 337, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		OpenList window = new OpenList();
		frame.getContentPane().add(window, BorderLayout.CENTER);
		frame.setVisible(true);
    }
}