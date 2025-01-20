package com.suman.game.states;

public enum SceneType {

	HOME("Home"), 
	GAME("Game"), 
	BATTLE("Battle");

	private String name;

	private SceneType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
