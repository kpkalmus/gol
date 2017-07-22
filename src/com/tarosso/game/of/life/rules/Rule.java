package com.tarosso.game.of.life.rules;

import com.tarosso.game.of.life.subject.Cell;

public abstract class Rule {

	public static Cell[][] gamefield;
	
	public abstract void checkRule(Cell cell);
	
	public boolean isNeighbourAboveAlive(Cell cell) {
		if(touchedTopBorder(cell)) {
			return gamefield[getCellXPosition(cell)][getGamefieldHeight()].isAlive();
		}
		return gamefield[getCellXPosition(cell)][getUpperPosition(cell)].isAlive();
	}
	
	public boolean isNeighbourAboveRightAlive(Cell cell) {
		int gamefieldHeight = getGamefieldHeight();
		int gamefieldZero = getGamefieldZero();
		if(touchedRightBorder(cell) && touchedTopBorder(cell)) {
			return gamefield[gamefieldZero][gamefieldHeight].isAlive();
		}
		if(touchedRightBorder(cell) && !touchedTopBorder(cell)) {
			return gamefield[gamefieldZero][getUpperPosition(cell)].isAlive();
		}
		if(!touchedRightBorder(cell) && touchedTopBorder(cell)) {
			return gamefield[getRighterPosition(cell)][gamefieldHeight].isAlive();
		}
		return gamefield[getRighterPosition(cell)][getUpperPosition(cell)].isAlive();
	}
	
	public boolean isNeighbourRightAlive(Cell cell) {
		if(touchedRightBorder(cell)) {
			return gamefield[getGamefieldZero()][getCellYPosition(cell)].isAlive();
		}
		return gamefield[getRighterPosition(cell)][getCellYPosition(cell)].isAlive();
	}
	
	public boolean isNeighbourUnderRightAlive(Cell cell) {
		int gamefieldZero = getGamefieldZero();
		if(touchedRightBorder(cell) && touchedBottomBorder(cell)) {
			return gamefield[gamefieldZero][gamefieldZero].isAlive();
		}
		if(touchedRightBorder(cell) && !touchedBottomBorder(cell)) {
			return gamefield[gamefieldZero][getLowerPosition(cell)].isAlive();
		}
		if(!touchedRightBorder(cell) && touchedBottomBorder(cell)) {
			return gamefield[getRighterPosition(cell)][gamefieldZero].isAlive();
		}
		return gamefield[getRighterPosition(cell)][getLowerPosition(cell)].isAlive();
	}
	
	public boolean isNeighbourUnderAlive(Cell cell) {
		if(touchedBottomBorder(cell)) {
			return gamefield[getCellXPosition(cell)][getGamefieldZero()].isAlive();
		}
		return gamefield[getCellXPosition(cell)][getLowerPosition(cell)].isAlive();
	}
	
	public boolean isNeighbourUnderLeftAlive(Cell cell) {
		int gamefieldWidth = getGamefieldWidth();
		int gamefieldZero = getGamefieldZero();
		if(touchedLeftBorder(cell) && touchedBottomBorder(cell)) {
			return gamefield[gamefieldWidth][gamefieldZero].isAlive();
		}
		if(touchedLeftBorder(cell) && !touchedBottomBorder(cell)) {
			return gamefield[gamefieldWidth][getLowerPosition(cell)].isAlive();
		}
		if(!touchedLeftBorder(cell) && touchedBottomBorder(cell)) {
			return gamefield[getLefterPosition(cell)][gamefieldZero].isAlive();
		}
		return gamefield[getLefterPosition(cell)][getLowerPosition(cell)].isAlive();
	}
	
	public boolean isNeighbourLeftAlive(Cell cell) {
		if(touchedLeftBorder(cell)) {
			return gamefield[getGamefieldWidth()][getCellYPosition(cell)].isAlive();
		}
		return gamefield[getLefterPosition(cell)][getCellYPosition(cell)].isAlive();
	}

	public boolean isNeighbourAboveLeftAlive(Cell cell) {
		int gamefieldWidth = getGamefieldWidth();
		int gamefieldHeight = getGamefieldHeight();
		if(touchedLeftBorder(cell) && touchedTopBorder(cell)) {
			return gamefield[gamefieldWidth][gamefieldHeight].isAlive();
		}
		if(touchedLeftBorder(cell) && !touchedTopBorder(cell)) {
			return gamefield[gamefieldWidth][getUpperPosition(cell)].isAlive();
		}
		if(!touchedLeftBorder(cell) && touchedTopBorder(cell)) {
			return gamefield[getLefterPosition(cell)][gamefieldHeight].isAlive();
		}
		return gamefield[getLefterPosition(cell)][getUpperPosition(cell)].isAlive();
	}
	
	private int getUpperPosition(Cell cell) {
		return cell.getPosition().getPosY()-1;
	}
	
	private int getRighterPosition(Cell cell) {
		return cell.getPosition().getPosX()+1;
	}
	
	private int getLowerPosition(Cell cell) {
		return cell.getPosition().getPosY()+1;
	}
	
	private int getLefterPosition(Cell cell) {
		return cell.getPosition().getPosX()-1;
	}
	
	private boolean touchedTopBorder(Cell cell) {
		return getCellYPosition(cell) <= getGamefieldZero();
	}
	
	private boolean touchedRightBorder(Cell cell) {
		return getCellXPosition(cell) >= getGamefieldWidth();
	}
	
	private boolean touchedBottomBorder(Cell cell) {
		return getCellYPosition(cell) >= getGamefieldHeight();
	}
	
	private boolean touchedLeftBorder(Cell cell) {
		return getCellXPosition(cell) <= getGamefieldZero();
	}
	
	private int getGamefieldWidth() {
		return gamefield.length-1;
	}
	
	private int getGamefieldHeight() {
		return gamefield[0].length-1;
	}
	
	private int getGamefieldZero() {
		return 0;
	}
	
	private int getCellXPosition(Cell cell) {
		return cell.getPosition().getPosX();
	}
	
	private int getCellYPosition(Cell cell) {
		return cell.getPosition().getPosY();
	}
	
}