/*     */ package events;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseMotionListener, MouseListener, KeyListener
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

     dt = 10;
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
     addMouseMotionListener(this);
     addMouseListener(this);
     addKeyListener(this);
     map = new Map();
     add(map, "Center");
   }

  private static void update()
  {
	  map.update();
  }

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	switch(e.getKeyChar()){
	case 'w':
		map.y_current-=10;
		break;
	case 'a':
		map.x_current-=10;
		break;
	case 's':
		map.y_current+=10;
		break;
	case 'd':
		map.x_current+=10;
		break;
	}
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	map.add_ship("Defiant", e.getX(), e.getY());
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
}
  
 }
