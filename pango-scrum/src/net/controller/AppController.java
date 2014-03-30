package net.controller;

import net.models.Collaborator;

public class AppController {

	private static Collaborator activeUser = new Collaborator();
	
	public static Collaborator getActiveUser(){
		return activeUser;
	}
	
	public static void setActiveUser(Collaborator collaborators){
		activeUser = collaborators;
	}
}
