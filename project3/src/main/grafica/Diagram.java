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
import javax.swing.JPanel;

import cardsPackage.Start;

public class Diagram extends JPanel {
	private double[] x, y;
	private int signal;
	private OpenList par;
	private Start start;
	final static Color bg = Color.white;
    final static Color fg = Color.black;
    
    public Diagram(OpenList arg, Start arg1) {
    	signal = -1;
    	par = arg;
    	start = arg1;
    	try{
    		readNumbers(par);
    	}catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setSignal(int i){
    	signal = i;
    }
    
    public int getSignal(){
    	return signal;
    }
    
	public void readNumbers(OpenList arg) throws IOException{
		FileReader fl =new FileReader (new File(arg.getFileName())); 
		StreamTokenizer st =new StreamTokenizer(new BufferedReader(fl));
		int t = new MyJList(arg.getFileName()).getT();
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
		x = x1;
		y = y1;
	}

	private double maxDouble(double[] arr, int t){ 
    	double max = arr[0];
    		for (int j = 0; j<t; j++){
    			if (arr[j]>max){
    				max = arr[j];
    			}
    	}
    	return max;
    }
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();
        int a = 70;
        int gridWidth = d.width-a;
        int gridHeight = d.height-a;
        g.setColor(Color.black);
        int[] xVertex = { 0, d.width, d.width, 0};
        int[] yVertex = { 0, 0, d.height, d.height};
		g.drawPolygon(xVertex, yVertex, 4);
		g.fillPolygon(xVertex, yVertex, 4);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color fg3D = Color.white;
		//стрелки и оси
        g2.setPaint(fg3D);
		g2.draw(new Line2D.Double(a/4, gridHeight+3*a/4, gridWidth+3*a/4, gridHeight+3*a/4));
		g2.draw(new Line2D.Double(a/4, gridHeight+3*a/4, a/4, a/4));
		g2.draw(new Line2D.Double(a/4, a/4, a/4-4, a/4+10));
		g2.draw(new Line2D.Double(a/4, a/4, a/4+4, a/4+10));
		g2.draw(new Line2D.Double(gridWidth+3*a/4, gridHeight+3*a/4, gridWidth+3*a/4-10, gridHeight+3*a/4+4));
		g2.draw(new Line2D.Double(gridWidth+3*a/4, gridHeight+3*a/4, gridWidth+3*a/4-10, gridHeight+3*a/4-4));
		
		int t = new MyJList(par.getFileName()).getT();
		double maxX = maxDouble(x, t);
		double maxY = maxDouble(y, t);
		double kWid = gridWidth/maxX;
		double kHgt = gridHeight/maxY;
		
		int ny = 10; int nx = 15;
		int NX = (int) gridWidth/nx;
		int NY = (int) gridHeight/ny;
		double xStep = maxX/nx;
		int yStep = (int) maxY/ny;
		
		g2.setColor(Color.green);
		g2.drawString("Intensity",a/2, a/3);
		if (xStep<1 && xStep>0.1){
			xStep = xStep*10;
			g2.setPaint(Color.green);
			g2.drawString("Angle(grad/10)", gridWidth-a/2 , gridHeight+3*a/4 - a/10);
		}else{
			g2.drawString("Angle(grad)", gridWidth-a/2 , gridHeight+3*a/4 - a/10);
		}
		g2.setColor(Color.blue);
		g2.drawString("Testing Matter Diffractogram", gridWidth*8/10 , gridHeight*1/10);
		
		g2.setColor(Color.yellow);
		g2.drawString("Database Matter Diffractogram", gridWidth*8/10 , gridHeight*1/6);
		
		Color fg3D1 = Color.blue;
		g2.setPaint(fg3D1);
			g2.setPaint(Color.white);
			for (int k = 0; k<ny+1; k++){
				g2.draw(new Line2D.Double(a/4-2, a/2+gridHeight-NY*k, a/4+2 , a/2 + gridHeight-NY*k));
				g2.drawString(Integer.toString(yStep*k), a/4+a/8, a/2+gridHeight-NY*k);
			}
			for (int i = 0; i<nx+1; i++){
				g2.draw(new Line2D.Double(a/2 + NX*i, gridHeight+3*a/4-2 , a/2 + NX*i , gridHeight+3*a/4+2));
				g2.drawString(Integer.toString((int)xStep*i), a/2 + NX*i, gridHeight+3*a/4 + a/5);
			}
			
			g2.setPaint(Color.blue);
			for(int p = 0; p<t; p++){
				g2.draw(new Line2D.Double(a/2+kWid*x[p], a/2+gridHeight ,a/2+kWid*x[p] , a/2+gridHeight - kHgt*y[p]));
			}
			
			g2.setPaint(Color.yellow);
			if(signal > -1){
				for(int j = 0; j<start.getLength(signal); j++){
					g2.draw(new Line2D.Double(a/2+kWid*start.getXPeak(signal, j), a/2+gridHeight ,a/2+kWid*start.getXPeak(signal, j) , (a/2+gridHeight - 13*kHgt*start.getYPeak(signal, j))));
				}
				//g2.drawString("Yes", gridWidth/2, gridHeight/2);
			}
	    g2.setPaint(fg);
	}
}	
