package com.suman.game.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.worldtiles.World;

public class Player {

	private Game game;
	private int x, y, dx, dy;

	private int hp, maxHp, mp, maxMp;

	private final int MoveSpeed = 10;

	private int currentSprite = 0;
	private int counter = 0;

	private boolean moving = false;

	// I am adding this to avoid confusion in the math
	private Rectangle bounds;

	public Player(Game game) {
		this.game = game;

		// player spawn points on the map
		x = 3 * World.tileSize;
		y = 4 * World.tileSize;

		maxHp = 100;
		maxMp = 50;
		hp = maxHp;
		mp = maxMp;

		// From point A to point D of player Sprite.
		// As explained in the video.
		bounds = new Rectangle(0, 0, Art.artResize, Art.artResize);
	}

	public void tick() {

		movePlayer();
		dx = 0;
		dy = 0;
	}

	private void movePlayer() {
		if (dy < 0) // moving up
		{
//			Without adding the displacement in the equation,
//			the player will keep bouncing off the tile
			int tileY = (y + dy + bounds.y) / World.tileSize;

			if (!game.getWorld().isSolid((x + bounds.x) / World.tileSize, tileY)
					&& !game.getWorld().isSolid((x + bounds.x + bounds.width) / World.tileSize, tileY)) {
//				System.out.println("Move");

				y += dy;
			} else {
//				System.out.println("Cannot move");

//				y = (3*64)+(64-0) 
//				y = 192+64 -> tree tile at 192 so player is stuck below the tree tile.
				y = (tileY * World.tileSize) + (World.tileSize - bounds.y);
			}
		} else if (dy > 0) // moving down
		{
			int tileY = (y + dy + bounds.y + bounds.height) / World.tileSize;

			if (!game.getWorld().isSolid((x + bounds.x) / World.tileSize, tileY)
					&& !game.getWorld().isSolid((x + bounds.x + bounds.width) / World.tileSize, tileY)) {
//				System.out.println("Move");
				y += dy;
			} else {
//				System.out.println("Cannot Move");
//				y = (3*64)-0-64-1;
//				y = 192-65 = same thing as above but this time the player stuck above the tile(-ve axis)
//				if we adjust the bounds a little then the bounds.x and y will also come into effect.
				y = (tileY * World.tileSize) - bounds.y - bounds.height - 1;
			}
		}

		if (dx < 0) // moving left
		{
			int tileX = (x + dx + bounds.x) / World.tileSize;

			if (!game.getWorld().isSolid(tileX, (y + bounds.y) / World.tileSize)
					&& !game.getWorld().isSolid(tileX, (y + bounds.y + bounds.height) / World.tileSize)) {
//				System.out.println("Move");
				x += dx;
			} else {
//				System.out.println("Cannot move");
				x = (tileX * World.tileSize) + (World.tileSize - bounds.x);
			}
		} else if (dx > 0) // moving right
		{
			int tileX = (x + dx + bounds.x + bounds.width) / World.tileSize;

			if (!game.getWorld().isSolid(tileX, (y + bounds.y) / World.tileSize)
					&& !game.getWorld().isSolid(tileX, (y + bounds.y + bounds.height) / World.tileSize)) {
//				System.out.println("Move");
				x += dx;
			} else {
//				System.out.println("Cannot move");
				x = (tileX * World.tileSize) - bounds.y - bounds.width - 1;
			}
		}
	}

	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), x - game.getCamera().getoffsetX(), y - game.getCamera().getoffsetY(), Art.artResize,
				Art.artResize, null);

		g2.setColor(Color.RED);
		g2.drawRect(x + bounds.x - game.getCamera().getoffsetX(), y + bounds.y - game.getCamera().getoffsetY(),
				bounds.width, bounds.height);
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
		JOptionPane.showMessageDialog(game, "Not done yet", "Player Error", JOptionPane.ERROR_MESSAGE);
	}

	public void movePlayerHorizontally(int flag) {
		dx = MoveSpeed * flag;
	}

	public void movePlayerVertically(int flag) {
		dy = MoveSpeed * flag;
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
