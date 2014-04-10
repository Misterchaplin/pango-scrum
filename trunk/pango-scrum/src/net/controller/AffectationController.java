package net.controller;

import net.models.Collaborator;
import net.models.Playrole;
import net.models.PlayroleId;
import net.models.Role;
import net.technics.DAOCollaborator;
import net.vues.VAffectationCollaborator;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AffectationController {

	private VAffectationCollaborator vAffectationCollaborator;

	public AffectationController(VAffectationCollaborator vAffectationCollaborator) {
		this.vAffectationCollaborator = vAffectationCollaborator;
	}

	public void init() {
		// bouton d'ajout de collaborateurs
		vAffectationCollaborator.getBtnAddCollaborators().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// récupération collaborateur sélectionné
				StructuredSelection selection = (StructuredSelection) vAffectationCollaborator.getTvUnaffectedCollaborators().getSelection();
				Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();

				// création instance de playroleId
				int idRole = 3;
				Integer idProduct = ProductController.getSelectedProduct().getId();
				Integer idCollaborator = selectedCollaborator.getId();
				PlayroleId playroleId = new PlayroleId(idCollaborator, idRole, idProduct);

				// récupération du rôle
				Session session = AppController.session;
				Transaction trans = session.beginTransaction();
				Role role = (Role) AppController.session.get(Role.class, 3);
				trans.commit();

				// création instance de playrole
				Playrole playrole = new Playrole(playroleId, role, ProductController.getSelectedProduct(), selectedCollaborator);
				Transaction transSave = session.beginTransaction();
				session.persist(playrole);
				transSave.commit();

				vAffectationCollaborator.getTvAffectedCollaborators().setInput(DAOCollaborator.getAffectedCollaborators());
				vAffectationCollaborator.getTvUnaffectedCollaborators().setInput(DAOCollaborator.getUnaffectedCollaborators());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton de suppression de collaborateurs
		vAffectationCollaborator.getBtnRemoveCollaborators().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// récupération du collaborateur sélectionné
				StructuredSelection selection = (StructuredSelection) vAffectationCollaborator.getTvAffectedCollaborators().getSelection();
				Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();

				// récupération id collaborateur
				Integer idCollaborator = selectedCollaborator.getId();

				// récupération id produit
				Integer idProduct = ProductController.getSelectedProduct().getId();

				// instanciation nouvel objet
				PlayroleId roleJoueId = new PlayroleId(idCollaborator, 3, idProduct);

				// enregistrement dans la base de données
				Session session = AppController.session;
				Transaction trans = session.beginTransaction();
				Playrole playrole = (Playrole) session.get(Playrole.class, roleJoueId);
				session.delete(playrole);
				trans.commit();

				// mise à jour tableViewer
				vAffectationCollaborator.getTvAffectedCollaborators().setInput(DAOCollaborator.getAffectedCollaborators());
				vAffectationCollaborator.getTvUnaffectedCollaborators().setInput(DAOCollaborator.getUnaffectedCollaborators());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// affichage du bouton de suppression lors du clic sur un collaborateur
		// affecté
		vAffectationCollaborator.getTableAffectedCollaborators().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAffectationCollaborator.getBtnRemoveCollaborators().setVisible(true);
				vAffectationCollaborator.getBtnAddCollaborators().setVisible(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// affichage du bouton d'ajout lors du clic sur un collaborateur non
		// affecté
		vAffectationCollaborator.getTableUnaffectedCollaborators().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vAffectationCollaborator.getBtnAddCollaborators().setVisible(true);
				vAffectationCollaborator.getBtnRemoveCollaborators().setVisible(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// clic sur le bouton de retour à la liste des projets
		vAffectationCollaborator.getBtnReturnListProject().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// clic sur le bouton de modification du scrum master
		vAffectationCollaborator.getBtnDefineScrumMaster().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
}
