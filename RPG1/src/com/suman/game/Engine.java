package com.suman.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Engine extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private Game game;
	public static final int GameWidth = 800, GameHeight = 600;

	private boolean running = false;
	private Thread gameThread = null;
	
	private TopPanel topPanel;
	private SidePanel sidePanel;
	
	public Engine()
	{
		setPreferredSize(new Dimension(GameWidth, GameHeight));
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		game = new Game(); //Game Area
		
		topPanel = new TopPanel();
		sidePanel = new SidePanel();
		
		add(topPanel,"North");
		add(sidePanel,"East");
		add(game, "Center");
	}
	public void startGame() {
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	private void update() {
		topPanel.update();
	}
	private void render() {
		topPanel.repaint();
	}

	@Override
	public void run() {
		while(running) {
			update();
			render();
		}
	}
}
