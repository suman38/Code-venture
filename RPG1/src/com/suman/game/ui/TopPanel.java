package com.suman.game.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.suman.game.Engine;
import com.suman.game.art.Art;
import com.suman.game.entities.Player;
import com.suman.game.worldtiles.World;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Player player;
	private Font f;
	private RenderingHints textRendering;

	private int hp, mp, maxHp, maxMp;
	private int posx, posy;

	public TopPanel(Player player) {
		this.player = player;
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(Engine.GameWidth, 120));
		f = new Font("Arial", Font.BOLD, 22);
		textRendering = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	public void tick() {
		hp = player.getHp();
		mp = player.getMp();
		maxHp = player.getMaxHp();
		maxMp = player.getMaxMp();

		posx = ((player.getX() + Art.artResize / 2) / World.tileSize) + 1;
		posy = ((player.getY() + Art.artResize / 2) / World.tileSize) + 1;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(textRendering);
		g2.setFont(f);
		g2.setColor(Color.YELLOW);
		g2.drawString("Hp: " + hp + "/" + maxHp, 30, 40);
		g2.drawString("Mp: " + mp + "/" + maxMp, 30, 90);

		g2.drawString("Place name", 550, 40);
		g2.drawString("X: " + posx + "  Y: " + posy, 550, 90);

		g2.dispose();
	}
}
