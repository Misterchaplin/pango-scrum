package net.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.models.Playrole;
import net.models.Product;
import net.models.Sprint;
import net.models.Userstory;
import net.technics.DAOProduct;
import net.vues.VAffectationCollaborator;
import net.vues.VListProduits;
import net.vues.VOverview;
import net.vues.VSprint;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitController implements SelectionListener {
	private VListProduits vListProduits;
	public static int nbOpenedWindowDetail = 0;
	public static int nbOpenedWindowaffectation = 0;
	public static int nbOpenedWindowsprint = 0;
	public static VAffectationCollaborator vAffectationCollaborator;

	public ProduitController(net.vues.VListProduits vListProduit) {
		this.vListProduits = vListProduit;
	}

	public void init() {
		// récupération de la session
		final Session session = AppController.session;

		// sélection d'un produit, seulement si l'utilisateur est
		// administrateur
		if (AppController.getActiveUser().getAdministrator()) {
			vListProduits.getTableProduits().addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					// récupération du projet sélectionné et enregistrement
					StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
					Product selectedProduit = (Product) selection.getFirstElement();
					ProductController.setSelectedProduct(selectedProduit);

					vListProduits.getGrpProduits().setVisible(true);
					vListProduits.gettxtNomProduit().setText(selectedProduit.getName());
					vListProduits.getTxtDescriptif().setText(selectedProduit.getDescription());
					vListProduits.gettxtNomProduit().setEnabled(false);
					vListProduits.getBtnOverview().setVisible(true);
					vListProduits.getGrpActions().setVisible(true);
					vListProduits.getBtnSupprimerProduits().setVisible(true);

					vListProduits.getLblInformation().setText("");
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		// bouton d'ajout d'un produit
		if (AppController.getActiveUser().getAdministrator()) {
			vListProduits.getBtnAjouterProduits().addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					vListProduits.getGrpProduits().setVisible(true);
					vListProduits.gettxtNomProduit().setText("");
					vListProduits.getTxtDescriptif().setText("");
					vListProduits.gettxtNomProduit().setVisible(true);
					vListProduits.gettxtNomProduit().setEnabled(true);
					vListProduits.getTxtDescriptif().setVisible(true);
					vListProduits.getBtnSupprimerProduits().setVisible(false);
					vListProduits.getGrpActions().setVisible(false);
					vListProduits.getBtnSupprimerProduits().setVisible(false);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		// bouton overveiw
		vListProduits.getBtnOverview().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (nbOpenedWindowDetail == 0) {
					nbOpenedWindowDetail = 1;
				VOverview vOverview = new VOverview();
				OverviewController OverviewController = new OverviewController(vOverview);
				vOverview.init();
				OverviewController.init();
				vOverview.open();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton de suppression d'un produit
		vListProduits.getBtnSupprimerProduits().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox messageConfirmSuppression = new MessageBox(vListProduits.getListProduits(), SWT.OK | SWT.ICON_CANCEL | SWT.ICON_QUESTION);
				messageConfirmSuppression.setMessage("Etes-vous sûr de vouloir supprimer ce projet ?");
				int result = messageConfirmSuppression.open();
				if (result == 32) {
					Product selectedproduct = ProductController.getSelectedProduct();
					Transaction trans = session.beginTransaction();
					List<Userstory> lesUserStorys = DAOProduct.getUserStorie(selectedproduct);
					for (Userstory userstory : lesUserStorys) {
						session.delete(userstory);
					}
					session.delete(selectedproduct);
					trans.commit();
					vListProduits.getLblInformation().setText("opération de suppression réussie");
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				else {
					vListProduits.getLblInformation().setText("opération d'annulation annulée");
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
				}
				vListProduits.getGrpProduits().setVisible(false);
				vListProduits.getTableViewerProduits().setInput(DAOProduct.getProducts());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton de validation
		vListProduits.getBtnValider().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// initialisation message erreur
				String messageErreur = "";

				// récupération données saisies
				String nom = vListProduits.gettxtNomProduit().getText();
				String descriptif = vListProduits.getTxtDescriptif().getText();

				// vérification donnés
				if (nom == "") {
					messageErreur = messageErreur + " > " + "nom obligatoire";
				}
				if (descriptif == "") {
					messageErreur = messageErreur + " > " + "descriptif obligatoire";
				}
				// affichage message erreur
				vListProduits.getLblInformation().setText(messageErreur);
				vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));

				// si pas d'erreur
				if (messageErreur == "") {
					String messageInformation = "";
					// si c'est un ajout
					if (!vListProduits.getBtnSupprimerProduits().isVisible()) {
						// instanciation du nouveau produit
						Set<Sprint> sprints = new HashSet<Sprint>(0);
						Set<Playrole> playroles = new HashSet<Playrole>(0);
						Set<Userstory> userstories = new HashSet<Userstory>(0);
						Product aProduct = new Product(nom, descriptif, sprints, playroles, userstories);
						Transaction trans = session.beginTransaction();
						session.persist(aProduct);
						trans.commit();
						messageInformation = "opération d'ajout réussie";
					}
					else {
						// récupération du produit sélectionné
						StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
						Product selectedProduct = (Product) selection.getFirstElement();
						vListProduits.gettxtNomProduit().setEnabled(true);
						selectedProduct.setName(nom);
						selectedProduct.setDescription(descriptif);
						Transaction trans1 = session.beginTransaction();
						session.update(selectedProduct);
						trans1.commit();
						messageInformation = "opération de mise à  jour réussie";
					}
					//vListProduits.getGrpProduits().setVisible(false);
					vListProduits.getLblInformation().setText(messageInformation);
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				vListProduits.getTableViewerProduits().setInput(DAOProduct.getProducts());

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton d'annulation
		vListProduits.getBtnAnnuler().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vListProduits.getGrpProduits().setVisible(false);
				vListProduits.getGrpActions().setVisible(false);
				vListProduits.getLblInformation().setText("opération annulée");
				vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton affectation de collaborateurs
		vListProduits.getBtnAffectationCollaborators().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (nbOpenedWindowaffectation == 0) {
					nbOpenedWindowaffectation = 1;
				vAffectationCollaborator = new VAffectationCollaborator();
				AffectationController affectationController = new AffectationController(vAffectationCollaborator);
				vAffectationCollaborator.init();
				affectationController.init();
				vAffectationCollaborator.open();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton voir sprints
		vListProduits.getBtnSprints().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (nbOpenedWindowsprint == 0) {
					nbOpenedWindowsprint = 1;
				VSprint vSprint = new VSprint();
				SprintController sprintController = new SprintController(vSprint);
				vSprint.init();
				sprintController.init();
				vSprint.open();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
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
