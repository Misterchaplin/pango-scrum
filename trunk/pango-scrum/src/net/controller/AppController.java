package net.controller;

import net.models.Collaborator;
import net.vues.VAccueil;
import net.vues.VSprint;

public class AppController {
	private static Collaborator activeUser = new Collaborator();

	public static Collaborator getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(Collaborator collaborators) {
		activeUser = collaborators;
	}

	public AppController(VAccueil vAccueil) {
		AccueilController accueilController = new AccueilController(vAccueil);
		vAccueil.init();
		accueilController.init();
		
	}
	public AppController(VSprint vSprint) {
		SprintController sprintController = new SprintController(vSprint);
		vSprint.init();
		sprintController.init();
	}
	
}