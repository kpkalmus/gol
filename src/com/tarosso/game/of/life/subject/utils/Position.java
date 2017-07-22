package com.tarosso.game.of.life.subject.utils;

public class Position {

	private final int posX;
	private final int posY;
	
	public Position(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
}