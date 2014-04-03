package net.controller;

import net.vues.VAccueil;
import net.vues.VListCollaborators;
import net.vues.VLogin;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class AccueilController implements SelectionListener {
	private VAccueil vAccueil;

	public AccueilController(VAccueil vAccueil) {
		this.vAccueil = vAccueil;
	}

	public void init() {
		vAccueil.getItemCollaborateurs().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VListCollaborators vListCollaborators = new VListCollaborators();
				CollaboratorController collaboratorController = new CollaboratorController(vListCollaborators);
				vListCollaborators.init();
				collaboratorController.init();
				vListCollaborators.open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		vAccueil.getItemConnexion().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VLogin vLogin = new VLogin();
				LoginController loginController = new LoginController(vLogin);
				vLogin.init();
				loginController.init();
				vLogin.open();
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
