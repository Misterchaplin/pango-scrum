package net.technics;

import java.util.ArrayList;
import java.util.List;

import net.controller.AppController;
import net.controller.ProductController;
import net.models.Collaborator;
import net.models.Playrole;

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

	public static List<Collaborator> getAffectedCollaborators() {
		List<Collaborator> lesCollaborateursAffectes = new ArrayList<>();
		org.hibernate.Query query = AppController.session.createQuery("from Playrole where idProduct = " + ProductController.getSelectedProduct().getId());
		List<Playrole> lesRolesJoues = query.list();
		for (Playrole playrole : lesRolesJoues) {
			Collaborator aCollaborator = (Collaborator) AppController.session.get(Collaborator.class, playrole.getCollaborator().getId());
			lesCollaborateursAffectes.add(aCollaborator);
		}
		return lesCollaborateursAffectes;
	}

	public static List<Collaborator> getUnaffectedCollaborators() {
		org.hibernate.Query query = AppController.session.createQuery("from Collaborator where id not in (select id from Collaborator inner join Playrole on Collaborator.id = Playrole.idCollaborator where idProdcut =" + ProductController.getSelectedProduct().getId());
		List<Collaborator> lesCollaborateursNonAffectes = query.list();
		return lesCollaborateursNonAffectes;
	}
}
