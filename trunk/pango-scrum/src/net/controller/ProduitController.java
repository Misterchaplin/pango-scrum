package net.controller;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.models.Collaborator;
import net.models.Playrole;
import net.models.Product;
import net.models.Sprint;
import net.models.Userstory;
import net.technics.DAOCollaborator;
import net.vues.VListCollaborators;

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
	public ProduitController(net.vues.VListProduits vListProduit) {
		this.vListProduits = vListProduit;
	}

	public void init() {
		// récupération de la session
		final Session session = AppController.session;

		// sélection d'un collaborateur, seulement si l'utilisateur est
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
					vListProduits.gettxtNomProduit().setText("");
					vListProduits.getTxtDescriptif().setText("");
					vListProduits.getBtnSupprimerProduits().setVisible(false);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		// bouton de suppression d'un collaborateur
		vListProduits.getBtnSupprimerProduits().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox messageConfirmSuppression = new MessageBox(vListProduits.getListProduits(), SWT.OK | SWT.ICON_CANCEL | SWT.ICON_QUESTION);
				messageConfirmSuppression.setMessage("Etes-vous sûr de vouloir supprimer ce projet ?");
				int result = messageConfirmSuppression.open();
				if (result == 32) {
					StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
					Collaborator selectedproduct = (Collaborator) selection.getFirstElement();
					Transaction trans = session.beginTransaction();
					session.delete(selectedproduct);
					trans.commit();
					vListProduits.getLblInformation().setText("opération d'annulation réussie");
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				else {
					vListProduits.getLblInformation().setText("opération d'annulation annulée");
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
				}
				vListProduits.getGrpProduits().setVisible(false);
				vListProduits.getTableViewerProduits().setInput(DAOCollaborator.getCollaborators());
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
				

				// vérification données
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
					
						// instanciation du nouveau collaborateur
						Set<Sprint> sprints = new HashSet<Sprint>(0);
						Set<Playrole> playroles = new HashSet<Playrole>(0);
						Set<Userstory> userstories = new HashSet<Userstory>(0);
						Product aProduct = new Product(nom, descriptif,sprints,playroles,userstories);
						Transaction trans = session.beginTransaction();
						session.persist(aProduct);
						trans.commit();
						messageInformation = "opération d'ajout réussie";
				
						// récupération du collaborateur sélectionné
						StructuredSelection selection = (StructuredSelection) vListProduits.getTableViewerProduits().getSelection();
						Product selectedProduct = (Product) selection.getFirstElement();
						vListProduits.gettxtNomProduit().setEnabled(true);
						selectedProduct.setName(nom);
						selectedProduct.setDescription(descriptif);
						Transaction trans1 = session.beginTransaction();
						session.update(selectedProduct);
						trans1.commit();
						messageInformation = "opération de mise à jour réussie";
					
					vListProduits.getGrpProduits().setVisible(false);
					vListProduits.getLblInformation().setText(messageInformation);
					vListProduits.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				vListProduits.getTableViewerProduits().setInput(DAOCollaborator.getCollaborators());

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
				vListProduits.getLblInformation().setText("opération annulée");
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
