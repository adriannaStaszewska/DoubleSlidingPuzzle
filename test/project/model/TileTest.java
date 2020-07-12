package project.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TileTest {
	
	@Test
	public void flipTest() {
		Tile testTile = new Tile(1, false, 0, 0);
		testTile.flip();
		assertEquals(testTile.getTop(), 4);
		assertEquals(testTile.isFlipState(), true);
		
		
	}
	
	@Test
	public void moveTest() {
		Tile testTile = new Tile(1, false, 0, 0);
		testTile.move(1, 2);
		assertEquals(testTile.getRow(), 1);
		assertEquals(testTile.getCol(), 2);
	}
	
	@Test
	public void setTest() {
		Tile testTile = new Tile(1, false, 0, 0);
		testTile.setCol(1);
		assertEquals(testTile.getCol(), 1);
		
		
	}

}
