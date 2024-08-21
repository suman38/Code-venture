package com.suman.game.art;

import java.awt.image.BufferedImage;

public class Art {

	private final int artSize = 16;
	public final int artResize = 32;

	private SpriteSheet playersheet;
	private SpriteSheet tileSheet;

	public BufferedImage[] playerMovingDown;
	public BufferedImage[] playerMovingUp;
	public BufferedImage[] playerMovingLeft;
	public BufferedImage[] playerMovingRight;

	public BufferedImage playerDown, playerUp, playerLeft, playerRight;

	public BufferedImage grass, water, dirt, cement, rock;

	public Art() {
		playersheet = new SpriteSheet("/playerimages/player_sheet_16x16.png");
		tileSheet = new SpriteSheet("/tiles/tile_sheet_48x32.png");

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
		dirt = tileSheet.crop(0, artSize, artSize, artSize);
		rock = tileSheet.crop(artSize, artSize, artSize, artSize);
	}
}
