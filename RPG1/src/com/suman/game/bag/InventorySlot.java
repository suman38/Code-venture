package com.suman.game.bag;

public class InventorySlot {

	private int itemId;
	private int itemAmount;

	public InventorySlot(int id, int amount) {
		this.itemId = id;
		this.itemAmount = amount;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public int getItemId() {
		return itemId;
	}
}
