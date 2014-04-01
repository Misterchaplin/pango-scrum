package net.controller;

import net.models.Collaborator;
import net.technics.HibernateUtil;

import org.hibernate.Session;

public class LoginController extends AppController {

	public static boolean verify(String login, String password) {
		Session session = HibernateUtil.getSession();
		org.hibernate.Query query = session.createQuery("From Collaborator WHERE login = '" + login + "'");
		Collaborator collaborators = (Collaborator) query.uniqueResult();

		if (collaborators != null && collaborators.getPassword().equals(password)) {
			AppController.setActiveUser(collaborators);
			return true;
		}
		return false;
	}
}