package com.suman.game.bag;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<InventorySlot> items;

	public Inventory() {
		items = new ArrayList<InventorySlot>();
	}

	public void addItem(int id, int amount) {
		for (InventorySlot i : items) {
			if (i.getItemId() == id) {
				i.setItemAmount(i.getItemAmount() + amount);
				return;
			}
		}
		items.add(new InventorySlot(id, amount));
	}

	public List<InventorySlot> getItems() {
		return items;
	}

}
