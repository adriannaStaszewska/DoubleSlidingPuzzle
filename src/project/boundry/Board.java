package project.boundry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import project.controller.MoveController;
import project.model.Model;
import project.model.Tile;

public class Board extends JPanel {

	/**
	 * Create the panel.
	 */
	Model model;
	AppView app;
	
	public Board() {
 
	}
	
	public Board(Model model, AppView app) {
		this.model = model;
		this.app = app;
		this.addMouseListener(new MoveController(model, app)); 
	}

	@Override
	public void paintComponent(Graphics g) {
		app.getMoveCounter().setText("" + model.getNumOfMoves());
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				drawTile(g, model.getTile(row, col));
			}
		}
		
	}
	
	
	public static void drawTile(Graphics g, Tile tile) {
		int x = (110)*tile.getCol();
		int y = (110)*tile.getRow();
		g.setFont(new Font("Arial", Font.BOLD, 50));
		if(tile.getTop() == 0) {
			g.setColor(Color.orange);
			g.fillRect(x, y, 100, 100);
		}else {
			if(tile.isFlipState()) {
				g.setColor(Color.black);
				g.fillRect(x, y, 100, 100);
				g.setColor(Color.white);
				g.drawString(Integer.toString(tile.getTop()), x+35, y+65);
			} else {
				g.setColor(Color.gray);
				g.fillRect(x, y, 100, 100);
				g.setColor(Color.black); 
				g.drawString(Integer.toString(tile.getTop()), x+35, y+65);
			
			}
		}
		
	}

}
