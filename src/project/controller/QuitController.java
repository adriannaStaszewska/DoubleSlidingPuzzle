package project.controller;

import javax.swing.JOptionPane;

import project.boundry.AppView;

public class QuitController {

	//borrowed from Tangram Application
	public boolean confirm(AppView app) {
		return JOptionPane.showConfirmDialog(app, "Do you wish to exit Application?") == JOptionPane.OK_OPTION;	
	}
	
}
