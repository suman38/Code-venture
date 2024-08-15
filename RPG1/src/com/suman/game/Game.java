package com.suman.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.suman.game.art.Art;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;

	private BufferedImage img1;
	private int x, y, width, height;

	private int playerMoveSpeed = 5;

	private final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private final String MOVE_UP = "move player up";
	private final String MOVE_DOWN = "move player down";

	private Art art;

	// This is for the rendering the game
	public Game() {

		// Arrow keys
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), MOVE_UP);
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), MOVE_DOWN);

		// W and S
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), MOVE_UP);
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), MOVE_DOWN);

		this.getActionMap().put(MOVE_UP, new MovePlayerAction(1,this));
		this.getActionMap().put(MOVE_DOWN, new MovePlayerAction(2,this));

		art = new Art();

		try {
			img1 = ImageIO.read(getClass().getResource("/playerimages/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 0;
		y = 200;
		width = img1.getWidth();
		height = img1.getHeight();
	}

	public void tick() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img1, x, y, width, height, null);

		g2.drawImage(art.playerDown, x+100, y, art.artResize, art.artResize, null);
		g2.drawImage(art.grass, 100, 0, art.artResize, art.artResize, null);

		g2.dispose();
	}

	public void movePlayerUp() {
		y -= playerMoveSpeed;
	}
	
	public void movePlayerDown()
	{
		y += playerMoveSpeed;
	}
}

class MovePlayerAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private Game game;
	private int direction;

	public MovePlayerAction(int direction, Game game) {
		this.direction = direction;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (direction) {
		case 1:
			//up
			game.movePlayerUp();
			break;
		case 2:
			//down
			game.movePlayerDown();
			break;
		}
	}
}
