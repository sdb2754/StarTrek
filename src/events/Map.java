 package events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Map extends JPanel
 {
   private static final long serialVersionUID = 1L;

   private BufferedImage background;
  public BufferedImage image = new BufferedImage(1000, 1000, 2);
  private Graphics draw = image.getGraphics();
 

   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     draw.drawImage(background, 0, 0, null);
     
     g.drawImage(this.image, 20, 20, null);
   }

 public Map()
 {
 setPreferredSize(new Dimension(1000, 1000));
 setLayout(null);
 // Must use .setBounds(500, 500, 200, 100);

 
 }


}