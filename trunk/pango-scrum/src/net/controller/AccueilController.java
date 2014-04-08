package net.controller;

import net.vues.VAccueil;
import net.vues.VListCollaborators;
import net.vues.VLogin;
import net.vues.VMyProfile;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class AccueilController implements SelectionListener {
	public static VAccueil vAccueil;
	public static int nbOpenedWindowCollaborator = 0;
	public static int nbOpenedWindowConnection = 0;
	public static int nbOpenedWindowMyProfile = 0;

	public AccueilController(VAccueil vAccueil) {
		this.vAccueil = vAccueil;
	}

	public void init() {
		// onglet connexion
		vAccueil.getItemConnexion().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// si on se connecte
				if (vAccueil.getItemConnexion().getText().equals("Connexion")) {
					// on ouvre la fenêtre seulement si elle n'est pas déjà
					// ouverte
					if (nbOpenedWindowConnection == 0) {
						nbOpenedWindowConnection = 1;
						VLogin vLogin = new VLogin();
						LoginController loginController = new LoginController(vLogin);
						vLogin.init();
						loginController.init();
						vLogin.open();
					}
				}
				// si on se déconnecte
				else {
					AppController.setActiveUser(null);
					vAccueil.getItemConnexion().setText("Connexion");
					vAccueil.getItemProduits().setText("");
					vAccueil.getItemProduits().setEnabled(false);
					vAccueil.getItemCollaborateurs().setText("");
					vAccueil.getItemCollaborateurs().setEnabled(false);
					vAccueil.getItemMonProfil().setEnabled(false);
					vAccueil.getItemMonProfil().setText("");
					vAccueil.getLblInformation().setText("");
					vAccueil.getItemLogin().setText("");
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// onglet collaborateurs
		vAccueil.getItemCollaborateurs().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// on ouvre la fenêtre seulement si elle n'est pas déjà ouverte
				if (nbOpenedWindowCollaborator == 0) {
					nbOpenedWindowCollaborator = 1;
					VListCollaborators vListCollaborators = new VListCollaborators();
					CollaboratorController collaboratorController = new CollaboratorController(vListCollaborators);
					vListCollaborators.init();
					collaboratorController.init();
					vListCollaborators.open();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// onglet mon profil
		vAccueil.getItemMonProfil().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// on ouvre la fenêtre seulement si elle n'est pas déjà ouverte
				if (nbOpenedWindowMyProfile == 0) {
					nbOpenedWindowMyProfile = 1;
					VMyProfile vMyProfile = new VMyProfile();
					MyProfileController myProfileController = new MyProfileController(vMyProfile);
					vMyProfile.init();
					myProfileController.init();
					vMyProfile.open();
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
