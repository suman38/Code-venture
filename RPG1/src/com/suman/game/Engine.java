package com.suman.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Engine extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int GameWidth = 800, GameHeight = 600;

	private Timer gameTimer;
	private int delay = 33; // 1000 millisec = 1sec, 33ms = ~30fps

	private TopPanel topPanel;
	private SidePanel sidePanel;
	private Game game;

	public Engine() {
		setPreferredSize(new Dimension(GameWidth, GameHeight));
		setDoubleBuffered(true);
		setLayout(new BorderLayout());

		game = new Game(); // Game Area

		topPanel = new TopPanel();
		sidePanel = new SidePanel();

		add(topPanel, "North");
		add(sidePanel, "East");
		add(game, "Center");
	}

	public void startGame() {
		gameTimer = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tick();
				render();
			}
		});
		gameTimer.start();
	}

	private void tick() {
		topPanel.tick();
		game.tick();
	}

	private void render() {
		topPanel.repaint();
		game.repaint();
	}
}
