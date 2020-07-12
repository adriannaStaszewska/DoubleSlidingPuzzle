package project;

import project.boundry.AppView;
import project.model.Model;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		AppView app = new AppView(m);
		app.setVisible(true);
		
	}

} 
