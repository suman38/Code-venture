package com.suman.game.entities.objects;

import java.awt.Graphics2D;

import com.suman.game.Game;
import com.suman.game.entities.InteractableObject;

public class ActionBox extends InteractableObject {

	private String next_map;

	public ActionBox(Game game, int indexX, int indexY, String next_map) {
		super(game, indexX, indexY);
		this.next_map = next_map;
	}

	public String getNextMap() {
		return next_map;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics2D g2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
	}

	@Override
	public int dropItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
