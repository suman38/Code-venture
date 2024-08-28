package com.suman.game;

import com.suman.game.art.Art;

public class Camera {

	private Game game;

	private int offsetX, offsetY;

	public Camera(Game game) {
		this.game = game;
	}

	public void centerOnPlayer() {
		offsetX = game.getPlayer().getX() - game.getWidth() / 2 + Art.artResize / 2;
		offsetY = game.getPlayer().getY() - game.getHeight() / 2 + Art.artResize / 2;
		removeBlankSpace();
	}
	
	private void removeBlankSpace()
	{
		//fix the offsetX from 0 to ((25*64)-640) = 0 to 960
		//fix the offsetY from 0 to ((25*64)-480) = 0 to 1120
		//This will prevent the camera from going out of the bounds.
		
		if(offsetX<0)
			offsetX = 0;
		else if(offsetX > game.getWorld().getWidth() - game.getWidth())
			offsetX = game.getWorld().getWidth() - game.getWidth();
		
		if(offsetY<0)
			offsetY = 0;
		else if(offsetY > game.getWorld().getHeight() - game.getHeight())
			offsetY = game.getWorld().getHeight() - game.getHeight();
	}

	public int getoffsetX() {
		return offsetX;
	}

	public int getoffsetY() {
		return offsetY;
	}

}
