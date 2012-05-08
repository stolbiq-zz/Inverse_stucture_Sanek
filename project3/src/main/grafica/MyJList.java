package grafica;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;
 
public class MyJList extends JPanel {
    private JList list;
    private DefaultListModel listModel;
    public static int t;
    
    public ArrayList<String> scannerReadFile(String file) throws FileNotFoundException{
    	t = 0;
    	ArrayList<String> array = new ArrayList<String>();
		Scanner scanner = new Scanner(new FileInputStream(file));
		while (scanner.hasNextLine()) {
			 array.add(scanner.nextLine());
			 t++;
		}
		return array;
	}
    public MyJList(){
        super(new BorderLayout());
        try{
        	ArrayList<String> array = scannerReadFile("quickstart.dat");
	        listModel = new DefaultListModel();
	        for (int i =0; i<t; i++){
		        String line = array.get(i);
		    	listModel.addElement(line);
				
	        }
	        //Create the list and put it in a scroll pane.
	        list = new JList(listModel);
	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        list.setSelectedIndex(0);
	        list.setVisibleRowCount(5);
	        JScrollPane listScrollPane = new JScrollPane(list);
	        add(listScrollPane, BorderLayout.CENTER);
        }
        
        catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
    }
    
    public int getT(){
    	int a = t;
    	System.out.println(a);
    	return a;
    }
}