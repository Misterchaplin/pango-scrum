package net.controller;

import net.models.Collaborator;
import net.vues.VLogin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;

public class LoginController implements SelectionListener {
	private VLogin vLogin;

	public LoginController(VLogin vLogin) {
		this.vLogin = vLogin;
	}

	/**
	 * V√©rification de la coh√©rence login / mot de passe
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	public static boolean verify(String login, String password) {
		org.hibernate.Query query = AppController.session.createQuery("FROM Collaborator WHERE login = '" + login + "' AND password = '" + password + "'");
		Collaborator activeUser = (Collaborator) query.uniqueResult();

		if (activeUser != null) {
			AppController.setActiveUser(activeUser);
			return true;
		}
		return false;
	}

	public void init() {
		// bouton valider
		vLogin.getBtnValider().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String login = vLogin.getText_login().getText();
				String password = vLogin.getText_mdp().getText();

				// identification correcte
				if (LoginController.verify(login, password)) {
					// fermeture de la bo√Æte de login
					vLogin.getShlLogin().close();
					AccueilController.vAccueil.getItemMonProfil().setText("Mon profil");
					AccueilController.vAccueil.getItemConnexion().setText("DÈconnexion");
					AccueilController.vAccueil.getItemMonProfil().setEnabled(true);
					AccueilController.vAccueil.getItemLogin().setText(AppController.getActiveUser().getLogin());
					AccueilController.vAccueil.getGrpProduits().setVisible(true);
					if (AppController.getActiveUser().getAdministrator()) {
						AccueilController.vAccueil.getBtnProducts().setVisible(true);
						AccueilController.vAccueil.getBtnCollaborators().setVisible(true);
						AccueilController.vAccueil.getGrpCollaborateurs().setVisible(true);
					}
					else {
						AccueilController.vAccueil.getBtnProducts().setVisible(false);
						AccueilController.vAccueil.getBtnCollaborators().setVisible(false);
						AccueilController.vAccueil.getGrpCollaborateurs().setVisible(false);
						AccueilController.vAccueil.getGrpCollaborateurs().setText("DÈtail du produit");
						AccueilController.vAccueil.getTableMesProjets().setVisible(true);
					}

					// identification incorrecte
				} else {
					if (login == "" || password == "") {
						vLogin.getLblmsgerreur().setText("Veuillez remplir tous les champs");
						}
					else if(login != "" && password != "") {
						vLogin.getLblmsgerreur().setText("Identifiant incorrecte");
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// bouton annuler
		vLogin.getBtnAnnuler().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vLogin.getText_login().setText("");
				vLogin.getText_mdp().setText("");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		vLogin.getText_login().addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent event) {
				if (event.keyCode == 13) {
					String login = vLogin.getText_login().getText();
					String password = vLogin.getText_mdp().getText();

					// identification correcte
					if (LoginController.verify(login, password)) {
						// fermeture de la bo√Æte de login
						vLogin.getShlLogin().close();
						AccueilController.vAccueil.getItemMonProfil().setText("Mon profil");
						AccueilController.vAccueil.getItemConnexion().setText("DÈconnexion");
						AccueilController.vAccueil.getItemMonProfil().setEnabled(true);
						AccueilController.vAccueil.getItemLogin().setText(AppController.getActiveUser().getLogin());
						AccueilController.vAccueil.getGrpProduits().setVisible(true);
						if (AppController.getActiveUser().getAdministrator()) {
							AccueilController.vAccueil.getBtnProducts().setVisible(true);
							AccueilController.vAccueil.getBtnCollaborators().setVisible(true);
							AccueilController.vAccueil.getGrpCollaborateurs().setVisible(true);
						}
						else {
							AccueilController.vAccueil.getBtnProducts().setVisible(false);
							AccueilController.vAccueil.getBtnCollaborators().setVisible(false);
							AccueilController.vAccueil.getGrpCollaborateurs().setVisible(false);
							AccueilController.vAccueil.getGrpCollaborateurs().setText("DÈtail du produit");
							AccueilController.vAccueil.getTableMesProjets().setVisible(true);
						}

						// identification incorrecte
					} else {
						if (login == "" || password == "") {
							vLogin.getLblmsgerreur().setText("Veuillez remplir tous les champs");
							}
						else if(login != "" && password != "") {
							vLogin.getLblmsgerreur().setText("Identifiant incorrecte");
						}
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub	
			}
		});
		
		vLogin.getText_mdp().addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent event) {
				if (event.keyCode == 13) {
					String login = vLogin.getText_login().getText();
					String password = vLogin.getText_mdp().getText();

					// identification correcte
					if (LoginController.verify(login, password)) {
						// fermeture de la bo√Æte de login
						vLogin.getShlLogin().close();
						AccueilController.vAccueil.getItemMonProfil().setText("Mon profil");
						AccueilController.vAccueil.getItemConnexion().setText("DÈconnexion");
						AccueilController.vAccueil.getItemMonProfil().setEnabled(true);
						AccueilController.vAccueil.getItemLogin().setText(AppController.getActiveUser().getLogin());
						AccueilController.vAccueil.getGrpProduits().setVisible(true);
						if (AppController.getActiveUser().getAdministrator()) {
							AccueilController.vAccueil.getBtnProducts().setVisible(true);
							AccueilController.vAccueil.getBtnCollaborators().setVisible(true);
							AccueilController.vAccueil.getGrpCollaborateurs().setVisible(true);
						}
						else {
							AccueilController.vAccueil.getBtnProducts().setVisible(false);
							AccueilController.vAccueil.getBtnCollaborators().setVisible(false);
							AccueilController.vAccueil.getGrpCollaborateurs().setVisible(false);
							AccueilController.vAccueil.getGrpCollaborateurs().setText("DÈtail du produit");
							AccueilController.vAccueil.getTableMesProjets().setVisible(true);
						}

						// identification incorrecte
					} else {
						if (login == "" || password == "") {
							vLogin.getLblmsgerreur().setText("Veuillez remplir tous les champs");
							}
						else if(login != "" && password != "") {
							vLogin.getLblmsgerreur().setText("Identifiant incorrecte");
						}
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
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