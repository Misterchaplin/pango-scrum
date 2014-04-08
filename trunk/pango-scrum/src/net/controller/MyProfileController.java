package net.controller;

import net.models.Collaborator;
import net.vues.VMdpModification;
import net.vues.VMyProfile;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Transaction;

public class MyProfileController {

	private VMyProfile vMyProfile;

	public MyProfileController(VMyProfile vMyProfile) {
		this.vMyProfile = vMyProfile;
	}

	public void init() {
		// bouton valider
		vMyProfile.getBtnValider().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// récupération des données
				String nom = vMyProfile.getTxtNom().getText();
				String prenom = vMyProfile.getTxtPrenom().getText();
				String email = vMyProfile.getTxtEmail().getText();

				// récupération de l'utilisateur actif
				Collaborator activeUser = AppController.getActiveUser();

				// modification des memebres de l'utilisateur actif
				activeUser.setLastname(nom);
				activeUser.setFirstname(prenom);
				activeUser.setEmail(email);

				// mise à jour de l'utilisateur actif
				Transaction trans = AppController.session.beginTransaction();
				AppController.session.update(activeUser);
				trans.commit();

				// affichage message information sur la page d'accueil
				AccueilController.vAccueil.getLblInformation().setText("Votre profil a été modifié.");

				// fermeture de la boîte de profil
				vMyProfile.getvMyProfile().close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// lien de chagement du mot de passe
		vMyProfile.getLinkChangeMdp().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VMdpModification vMdpModification = new VMdpModification();
				MdpModificationController mdpModificationController = new MdpModificationController(vMdpModification);
				vMdpModification.init();
				mdpModificationController.init();
				vMdpModification.open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		vMyProfile.getBtnAnnuler().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vMyProfile.getvMyProfile().close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
