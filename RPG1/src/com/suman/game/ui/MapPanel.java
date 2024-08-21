package com.suman.game.ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String path = "/misc/worldmap.png";

	public MapPanel() {
		setBackground(Color.BLACK);
		JLabel lbl = new JLabel(new ImageIcon(getClass().getResource(path)));
		lbl.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		add(lbl);
	}
}
