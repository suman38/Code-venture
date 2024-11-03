package com.suman.game.entities.npcs;

import java.awt.Graphics2D;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.entities.NPC;

public class ShopNPC extends NPC {

	public ShopNPC(Game game, int indexX, int indexY) {
		super(game, 2, indexX, indexY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(game.getArt().npc_shop, x - game.getCamera().getoffsetX(), y - game.getCamera().getoffsetY(),
				Art.artResize, Art.artResize, null);
	}

	@Override
	public void interact() {
		System.out.println("How can I help you adventurer?");
	}

	@Override
	public int dropItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
