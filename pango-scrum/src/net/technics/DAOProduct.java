package net.technics;

import java.util.ArrayList;
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
	 * Fonction de récupération des produits dans lesquels le collaborateur
	 * connecté joue un rôle
	 * 
	 * @return List<Product>
	 */
	public static List<Product> getMyProducts() {
		org.hibernate.Query query = AppController.session.createQuery("from PlayRole where idCollaborator =" + AppController.getActiveUser().getId());
		List<Playrole> lesRolesJoues = query.list();
		List<Product> lesProduits = new ArrayList<>();
		for (Playrole playrole : lesRolesJoues) {
			Product product = (Product) AppController.session.get(Product.class, playrole.getProduct().getId());
			lesProduits.add(product);
		}
		return lesProduits;
	}

	public static List<Product> getMyCurrentProducts() {
		// récupération des produits
		List<Product> lesProducts = DAOProduct.getMyProducts();

		List<Product> lesProduitsEnCours = new ArrayList<>();

		// on vérifie si le projet est terminé ou non
		for (Product product : lesProduitsEnCours) {
			// récupération des sprints du produit
			org.hibernate.Query query = AppController.session.createQuery("from Sprint where idProduct=" + product.getId());
			List<Sprint> lesSprints = query.list();
			// pour chaque sprint
			int i = 0;
			boolean trouve = false;
			while ((!trouve) && (i < lesSprints.size())) {
				// récupération de la date de fin
				org.hibernate.Query queryEvent = AppController.session.createQuery("from Event where idSprint=" + lesSprints.get(i).getId() + "and idEventType=2");

				if (queryEvent.uniqueResult() != null) {
					net.models.Event evenement = (net.models.Event) queryEvent.uniqueResult();
					/*
					 * if (evenement.getEventDate() < ){ trouve = true; }
					 */
				}
			}
			i = i + 1;
		}

		return lesProduitsEnCours;
	}

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
	 * Fonction de récupération des sprints d'un utilisateur
	 * 
	 * @return List<Sprint>
	 */
	public static List<Sprint> getLesSprintsUtilisateur() {
		Query query = AppController.session.createQuery("SELECT s FROM Sprint AS s JOIN s.userstories AS us "
				+ "JOIN us.collaborators AS co WHERE s.product=" + ProductController.getSelectedProduct().getId() + " AND co.id =" + AppController.getActiveUser().getId());
		List<Sprint> lesSprintsUtils = query.list();
		return lesSprintsUtils;

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
	 * Fonction de récupération des user stories à faire d'un utilisateur
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesAFaireUtils() {
		Query query = AppController.session.createQuery("SELECT us FROM Userstory AS us JOIN us.collaborators AS co WHERE us.status = 1 and us.product=" + ProductController.getSelectedProduct().getId() + " AND co.id=" + AppController.getActiveUser().getId());
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
	 * Fonction de récupération des user stories en cours d'un utilisateur
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesEnCoursUtils() {
		Query query = AppController.session.createQuery("SELECT us FROM Userstory AS us JOIN us.collaborators AS co WHERE us.status = 2 and us.product=" + ProductController.getSelectedProduct().getId() + " AND co.id=" + AppController.getActiveUser().getId());
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
	 * Fonction de récupération des user stories finies d'un utilisateur
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesFiniesUtils() {
		Query query = AppController.session.createQuery("SELECT us FROM Userstory AS us JOIN us.collaborators AS co WHERE us.status = 3 and us.product=" + ProductController.getSelectedProduct().getId() + " AND co.id=" + AppController.getActiveUser().getId());
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
	 * Fonction de récupération des user stories à faire pour un sprint d'un
	 * utilisateur
	 * 
	 * @return List<Userstory>
	 */
	public static List<Userstory> getLesUserstoriesAFaireDeSprintUtils(Integer idActiveSprint) {
		Query query = AppController.session.createQuery("SELECT us FROM Userstory AS us JOIN us.collaborators AS co WHERE us.idStatus = 1 and us.idSprint=" + idActiveSprint + " and us.idProduct=" + ProductController.getSelectedProduct().getId() + " and co.id=" + AppController.getActiveUser().getId());
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
