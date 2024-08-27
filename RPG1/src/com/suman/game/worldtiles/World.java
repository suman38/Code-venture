package com.suman.game.worldtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.utils.StringUtils;

public class World {

	private Game game;
	private String path = "res/maps/";
	private int[][] map;
	private int mapCols, mapRows;
	private int width, height;
	public static final int tileSize = Art.artResize;
	
	public World(Game game) {
		this.game = game;
	}

	public void tick() {

	}

	public void render(Graphics2D g2) {
//		g2.drawImage(getImage(1,1),0,0,32,32,null);

		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapCols; j++) {
				g2.drawImage(getImage(j,i), i * tileSize - game.getCamera().getoffsetX(), j * tileSize - game.getCamera().getoffsetY(), tileSize, tileSize, null);
			}
		}
	}

	private BufferedImage getImage(int x, int y) {
		BufferedImage img = game.getArt().cement;
		
		if (map[x][y] == 1)
			img = game.getArt().water;
		else if (map[x][y] == 2)
			img = game.getArt().grass;
		else if (map[x][y] == 3)
			img = game.getArt().dirt;
		else if(map[x][y] == 4)
			img = game.getArt().tree;
		
		return img;
	}

	public void loadWorld(String name) {
		String[] tokens = StringUtils.loadFileAsString(path + name + ".txt").split("\\s+");

//		for (String s : tokens)
//			System.out.println(s);

		// first 2 counter tokens to find the max rows and cols
		mapRows = Integer.parseInt(tokens[0]);
		mapCols = Integer.parseInt(tokens[1]);
		width = mapCols*tileSize;
		height = mapRows*tileSize;

		map = new int[mapRows][mapCols];
		
		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapCols; j++) {

				/*
				 * start from row = 3 and count till the end 
				 * math: (j+i*rows)+2; 
				 * (0+0*5)+2 = [2]-> 3rd element -> 1st row 1st col 
				 * (1+0*5)+2 = [3]-> 4th element -> 1st row 2nd col 
				 * (1+1*5)+2 = [8]-> 9th element -> 2nd row 2nd col
				 */

				map[i][j] = Integer.parseInt(tokens[(j + i * mapRows) + 2]);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
