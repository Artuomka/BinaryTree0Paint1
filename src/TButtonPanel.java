
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TButtonPanel extends JPanel

{
	
	
	public static String txt;
	TCommand cmd = TCommand.getInstance();
	public TButtonPanel() {
		setBackground(Color.DARK_GRAY);
	
		setBounds(10, 10, 600, 560);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField txt1 = new JTextField();
		JButton btnRepaint = new JButton("Repaint");
		JButton btnAdd = new JButton ("Add");
		JButton btnDel = new JButton ("Delete");
		JLabel lab1 = new JLabel("VALUE:");
		lab1.setForeground(Color.WHITE);
		Font font = new Font("Tahoma", Font.BOLD|Font.CENTER_BASELINE, 18);
		
		lab1.setFont(font);
		
		add(lab1, gbc);
		add (txt1, gbc);
		add (btnAdd, gbc);
		add (btnDel, gbc);
		add(btnRepaint, gbc);
		
	
		
		btnRepaint.setActionCommand("Repaint");
		btnAdd.setActionCommand ("Add");
		btnDel.setActionCommand ("Del");
		
		btnAdd.addActionListener(cmd.aChange);
		btnDel.addActionListener(cmd.aChange);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 txt = txt1.getText();				
			}
		});
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 txt = txt1.getText();				
			}
		});
		
		
		btnRepaint.addActionListener(cmd.aRepaint);
		
//		btnBLACK.setBounds(25, 20, 100, 30);	
	

	}

}
