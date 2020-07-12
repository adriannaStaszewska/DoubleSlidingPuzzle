package project.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import project.boundry.AppView;
import project.boundry.Board;
import project.model.Location;
import project.model.Model;
import project.model.Tile;

public class MoveController extends MouseAdapter{
	
	Model model;
	AppView app;
	
	public MoveController(Model model, AppView app) {
		this.model = model;
		this.app = app;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		if(!model.isLocked()){
			Point p = me.getPoint();
			makeAMove(p);
			
			}
			app.repaint();
			if(isWon()) {
				JOptionPane.showMessageDialog(null, "Congratualions you won! You can try again by restarting the puzzle.");
				model.setLocked(true);
			}else if(isLost()) {
				JOptionPane.showMessageDialog(null, "You lost! You can try again by restarting the puzzle.");
				model.setLocked(true);
			}
		}
	
	
	public Location getTileLocation(Point p) { 
		Location loc = new Location(-1, -1);
		
		if(p.x <= 100) {
			loc.setCol(0);
		} else if(p.x <= 210 && p.x >= 110) {
			loc.setCol(1);
		} else if(p.x >= 220 && p.x <= 320) {
			loc.setCol(2);
		}
		
		if(p.y <= 100) { 
			loc.setRow(0);
		}else if(p.y <= 210 && p.y >= 110) {
			loc.setRow(1);
		} else if(p.y >= 220 && p.y <= 320) {
			loc.setRow(2);
		}
		
		return loc;
	}
	
	public boolean isValidMove(Location loc) {
		int diff = 0;
		diff += Math.abs(loc.getRow()-model.getEmpty().getRow());
		diff += Math.abs(loc.getCol()-model.getEmpty().getCol());
		
		if(diff == 1) {
			return true;
		}
		return false;
	}
	
	public boolean isLost() {
		int[] frequencyCount = {0, 0, 0, 0};
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				if(model.getTile(row, col).getTop() != 0)
				frequencyCount[model.getTile(row, col).getTop()-1]++;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(frequencyCount[i] > 3) {
				return true;
			}
		}
		return false; 
	}
	
	public boolean isWon() {
		if(model.getTile(0, 0).getTop() !=  1 || (model.getTile(0, 0).isFlipState()==true)){
			return false;
		} else if(model.getTile(0, 1).getTop() != 2 || (model.getTile(0, 1).isFlipState()==true)){
			return false;
		} else if(model.getTile(0, 2).getTop() != 3 || (model.getTile(0, 2).isFlipState()==true)){
			return false;
		}else if(model.getTile(1, 2).getTop() != 4 || (model.getTile(1, 2).isFlipState()==true)){
			return false;
		}else if(model.getTile(1, 1).getTop() != 0) {
			return false;
		}else if(model.getTile(1, 0).getTop() != 4 || (model.getTile(1, 0).isFlipState()==false)){
			return false;
		}else if(model.getTile(2, 0).getTop() != 3 || (model.getTile(2, 0).isFlipState()==false)){
			return false;
		}else if(model.getTile(2, 1).getTop() != 2 || (model.getTile(2, 1).isFlipState()==false)){
			return false;
		}else if(model.getTile(2, 2).getTop() != 1 || (model.getTile(2, 2).isFlipState()==false)){
			return false;
		}
		
		return true;
	}
	
	public void makeAMove(Point p) {
		Location clickLoc = getTileLocation(p);
		if(clickLoc.getRow() == -1 || clickLoc.getCol() == -1) {
			return;
		}
		if (isValidMove(clickLoc)) { 
			Tile clickTile = model.getTile(clickLoc);
			Tile emptyTile = model.getTile(model.getEmpty());
			Location loc1 = new Location(emptyTile.getRow(), emptyTile.getCol());
			Tile moveTile = new Tile (clickTile.getTop(), clickTile.isFlipState(), loc1.getRow(), loc1.getCol());
			Tile emptyMove = new Tile (0, emptyTile.isFlipState(), clickLoc.getRow(), clickLoc.getCol());
			moveTile.flip();
			model.setEmptyTile(clickTile.getRow(), clickTile.getCol());
			model.setTile(emptyMove.getLocation(), emptyMove);
			model.setTile(moveTile.getLocation(), moveTile);
			model.setNumOfMoves(model.getNumOfMoves() + 1);
		}
	}
	
}
