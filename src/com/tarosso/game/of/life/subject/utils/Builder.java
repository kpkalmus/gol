package com.tarosso.game.of.life.subject.utils;

import com.tarosso.game.of.life.subject.Cell;

public class Builder {

	public static class GamefieldBuilder {
	
		public static final boolean DEFAULT_ALIVE = false;
		
		private Cell[][] gamefield;
		
		public GamefieldBuilder(int gamefieldSize) {
			this.gamefield = new Cell[gamefieldSize][gamefieldSize];
			initGamefield();
		}
		
		public GamefieldBuilder(int gamefieldSize, int maxAliveCellsByStart) {
			this.gamefield = new Cell[gamefieldSize][gamefieldSize];
			initGamefield(maxAliveCellsByStart);
		}
		
		private void initGamefield() {
			for(int y = 0; y < this.gamefield[0].length; y++) {
				for(int x = 0; x < this.gamefield.length; x++) {
					Position position = new Position(x, y);
					this.gamefield[x][y] = new Cell(position, DEFAULT_ALIVE);
				}
			}
		}
		
		private void initGamefield(int maxAliveCellsByStart) {
			for(int y = 0; y < this.gamefield[0].length; y++) {
				for(int x = 0; x < this.gamefield.length; x++) {
					Position position = new Position(x, y);
					this.gamefield[x][y] = new Cell(position, DEFAULT_ALIVE);
				}
			}
			initAliveCells(maxAliveCellsByStart);
		}
	
		private void initAliveCells(int maxAliveCellsByStart) {
			int aliveCells = 0;
			while(aliveCells < maxAliveCellsByStart) {
				int posX = (int) (Math.random() * this.gamefield.length);
				int posY = (int) (Math.random() * this.gamefield[0].length);
				Cell cell = this.gamefield[posX][posY];
				if(!cell.isAlive()) {
					cell.alive();
					aliveCells ++;
				}
			}
		}
		
		public GamefieldBuilder aliveCell(int x, int y) {
			gamefield[x][y].alive();
			return this;
		}
		
		public Cell[][] build() {
			return this.gamefield;
		}
		
	}

}