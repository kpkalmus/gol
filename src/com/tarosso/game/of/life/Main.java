package com.tarosso.game.of.life;

import java.util.ArrayList;

import com.tarosso.game.of.life.gui.CellPanel;
import com.tarosso.game.of.life.gui.GOLFrame;
import com.tarosso.game.of.life.rules.Rule;
import com.tarosso.game.of.life.rules.RuleOne;
import com.tarosso.game.of.life.rules.RuleThree;
import com.tarosso.game.of.life.rules.RuleTwo;
import com.tarosso.game.of.life.subject.Cell;
import com.tarosso.game.of.life.subject.utils.Builder;
import com.tarosso.game.of.life.subject.utils.Position;

public class Main {

	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	public static final int GAMEFIELD_SIZE = 70;
	public static final int MAX_ALIVE_BY_START = 1000;
	
	public static void main(String[] args) {
		Cell.rules = new ArrayList<>();
		Cell[][] gamefield = new Builder.GamefieldBuilder(GAMEFIELD_SIZE)
//										.aliveCell(2,1)
//										.aliveCell(3, 2)
//										.aliveCell(1, 3)
//										.aliveCell(2, 3)
//										.aliveCell(3, 3)
//										.aliveCell(47, 1)
//										.aliveCell(46, 2)
//										.aliveCell(48, 3)
//										.aliveCell(47, 3)
//										.aliveCell(46, 3)
//										.aliveCell(2, 48)
//										.aliveCell(3, 47)
//										.aliveCell(1, 46)
//										.aliveCell(2, 46)
//										.aliveCell(3, 46)
//										.aliveCell(47, 48)
//										.aliveCell(46, 47)
//										.aliveCell(48, 46)
//										.aliveCell(47, 46)
//										.aliveCell(46, 46)
				
				
//										// Rectangle Left
//										.aliveCell(0, 4)
//										.aliveCell(0, 5)
//										.aliveCell(1, 4)
//										.aliveCell(1, 5)
//										// Rectangle Right
//										.aliveCell(34, 2)
//										.aliveCell(34, 3)
//										.aliveCell(35, 2)
//										.aliveCell(35, 3)
//										//Rectangle Middle
//										.aliveCell(16, 4)
//										.aliveCell(16, 5)
//										.aliveCell(16, 6)
//										.aliveCell(17, 4)
//										.aliveCell(17, 5)
//										.aliveCell(17, 6)
//										//object left
//										.aliveCell(12, 2)
//										.aliveCell(12, 3)
//										.aliveCell(11, 3)
//										.aliveCell(11, 4)
//										.aliveCell(10, 4)
//										.aliveCell(11, 5)
//										.aliveCell(10, 5)
//										.aliveCell(9, 5)
//										.aliveCell(11, 6)
//										.aliveCell(10, 6)
//										.aliveCell(12, 7)
//										.aliveCell(11, 7)
//										.aliveCell(12, 8)
//										//object rigth
//										.aliveCell(23, 0)
//										.aliveCell(23, 1)
//										.aliveCell(21, 1)
//										.aliveCell(22, 2)
//										.aliveCell(20, 2)
//										.aliveCell(22, 3)
//										.aliveCell(19, 3)
//										.aliveCell(22, 4)
//										.aliveCell(20, 4)
//										.aliveCell(23, 5)
//										.aliveCell(21, 5)
//										.aliveCell(23, 6)
										.build();
		Cell.rules.add(new RuleThree());
		Cell.rules.add(new RuleOne());
		Cell.rules.add(new RuleTwo());
		
		GOLFrame frame = new GOLFrame(GAMEFIELD_SIZE);
		initFrame(gamefield, frame);
		
		while(true) {
			Rule.gamefield = copyGamefield(gamefield);
//			showGamefield(gamefield);
			frame.updateCells();
			checkRules(gamefield);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
	
	public static void initFrame(Cell[][] gamefield, GOLFrame frame) {
		for(int y = 0; y < gamefield[0].length; y++) {
			for(int x = 0; x < gamefield.length; x++) {
				frame.appendCellPanel(new CellPanel(gamefield[x][y]));
			}
			frame.updateCells();
		}
	}
	
	public static void showGamefield(Cell[][] gamefield) {
		int height = gamefield[0].length;
		int width = gamefield.length;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				System.out.print(gamefield[x][y].isAliveInt() + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
	}
	
	public static void checkRules(Cell[][] gamefield) {
		int height = gamefield[0].length;
		int width = gamefield.length;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				gamefield[x][y].checkRules();
			}
		}
		
	}
	
	public static Cell[][] copyGamefield(Cell[][] gamefield) {
		Cell[][] copy = new Cell[gamefield.length][gamefield[0].length];
		for(int y = 0; y < gamefield[0].length; y++) {
			for(int x = 0; x < gamefield.length; x++) {
				Cell toCopy = gamefield[x][y];
				Position position = new Position(toCopy.getPosition().getPosX(),
												 toCopy.getPosition().getPosY());
				copy[x][y] = new Cell(position, toCopy.isAlive());
			}
		}
		return copy;
	}
	
}