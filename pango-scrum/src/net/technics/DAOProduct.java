package net.technics;

import java.util.List;
import java.util.Set;

import net.controller.AppController;
import net.controller.ProductController;
import net.models.Collaborator;
import net.models.Playrole;
import net.models.Product;
import net.models.Sprint;
import net.models.Userstory;

import org.hibernate.Query;

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

	/**
	 * Fonction de récupération des user stories du produit sélectionné
	 * 
	 * @param Produit
	 * @return List<Userstory> lesUserStories
	 */
	public static Set<Userstory> getUserStorie(Product Produit) {
		Set<Userstory> lesUserStories = ProductController.getSelectedProduct().getUserstories();
		return lesUserStories;
	}

	/**
	 * Fonction de récupération du product owner du produit sélectionné
	 * 
	 * @return Collaborator productOwner
	 */
	public static Collaborator getProductOwner() {
		String sql = "SELECT c FROM Collaborator AS c JOIN c.playroles AS pl "
				+ "JOIN pl.product AS p "
				+ "JOIN pl.role AS r "
				+ "WHERE p.id=" + ProductController.getSelectedProduct().getId() + " AND r.id=2";
		Query query = AppController.session.createQuery(sql);

		Collaborator productOwner = new Collaborator();
		if (query.uniqueResult() != null) {
			productOwner = (Collaborator) query.uniqueResult();
		}

		return productOwner;
	}

	/**
	 * Fonction de récupération du nombre total de points des user stories du
	 * projet
	 * 
	 * @return int totalPoint
	 */
	public static int getUserstoryTotalPoint() {
		int totalPoint = 0;
		Query query = AppController.session.createQuery("SELECT SUM(storyPoints) FROM Userstory WHERE idproduct =" + ProductController.getSelectedProduct().getId());
		if (query.uniqueResult() != null) {
			totalPoint = Integer.valueOf(query.uniqueResult() + "");
		}
		return totalPoint;
	}

	/**
	 * Fonction de récupération des points effectués
	 * 
	 * @return
	 */
	public static int getUserstoryDonePoint() {
		int totalPointFinished = 0;
		Query query = AppController.session.createQuery("SELECT SUM(storyPoints) FROM Userstory WHERE idproduct =" + ProductController.getSelectedProduct().getId() + " AND finishedAt IS NOT Null");
		if (query.uniqueResult() != null) {
			totalPointFinished = Integer.valueOf(query.uniqueResult() + "");
		}
		return totalPointFinished;
	}

	/**
	 * Fonction de récupération des sprints du produit sélectionné
	 * 
	 * @return List<Sprint>
	 */
	public static List<Sprint> getLesSprints() {
		Query query = AppController.session.createQuery("from Sprint where idProduct=" + ProductController.getSelectedProduct().getId());
		List<Sprint> lesSprints = query.list();
		return lesSprints;
	}

	/**
	 * Fonction de récupération des user stories à faire
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesAFaire() {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idstatus = 1 and idProduct=" + ProductController.getSelectedProduct().getId());
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;
	}

	/**
	 * Fonction de récupération des user stories en cours
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesEnCours() {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idstatus = 2 and idProduct=" + ProductController.getSelectedProduct().getId());
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;
	}

	/**
	 * Fonction de récupération des user stories finies
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesFinies() {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idstatus = 3 and idProduct=" + ProductController.getSelectedProduct().getId());
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;
	}

	/**
	 * Fonction de récupération des user stories à faire pour un sprints
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesAFaireDeSprint(Integer idActiveSprint) {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus = 1 and idSprint=" + idActiveSprint + " and idProduct=" + ProductController.getSelectedProduct().getId());
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;
	}

	/**
	 * Fonction de récupération des user stories en cours pour un sprints
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesEnCoursDeSprint(Integer idActiveSprint) {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus = 2 and idSprint=" + idActiveSprint + " and idProduct=" + ProductController.getSelectedProduct().getId());
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;
	}

	/**
	 * Fonction de récupération des user stories fait pour un sprints
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesFaitDeSprint(Integer idActiveSprint) {
		Query query = AppController.session.createQuery("FROM Userstory WHERE idStatus = 3 and idSprint=" + idActiveSprint + " and idProduct=" + ProductController.getSelectedProduct().getId());
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;
	}

	/**
	 * Fonction de récupération des playrole d'un projet
	 * 
	 * @return List<Playrole>
	 */
	public static List<Playrole> getPlayroled(int id) {
		Query query = AppController.session.createQuery("FROM Playrole WHERE idProduct=" + id);
		List<Playrole> lesplayrole = (List<Playrole>) query.list();
		return lesplayrole;
	}

}
