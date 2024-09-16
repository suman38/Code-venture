package com.suman.game.entities.objects;

import java.awt.Graphics2D;

import com.suman.game.Game;
import com.suman.game.entities.InteractableObject;

public class Box extends InteractableObject {

	public Box(Game game, int indexX, int indexY) {
		super(game, indexX, indexY);

		bounds.x = x + 4;
		bounds.y = y + 6;
		bounds.width = objectSize - 9;
		bounds.height = objectSize - 10;
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

}
