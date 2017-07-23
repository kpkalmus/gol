package com.tarosso.game.of.life.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.tarosso.game.of.life.subject.Cell;

public class CellPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SIZE = 15;

	public static boolean mousePressed;
	
	private Cell cell;
	
	public CellPanel(Cell cell) {
		this.cell = cell;
		setLayout(null);
		setBackground(cell.isAliveColor());
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setBounds(SIZE * cell.getPosition().getPosX(), SIZE * cell.getPosition().getPosY()-1, SIZE, SIZE);
		addMouseListener(new CellAliveListener());
		setVisible(true);
	}
	
	public void updateColor() {
		setBackground(this.cell.isAliveColor());
	}
	
	public class CellAliveListener implements MouseListener {
		
		public CellAliveListener() {
			mousePressed = false;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			mousePressed = true;
			if(cell.isAlive()) {
				cell.die();
			} else {
				cell.alive();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mousePressed = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(mousePressed) {
				if(cell.isAlive()) {
					cell.die();
				} else {
					cell.alive();
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
}