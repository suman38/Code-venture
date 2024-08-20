package com.suman.game.ui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapPanel extends JDialog{

	private static final long serialVersionUID = 1L;

	public MapPanel(JFrame frm)
	{
		super(frm,"World Map");
				
		JLabel lbl = new JLabel(new ImageIcon(getClass().getResource("/misc/worldmap.png")));
		lbl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(lbl);
		
		pack();
		setLocationRelativeTo(frm);
	}
}
