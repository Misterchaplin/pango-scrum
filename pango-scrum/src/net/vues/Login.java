package net.vues;

import net.controller.AppController;
import net.controller.LoginController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;

public class Login {

	protected Shell shlLogin;
	private Text text_login;
	private Text text_mdp;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
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
		shlLogin.setImage(null);
		shlLogin.setSize(450, 300);
		shlLogin.setText("Pango-Scrum");
		shlLogin.setLayout(null);

		Group grpAuthentification = new Group(shlLogin, SWT.NONE);
		grpAuthentification.setText("Authentification");
		grpAuthentification.setBounds(26, 30, 336, 200);

		CLabel lblpassword = new CLabel(grpAuthentification, SWT.NONE);
		lblpassword.setBounds(42, 93, 76, 26);
		lblpassword.setText("Password");

		CLabel lbllogin = new CLabel(grpAuthentification, SWT.NONE);
		lbllogin.setBounds(42, 42, 76, 26);
		lbllogin.setText("Login");

		text_login = new Text(grpAuthentification, SWT.BORDER);
		text_login.setBounds(169, 42, 135, 26);

		text_mdp = new Text(grpAuthentification, SWT.BORDER | SWT.PASSWORD);
		text_mdp.setBounds(169, 93, 135, 26);

		/* Bouton Valider */
		Button btnValider = new Button(grpAuthentification, SWT.NONE);
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String login = text_login.getText();
				String password = text_mdp.getText();

				if (LoginController.verify(login, password)) {
					if(AppController.getActiveUser().getAdministrator()== true){
						shlLogin.close();
						AccueilAdmin aclAdmin = new AccueilAdmin();
						aclAdmin.open();
					}else {
						shlLogin.close();
						Accueil acl = new Accueil();
						acl.open();
					}
					
				} else {
					if (login == "" || password == "") {
						if (login == "") {
							MessageBox mb = new MessageBox(shlLogin, SWT.OK| SWT.ICON_WARNING);
							mb.setMessage("Veuillez remplir le Login");
							mb.open();
						} else if (password == "") {
							MessageBox mb = new MessageBox(shlLogin, SWT.OK| SWT.ICON_WARNING);
							mb.setMessage("Veuillez remplir le mot de passe");
							mb.open();
						}
					} else if (login != "" && password != "") {
						MessageBox mb = new MessageBox(shlLogin, SWT.OK| SWT.ICON_WARNING);
						mb.setMessage("Identifiant incorrecte");
						mb.open();
					}
				}
			}
		});

		btnValider.setBounds(140, 160, 90, 30);
		btnValider.setText("Valider");

		/* Bouton Annuler */
		Button btnannuler = new Button(grpAuthentification, SWT.NONE);
		btnannuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlLogin.close();
			}
		});

		btnannuler.setBounds(236, 160, 90, 30);
		btnannuler.setText("Annuler");

		/* Bouton Admin */
		Button btnAdmin = new Button(grpAuthentification, SWT.NONE);
		btnAdmin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_login.setText("admin");
				text_mdp.setText("admin");
			}
		});

		btnAdmin.setBounds(28, 160, 90, 30);
		btnAdmin.setText("Admin");
	}
}
