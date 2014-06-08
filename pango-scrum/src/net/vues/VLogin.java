package net.vues;

import net.controller.AccueilController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

public class VLogin {

	protected Shell shlLogin;
	private Text txtVotreLogin;
	private Text text_mdp;
	private Button btnValider;
	private Button btnAnnuler;
	private Label lblmsgerreur;

	public Shell getShlLogin() {
		return shlLogin;
	}

	public Text getText_login() {
		return txtVotreLogin;
	}
	

	public Label getLblmsgerreur() {
		return lblmsgerreur;
	}

	public Text getText_mdp() {
		return text_mdp;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}
	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void init() {
		createContents();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		AccueilController.nbOpenedWindowConnection = 0;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setBackground(SWTResourceManager.getColor(255, 255, 240));
		shlLogin.setImage(SWTResourceManager.getImage(VLogin.class, "/net/images/connexion.PNG"));
		shlLogin.setSize(413, 268);
		shlLogin.setText("Scrum Tool");
		shlLogin.setLayout(null);

		Group grpAuthentification = new Group(shlLogin, SWT.NONE);
		grpAuthentification.setText("Veuillez vous authentifier avant de poursuivre : ");
		grpAuthentification.setBounds(10, 52, 378, 171);
		grpAuthentification.setBackground(SWTResourceManager.getColor(255, 255, 240));

		CLabel lblpassword = new CLabel(grpAuthentification, SWT.NONE);
		lblpassword.setBounds(63, 67, 70, 26);
		lblpassword.setText("Password* : ");
		lblpassword.setBackground(SWTResourceManager.getColor(255, 255, 240));

		CLabel lbllogin = new CLabel(grpAuthentification, SWT.NONE);
		lbllogin.setBounds(63, 35, 48, 26);
		lbllogin.setText("Login* :");
		lbllogin.setBackground(SWTResourceManager.getColor(255, 255, 240));

		txtVotreLogin = new Text(grpAuthentification, SWT.BORDER);
		txtVotreLogin.setToolTipText("");
		txtVotreLogin.setBounds(145, 35, 140, 23);

		text_mdp = new Text(grpAuthentification, SWT.BORDER | SWT.PASSWORD);
		text_mdp.setBounds(145, 67, 140, 23);

		/* Bouton Valider */
		btnValider = new Button(grpAuthentification, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VLogin.class, "/net/images/accept.png"));
		btnValider.setBounds(117, 131, 90, 30);
		btnValider.setText("Valider");

		/* Bouton Annuler */
		btnAnnuler = new Button(grpAuthentification, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VLogin.class, "/net/images/cancel.png"));
		btnAnnuler.setBounds(219, 131, 90, 30);
		btnAnnuler.setText("Annuler");
		
		Group grpMessageDerreur = new Group(shlLogin, SWT.NONE);
		grpMessageDerreur.setText("Message d'erreur");
		grpMessageDerreur.setBounds(10, 0, 378, 46);
		grpMessageDerreur.setBackground(SWTResourceManager.getColor(255, 255, 240));
		
		lblmsgerreur = new Label(grpMessageDerreur, SWT.NONE);
		lblmsgerreur.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblmsgerreur.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblmsgerreur.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblmsgerreur.setBounds(10, 21, 358, 18);
	}
}
