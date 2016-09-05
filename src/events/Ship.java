package events;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ship {
	
	public BufferedImage sprite = new BufferedImage(63, 49, 2);
	public int x_loc;
	public int y_loc;
	public double theta;
	public String name;
	public boolean iswarping = false;

	public Ship(String type, int x, int y)
	{
	    x_loc = x;
	    y_loc = y;
	    theta = 0;
	    name = type;

	    try {
	       sprite = ImageIO.read(getClass().getClassLoader().getResource("assets/" + type + ".png"));
	     }
	     catch (IOException e) {
	       e.printStackTrace();
	    }
	   }
	
	public AffineTransform transform(int rel_x, int rel_y){
		
		AffineTransform at = new AffineTransform();
        at.translate(x_loc-rel_x, y_loc-rel_y);

        at.rotate(theta+Math.PI);

        if(iswarping)
        	at.scale(2, 0.9);

        at.translate(-sprite.getWidth()/2, -sprite.getHeight()/2);
        
        return at;
	}
	
	public int get_rel_dist(int x, int y){
		
		return (int) Math.sqrt(Math.pow(x_loc-x, 2) + Math.pow(y_loc-y, 2));
		
	}
	
}
