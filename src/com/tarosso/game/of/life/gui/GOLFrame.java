package com.tarosso.game.of.life.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class GOLFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CellPanel> cells;
	
	public GOLFrame(int cells) {
		int width = 16 + CellPanel.SIZE * cells;
		int height = 38 + CellPanel.SIZE * cells;
		this.cells = new ArrayList<>();
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = device.getDisplayMode().getWidth();
		int screenHeight = device.getDisplayMode().getHeight();
		setBounds((screenWidth - width) / 2, (screenHeight - height) / 2, width, height);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void appendCellPanel(CellPanel panel) {
		cells.add(panel);
		add(panel);
	}
	
	public void updateCells() {
		for(CellPanel cell : cells) {
			cell.updateColor();
			repaint();
		}
	}
	
}