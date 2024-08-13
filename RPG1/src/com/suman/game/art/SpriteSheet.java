package com.suman.game.art;

import java.awt.image.BufferedImage;

import com.suman.game.utils.BackgroundRemover;

public class SpriteSheet {

	private BackgroundRemover bgRemover;
	private BufferedImage img;

	public SpriteSheet(String path) {
		bgRemover = new BackgroundRemover();
		img = bgRemover.loadPath(path);
	}

	public BufferedImage crop(int x, int y, int width, int height) {
		return img.getSubimage(x, y, width, height);
	}
}
