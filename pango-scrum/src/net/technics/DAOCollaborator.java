package net.technics;

import java.util.ArrayList;
import java.util.List;

import net.controller.AppController;
import net.controller.ProductController;
import net.models.Collaborator;
import net.models.Playrole;

/**
 * Classe technique d'accès aux données pour la table Collaborator
 * 
 * @author PENELOPE
 * 
 */
public class DAOCollaborator {

	/**
	 * Fonction de récupération de tous les collaborateurs
	 * 
	 * @return List<Collaborator> lesCollaborateurs
	 */
	public static List<Collaborator> getCollaborators() {
		org.hibernate.Query query = AppController.session.createQuery("from Collaborator");
		List<Collaborator> lesCollaborateurs = query.list();
		return lesCollaborateurs;
	}

	/**
	 * Fonction de récupération des collaborateurs affectés au projet
	 * sélectionné
	 * 
	 * @return List<Collaborator> lesCollaborateursAffectes
	 */
	public static List<Collaborator> getAffectedCollaborators() {
		// initialisation collection
		List<Collaborator> lesCollaborateursAffectes = new ArrayList();

		// execution requête hql
		org.hibernate.Query query = AppController.session.createQuery("from Playrole where idProduct = " + ProductController.getSelectedProduct().getId() + " and idRole = 3");
		List<Playrole> lesRolesJoues = query.list();

		// récupération des collaborateurs
		for (Playrole playrole : lesRolesJoues) {
			Collaborator aCollaborator = (Collaborator) AppController.session.get(Collaborator.class, playrole.getCollaborator().getId());
			if (!lesCollaborateursAffectes.contains(aCollaborator)) {
				lesCollaborateursAffectes.add(aCollaborator);
			}
		}
		return lesCollaborateursAffectes;
	}

	/**
	 * Fonction de récupération des collaborateurs non affectés au projet
	 * 
	 * @return List<Collaborator> lesCollaborateursNonAffectes
	 */
	public static List<Collaborator> getUnaffectedCollaborators() {
		// récupéation des collaborateurs affectés au projet
		List<Collaborator> lesCollaborateursAffectes = DAOCollaborator.getAffectedCollaborators();

		// récupération de tous les collaborateurs dans la base de données
		org.hibernate.Query query = AppController.session.createQuery("from Collaborator");
		List<Collaborator> lesCollaborateurs = query.list();

		// initialisation collection
		List<Collaborator> lesCollaborateursNonAffectes = new ArrayList<>();

		for (Collaborator collaborator : lesCollaborateurs) {
			if (!lesCollaborateursAffectes.contains(collaborator)) {
				lesCollaborateursNonAffectes.add(collaborator);
			}
		}

		return lesCollaborateursNonAffectes;
	}

	/**
	 * Fonction de récupération du scrum master du projet sélectionné
	 * 
	 * @return Collaborator scrumMaster
	 */
	public static Collaborator getScrumMaster() {
		// instanciation collaborateur
		Collaborator scrumMaster = new Collaborator();

		// execution requête hql
		org.hibernate.Query query = AppController.session.createQuery("from Playrole where idProduct = " + ProductController.getSelectedProduct().getId() + " and idRole = 1");
		List<Playrole> roleJoue = query.list();

		// récupération du scrum master
		if (roleJoue.size() == 1) {
			scrumMaster = roleJoue.get(0).getCollaborator();
		}

		return scrumMaster;
	}
}
