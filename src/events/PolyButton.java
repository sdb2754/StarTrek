package events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PolyButton extends JButton implements ActionListener{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape polygon;
	private Color color;
	
	public PolyButton(int[][] pnts){
		Polygon p = new Polygon();
		int x = pnts[0][0];
		int y = pnts[0][1];
		for (int[] pnt : pnts) {
		    x=Math.min(x, pnt[0]);
		    y=Math.min(x, pnt[0]);
		}
		for (int[] pnt : pnts) {
		    p.addPoint(pnt[0]-x,pnt[1]-y);
		}
		polygon = p;
		color = new Color(0, 0, 0, 0);
		Rectangle r = polygon.getBounds();
		setBounds(x,y,r.width,r.height);
		addActionListener(this);
	}
	
	public PolyButton(Color c, int[][] pnts){
		Polygon p = new Polygon();
		int x = pnts[0][0];
		int y = pnts[0][1];
		for (int[] pnt : pnts) {
		    x=Math.min(x, pnt[0]);
		    y=Math.min(x, pnt[0]);
		}
		for (int[] pnt : pnts) {
		    p.addPoint(pnt[0]-x,pnt[1]-y);
		}
		polygon = p;
		color = c;
		Rectangle r = polygon.getBounds();
		setBounds(x,y,r.width,r.height);
		addActionListener(this);
	}

	public void paintBorder( Graphics g ) {
		g.setColor(color);
        ((Graphics2D) g).draw(polygon);
    }
    public void paintComponent( Graphics g ) {
    	g.setColor(color);
        ((Graphics2D)g).fill(polygon);
    }
    public Dimension getPreferredSize() {
    	Rectangle r = polygon.getBounds();
        return new Dimension(r.width,r.height);
    }
    public boolean contains(int x, int y) {
        return polygon.contains(x, y);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Action\n");
	}

}