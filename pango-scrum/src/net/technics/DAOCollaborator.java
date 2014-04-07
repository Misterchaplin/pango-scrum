package net.technics;

import java.util.List;

import net.controller.AppController;
import net.models.Collaborator;

public class DAOCollaborator {

	/**
	 * Fonction de récupération de tous les collaborateurs
	 * 
	 * @return List<Collaborator> lesCollaborateurs
	 */
	public static List<Collaborator> getCollaborators() {
		org.hibernate.Query query = AppController.getSession().createQuery("from Collaborator");
		List<Collaborator> lesCollaborateurs = query.list();
		return lesCollaborateurs;
	}
}
