package com.suman.game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.bag.Inventory;
import com.suman.game.entities.npcs.CommonerNPC;
import com.suman.game.entities.npcs.HealerNPC;
import com.suman.game.entities.npcs.MayorNPC;
import com.suman.game.entities.npcs.ShopNPC;
import com.suman.game.worldtiles.World;

public class Player implements Serializable {

	// transient modifier to avoid being serialized.
	// Final variables are constants by default hence no use serializing.
	// Static and non static variables can be serialized.

	private static final long serialVersionUID = 1L;
	private transient Game game;
	private int x, y;
	private transient int dx, dy;

	private int playerLevel;

	private int hp, mp;
	private int maxHp, maxMp;

	private final int MoveSpeed = 10;

	private transient int currentSprite = 0;
	private transient int counter = 0;

	private transient boolean moving = false;

	// I am adding this to avoid confusion in the math
	private transient Rectangle bounds;

	private transient Inventory bag;
	
	private String mapName;

	public Player(Game game) {
		this.game = game;
		// player spawn points on the map
//		x = 3 * World.tileSize;
//		y = 4 * World.tileSize;

		maxHp = 100;
		maxMp = 50;
		hp = maxHp;
		mp = maxMp;
		playerLevel = 1;

		// From point A to point D of player Sprite.
		// As explained in the video.
//		bounds = new Rectangle(16, 30, 31, 31);
		bounds = new Rectangle(0, 0, (Art.artResize / 2) - 1, (Art.artResize / 2) - 1);

		bag = new Inventory();

//		bag.addItem(1, 10);
//		bag.addItem(2, 20);
//		bag.addItem(1, 5);
//		bag.addItem(1, 30);
//		bag.addItem(2, 100);
//		bag.addItem(3, 50);
//		bag.addItem(3, 23);

//		for (InventorySlot it : bag.getItems()) {
//			System.out.print(game.getItemManager().getGameItem(it.getItemId()).getItemName());
//			System.out.println("x" + it.getItemAmount());
//		}
	}

	public void setSpawn(int sx, int sy) {
		x = sx * World.tileSize;
		y = sy * World.tileSize;
	}

	public void tick() {

		bounds.x = x + 16;
		bounds.y = y + 30;

		movePlayer();
		dx = 0;
		dy = 0;
	}

	@Override
	public String toString() {
//		return "Player[Level:," + playerLevel + "x:" + x + ", y:" + y + ", dx:" + dx + ", dy:" + dy + ", hp:" + hp
//				+ ", maxHp:" + maxHp + ",mp:" + mp + ",maxmp:" + maxMp + "]";

		String str = "Player[Level:%d, x:%d, y:%d, HP:%d, MaxHP:%d, MP:%d, MaxMP:%d, MapName: %s]";
		return String.format(str, playerLevel, x, y, hp, maxHp, mp, maxMp,mapName);
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

		// this exception happened because I returned 0
		// no item exists in id = 0;

		if (!(obj instanceof NPC)) {
			if (!obj.interacted) {

				int item = obj.dropItem();
				if (item != 0) {
					int amount = (int) (Math.random() * 5) + 1;

					System.out.println(
							"You got: " + game.getItemManager().getGameItem(item).getItemName() + " x " + amount);
					bag.addItem(item, amount);
				} else {
					System.out.println("--Empty--");
				}
			} else {
				System.out.println("--Already interacted--");
			}
			obj.interact();
		} else {
			NPC n1 = (NPC) obj;
			switch (n1.getNpcId()) {
			case 1:
				CommonerNPC c1 = (CommonerNPC) n1;
				c1.interact();
				break;

			case 2:
				ShopNPC s1 = (ShopNPC) n1;
				s1.interact();
				break;

			case 3:
				HealerNPC h1 = (HealerNPC) n1;
				h1.interact();
				break;

			case 4:
				MayorNPC m1 = (MayorNPC) n1;
				m1.interact();
				break;
			}
		}
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(int level) {
		this.playerLevel = level;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Inventory getBag() {
		return bag;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
}
