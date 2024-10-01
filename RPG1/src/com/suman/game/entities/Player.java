package com.suman.game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.bag.Inventory;
import com.suman.game.bag.InventorySlot;
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

	private Inventory bag;
	
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
//		bounds = new Rectangle(16, 30, 31, 31);
		bounds = new Rectangle(0, 0, (Art.artResize / 2) - 1, (Art.artResize / 2) - 1);
		
		bag = new Inventory();
		
		bag.addItem(1, 10);
		bag.addItem(2, 20);
		bag.addItem(1, 5);
		bag.addItem(1, 30);
		bag.addItem(2, 100);
		bag.addItem(3, 50);
		bag.addItem(3, 23);
		
		for(InventorySlot it : bag.getItems())
		{
			System.out.print(game.getItemManager().getGameItem(it.getItemId()).getItemName());
			System.out.println("x"+it.getItemAmount());
		}
	}

	public void tick() {

		bounds.x = x + 16;
		bounds.y = y + 30;

		movePlayer();
		dx = 0;
		dy = 0;
	}

	private void movePlayer() {
		if (dy < 0) // moving up
		{
//			Without adding the displacement in the equation,
//			the player will get stuck to the tile
			int tileY = (dy + bounds.y) / World.tileSize;

			if (!game.getWorld().isSolid(bounds.x / World.tileSize, tileY)
					&& !game.getWorld().isSolid((bounds.x + bounds.width) / World.tileSize, tileY)) {
//				System.out.println("Move");
				y += dy;
			}
		} else if (dy > 0) // moving down
		{
			int tileY = (dy + bounds.y + bounds.height) / World.tileSize;

			if (!game.getWorld().isSolid(bounds.x / World.tileSize, tileY)
					&& !game.getWorld().isSolid((bounds.x + bounds.width) / World.tileSize, tileY)) {
//				System.out.println("Move");
				y += dy;
			}
		}

		if (dx < 0) // moving left
		{
			int tileX = (dx + bounds.x) / World.tileSize;

			if (!game.getWorld().isSolid(tileX, bounds.y / World.tileSize)
					&& !game.getWorld().isSolid(tileX, (bounds.y + bounds.height) / World.tileSize)) {
//				System.out.println("Move");
				x += dx;
			}
		} else if (dx > 0) // moving right
		{
			int tileX = (dx + bounds.x + bounds.width) / World.tileSize;

			if (!game.getWorld().isSolid(tileX, bounds.y / World.tileSize)
					&& !game.getWorld().isSolid(tileX, (bounds.y + bounds.height) / World.tileSize)) {
//				System.out.println("Move");
				x += dx;
			}
		}
	}

	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), x - game.getCamera().getoffsetX(), y - game.getCamera().getoffsetY(), Art.artResize,
				Art.artResize, null);

//		g2.setColor(Color.RED);
//		g2.drawRect(bounds.x - game.getCamera().getoffsetX(), bounds.y - game.getCamera().getoffsetY(), bounds.width,
//				bounds.height);
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

	public void interact(InteractableObject obj) {
		obj.interact();
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

	public Rectangle getBounds() {
		return bounds;
	}
}
