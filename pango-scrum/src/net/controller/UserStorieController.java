package net.controller;

import java.util.ArrayList;
import java.util.List;

import net.models.Userstory;
import net.vues.VAddUserStorie;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;
import org.hibernate.Session;

import net.models.Product;
import net.technics.HibernateUtil;

public class UserStorieController implements SelectionListener {
	
	private VAddUserStorie vAddUserStorie;

	/**
	 * @wbp.parser.entryPoint
	 */
	public UserStorieController(VAddUserStorie vAddUserStorie) {
		this.vAddUserStorie = vAddUserStorie;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void init() {
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private List<Userstory> getUserstories() {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus= 1");
		List<Userstory> userStories = query.list();
		return userStories;

	}
	
	private List<Product> getProduct() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Product");
		List<Product> lesproducts = query.list();
		return lesproducts;
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
