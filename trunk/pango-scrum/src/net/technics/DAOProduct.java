package net.technics;

import java.util.ArrayList;
import java.util.List;

import net.controller.AppController;
import net.controller.ProductController;
import net.models.Collaborator;
import net.models.Playrole;
import net.models.Product;

public class DAOProduct {

	/**
	 * Fonction de récupération de tous les product
	 * 
	 * @return List<Product> lesProduits
	 */
	public static List<Product> getProducts() {
		org.hibernate.Query query = AppController.session.createQuery("from Product");
		List<Product> lesProduits = query.list();
		return lesProduits;
	}
}
