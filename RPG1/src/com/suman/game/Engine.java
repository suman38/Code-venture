package com.suman.game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.suman.game.states.GameState;
import com.suman.game.states.HomeState;
import com.suman.game.states.State;

public class Engine extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int GameWidth = 800, GameHeight = 600;

	State homeState, gameState;
	
	CardLayout cardLayout;
	String currentCard = "B";
	
	public Engine() {
		setPreferredSize(new Dimension(Engine.GameWidth, Engine.GameHeight));
		setDoubleBuffered(true);
		setFocusable(true);

		homeState = new HomeState(this);
		homeState.setBackground(Color.RED);
		gameState = new GameState(this);
		gameState.setBackground(Color.BLACK);
		
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		add(homeState,"A");
		add(gameState,"B");

		cardLayout.show(this, currentCard);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
