import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

@SuppressWarnings("serial")
public class Scaler extends Frame implements AdjustmentListener {

	ScalableWindow s = new ScalableWindow();
	
	public Scaler() {
		
	  scrollSize.addAdjustmentListener(this);
		
	  setSize(100,600);
	  setLocation(100,100);
	  Panel p = new Panel();
	  p.setLayout(new GridLayout(1, 0));
	  p.add(scrollSize);
	  add(p, "Center");
	  setVisible(true);
	}
	
	private Scrollbar scrollSize = new Scrollbar(Scrollbar.VERTICAL, 100, 0, 20, 100);
	
	public int imageSize;

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		s.drawDefault = false;
		
		imageSize = scrollSize.getValue();
		
		s.imageX = 7 * imageSize;
		s.imageY = 6 * imageSize;
		
		s.repaint();
	}
	
}
