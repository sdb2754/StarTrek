package events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;

import javax.swing.JButton;

public class PolyButton extends JButton {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape polygon = createPolygon();
	private Color color;
	
	public PolyButton(Color c){
		color = c;
	}

public void paintBorder( Graphics g ) {
        ((Graphics2D) g).draw(polygon);
    }
    public void paintComponent( Graphics g ) {
    	g.setColor(color);
        ((Graphics2D)g).fill(polygon);
    }
    public Dimension getPreferredSize() {
        return new Dimension(200,100);
    }
    public boolean contains(int x, int y) {
        return polygon.contains(x, y);
    }
private Shape createPolygon() {
        Polygon p = new Polygon();
        p.addPoint( 0   , 100 );
        p.addPoint( 100 , 0   );
        p.addPoint( 200 ,100  );
        return p;
    }
}

