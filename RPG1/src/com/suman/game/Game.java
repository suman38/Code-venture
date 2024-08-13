package com.suman.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.suman.game.art.Art;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;

	private BufferedImage img1;
	private int x, y, width, height;

	private int playerMoveSpeed = 5;

	private Art art;
	
	// This is for the rendering the game
	public Game() {
		
		art = new Art();
		
		try {
			img1 = ImageIO.read(getClass().getResource("/playerimages/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 0;
		y = 200;
		width = img1.getWidth();
		height = img1.getHeight();
	}

	public void tick() {
		x += playerMoveSpeed;
		// y += playerMoveSpeed;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img1, x, y, width, height, null);
		
		g2.drawImage(art.playerDown, x, 0, art.artResize, art.artResize, null);
		g2.drawImage(art.grass,100,0,art.artResize,art.artResize,null);
		
		
		g2.dispose();
	}
}
