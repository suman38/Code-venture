package com.suman.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.suman.game.art.Art;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;

	private Art art;

	private int x, y;
	private final int playerMoveSpeed = 5;

	private int inFocus = JComponent.WHEN_IN_FOCUSED_WINDOW;

	// This is for the rendering the game
	public Game() {

		// directional keys
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("W"), "move_player_up");
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("S"), "move_player_down");
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("A"), "move_player_left");
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("D"), "move_player_right");

		// Arrow Keys
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("UP"), "move_player_up");
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("DOWN"), "move_player_down");
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("LEFT"), "move_player_left");
		getInputMap(inFocus).put(KeyStroke.getKeyStroke("RIGHT"), "move_player_right");

		// Action maps
		getActionMap().put("move_player_up", new MovePlayer(1, this));
		getActionMap().put("move_player_down", new MovePlayer(2, this));
		getActionMap().put("move_player_left", new MovePlayer(3, this));
		getActionMap().put("move_player_right", new MovePlayer(4, this));

		art = new Art();
	}

	public void tick() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(art.grass, 0, 0, art.artResize, art.artResize, null);
		g2.drawImage(art.grass, art.artResize, 0, art.artResize, art.artResize, null);
		g2.drawImage(art.grass, art.artResize * 2, 0, art.artResize, art.artResize, null);
		g2.drawImage(art.grass, 0, art.artResize, art.artResize, art.artResize, null);
		g2.drawImage(art.grass, art.artResize, art.artResize, art.artResize, art.artResize, null);
		g2.drawImage(art.grass, art.artResize * 2, art.artResize, art.artResize, art.artResize, null);

		g2.drawImage(art.playerDown, x, y, art.artResize, art.artResize, null);

		g2.dispose();
	}

	public void movePlayerHorizontally(int flag) {
		x += playerMoveSpeed * flag;
	}

	public void movePlayerVertically(int flag) {
		y += playerMoveSpeed * flag;
	}
}

class MovePlayer extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private int dir;
	private Game game;

	public MovePlayer(int dir, Game game) {
		this.dir = dir;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (dir == 1)
			game.movePlayerVertically(-1); // up
		else if (dir == 2)
			game.movePlayerVertically(1); // down
		else if (dir == 3)
			game.movePlayerHorizontally(-1); // left
		else if (dir == 4)
			game.movePlayerHorizontally(1); // right
	}
}
