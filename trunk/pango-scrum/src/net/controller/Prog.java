package net.controller;

import net.vues.VAccueil;
import net.vues.VAddUserStorie;
import net.vues.VSprint;

public class Prog {

	public static VAccueil vAccueil;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// ajout de vSprint pour tester la partie sprint sans avoir � se
			// connecter ne pas effacer svp...

			VSprint vSprint = new VSprint();
			new AppController(vSprint);
			vAccueil = new VAccueil();
			new AppController(vAccueil);
			VAddUserStorie vAddUserStorie = new VAddUserStorie();
			new AppController(vAddUserStorie);
			vAccueil.open();
			vSprint.open();
			vAddUserStorie.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
