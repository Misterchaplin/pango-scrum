package net.vues;

import net.controller.AppController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class VMyProfile {

	protected Shell vMyProfile;
	private Text txtNom;
	private Text txtEmail;
	private Button btnValider;
	private Button btnAnnuler;
	private Link linkChangeMdp;

	public Shell getvMyProfile() {
		return vMyProfile;
	}

	public Text getTxtNom() {
		return txtNom;
	}

	public Text getTxtEmail() {
		return txtEmail;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}

	public Link getLinkChangeMdp() {
		return linkChangeMdp;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VMyProfile window = new VMyProfile();
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
		vMyProfile.open();
		vMyProfile.layout();
		while (!vMyProfile.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
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
	 * Create contents of the window.
	 */
	protected void createContents() {
		vMyProfile = new Shell();
		vMyProfile.setSize(397, 271);
		vMyProfile.setText("SWT Application");

		Group grpProfil = new Group(vMyProfile, SWT.NONE);
		grpProfil.setText("Mon profil");
		grpProfil.setBounds(11, 10, 360, 213);

		Label lblNom = new Label(grpProfil, SWT.NONE);
		lblNom.setLocation(10, 48);
		lblNom.setSize(55, 15);
		lblNom.setText("Nom :");

		Label lblEMail = new Label(grpProfil, SWT.NONE);
		lblEMail.setLocation(10, 90);
		lblEMail.setSize(55, 15);
		lblEMail.setText("Email :");

		txtNom = new Text(grpProfil, SWT.BORDER);
		txtNom.setText(AppController.getActiveUser().getLastname() + " " + AppController.getActiveUser().getFirstname());
		txtNom.setLocation(85, 44);
		txtNom.setSize(232, 21);

		txtEmail = new Text(grpProfil, SWT.BORDER);
		txtEmail.setText(AppController.getActiveUser().getEmail());
		txtEmail.setLocation(86, 86);
		txtEmail.setSize(232, 21);

		btnValider = new Button(grpProfil, SWT.NONE);
		btnValider.setLocation(83, 167);
		btnValider.setSize(75, 25);
		btnValider.setText("Valider");

		btnAnnuler = new Button(grpProfil, SWT.NONE);
		btnAnnuler.setLocation(165, 167);
		btnAnnuler.setSize(75, 25);
		btnAnnuler.setText("Annuler");

		linkChangeMdp = new Link(grpProfil, SWT.NONE);
		linkChangeMdp.setLocation(86, 130);
		linkChangeMdp.setSize(145, 15);
		linkChangeMdp.setText("<a>Changer le mot de passe</a>");

	}
}
