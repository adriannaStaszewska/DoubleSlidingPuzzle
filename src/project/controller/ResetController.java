package project.controller;

import project.boundry.AppView;
import project.model.Model;

public class ResetController {

	Model model;
	AppView app;
	
	public ResetController(Model model, AppView app) {
		this.model = model;
		this.app = app;
	}

	public void reset() {
		model.populateBoard();
		model.setNumOfMoves(0);
		model.setLocked(false);
		app.repaint();
	}
}

