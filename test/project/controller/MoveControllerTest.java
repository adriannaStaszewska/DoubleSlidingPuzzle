package project.controller;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import project.boundry.AppView;
import project.boundry.Board;
import project.model.Location;
import project.model.Model;
import project.model.Tile;

public class MoveControllerTest {
	
	@Test
	public void testGetLocation() {
		Model m = new Model();
		AppView app = new AppView(m);
		Board b = new Board(m, app);
		
		MoveController control = new MoveController(m, app);
		
		assertEquals(control.getTileLocation(new Point(100, 100)).getRow(), 0);
		assertEquals(control.getTileLocation(new Point(100, 100)).getCol(), 0);
		
		assertEquals(control.getTileLocation(new Point(101, 100)).getRow(), 0);
		assertEquals(control.getTileLocation(new Point(101, 100)).getCol(), -1);
		
		assertEquals(control.getTileLocation(new Point(400, 400)).getRow(), -1);
		assertEquals(control.getTileLocation(new Point(400, 400)).getCol(), -1);
		
		assertEquals(control.getTileLocation(new Point(130, 130)).getRow(), 1);
		assertEquals(control.getTileLocation(new Point(130, 130)).getCol(), 1);
		
		assertEquals(control.getTileLocation(new Point(150, 300)).getRow(), 2);
		assertEquals(control.getTileLocation(new Point(150, 300)).getCol(), 1);
	}
	
	@Test
	public void isValidTest() {
		Model m = new Model();
		AppView app = new AppView(m);
		Board b = new Board(m, app);
		
		MoveController control = new MoveController(m, app);
		
		assertEquals(control.isValidMove(new Location(1, 0)), true);
		assertEquals(control.isValidMove(new Location(2,1)), true);
		assertEquals(control.isValidMove(new Location(0, 0)), false);
		assertEquals(control.isValidMove(new Location(2, 0)), false);
	}

	@Test 
	public void isWonTest() {
		Model m = new Model();
		AppView app = new AppView(m);
		Board b = new Board(m, app);
		
		MoveController control = new MoveController(m, app);
		assertEquals(control.isWon(), false);
		
		m.setTile(new Location(0, 0), new Tile(1, false, 0, 0));
		m.setTile(new Location(0, 1), new Tile(2, false, 0, 1));
		m.setTile(new Location(0, 2), new Tile(3, false, 0, 2));
		m.setTile(new Location(1, 0), new Tile(4, true, 1, 0));
		m.setTile(new Location(1, 1), new Tile(0, true, 1, 1));
		m.setTile(new Location(1, 2), new Tile(4, false, 1, 2));
		m.setTile(new Location(2, 0), new Tile(3, true, 2, 0));
		m.setTile(new Location(2, 1), new Tile(2, true, 2, 1));
		m.setTile(new Location(2, 2), new Tile(1, true, 2, 2));
		
		MoveController control2 = new MoveController(m, app);
		assertEquals(control2.isWon(), true);

		m.setTile(new Location(2, 2), new Tile(3, true, 2, 2));
		MoveController control3 = new MoveController(m, app);
		assertEquals(control3.isWon(), false);
	
	}
	
	@Test 
	public void isLostTest() {
		Model m = new Model();
		AppView app = new AppView(m);
		Board b = new Board(m, app); 
		
		MoveController control = new MoveController(m, app);
		assertEquals(control.isLost(), false);
		
		m.setTile(new Location(0, 0), new Tile(1, false, 0, 0));
		m.setTile(new Location(0, 1), new Tile(1, false, 0, 1));
		m.setTile(new Location(0, 2), new Tile(3, false, 0, 2));
		m.setTile(new Location(1, 0), new Tile(4, false, 1, 0));
		m.setTile(new Location(1, 1), new Tile(0, true, 1, 1));
		m.setTile(new Location(1, 2), new Tile(1, true, 1, 2));
		m.setTile(new Location(2, 0), new Tile(3, true, 2, 0));
		m.setTile(new Location(2, 1), new Tile(2, true, 2, 1));
		m.setTile(new Location(2, 2), new Tile(1, true, 2, 2));
		
		MoveController control2 = new MoveController(m, app);
		assertEquals(control2.isLost(), true);

	}
	
	@Test
	public void makeAMoveTest() {
		Model m = new Model();
		AppView app = new AppView(m);
		Board b = new Board(m, app); 
		
		MoveController control = new MoveController(m, app);
		control.makeAMove(new Point(150, 300));
		assertEquals(m.getNumOfMoves(), 1);
		
	}
}
