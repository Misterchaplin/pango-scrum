package net.vues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VLogin {

	protected Shell shlLogin;
	private Text text_login;
	private Text text_mdp;
	private Button btnValider;
	private Button btnAnnuler;
	private Button btnAdmin;

	public Shell getShlLogin() {
		return shlLogin;
	}

	public Text getText_login() {
		return text_login;
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

	public Button getBtnAdmin() {
		return btnAdmin;
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
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setBackground(SWTResourceManager.getColor(204, 255, 153));
		shlLogin.setImage(null);
		shlLogin.setSize(450, 300);
		shlLogin.setText("Scrum tool");
		shlLogin.setLayout(null);

		Group grpAuthentification = new Group(shlLogin, SWT.NONE);
		grpAuthentification.setText("Authentification");
		grpAuthentification.setBounds(26, 30, 336, 200);
		grpAuthentification.setBackground(SWTResourceManager.getColor(204, 255, 153));

		CLabel lblpassword = new CLabel(grpAuthentification, SWT.NONE);
		lblpassword.setBounds(42, 93, 76, 26);
		lblpassword.setText("Password");
		lblpassword.setBackground(SWTResourceManager.getColor(204, 255, 153));

		CLabel lbllogin = new CLabel(grpAuthentification, SWT.NONE);
		lbllogin.setBounds(42, 42, 76, 26);
		lbllogin.setText("Login");
		lbllogin.setBackground(SWTResourceManager.getColor(204, 255, 153));

		text_login = new Text(grpAuthentification, SWT.BORDER);
		text_login.setBounds(169, 42, 135, 26);

		text_mdp = new Text(grpAuthentification, SWT.BORDER | SWT.PASSWORD);
		text_mdp.setBounds(169, 93, 135, 26);

		/* Bouton Valider */
		btnValider = new Button(grpAuthentification, SWT.NONE);
		btnValider.setBounds(140, 160, 90, 30);
		btnValider.setText("Valider");

		/* Bouton Annuler */
		btnAnnuler = new Button(grpAuthentification, SWT.NONE);
		btnAnnuler.setBounds(236, 160, 90, 30);
		btnAnnuler.setText("Annuler");

		/* Bouton Admin */
		btnAdmin = new Button(grpAuthentification, SWT.NONE);
		btnAdmin.setBounds(28, 160, 90, 30);
		btnAdmin.setText("Admin");
	}
}
