package grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import javax.swing.JApplet;

public class Diagram extends JApplet {
	private double[] x, y;
	
	final static Color bg = Color.white;
    final static Color fg = Color.black;
    
	public Diagram readNumbers(String file) throws IOException{
		FileReader fl =new FileReader (new File("quickstart.dat")); 
		StreamTokenizer st =new StreamTokenizer(new BufferedReader(fl));
		int t = new MyJList(file).getT();
		double[] x1 = new double[t];
		double[] y1 = new double[t];
		int i = 0;
		boolean sig1 = true;
		while((st.nextToken()!=StreamTokenizer.TT_EOL) && (i<t)){
			if(st.ttype==StreamTokenizer.TT_NUMBER){	
				if (sig1){
					x1[i]=(double)st.nval;	
					sig1 = false;
				}
				else{
					y1[i]=(double)st.nval;
					sig1 = true;
					i++;
				}
			}
		}
		Diagram ob = new Diagram();
		ob.x = x1;
		ob.y = y1;
		return ob;
	}

	private double maxDouble(double[] arr, int t){ 
    	double max = arr[0];
    	for (int i = 0; i<t; i++){
    		for (int j = 0; j<t; j++){
    			if (arr[j]>max){
    				max = arr[j];
    			}
    		}
    	}
    	return max;
    }
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color fg3D = Color.blue;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        int gridWidth = d.width;
        int gridHeight = d.height;
		g2.setPaint(fg3D);
		int t = new MyJList("quickstart.dat").getT();
		try{
			Diagram ob = readNumbers("quickstart.dat");
			double kWid = gridWidth/maxDouble(ob.x, t);
			double kHgt = gridHeight/maxDouble(ob.y, t);
			for(int p = 0; p<t; p++){
				g2.draw(new Line2D.Double(kWid*ob.x[p], gridHeight ,kWid*ob.x[p] , gridHeight - kHgt*ob.y[p]));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	    g2.setPaint(fg);
	}
}	
