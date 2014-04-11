package net.technics;

import java.util.ArrayList;
import java.util.List;

import net.controller.AppController;
import net.controller.ProductController;
import net.models.Collaborator;
import net.models.Playrole;
import net.models.Product;
import net.models.Userstory;

public class DAOProduct {

	/**
	 * Fonction de rÃ©cupÃ©ration de tous les product
	 * 
	 * @return List<Product> lesProduits
	 */
	public static List<Product> getProducts() {
		org.hibernate.Query query = AppController.session.createQuery("from Product");
		List<Product> lesProduits = query.list();
		return lesProduits;
	}
	public static List<Userstory> getUserStorie(Product Produit){
		org.hibernate.Query query = AppController.session.createQuery("from UserStory");
		List<Userstory> lesUserStorys = query.list();
		List<Userstory> lesUserStorys1 = null;
		for (Userstory userstory : lesUserStorys) {
			if(userstory.getProduct()== Produit){
				lesUserStorys1.add(userstory);
			}
		}
		return lesUserStorys1;
	}
}
