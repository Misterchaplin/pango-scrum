package net.controller;

import net.models.Collaborator;
import net.technics.HibernateUtil;
import net.vues.Accueil;
import net.vues.VLogin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;
import org.hibernate.Session;

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
		Session session = HibernateUtil.getSession();
		org.hibernate.Query query = session.createQuery("From Collaborator WHERE login = '" + login + "'");
		Collaborator activeUser = (Collaborator) query.uniqueResult();

		if (activeUser != null && activeUser.getPassword().equals(password)) {
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

				if (LoginController.verify(login, password)) {

					if (AppController.getActiveUser().getAdministrator() == true) {
						vLogin.getShlLogin().close();
						Accueil accueil = new Accueil();
						accueil.open();
					}

				} else {
					if (login == "" || password == "") {
						if (login == "") {
							MessageBox mb = new MessageBox(vLogin.getShlLogin(), SWT.OK | SWT.ICON_WARNING);
							mb.setMessage("Veuillez remplir le Login");
							mb.open();
						} else if (password == "") {
							MessageBox mb = new MessageBox(vLogin.getShlLogin(), SWT.OK | SWT.ICON_WARNING);
							mb.setMessage("Veuillez remplir le mot de passe");
							mb.open();
						}
					} else if (login != "" && password != "") {
						MessageBox mb = new MessageBox(vLogin.getShlLogin(), SWT.OK | SWT.ICON_WARNING);
						mb.setMessage("Identifiant incorrecte");
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
		vLogin.getBtnAnnuler().addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent arg0) {
				vLogin.getShlLogin().close();
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
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