package com.suman.game.worldtiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.suman.game.Game;
import com.suman.game.art.Art;
import com.suman.game.entities.InteractableObject;
import com.suman.game.entities.npcs.CommonerNPC;
import com.suman.game.entities.npcs.HealerNPC;
import com.suman.game.entities.npcs.MayorNPC;
import com.suman.game.entities.npcs.ShopNPC;
import com.suman.game.entities.objects.ActionBox;
import com.suman.game.entities.objects.Box;
import com.suman.game.utils.StringUtils;

public class World {

	private Game game;
	private String path = "res/maps/";
	private String dataPath = "res/mapdata/";
	private int[][] map;
	private int mapCols, mapRows;
	private int width, height;
	public static final int tileSize = Art.artResize;
	private int xStart, xEnd, yStart, yEnd;

	private List<InteractableObject> gameObjects;

	public World(Game game) {
		this.game = game;

		gameObjects = new ArrayList<InteractableObject>();
//		gameObjects.add(new CommonerNPC(game, 3, 6));
//		gameObjects.add(new ShopNPC(game, 9, 6));
	}

	public boolean isSolid(int x, int y) {
		if (map[y][x] == 1 || map[y][x] == 4)
			return true;
		else
			return false;
	}

	public void tick() {
	}

	public void render(Graphics2D g2) {
//		g2.drawImage(getImage(1,1),0,0,32,32,null);

		xStart = Math.max(0, game.getCamera().getoffsetX() / tileSize);
		xEnd = Math.min(mapCols, (game.getCamera().getoffsetX() + game.getWidth()) / tileSize + 1);

		yStart = Math.max(0, game.getCamera().getoffsetY() / tileSize);
		yEnd = Math.min(mapRows, (game.getCamera().getoffsetY() + game.getHeight()) / tileSize + 1);

		for (int i = xStart; i < xEnd; i++) {
			for (int j = yStart; j < yEnd; j++) {
				g2.drawImage(getImage(j, i), i * tileSize - game.getCamera().getoffsetX(),
						j * tileSize - game.getCamera().getoffsetY(), tileSize, tileSize, null);
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
		else if (map[x][y] == 4)
			img = game.getArt().tree;

		return img;
	}

	public void loadMapData(String name) {

		gameObjects.clear();

//		System.out.println(StringUtils.loadMapData(dataPath+name+"_data.json"));
		JSONObject data = new JSONObject(StringUtils.loadMapData(dataPath + name + "_data.json"));

//		 System.out.println(data.get("name"));

		JSONArray spawnArray = data.getJSONArray("spawn_location");
		JSONObject spawnObj = spawnArray.getJSONObject(0);
		game.getPlayer().setSpawn(spawnObj.getInt("x"), spawnObj.getInt("y"));

		JSONArray arr1 = data.getJSONArray("treasure_boxes");
		for (int i = 0; i < arr1.length(); i++) {
//			System.out.println(arr1.get(i));
			JSONObject obj = arr1.getJSONObject(i);
			gameObjects.add(new Box(game, obj.getInt("x"), obj.getInt("y")));
		}

		JSONArray arr2 = data.getJSONArray("action_boxes");
		for (int i = 0; i < arr2.length(); i++) {
			JSONObject obj = arr2.getJSONObject(i);
			gameObjects.add(new ActionBox(game, obj.getInt("x"), obj.getInt("y"), obj.getString("next_map")));
		}

		JSONArray arr3 = data.getJSONArray("npcs");
		for (int i = 0; i < arr3.length(); i++) {
			JSONObject obj = arr3.getJSONObject(i);
			// here we will need an id to differentiate the npcs.
			switch (obj.getInt("id")) {
			case 1:
				gameObjects.add(new CommonerNPC(game, obj.getInt("x"), obj.getInt("y")));
				break;

			case 2:
				gameObjects.add(new ShopNPC(game, obj.getInt("x"), obj.getInt("y")));
				break;

			case 3:
				gameObjects.add(new HealerNPC(game, obj.getInt("x"), obj.getInt("y")));
				break;

			case 4:
				gameObjects.add(new MayorNPC(game, obj.getInt("x"), obj.getInt("y")));
				break;
			}

		}
	}

	public void loadWorld(String name) {
		String[] tokens = StringUtils.loadFileAsString(path + name + ".txt").split("\\s+");

//		for (String s : tokens)
//			System.out.println(s);

		// first 2 counter tokens to find the max rows and cols
		mapRows = Integer.parseInt(tokens[0]);
		mapCols = Integer.parseInt(tokens[1]);
		width = mapCols * tileSize;
		height = mapRows * tileSize;

		map = new int[mapRows][mapCols];

		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapCols; j++) {

//			start from row = 3 and count till the end 
//			math: (j+i*rows)+2; 
//			(0+0*5)+2 = [2]-> 3rd element -> 1st row 1st col 
//			(1+0*5)+2 = [3]-> 4th element -> 1st row 2nd col 
//			(1+1*5)+2 = [8]-> 9th element -> 2nd row 2nd col

				map[i][j] = Integer.parseInt(tokens[(j + i * mapRows) + 2]);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
		}

		loadMapData(name);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<InteractableObject> getGameObjects() {
		return gameObjects;
	}
}
