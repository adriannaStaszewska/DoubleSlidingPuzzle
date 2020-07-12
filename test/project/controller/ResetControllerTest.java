package project.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.boundry.AppView;
import project.boundry.Board;
import project.model.Model;

public class ResetControllerTest {
	
	@Test
	public void resetTest() {
		Model m = new Model();
		AppView app = new AppView(m);
		Board b = new Board(m, app);
		
		ResetController control = new ResetController(m, app);
		control.reset();
		assertEquals(m.getNumOfMoves(), 0);
		assertEquals(m.isLocked(), false);
	}

}
