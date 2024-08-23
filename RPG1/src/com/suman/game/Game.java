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
import com.suman.game.entities.Player;
import com.suman.game.worldtiles.World;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;

	private Art art;
	private World world;
	private Player player;
	
	private final int InFocus = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private int playerDirection = 0;

	// This is for rendering the game area
	public Game() {
		setPreferredSize(new Dimension(640, 480));
		setBackground(Color.BLACK);

		art = new Art();

		world = new World(this);
		world.loadWorld("sample1");

		player = new Player(this);

		assignKeyBindings();
	}

	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		world.render(g2);
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

		// Arrow Keys
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed UP"), "move_player_up");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed DOWN"), "move_player_down");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed LEFT"), "move_player_left");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("pressed RIGHT"), "move_player_right");

		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released UP"), "stop_player");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released LEFT"), "stop_player");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released DOWN"), "stop_player");
		getInputMap(InFocus).put(KeyStroke.getKeyStroke("released RIGHT"), "stop_player");

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