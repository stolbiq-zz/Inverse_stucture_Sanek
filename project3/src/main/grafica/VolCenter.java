package grafica;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class VolCenter extends JPanel implements MouseListener, MouseMotionListener {

int width, height;
int mx, my;
int scaleFactor;

BufferedImage backbuffer;
Graphics backg;

int azimuth = 35, elevation = 30;

Point3D[] vertices;
Edge[] edges;
public VolCenter(){
	   width = 235;
	   height = 182;
	   scaleFactor = width/4;

	   vertices = new Point3D[ 8 ];
	   vertices[0] = new Point3D( -1, -1, -1 );
	   vertices[1] = new Point3D( -1, -1,  1 );
	   vertices[2] = new Point3D( -1,  1, -1 );
	   vertices[3] = new Point3D( -1,  1,  1 );
	   vertices[4] = new Point3D(  1, -1, -1 );
	   vertices[5] = new Point3D(  1, -1,  1 );
	   vertices[6] = new Point3D(  1,  1, -1 );
	   vertices[7] = new Point3D(  1,  1,  1 );

	   edges = new Edge[ 16 ];
	   edges[ 0] = new Edge( 0, 1 );
	   edges[ 1] = new Edge( 0, 2 );
	   edges[ 2] = new Edge( 0, 4 );
	   edges[ 3] = new Edge( 1, 3 );
	   edges[ 4] = new Edge( 1, 5 );
	   edges[ 5] = new Edge( 2, 3 );
	   edges[ 6] = new Edge( 2, 6 );
	   edges[ 7] = new Edge( 3, 7 );
	   edges[ 8] = new Edge( 4, 5 );
	   edges[ 9] = new Edge( 4, 6 );
	   edges[10] = new Edge( 5, 7 );
	   edges[11] = new Edge( 6, 7 );
	   edges[12] = new Edge( 7, 0 );
	   edges[13] = new Edge( 6, 1 );
	   edges[14] = new Edge( 5, 2 );
	   edges[15] = new Edge( 4, 3 );

	   backbuffer = new BufferedImage(width	, height, BufferedImage.TYPE_INT_RGB);
	   backg = backbuffer.getGraphics();
	   drawWireframe( backg );

	   addMouseListener( this );
	   addMouseMotionListener( this );
}
public void init() {
   width = getSize().width;
   height = getSize().height;

   backbuffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB);
   backg = backbuffer.getGraphics();
   drawWireframe( backg );

   addMouseListener( this );
   addMouseMotionListener( this );
}

public void drawWireframe( Graphics g ) {

   double theta = Math.PI * azimuth / 180.0;
   double phi = Math.PI * elevation / 180.0;
   //System.out.println(theta);
   float cosT = (float)Math.cos( theta ), 
   sinT = (float)Math.sin( theta );
   float cosP = (float)Math.cos( phi ),
   sinP = (float)Math.sin( phi );
   float cosTcosP = cosT*cosP,
    cosTsinP = cosT*sinP,
    sinTcosP = sinT*cosP,
    sinTsinP = sinT*sinP;

   Point[] points;
   points = new Point[ vertices.length ];
   int j;
   float near = 3;
   float nearToObj = 1.5f;
   for ( j = 0; j < vertices.length; ++j ) {

      double x0 = vertices[j].x;
      double y0 = vertices[j].y;
      double z0 = vertices[j].z;

      double x1 = cosT*x0 + sinT*z0;
      double y1 = -sinTsinP*x0 + cosP*y0 + cosTsinP*z0;

      double z1 = cosTcosP*z0 - sinTcosP*x0 - sinP*y0;
      x1 = x1*near/(z1+near+nearToObj);
      y1 = y1*near/(z1+near+nearToObj);
      //System.out.println(scaleFactor);
      points[j] = new Point(
         (int)(width/2 + scaleFactor*x1 + 0.5),
         (int)(height/2 - scaleFactor*y1 + 0.5)
      );
   }
   g.setColor( Color.black );
   g.fillRect( 0, 0, width, height );
   g.setColor(Color.yellow);
   g.drawString("Volume Centered Structure", 5 , 15);
   g.setColor( Color.white );
   for ( j = 0; j < edges.length; ++j ) {
      g.drawLine(
         points[ edges[j].a ].x, points[ edges[j].a ].y,
         points[ edges[j].b ].x, points[ edges[j].b ].y
      );
   }
   
}

public void mouseEntered( MouseEvent e ) { }
public void mouseExited( MouseEvent e ) { }
public void mouseClicked( MouseEvent e ) { }
public void mousePressed( MouseEvent e ) {
   mx = e.getX();
   my = e.getY();
   e.consume();
}
public void mouseReleased( MouseEvent e ) { }
public void mouseMoved( MouseEvent e ) { }
public void mouseDragged( MouseEvent e ) {
   // get the latest mouse position
   int new_mx = e.getX();
   int new_my = e.getY();

   azimuth -= new_mx - mx;
   elevation += new_my - my;
  //System.out.println(azimuth);
   drawWireframe( backg );

   mx = new_mx;
   my = new_my;

   repaint();
   e.consume();
}

public void update( Graphics g ) {
   g.drawImage( backbuffer, 0, 0, this );
  // showStatus("Elev: "+elevation+" deg,Azim: "+azimuth+" deg");
}

public void paint( Graphics g ) {
   update( g );
}
}