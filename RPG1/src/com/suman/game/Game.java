package com.suman.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;

	private BufferedImage img1;
	private int x,y,width,height;
	
	//best practise would be "res" but who cares.
	
	// This is for the rendering the game
	public Game() {

		//That's it
		
		try {
			img1 = ImageIO.read(getClass().getResource("/playerimages/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		x = 100;
		y = 200;
		width = img1.getWidth();
		height = img1.getHeight();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(img1, x+100, y, width, height, null);
//		g2.drawImage(img1, x, y+20, width, height, null);
//		g2.drawImage(img1, x+50, y+40, width, height, null);
//		g2.drawImage(img1, x-10, y-20, width, height, null);
		
		g2.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
