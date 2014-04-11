package net.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.models.Playrole;
import net.models.Product;
import net.models.Sprint;
import net.models.Userstory;
import net.technics.DAOProduct;
import net.vues.VListProduits;
import net.vues.VOverview;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitController implements SelectionListener {
	private net.vues.VListProduits vListProduits;
public static int nbOpenedWindowDetail = 0;
	public ProduitController(net.vues.VListProduits vListProduit) {
		this.vListProduits = vListProduit;
	}

	public void init() {
		// rÃ©cupÃ©ration de la session
		final Session session = AppController.session;

		// sÃ©lection d'un produit, seulement si l'utilisateur est
		// administrateur
		if (AppController.getActiveUser().getAdministrator()) {
			vListProduits.getTableProduits().addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					vListProduits.getGrpProduits().setVisible(true);
					StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
					Product selectedProduit = (Product) selection.getFirstElement();
					vListProduits.gettxtNomProduit().setText(selectedProduit.getName());
					vListProduits.getTxtDescriptif().setText(selectedProduit.getDescription());
					vListProduits.gettxtNomProduit().setEnabled(false);
					vListProduits.getBtndetail().setVisible(true);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

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
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		
		//bouton detail
		vListProduits.getBtndetail().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (nbOpenedWindowDetail == 0) {
					nbOpenedWindowDetail = 1;
					StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
					Product selectedproduct = (Product) selection.getFirstElement();
					
					
					VOverview vOverview = new VOverview();
					OverviewController OverviewController = new OverviewController(vOverview);
					OverviewController.setIdProduit(selectedproduct.getId());
					vListProduits.init();
					OverviewController.init();
					vListProduits.open();
				}
				//envoi vers la page de charli
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
				messageConfirmSuppression.setMessage("Etes-vous sÃ»r de vouloir supprimer ce projet ?");
				int result = messageConfirmSuppression.open();
				if (result == 32) {
					StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
					Product selectedproduct = (Product) selection.getFirstElement();
					Transaction trans = session.beginTransaction();
					List<Userstory> lesUserStorys =DAOProduct.getUserStorie(selectedproduct);
					for (Userstory userstory : lesUserStorys) {
						session.delete(userstory);
					}
					session.delete(selectedproduct);
					trans.commit();
					vListProduits.getLblInformation().setText("opÃ©ration d'annulation rÃ©ussie");
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				else {
					vListProduits.getLblInformation().setText("opÃ©ration d'annulation annulÃ©e");
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

				// rÃ©cupÃ©ration donnÃ©es saisies
				String nom = vListProduits.gettxtNomProduit().getText();
				String descriptif = vListProduits.getTxtDescriptif().getText();

				// vÃ©rification donnÃ©es
				if (nom == "") {
					messageErreur = messageErreur + " > " + "nom obligatoir";
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
						messageInformation = "opÃ©ration d'ajout rÃ©ussie";
					}
					else {
						// rÃ©cupÃ©ration du produit sÃ©lectionnÃ©
						StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
						Product selectedProduct = (Product) selection.getFirstElement();
						vListProduits.gettxtNomProduit().setEnabled(true);
						selectedProduct.setName(nom);
						selectedProduct.setDescription(descriptif);
						Transaction trans1 = session.beginTransaction();
						session.update(selectedProduct);
						trans1.commit();
						messageInformation = "opÃ©ration de mise Ã  jour rÃ©ussie";
					}
					vListProduits.getGrpProduits().setVisible(false);
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
				vListProduits.getLblInformation().setText("opÃ©ration annulÃ©e");
				vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
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
