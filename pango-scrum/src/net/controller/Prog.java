package net.controller;

import net.vues.VAccueil;
import net.vues.VSprint;

public class Prog {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {			
			VSprint vSprint = new VSprint();
			new AppController(vSprint);
			VAccueil vAccueil = new VAccueil();
			new AppController(vAccueil);
			vAccueil.open();
			vSprint.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
