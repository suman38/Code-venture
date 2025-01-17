package com.suman.game;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.suman.game.states.BattleState;
import com.suman.game.states.GameState;
import com.suman.game.states.HomeState;
import com.suman.game.states.State;
import com.suman.game.states.StateType;

public class Engine extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int GameWidth = 800, GameHeight = 600;

	private State homeState, gameState, battleState;

	private CardLayout cardLayout;

	public Engine() {
		setPreferredSize(new Dimension(GameWidth, GameHeight));
		setDoubleBuffered(true);
		setFocusable(true);

		homeState = new HomeState(this);
		gameState = new GameState(this);
		battleState = new BattleState(this);

		cardLayout = new CardLayout();
		setLayout(cardLayout);

		add(homeState, StateType.HOME.getName());
		add(gameState, StateType.GAME.getName());
		add(battleState, StateType.BATTLE.getName());
		
//		System.out.println(StateType.HOME.getClass().getName());

		showScene(StateType.HOME);
	}

	public void showScene(StateType type) {
		if (type == StateType.GAME) {
			((GameState) gameState).startGame();
		} else {
			((GameState) gameState).stopGame();
		}
		
		cardLayout.show(this, type.getName());
	}
}
