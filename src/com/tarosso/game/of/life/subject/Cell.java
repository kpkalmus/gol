package com.tarosso.game.of.life.subject;

import java.awt.Color;
import java.util.List;

import com.tarosso.game.of.life.rules.Rule;
import com.tarosso.game.of.life.subject.utils.Position;

public class Cell {

	public static final Color DEAD_COLOR = Color.BLACK;
	public static final Color ALIVE_COLOR = Color.WHITE;
	
	public static List<Rule> rules;
	
	public static final String DEAD_INT = ".";
	public static final String LIFE_INT = "X";
	
	public final Position position;
	
	private boolean isAlive;
	
	public Cell(Position position, boolean isAlive) {
		this.position = position;
		this.isAlive = isAlive;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void alive() {
		this.isAlive = true;
	}
	
	public void die() {
		this.isAlive = false;
	}
	
	public String isAliveInt() {
		return isAlive ? LIFE_INT : DEAD_INT;
	}
	
	public void checkRules() {
		for(Rule rule : rules) {
			rule.checkRule(this);
		}
	}

}