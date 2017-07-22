package com.tarosso.game.of.life.rules;

import com.tarosso.game.of.life.subject.Cell;

public class RuleThree extends Rule {

	@Override
	public void checkRule(Cell cell) {
		int lifeNeighbours = 0;
		if(isNeighbourAboveAlive(cell)) lifeNeighbours++;
		if(isNeighbourAboveRightAlive(cell)) lifeNeighbours++;
		if(isNeighbourRightAlive(cell)) lifeNeighbours++;
		if(isNeighbourUnderRightAlive(cell)) lifeNeighbours++;
		if(isNeighbourUnderAlive(cell)) lifeNeighbours++;
		if(isNeighbourUnderLeftAlive(cell)) lifeNeighbours++;
		if(isNeighbourLeftAlive(cell)) lifeNeighbours++;
		if(isNeighbourAboveLeftAlive(cell)) lifeNeighbours++;
		if(lifeNeighbours == 3) cell.alive();
	}

}