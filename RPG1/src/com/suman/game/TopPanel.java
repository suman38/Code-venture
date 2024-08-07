package com.suman.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TopPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Font f;
	public TopPanel()
	{
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Engine.GameWidth, 120));
		f = new Font("Comic Sans MS",Font.BOLD,22);
	}
	
	
	public void update()
	{
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("HP: 100/100", 30, 40);
		g.drawString("MP: 100/100", 30, 90);
		
		g.drawString("Location",550,40);
		g.drawString("x:    y: ", 550, 90);
	}	
}