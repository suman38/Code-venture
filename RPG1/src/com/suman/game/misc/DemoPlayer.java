package com.suman.game.misc;

import java.io.Serializable;

public class DemoPlayer implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int posX, posY;

	public DemoPlayer(String name, int x, int y) {
		this.name = name;
		this.posX = x;
		this.posY = y;
	}

	public String toString()
	{
		return "Player{"
				+ "Name:"+this.name
				+", X: "+this.posX
				+", Y: "+this.posY
				+"}"; 
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
