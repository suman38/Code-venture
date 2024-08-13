package com.suman.game.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundRemover {

	private BufferedImage result;

	public BufferedImage loadPath(String path) {
		try {
			result = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		replaceColor(result, new Color(255, 0, 255), new Color(0, 0, 0, 0));

		return result;
	}

	// I found the below code at:
	// https://gamedev.stackexchange.com/questions/101228/tilesets-how-to-make-the-pink-color-appear-transparent

	private void replaceColor(BufferedImage image, Color oldColor, Color newColor) {
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {

				// get the rgb code at that pixel
				int color = image.getRGB(x, y);

				// if color == pink then change it to 0(black) with alpha 0(transparent)
				if (color == oldColor.getRGB()) {
					image.setRGB(x, y, newColor.getRGB());
				}
			}
		}
	}
}
