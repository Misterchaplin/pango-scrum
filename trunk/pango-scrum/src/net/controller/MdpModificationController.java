package net.controller;

import net.models.Collaborator;
import net.vues.VMdpModification;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Transaction;

public class MdpModificationController {

	private VMdpModification vMdpModification;

	public MdpModificationController(VMdpModification vMdpModification) {
		this.vMdpModification = vMdpModification;
	}

	public void init() {
		// bouton valider
		vMdpModification.getBtnValider().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Collaborator activeUser = AppController.getActiveUser();
				vMdpModification.getLblInformation().setText("");
				// mot de passe actuel non renseigné
				if (vMdpModification.getTxtOldMdp().getText() == "") {
					vMdpModification.getLblInformation().setText("Saisir mot de passe actuel");
				}
				// mot de passe actuel non correct
				else if (!vMdpModification.getTxtOldMdp().getText().equals(activeUser.getPassword())) {
					vMdpModification.getLblInformation().setText("Mot de passe actuel incorrect");
				}
				else {
					if (!vMdpModification.getTxtNewMdp().getText().equals(vMdpModification.getTxtNewMdpConfirm().getText())) {
						vMdpModification.getLblInformation().setText("Nouveau mot de passe et confirmation différents");
					}
					else if (vMdpModification.getTxtNewMdp().getText().length() < 8) {
						vMdpModification.getLblInformation().setText("Le nouveau mot de passe doit contenir au moins 8 caractères");
					}
					else {
						// mise à jour du mot de passe de l'utilisateur connecté
						activeUser.setPassword(vMdpModification.getTxtNewMdp().getText());
						Transaction trans = AppController.session.beginTransaction();
						AppController.session.update(activeUser);
						trans.commit();
						Prog.vAccueil.getLblInformation().setText("Votre mot de passe a été modifié avec succès.");
						vMdpModification.getShlScrumTool().close();
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// bouton annuler
		vMdpModification.getBtnAnnuler().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Prog.vAccueil.getLblInformation().setText("");
				vMdpModification.getShlScrumTool().close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
}
