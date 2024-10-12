package com.suman.game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.worldtiles.World;

public abstract class InteractableObject {

	protected Game game;
	protected int x, y;// position on the world

	protected final int objectSize = Art.artResize;

	protected boolean interacted = false;

	protected Rectangle bounds;

	public InteractableObject(Game game, int indexX, int indexY) {
		this.game = game;
		this.x = indexX * World.tileSize;
		this.y = indexY * World.tileSize;

		bounds = new Rectangle(0, 0, objectSize, objectSize);
	}

	public abstract void tick();

	public abstract void render(Graphics2D g2);

	public abstract void interact();
	
	public abstract int dropItem();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
