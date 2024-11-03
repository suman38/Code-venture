package com.suman.game.art;

import java.awt.image.BufferedImage;

public class Art {

	private final int artSize = 16;
	public static final int artResize = 64;

	private SpriteSheet playersheet;
	private SpriteSheet tileSheet;
	private SpriteSheet objectsSheet;
	private SpriteSheet npcSheet;

	public BufferedImage[] playerMovingDown;
	public BufferedImage[] playerMovingUp;
	public BufferedImage[] playerMovingLeft;
	public BufferedImage[] playerMovingRight;

	public BufferedImage playerDown, playerUp, playerLeft, playerRight;

	public BufferedImage grass, water, dirt, cement, rock, tree;
	
	public BufferedImage[] box;
	
	public BufferedImage npc_common1, npc_common2, npc_healer, npc_shop;

	public Art() {
		playersheet = new SpriteSheet("/playerimages/player_sheet_16x16.png");
		tileSheet = new SpriteSheet("/tiles/tile_sheet2.png");
		objectsSheet = new SpriteSheet("/objects/boxes_16x16.png");
		npcSheet = new SpriteSheet("/misc/npcsheet_32x32.png");

		playerMovingDown = new BufferedImage[4];
		playerMovingDown[0] = playersheet.crop(artSize, 0, artSize, artSize);
		playerMovingDown[1] = playersheet.crop(0, 0, artSize, artSize);
		playerMovingDown[2] = playersheet.crop(artSize * 2, 0, artSize, artSize);
		playerMovingDown[3] = playersheet.crop(0, 0, artSize, artSize);

		playerMovingUp = new BufferedImage[4];
		playerMovingUp[0] = playersheet.crop(artSize, artSize, artSize, artSize);
		playerMovingUp[1] = playersheet.crop(0, artSize, artSize, artSize);
		playerMovingUp[2] = playersheet.crop(artSize * 2, artSize, artSize, artSize);
		playerMovingUp[3] = playersheet.crop(0, artSize, artSize, artSize);

		playerMovingLeft = new BufferedImage[4];
		playerMovingLeft[0] = playersheet.crop(artSize, artSize * 2, artSize, artSize);
		playerMovingLeft[1] = playersheet.crop(0, artSize * 2, artSize, artSize);
		playerMovingLeft[2] = playersheet.crop(artSize * 2, artSize * 2, artSize, artSize);
		playerMovingLeft[3] = playersheet.crop(0, artSize * 2, artSize, artSize);

		playerMovingRight = new BufferedImage[4];
		playerMovingRight[0] = playersheet.crop(artSize, artSize * 3, artSize, artSize);
		playerMovingRight[1] = playersheet.crop(0, artSize * 3, artSize, artSize);
		playerMovingRight[2] = playersheet.crop(artSize * 2, artSize * 3, artSize, artSize);
		playerMovingRight[3] = playersheet.crop(0, artSize * 3, artSize, artSize);

		playerDown = playersheet.crop(0, 0, artSize, artSize);
		playerUp = playersheet.crop(0, artSize, artSize, artSize);
		playerLeft = playersheet.crop(0, artSize * 2, artSize, artSize);
		playerRight = playersheet.crop(0, artSize * 3, artSize, artSize);

		grass = tileSheet.crop(0, 0, artSize, artSize);
		water = tileSheet.crop(artSize, 0, artSize, artSize);
		cement = tileSheet.crop(artSize * 2, 0, artSize, artSize);
		dirt = tileSheet.crop(artSize*2, artSize, artSize, artSize);
		rock = tileSheet.crop(artSize, artSize, artSize, artSize);
		tree = tileSheet.crop(0, artSize, artSize, artSize);
		
		box = new BufferedImage[2];
		box[0] = objectsSheet.crop(0, 0, artSize, artSize);
		box[1] = objectsSheet.crop(artSize, 0, artSize, artSize);
		
		npc_common1 = npcSheet.crop(0, 0, artSize, artSize);
		npc_common2 = npcSheet.crop(artSize, 0, artSize, artSize);
		npc_shop = npcSheet.crop(artSize, artSize, artSize, artSize);
		npc_healer = npcSheet.crop(0, artSize, artSize, artSize);			
	}
}
