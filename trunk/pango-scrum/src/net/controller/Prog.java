package net.controller;

import net.vues.VAccueil;
import net.vues.VAddUserStorie;
import net.vues.VOverview;
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

			vAccueil = new VAccueil();
			new AppController(vAccueil);
			VOverview vOverview = new VOverview();
			new AppController(vOverview);
			vAccueil.open();
			vOverview.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
