package net.controller;

import net.models.Collaborator;
import net.vues.VLogin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;

public class LoginController implements SelectionListener {
	private VLogin vLogin;

	public LoginController(VLogin vLogin) {
		this.vLogin = vLogin;
	}

	/**
	 * Vérification de la cohérence login / mot de passe
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
		// bouton admin
		vLogin.getBtnAdmin().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vLogin.getText_login().setText("admin");
				vLogin.getText_mdp().setText("admin");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// bouton valider
		vLogin.getBtnValider().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String login = vLogin.getText_login().getText();
				String password = vLogin.getText_mdp().getText();

				// identification correcte
				if (LoginController.verify(login, password)) {
					// fermeture de la boîte de login
					vLogin.getShlLogin().close();
					AccueilController.vAccueil.getItemMonProfil().setText("Mon profil");
					AccueilController.vAccueil.getItemMonProfil().setEnabled(true);
					AccueilController.vAccueil.getItemLogin().setText(AppController.getActiveUser().getLogin());
					AccueilController.vAccueil.getItemProduits().setEnabled(true);
					AccueilController.vAccueil.getItemCollaborateurs().setEnabled(true);
					// identification incorrecte
				} else {
					if (login == "" || password == "") {
						if (login == "") {
							MessageBox mb = new MessageBox(vLogin.getShlLogin(), SWT.OK | SWT.ICON_WARNING);
							mb.setMessage("Veuillez remplir le login");
							mb.open();
						} else if (password == "") {
							MessageBox mb = new MessageBox(vLogin.getShlLogin(), SWT.OK | SWT.ICON_WARNING);
							mb.setMessage("Veuillez remplir le mot de passe");
							mb.open();
						}
					} else if (login != "" && password != "") {
						MessageBox mb = new MessageBox(vLogin.getShlLogin(), SWT.OK | SWT.ICON_WARNING);
						mb.setMessage("Identifiant incorrect");
						mb.open();
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