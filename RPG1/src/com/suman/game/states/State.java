package com.suman.game.states;

import javax.swing.JPanel;

import com.suman.game.Engine;

public abstract class State extends JPanel{
	
	protected Engine engine;
	public State(Engine engine)
	{
		this.engine = engine;
	}

}
