package net.controller;

import net.models.Collaborator;
import net.models.Product;
import net.technics.HibernateUtil;
import net.vues.VAccueil;
import net.vues.VAddUserStorie;
import net.vues.VAffectationCollaborator;
import net.vues.VOverview;
import net.vues.VSprint;

import org.hibernate.Session;

public class AppController {
	// utilisateur connecté
	private static Collaborator activeUser = new Collaborator();
	// session
	public static Session session = HibernateUtil.getSession();

	public static Collaborator getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(Collaborator collaborator) {
		activeUser = collaborator;
	}

	public AppController(VAccueil vAccueil) {
		AccueilController accueilController = new AccueilController(vAccueil);
		vAccueil.init();
		accueilController.init();
	}

	public AppController(VOverview vOverview) {
		OverviewController overviewController = new OverviewController(vOverview);
		vOverview.init();
		overviewController.init();
		overviewController.init1();
		overviewController.init2();
		overviewController.initSprint();
		overviewController.initTotalPoint();
		overviewController.initDonePoint();
		overviewController.initCustomer();
	}

	public AppController(VSprint vSprint) {
		SprintController sprintController = new SprintController(vSprint);
		vSprint.init();
		sprintController.init();
	}

	public AppController(VAddUserStorie vAddUserStorie) {
		UserStorieController userStorieController = new UserStorieController(vAddUserStorie);
		vAddUserStorie.init();
		userStorieController.init();
	}

	public AppController(VAffectationCollaborator vAffectationCollaborator) {
		AffectationController affectationController = new AffectationController(vAffectationCollaborator);
		vAffectationCollaborator.init();
		affectationController.init();
	}
}
