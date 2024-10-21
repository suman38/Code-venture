package com.suman.game.entities.objects;

import java.awt.Graphics2D;

import com.suman.game.Game;
import com.suman.game.entities.InteractableObject;

public class ActionBox extends InteractableObject{

	public ActionBox(Game game, int indexX, int indexY) {
		super(game, indexX, indexY);
		// TODO Auto-generated constructor stub
		
		bounds.x = x;
		bounds.y = y;
		
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
