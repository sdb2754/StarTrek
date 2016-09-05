 package events;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Map extends JPanel
 {
   private static final long serialVersionUID = 1L;
   
   public static final int x_dim = 1000;
   public static final int y_dim = 1000;
   
   public int x_current;
   public int y_current;

   private BufferedImage background= new BufferedImage(x_dim, y_dim, 2);
   public BufferedImage image = new BufferedImage(x_dim, y_dim, 2);
   private Graphics draw = image.getGraphics();
   Graphics2D g2d = (Graphics2D) draw;
   
   ArrayList<Ship> ships = new ArrayList<Ship>();
 


   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     draw.drawImage(background, 0, 0, null);
     draw_ships();
     g.drawImage(this.image, 0, 0, null);
   }

 public Map()
 {
	 setPreferredSize(new Dimension(1000, 1000));
	 setLayout(null);

	 background.getGraphics().fillRect(0, 0, x_dim, y_dim);
	 
	 x_current = 0;
	 y_current = 0;
 }
 
 //update map
 public void update(){
	 
 }
 
 public void add_ship(String type, int x, int y){
	 
	 ships.add(new Ship(type,x+x_current,y+y_current));
 }

 	private void draw_ships(){
 		
 		for(int i=0;i<ships.size();i++){
 			//is ship close enough that is should be drawn?
 			if(ships.get(i).get_rel_dist(x_current, y_current)<2*x_dim)
 			g2d.drawImage(ships.get(i).sprite, ships.get(i).transform(x_current,y_current), null);
 		}
 		
 	}

}