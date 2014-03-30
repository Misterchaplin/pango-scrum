package net.controller;

import net.hibernate.HibernateUtil;
import net.models.Collaborator;

import org.hibernate.Session;

public class LoginController {
	
	public static boolean verify(String login, String password){
		Session session = HibernateUtil.getSession();
		org.hibernate.Query query = session.createQuery("From Collaborator WHERE login = '"+login+"'");
		Collaborator collaborators  = (Collaborator) query.uniqueResult();
		
		if(collaborators != null && collaborators.getPassword().equals(password)){
			AppController.setActiveUser(collaborators);
			return true;
		}
		return false;
	}
}