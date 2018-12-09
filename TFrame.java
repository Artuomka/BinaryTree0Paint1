
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TFrame extends JFrame
{
	public TFrame()
	{
		//setLayout(null);
		setTitle("PaintTree");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setBounds(50, 10, 1200, 700);
		TCommand cmd = TCommand.getInstance();
		TPanel pan = TPanel.getInstance();
		
		add(pan);
		TButtonPanel bpan = new TButtonPanel();	
		add(pan);
		add(bpan, BorderLayout.EAST);
		setVisible(true);
	}
}
