package com.suman.game.states;

import javax.swing.JPanel;

import com.suman.game.Engine;

public abstract class Scene extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Engine engine;

	public Scene(Engine engine) {
		this.engine = engine;
	}

	public Engine getGameEngine() {
		return engine;
	}

}
