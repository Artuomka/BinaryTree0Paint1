
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class TPanel extends JPanel
{
	BSTree0 lst = new BSTree0();
	
	public static  BufferedImage bi = new BufferedImage (1000, 900, BufferedImage.SCALE_DEFAULT);
	
	private TPanel() {
		
		
		TCommand cmd = TCommand.getInstance();
		cmd.setBI(bi);
		setBackground(Color.DARK_GRAY);		
		setBounds (10, 10, 1000, 900);
		Graphics2D gg = (Graphics2D) bi.getGraphics();
		gg.setColor(Color.WHITE);
		gg.fillRect(0, 0, 1000, 900);
		
	
	}	
	public static TPanel instance;
	
	
	public static TPanel getInstance()
	{
		if (instance == null)
		{
			instance = new TPanel();
		}		
		return instance;
	}
	
	
	public void paint (Graphics g) {
		super.paint(g);
		TreeGUI tr = TCommand.getInstance().tr;
		if (tr!=null&&tr.size()>0) {
			tr.draw((Graphics2D)g, 1000);
		}
	}
}

