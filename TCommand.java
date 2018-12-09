
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.w3c.dom.css.RGBColor;

public class TCommand 
{
	public TreeGUI tr;
	
	ActionRepaint aRepaint;
	public RenderedImage bi;

	ActionChange aChange;

	
	private TCommand()
	{		
		aRepaint = new ActionRepaint();
		aChange = new ActionChange();
		int [] ini = {34, 10, 1, 15, 78, 94, 36, 42, 999};
		tr = new TreeGUI();
		tr.init(ini);
	}
	public static TCommand instance;
	
	
	public static TCommand getInstance()
	{
		if (instance == null)
		{
			instance = new TCommand();
		}		
		return instance;
	}
	
	public void setBI(BufferedImage bi)
		{
		this.bi= bi;
		}
	class ActionRepaint implements ActionListener
	{
		@Override 
		public void actionPerformed (ActionEvent e)
		{		
		TPanel.getInstance().repaint();
		}
		
	}
	class ActionChange implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String btnPressed = e.getActionCommand();
			String str_val = TButtonPanel.txt;
			switch (btnPressed) {
			case "Add":				
				tr.add(Integer.parseInt(str_val));
				TPanel.getInstance().repaint();
				break;
			
			case "Del":
				tr.del(Integer.parseInt(str_val));
				TPanel.getInstance().repaint();
				break;
				
			
			}
		}
		
	}
}




