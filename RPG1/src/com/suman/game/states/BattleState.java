package com.suman.game.states;

import java.awt.Color;

import com.suman.game.Engine;

public class BattleState extends State {

	private static final long serialVersionUID = 1L;

	public BattleState(Engine engine) {
		super(engine);
		setBackground(Color.YELLOW);
	}

}
