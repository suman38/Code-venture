package com.suman.game.items;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

	private List<GameItem> gameItems;
	
	public ItemManager()
	{
		gameItems = new ArrayList<GameItem>();
		
		gameItems.add(new GameItem(1, "Stone Piece"));
		gameItems.add(new GameItem(2, "Bone Shard"));
		gameItems.add(new GameItem(3, "Spirit Crystal"));
	}
	
	public GameItem getGameItem(int id)
	{
		for(GameItem i : gameItems)
		{
			if(i.getItemId() == id)
				return i;
		}
		
		return null;
	}
}
