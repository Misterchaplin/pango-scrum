package net.controller;

import java.util.Random;

import net.models.Collaborator;
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

public class CollaboratorController implements SelectionListener {
	private VListCollaborators vListCollaborator;

	public CollaboratorController(VListCollaborators vListCollaborator) {
		this.vListCollaborator = vListCollaborator;
	}

	public void init() {
		// récupération de la session
		final Session session = AppController.session;

		// sélection d'un collaborateur, seulement si l'utilisateur est
		// administrateur
		if (AppController.getActiveUser().getAdministrator()) {
			vListCollaborator.getTableCollaborators().addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					vListCollaborator.getGrpCollaborateur().setVisible(true);
					StructuredSelection selection = (StructuredSelection) vListCollaborator.getTableViewerCollaborators().getSelection();
					Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();
					vListCollaborator.getTxtLogin().setText(selectedCollaborator.getLogin());
					vListCollaborator.getTxtNom().setText(selectedCollaborator.getLastname());
					vListCollaborator.getTxtPrenom().setText(selectedCollaborator.getFirstname());
					vListCollaborator.getTxtEMail().setText(selectedCollaborator.getEmail());
					if (selectedCollaborator.getAdministrator()) {
						vListCollaborator.getBtnAdmin().setSelection(true);
					}
					else {
						vListCollaborator.getBtnAdmin().setSelection(false);
					}
					vListCollaborator.getBtnSupprimerCollaborateur().setVisible(true);
					vListCollaborator.getLinkReinitMdp().setVisible(true);
					vListCollaborator.getTxtLogin().setEnabled(false);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		// bouton d'ajout d'un collaborateur, si l'utilisateur actif est
		// administrateur
		if (AppController.getActiveUser().getAdministrator()) {
			vListCollaborator.getBtnAjouterCollaborator().addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					vListCollaborator.getGrpCollaborateur().setVisible(true);
					vListCollaborator.getTxtLogin().setText("");
					vListCollaborator.getTxtNom().setText("");
					vListCollaborator.getTxtPrenom().setText("");
					vListCollaborator.getTxtEMail().setText("");
					vListCollaborator.getBtnSupprimerCollaborateur().setVisible(false);
					vListCollaborator.getLinkReinitMdp().setVisible(false);
					vListCollaborator.getBtnAdmin().setSelection(false);
					vListCollaborator.getTxtLogin().setEnabled(true);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		// bouton de suppression d'un collaborateur
		vListCollaborator.getBtnSupprimerCollaborateur().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox messageConfirmSuppression = new MessageBox(vListCollaborator.getListCollaborators(), SWT.OK | SWT.ICON_CANCEL | SWT.ICON_QUESTION);
				messageConfirmSuppression.setMessage("Etes-vous sûr de vouloir supprimer ce collaborateur ?");
				int result = messageConfirmSuppression.open();
				if (result == 32) {
					StructuredSelection selection = (StructuredSelection) vListCollaborator.getTableViewerCollaborators().getSelection();
					Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();
					Transaction trans = session.beginTransaction();
					session.delete(selectedCollaborator);
					trans.commit();
					vListCollaborator.getLblInformation().setText("opération d'annulation réussie");
					vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				else {
					vListCollaborator.getLblInformation().setText("opération d'annulation annulée");
					vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
				}
				vListCollaborator.getGrpCollaborateur().setVisible(false);
				vListCollaborator.getTableViewerCollaborators().setInput(DAOCollaborator.getCollaborators());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton de validation
		vListCollaborator.getBtnValider().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// initialisation message erreur
				String messageErreur = "";

				// récupération données saisies
				String login = vListCollaborator.getTxtLogin().getText();
				String nom = vListCollaborator.getTxtNom().getText();
				String prenom = vListCollaborator.getTxtPrenom().getText();
				String mail = vListCollaborator.getTxtEMail().getText();
				Boolean admin;
				if (vListCollaborator.getBtnAdmin().getSelection()) {
					admin = true;
				}
				else {
					admin = false;
				}
				// génération aléatoire du mot de passe
				Random mdp = new Random(0);

				// vérification données
				if (login == "") {
					messageErreur = messageErreur + " > " + "login obligatoire";
				}
				if (nom == "") {
					messageErreur = messageErreur + " > " + "nom obligatoire";
				}
				if (prenom == "") {
					messageErreur = messageErreur + " > " + "prénom obligatoire";
				}
				if (mail == "") {
					messageErreur = messageErreur + " > " + "email obligatoire";
				}
				// affichage message erreur
				vListCollaborator.getLblInformation().setText(messageErreur);
				vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));

				// si pas d'erreur
				if (messageErreur == "") {
					String messageInformation = "";
					// si c'est un ajout
					if (!vListCollaborator.getLinkReinitMdp().isVisible()) {
						// instanciation du nouveau collaborateur
						Collaborator aCollaborator = new Collaborator(login, mdp.toString().substring(17), prenom, nom, mail, admin);
						Transaction trans = session.beginTransaction();
						session.persist(aCollaborator);
						trans.commit();
						messageInformation = "opération d'ajout réussie";
					}
					// si c'est une modification
					else {
						// récupération du collaborateur sélectionné
						StructuredSelection selection = (StructuredSelection) vListCollaborator.getTableViewerCollaborators().getSelection();
						Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();
						vListCollaborator.getTxtLogin().setEnabled(true);
						selectedCollaborator.setFirstname(prenom);
						selectedCollaborator.setLastname(nom);
						selectedCollaborator.setEmail(mail);
						Transaction trans = session.beginTransaction();
						session.update(selectedCollaborator);
						trans.commit();
						messageInformation = "opération de mise à jour réussie";
					}
					vListCollaborator.getGrpCollaborateur().setVisible(false);
					vListCollaborator.getLblInformation().setText(messageInformation);
					vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				vListCollaborator.getTableViewerCollaborators().setInput(DAOCollaborator.getCollaborators());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton d'annulation
		vListCollaborator.getBtnAnnuler().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vListCollaborator.getGrpCollaborateur().setVisible(false);
				vListCollaborator.getLblInformation().setText("opération annulée");
				vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// lien de réinitialisation d'un mot de passe
		vListCollaborator.getLinkReinitMdp().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String messageInformation = "";
				// récupération du collaborateur sélectionné
				StructuredSelection selection = (StructuredSelection) vListCollaborator.getTableViewerCollaborators().getSelection();
				Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();
				// demande de confirmation
				MessageBox messageConfirmReinitialisation = new MessageBox(vListCollaborator.getListCollaborators(), SWT.OK | SWT.ICON_CANCEL | SWT.ICON_QUESTION);
				messageConfirmReinitialisation.setMessage("Etes-vous sûr de vouloir réinitialiser le mot de passe ?");
				int result = messageConfirmReinitialisation.open();
				if (result == 32) {
					// réinitialisation mot de passe
					Random mdp = new Random(0);
					selectedCollaborator.setPassword(mdp.toString().substring(17));
					Transaction trans = session.beginTransaction();
					session.update(selectedCollaborator);
					trans.commit();
					messageInformation = "opération de réinitialisation du mot de passe réussie";
					vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				}
				else {
					messageInformation = "opération de réinitialisation du mot de passe annulée";
					vListCollaborator.getLblInformation().setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
				}
				vListCollaborator.getGrpCollaborateur().setVisible(false);
				vListCollaborator.getLblInformation().setText(messageInformation);
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
