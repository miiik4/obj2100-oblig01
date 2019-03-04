import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class ScalableWindow extends Frame {
	
	boolean drawDefault = true;
	
	public ScalableWindow() {
		
	    setTitle("ScalableWindow");
	    setSize(700,600);
	    setLocation(230,100);
	    setVisible(true);
	  
	    addWindowListener(new WindowAdapter() {
		
		public void windowClosing(WindowEvent e) {
		  System.exit(0);
	  	}
	  }
	  );
	  
	}
	
	int imageX;
	int imageY;

	public void paint(Graphics g) {
		
		Image image = null;
		
		try {
			URL url = new URL("https://obj.holmstedt.no/pics/26815574_835191906649288_7507950488720876851_n.jpg");
			image = ImageIO.read(url);
		} catch (IOException e) {
		}
		
        super.paint(g);
        int w = getWidth();
        int h = getHeight();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        int x = (w - imageWidth)/2;
        int y = (h - imageHeight)/2;
        
        if(drawDefault) {
        	g.drawImage(image, x, y, this);
        }
        else {
        	g.drawImage(image, 0, 0, imageX, imageY, this);
        }
     
    }
	
}
