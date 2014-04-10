package net.controller;

import net.models.Collaborator;
import net.models.Playrole;
import net.models.PlayroleId;
import net.models.Role;
import net.vues.VAffectationScrumMasterProjet;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class AffectationScrumMasterProjetController {

	private VAffectationScrumMasterProjet vAffectationScrumMasterProjet;

	public AffectationScrumMasterProjetController(VAffectationScrumMasterProjet vAffectationScrumMasterProjet) {
		this.vAffectationScrumMasterProjet = vAffectationScrumMasterProjet;
	}

	public void init() {
		// bouton valider
		vAffectationScrumMasterProjet.getBtnValider().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// récupération du collaborateur
				StructuredSelection selection = (StructuredSelection) vAffectationScrumMasterProjet.getTvScrumMasterCollaborators().getSelection();
				Collaborator collaborateur = (Collaborator) selection.getFirstElement();

				// récupération des ids
				Integer idProduct = ProductController.getSelectedProduct().getId();
				Integer idCollaborateur = collaborateur.getId();
				int idRole = 1;

				// récupération du rôle
				Role role = (Role) AppController.session.get(Role.class, 1);

				PlayroleId playroleId = new PlayroleId(idCollaborateur, idRole, idProduct);
				Playrole playrole = new Playrole(playroleId, role, ProductController.getSelectedProduct(), collaborateur);

				// suppression de l'ancien scrum master
				Query session = AppController.session.createQuery("from Playrole where idProduct=" + ProductController.getSelectedProduct().getId() + "and idRole=1");
				Transaction trans = AppController.session.beginTransaction();

				if (session.uniqueResult() != null) {
					System.out.println("ok");
					Playrole oldPlayrole = (Playrole) session.uniqueResult();
					AppController.session.delete(oldPlayrole);
				}

				// enregistrement en tant que scrum master
				AppController.session.persist(playrole);
				trans.commit();

				// fermeture de la vue
				vAffectationScrumMasterProjet.getvAffectationScrumMasterProjet().close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton annuler
		vAffectationScrumMasterProjet.getBtnAnnuler().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAffectationScrumMasterProjet.getvAffectationScrumMasterProjet().close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
}
