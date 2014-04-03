package net.controller;

import net.vues.VAccueil;

public class Prog {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VAccueil vAccueil = new VAccueil();
			new AppController(vAccueil);
			vAccueil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
