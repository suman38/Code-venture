package com.suman.game.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.suman.game.Game;

public class Player {

	private Game game;
	private int x, y;

	private boolean moving = false;
	private final int MoveSpeed = 5;
	private int currentSprite = 0;
	private int counter = 0;

	public Player(Game game) {
		this.game = game;
	}

	public void tick() {
	}

	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), x, y, game.getArt().artResize, game.getArt().artResize, null);
	}

	private BufferedImage getImage() {

		BufferedImage img = game.getArt().playerDown;
		
		if (moving) {
			counter++;

			if (game.getDirection() == 1) {
				// up
				img = game.getArt().playerMovingUp[currentSprite];
			} else if (game.getDirection() == 2) {
				// down
				img = game.getArt().playerMovingDown[currentSprite];
			} else if (game.getDirection() == 3) {
				// left
				img = game.getArt().playerMovingLeft[currentSprite];
			} else if (game.getDirection() == 4) {
				// right
				img = game.getArt().playerMovingRight[currentSprite];
			}

			if (counter == 6) {
				currentSprite++;

				if (currentSprite > 3)
					currentSprite = 0;

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

	public void movePlayerHorizontally(int flag) {
		x += MoveSpeed * flag;
	}

	public void movePlayerVertically(int flag) {
		y += MoveSpeed * flag;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

}
