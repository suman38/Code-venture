package com.suman.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.suman.game.art.Art;
import com.suman.game.entities.InteractableObject;
import com.suman.game.entities.NPC;
import com.suman.game.entities.Player;
import com.suman.game.entities.objects.ActionBox;
import com.suman.game.entities.objects.Box;
import com.suman.game.items.ItemManager;
import com.suman.game.states.GameState;
import com.suman.game.worldtiles.World;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;

	private GameState engine;

	public ItemManager iManager;

	private Art art;
	private World world;
	private Player player;
	private Camera camera;

	private InteractableObject iobj;

	private final int InFocus = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private int playerDirection = 0;

	// This is for rendering the game area
	public Game(GameState engine) {
		this.engine = engine;
		setPreferredSize(new Dimension(640, 480));
		setBackground(Color.BLACK);

		iManager = new ItemManager();
		art = new Art();
		world = new World(this);
		player = new Player(this);
		camera = new Camera(this);

		assignKeyBindings();
		world.loadWorld("grass1");
//		player.setSpawn(3, 3);
	}

	public void tick() {
		world.tick();
		player.tick();
		camera.centerOnPlayer();

		for (InteractableObject obj : world.getGameObjects()) {
			obj.tick();
		}

		if (checkCollisions())
			engine.getSidePanel().setInteract(true, iobj);
		else
			engine.getSidePanel().setInteract(false, null);
	}

	private boolean checkCollisions() {

		var x = world.getGameObjects().toArray();
//		for(InteractableObject obj : world.getGameObjects()) {
		for (int i = 0; i < x.length; i++) {
			InteractableObject obj = (InteractableObject) x[i];
			if (obj.getBounds().intersects(player.getBounds())) {
				if (obj instanceof Box || obj instanceof NPC) {
//					interaction must happen here
					iobj = obj;
					return true;
				} else if (obj instanceof ActionBox) {
					world.loadWorld(((ActionBox)obj).getNextMap());
				}
			}
		}
		return false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		world.render(g2);

		for (InteractableObject obj : world.getGameObjects()) {
			obj.render(g2);
		}

		player.render(g2);

		g2.dispose();
	}

	private void assignKeyBindings() {
		// directional keys
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed W"), "move_player_up");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed S"), "move_player_down");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed A"), "move_player_left");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed D"), "move_player_right");

		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released W"), "stop_player");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released S"), "stop_player");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released A"), "stop_player");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released D"), "stop_player");

		// Action maps
		getActionMap().put("move_player_up", new MovePlayer(1));
		getActionMap().put("move_player_down", new MovePlayer(2));
		getActionMap().put("move_player_left", new MovePlayer(3));
		getActionMap().put("move_player_right", new MovePlayer(4));

		getActionMap().put("stop_player", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setMoving(false);
			}
		});
	}

	public Art getArt() {
		return art;
	}

	public int getDirection() {
		return playerDirection;
	}

	public Player getPlayer() {
		return player;
	}

	public World getWorld() {
		return world;
	}

	public Camera getCamera() {
		return camera;
	}

	public ItemManager getItemManager() {
		return iManager;
	}

	private class MovePlayer extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private int dir;

		public MovePlayer(int dir) {
			this.dir = dir;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			player.setMoving(true);

			playerDirection = dir;

			if (dir == 1)
				player.movePlayerVertically(-1); // up
			else if (dir == 2)
				player.movePlayerVertically(1); // down
			else if (dir == 3)
				player.movePlayerHorizontally(-1); // left
			else if (dir == 4)
				player.movePlayerHorizontally(1); // right
		}
	}
}