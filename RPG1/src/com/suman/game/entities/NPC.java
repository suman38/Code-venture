package com.suman.game.entities;

import com.suman.game.Game;

public abstract class NPC extends InteractableObject{

	/*
	 * ids:
	 * 
	 * 1. commoner
	 * 2. shop
	 * 3. healer
	 * 4. mayor
	 * 
	 * */
	
	
	protected int npcId;
	public NPC(Game game, int npcId, int indexX, int indexY) {
		super(game, indexX, indexY);
		this.npcId = npcId;
	}
	
	public int getNpcId()
	{
		return npcId;
	}

}
