package com.suman.game.states;

public enum StateType {

	HOME("Home"), 
	GAME("Game"), 
	BATTLE("Battle");

	private String name;

	private StateType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
