package com.tarosso.game.of.life.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.tarosso.game.of.life.subject.Cell;

public class CellPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SIZE = 20;
	
	private Cell cell;
	
	public CellPanel(Cell cell) {
		this.cell = cell;
		setLayout(null);
		setBackground(cell.isAliveColor());
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setBounds(SIZE * cell.getPosition().getPosX(), SIZE * cell.getPosition().getPosY()-1, SIZE, SIZE);
		setVisible(true);
	}
	
	public void updateColor() {
		setBackground(this.cell.isAliveColor());
	}
	
}