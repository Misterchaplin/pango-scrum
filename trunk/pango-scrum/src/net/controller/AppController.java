package net.controller;

import net.models.Collaborator;
import net.vues.VLogin;

public class AppController {
	private static Collaborator activeUser = new Collaborator();

	public static Collaborator getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(Collaborator collaborators) {
		activeUser = collaborators;
	}

	public AppController(VLogin vLogin) {
		LoginController loginController = new LoginController(vLogin);
		vLogin.init();
		loginController.init();
	}
	
}
