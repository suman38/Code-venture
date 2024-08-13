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
	private RenderingHints textRendering;

	public TopPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Engine.GameWidth, 120));
		f = new Font("Arial", Font.BOLD, 22);
		textRendering = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	public void tick() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(textRendering);
		g2.setFont(f);
		g2.setColor(Color.BLACK);
		g2.drawString("Hp: 100/100", 30, 40);
		g2.drawString("Mp: 100/100", 30, 90);

		g2.drawString("Place name", 550, 40);
		g2.drawString("x:     y: ", 550, 90);

		g2.dispose();
	}
}
