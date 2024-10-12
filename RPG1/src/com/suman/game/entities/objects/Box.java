package com.suman.game.entities.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.suman.game.Game;
import com.suman.game.entities.InteractableObject;

public class Box extends InteractableObject {

	private List<Integer> dropTable;

	public Box(Game game, int indexX, int indexY) {
		super(game, indexX, indexY);

		bounds.x = x + 4;
		bounds.y = y + 6;
		bounds.width = objectSize - 9;
		bounds.height = objectSize - 10;

		dropTable = new ArrayList<Integer>();
		dropTable.add(3); // Magic Crystal
		dropTable.add(2); // Bone Shard
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g2) {
		if (!interacted)
			g2.drawImage(game.getArt().box[0], x - game.getCamera().getoffsetX(), y - game.getCamera().getoffsetY(),
					objectSize, objectSize, null);
		else
			g2.drawImage(game.getArt().box[1], x - game.getCamera().getoffsetX(), y - game.getCamera().getoffsetY(),
					objectSize, objectSize, null);

//		g2.setColor(Color.YELLOW);
//		g2.drawRect(bounds.x-game.getCamera().getoffsetX(), bounds.y-game.getCamera().getoffsetY(),bounds.width, bounds.height);
	}

	@Override
	public void interact() {
		if (!interacted)
			interacted = true;
	}

	@Override
	public int dropItem() {
		
		int roll = (int) (Math.random()*100)+1;
		
		if(roll >= 85)
			return dropTable.get(0);
		else if(roll >= 50 && roll < 85)
			return dropTable.get(1);
		else
			return 0;
	}

}
