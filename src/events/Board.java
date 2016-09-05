/*     */ package events;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel
 {
   private static final long serialVersionUID = 1L;
   static JFrame frame;
   static Map map;
   static long dt;
   static Board newContentPane;
 
   public static void main(String[] args)
   {
     frame = new JFrame("Gem Tower Defense");
     frame.setDefaultCloseOperation(3);

     newContentPane = new Board();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);
    frame.setPreferredSize(new Dimension(1100, 1100)); 
     frame.pack();
     frame.setResizable(false);
     frame.setVisible(true);

     dt = 500;
     while (true)
     {
       update();
 
       newContentPane.repaint();
      try
      {
        Thread.sleep(dt);
      }
       catch (InterruptedException e) {
         e.printStackTrace();
      }
    }
  }

   public Board()
   {
     setLayout(new BorderLayout());
     setFocusable(true);
     map = new Map();
     add(map, "Center");
   }

  private static void update()
  {
	  
  }
  
 }
