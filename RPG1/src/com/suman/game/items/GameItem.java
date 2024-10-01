package com.suman.game.items;

public class GameItem {

	private int itemId;
	private String itemName;
	
	public GameItem(int id, String name)
	{
		this.itemId = id;
		this.itemName = name;
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}
}
