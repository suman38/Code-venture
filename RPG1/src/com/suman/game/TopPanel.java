package com.suman.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Font f;

	public TopPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Engine.GameWidth, 120));
		f = new Font("Comic Sans MS", Font.BOLD, 22);
	}

	public void update() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g2.setFont(f);
		g2.setColor(Color.BLACK);
		g2.drawString("HP: 100/100", 30, 40);
		g2.drawString("MP: 100/100", 30, 90);

		g2.drawString("Location", 550, 40);
		g2.drawString("x:    y: ", 550, 90);

		g2.dispose();
	}
}
