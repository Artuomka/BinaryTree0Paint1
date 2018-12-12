import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TreeGUI extends BSTree0
{
	private int r=17;

	public void draw (Graphics2D gg, int right) {
		drawNode (gg, 0, right, 1, 50, root);
	}
	
	public void drawNode (Graphics2D gg, int left, int right, int level, int dy, Node p) {
		if (p==null) 
		return;
		
		
		
		int x = (left+right)/2;
		int y = level*dy;
		
		int x0 = x-r;
		int y0 = y-r;
		String txt = String.valueOf(p.val);
		int strW = gg.getFontMetrics().stringWidth(String.valueOf(p.val));
		int strH = gg.getFontMetrics().getHeight();
		int strX = x-strW/2;
		int strY = y+strH/3;
		
		int d = r*2;
		
		if (p.left!=null) {
			gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			gg.setColor(Color.yellow);
			gg.setStroke(new BasicStroke(2));
			gg.drawLine(x, y+r, (left+x)/2, (level+1)*dy-r);
			gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		}
		if (p.right!=null) {
			gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			gg.setColor(Color.yellow);
			gg.setStroke(new BasicStroke(2));
			gg.drawLine(x, y+r, (right+x)/2, (level+1)*dy-r);
			gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		}
		
		gg.setColor(Color.GREEN);
		gg.setStroke(new BasicStroke(4));
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gg.drawOval(x0, y0, d, d);
		gg.setColor(Color.WHITE);
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		Font font = new Font("Tahoma", Font.BOLD|Font.CENTER_BASELINE, 12);
		gg.setFont(font);
		gg.drawString(txt, strX, strY);
		
		
		
		
		
		drawNode (gg, left, x, level+1, dy, p.left);
		drawNode (gg, x, right, level+1, dy, p.right);
		
		
	}
	
}
