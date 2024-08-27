package com.suman.game.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import com.suman.game.Game;
import com.suman.game.art.Art;

public class Player {

	private Game game;
	private int x, y;

	private int hp, maxHp, mp, maxMp;

	private final int MoveSpeed = 10;

	private int currentSprite = 0;
	private int counter = 0;

	private boolean moving = false;

	public Player(Game game) {
		this.game = game;

		maxHp = 100;
		maxMp = 50;
		hp = maxHp;
		mp = maxMp;
	}

	public void tick() {
		
	}

	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), x - game.getCamera().getoffsetX(), y - game.getCamera().getoffsetY(), Art.artResize,
				Art.artResize, null);
	}

	private BufferedImage getImage() {
		BufferedImage img = game.getArt().playerDown;

		if (moving) {

			if (game.getDirection() == 1)
				img = game.getArt().playerMovingUp[currentSprite];
			else if (game.getDirection() == 2)
				img = game.getArt().playerMovingDown[currentSprite];
			else if (game.getDirection() == 3)
				img = game.getArt().playerMovingLeft[currentSprite];
			else if (game.getDirection() == 4)
				img = game.getArt().playerMovingRight[currentSprite];

			counter++;
			if (counter > 7) {
				currentSprite++;
				if (currentSprite > 3) {
					currentSprite = 0;
				}
				counter = 0;
			}
		} else {
			if (game.getDirection() == 1)
				img = game.getArt().playerUp;
			else if (game.getDirection() == 2)
				img = game.getArt().playerDown;
			else if (game.getDirection() == 3)
				img = game.getArt().playerLeft;
			else if (game.getDirection() == 4)
				img = game.getArt().playerRight;
		}

		return img;
	}

	public void interact() {
		JOptionPane.showMessageDialog(game, "Not done yet","Player Error",JOptionPane.ERROR_MESSAGE);
	}

	public void movePlayerHorizontally(int flag) {
		x += MoveSpeed * flag;
	}

	public void movePlayerVertically(int flag) {
		y += MoveSpeed * flag;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
