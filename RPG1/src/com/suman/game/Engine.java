package com.suman.game;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;

import com.suman.game.entities.Player;
import com.suman.game.states.BattleScene;
import com.suman.game.states.GameScene;
import com.suman.game.states.HomeScene;
import com.suman.game.states.Scene;
import com.suman.game.states.SceneType;

public class Engine extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int GameWidth = 800, GameHeight = 600;

	private Scene homeScene, gameScene, battleScene;

	private CardLayout cardLayout;

	private final String fileDir = System.getenv("USERPROFILE") + "/documents/codeventure";
	private final String fileName = fileDir + "/savefile1.dat";
	private File myFile;

	public Engine() {

		myFile = new File(fileDir);
		if (!myFile.exists()) {
			myFile.mkdir();
		}

		setPreferredSize(new Dimension(GameWidth, GameHeight));
		setDoubleBuffered(true);
		setFocusable(true);

		homeScene = new HomeScene(this);
		gameScene = new GameScene(this);
		battleScene = new BattleScene(this);

		cardLayout = new CardLayout();
		setLayout(cardLayout);

		add(homeScene, SceneType.HOME.getName());
		add(gameScene, SceneType.GAME.getName());
		add(battleScene, SceneType.BATTLE.getName());

//		System.out.println(StateType.HOME.getClass().getName());

		showScene(SceneType.HOME);
	}

	public void setPlayer(Player player) {
		((GameScene)gameScene).getGame().setWorld(player.getMapName());
		((GameScene) gameScene).getGame().setPlayer(player);
	}

	public void serializePlayer() {
		Player p = ((GameScene) gameScene).getGame().getPlayer();
		System.out.println("Saving: "+p.toString());
		ObjectOutputStream objout;

		try {
			objout = new ObjectOutputStream(new FileOutputStream(fileName));
			objout.writeObject(p);
			objout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player deserializePlayer() {
		ObjectInputStream objin;

		try {
			objin = new ObjectInputStream(new FileInputStream(fileName));
			Player p = (Player) objin.readObject();
			objin.close();
			return p;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void showScene(SceneType type) {
		if (type == SceneType.GAME) {
			((GameScene) gameScene).startGame();
		} else {
			((GameScene) gameScene).stopGame();
		}

		cardLayout.show(this, type.getName());
	}
}
