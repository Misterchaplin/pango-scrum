package net.vues;

import net.controller.AccueilController;
import net.controller.AppController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VMyProfile {

	protected Shell vMyProfile;
	private Text txtNom;
	private Text txtEmail;
	private Button btnValider;
	private Button btnAnnuler;
	private Link linkChangeMdp;
	private Label lblPrenom;
	private Text txtPrenom;

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
		AccueilController.nbOpenedWindowMyProfile = 0;
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
		vMyProfile.setImage(SWTResourceManager.getImage(VMyProfile.class, "/net/images/logo.PNG"));
		vMyProfile.setSize(596, 244);
		vMyProfile.setBackground(SWTResourceManager.getColor(255, 255, 240));
		vMyProfile.setText("Scrum Tool");

		Group grpProfil = new Group(vMyProfile, SWT.NONE);
		grpProfil.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpProfil.setText("Mon profil");
		grpProfil.setBackground(SWTResourceManager.getColor(255, 255, 240));
		grpProfil.setBounds(11, 10, 562, 188);

		Label lblNom = new Label(grpProfil, SWT.NONE);
		lblNom.setLocation(10, 48);
		lblNom.setSize(40, 15);
		lblNom.setText("Nom :");

		Label lblEMail = new Label(grpProfil, SWT.NONE);
		lblEMail.setLocation(10, 72);
		lblEMail.setSize(40, 15);
		lblEMail.setText("Email :");

		txtNom = new Text(grpProfil, SWT.BORDER);
		txtNom.setText(AppController.getActiveUser().getLastname());
		txtNom.setLocation(54, 45);
		txtNom.setSize(146, 21);

		txtPrenom = new Text(grpProfil, SWT.BORDER);
		txtPrenom.setText(AppController.getActiveUser().getFirstname());
		txtPrenom.setBounds(356, 45, 166, 21);

		txtEmail = new Text(grpProfil, SWT.BORDER);
		txtEmail.setText(AppController.getActiveUser().getEmail());
		txtEmail.setLocation(54, 69);
		txtEmail.setSize(299, 21);

		btnValider = new Button(grpProfil, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VMyProfile.class, "/net/images/accept.png"));
		btnValider.setLocation(359, 144);
		btnValider.setSize(96, 36);
		btnValider.setText("Valider");

		btnAnnuler = new Button(grpProfil, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VMyProfile.class, "/net/images/cancel.png"));
		btnAnnuler.setLocation(461, 144);
		btnAnnuler.setSize(90, 36);
		btnAnnuler.setText("Annuler");

		linkChangeMdp = new Link(grpProfil, SWT.NONE);
		linkChangeMdp.setLocation(54, 96);
		linkChangeMdp.setSize(145, 15);
		linkChangeMdp.setText("<a>Changer le mot de passe</a>");

		lblPrenom = new Label(grpProfil, SWT.NONE);
		lblPrenom.setBounds(298, 48, 55, 15);
		lblPrenom.setText("Prénom :");

		Label label = new Label(grpProfil, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 136, 542, 2);

	}

	public Text getTxtPrenom() {
		return txtPrenom;
	}
}
