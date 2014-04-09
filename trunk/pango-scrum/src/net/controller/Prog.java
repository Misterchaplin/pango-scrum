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

			VSprint vSprint = new VSprint();
			new AppController(vSprint);
			vAccueil = new VAccueil();
			new AppController(vAccueil);
			VAddUserStorie vAddUserStorie = new VAddUserStorie();
			new AppController(vAddUserStorie);
			//VOverview vOverview = new VOverview();
			//new AppController(vOverview);
			vAccueil.open();
			//vOverview.open();
			vSprint.open();
			vAddUserStorie.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
