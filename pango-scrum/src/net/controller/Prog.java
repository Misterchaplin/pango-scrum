package net.controller;

import net.vues.VAccueil;
import net.vues.VAffectationCollaborator;
import net.vues.VOverview;

public class Prog {

	public static VAccueil vAccueil;
	public static VAffectationCollaborator vAffectationCollaborator;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// ajout de vSprint pour tester la partie sprint sans avoir à se
			// connecter ne pas effacer svp...

			vAffectationCollaborator = new VAffectationCollaborator();
			new AppController(vAffectationCollaborator);
			vAccueil = new VAccueil();
			new AppController(vAccueil);
			VOverview vOverview = new VOverview();
			new AppController(vOverview);
			vAccueil.open();
			vAffectationCollaborator.open();
			vOverview.open();
			// vSprint.open();
			// vAddUserStorie.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
