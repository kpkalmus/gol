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
	
	public static final int GAMEFIELD_SIZE = 50;
	public static final int MAX_ALIVE_BY_START = 500;
	
	public static void main(String[] args) {
		Cell.rules = new ArrayList<>();
		Cell[][] gamefield = new Builder.GamefieldBuilder(GAMEFIELD_SIZE)
										.aliveCell(1,0)
										.aliveCell(2, 1)
										.aliveCell(0, 2)
										.aliveCell(1, 2)
										.aliveCell(2, 2)
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
				Thread.sleep(250);
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