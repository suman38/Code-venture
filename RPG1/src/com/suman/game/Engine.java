package com.suman.game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.suman.game.ui.BagPanel;
import com.suman.game.ui.MapPanel;
import com.suman.game.ui.SidePanel;
import com.suman.game.ui.TopPanel;

public class Engine extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int GameWidth = 800, GameHeight = 600;

	private Timer gameTimer;
	private int delay = 16; // 1000 millisec = 1sec, 33ms = ~30fps, 16 = ~60fps

	private CardLayout cardLayout;
	private int currentCard;

	private TopPanel topPanel;
	private SidePanel sidePanel;
	private JPanel centerPanel;
	private MapPanel mapPanel;
	private BagPanel bagPanel;
	private Game game;

	public Engine() {
		setPreferredSize(new Dimension(GameWidth, GameHeight));
		setDoubleBuffered(true);
		setFocusable(true);
		setLayout(new BorderLayout());

		game = new Game(this); // Game Area

		topPanel = new TopPanel(game.getPlayer());
		sidePanel = new SidePanel(this);

		mapPanel = new MapPanel();
		bagPanel = new BagPanel(game);

		cardLayout = new CardLayout();
		centerPanel = new JPanel();
		centerPanel.setLayout(cardLayout);

		centerPanel.add(game, "1");
		centerPanel.add(mapPanel, "2");
		centerPanel.add(bagPanel, "3");

		add(topPanel, "North");
		add(sidePanel, "East");
		add(centerPanel, "Center");
	}

	public void showPanel(String s) {

		if (gameTimer.isRunning())
			gameTimer.stop();
		else
			gameTimer.restart();

		if (s.equals("game")) {
			currentCard = 1;
		} else if (s.equals("map")) {
			currentCard = 2;
		} else if (s.equals("bag")) {
			currentCard = 3;
		} else if (s.equals("quests")) {
			currentCard = 4;
		} else if (s.equals("interact")) {
			currentCard = 5;
		}

		cardLayout.show(centerPanel, "" + currentCard);
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

	public Game getGame() {
		return game;
	}

	public SidePanel getSidePanel() {
		return sidePanel;
	}

	public BagPanel getBagPanel() {
		return bagPanel;
	}
}
