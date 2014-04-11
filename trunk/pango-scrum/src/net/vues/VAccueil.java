package net.vues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAccueil {

	protected Shell accueil;
	private Label lblInformation;
	private ToolItem itemConnexion;
	private ToolItem itemProduits;
	private ToolItem itemCollaborateurs;
	private ToolItem itemMonProfil;
	private ToolItem itemLogin;
	private Label lblNomApplication;
	private Label lblDescriptionApplication;

	public ToolItem getItemConnexion() {
		return itemConnexion;
	}

	public ToolItem getItemProduits() {
		return itemProduits;
	}

	public ToolItem getItemCollaborateurs() {
		return itemCollaborateurs;
	}

	public ToolItem getItemMonProfil() {
		return itemMonProfil;
	}

	public Label getLblInformation() {
		return lblInformation;
	}

	public ToolItem getItemLogin() {
		return itemLogin;
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
		accueil.open();
		accueil.layout();
		while (!accueil.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		accueil = new Shell();
		accueil.setImage(SWTResourceManager.getImage(VAccueil.class, "/net/images/logo.PNG"));
		accueil.setSize(1024, 700);
		accueil.setText("Scrum Tool");
		accueil.setLayout(new FormLayout());
		accueil.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Group grpNotification = new Group(accueil, SWT.BORDER | SWT.SHADOW_OUT);
		grpNotification.setText("Information");
		FormData fd_grpNotification = new FormData();
		fd_grpNotification.bottom = new FormAttachment(100, -496);
		fd_grpNotification.left = new FormAttachment(0);
		fd_grpNotification.right = new FormAttachment(100);
		grpNotification.setLayoutData(fd_grpNotification);

		lblInformation = new Label(grpNotification, SWT.NONE);
		lblInformation.setBounds(10, 25, 988, 25);

		ToolBar menuConnexion = new ToolBar(accueil, SWT.FLAT | SWT.RIGHT);
		menuConnexion.setBackground(SWTResourceManager.getColor(255, 255, 240));
		FormData fd_menuConnexion = new FormData();
		fd_menuConnexion.top = new FormAttachment(0, 40);
		menuConnexion.setLayoutData(fd_menuConnexion);

		itemLogin = new ToolItem(menuConnexion, SWT.NONE);
		itemLogin.setEnabled(false);

		itemMonProfil = new ToolItem(menuConnexion, SWT.NONE);
		itemMonProfil.setEnabled(false);

		ToolBar menu = new ToolBar(accueil, SWT.FLAT | SWT.RIGHT);
		fd_grpNotification.top = new FormAttachment(0, 121);

		itemConnexion = new ToolItem(menuConnexion, SWT.NONE);
		itemConnexion.setText("Connexion");
		FormData fd_menu = new FormData();
		fd_menu.bottom = new FormAttachment(grpNotification, -6);
		fd_menu.left = new FormAttachment(grpNotification, 0, SWT.LEFT);
		fd_menu.right = new FormAttachment(100);
		menu.setLayoutData(fd_menu);

		itemProduits = new ToolItem(menu, SWT.NONE);
		itemProduits.setEnabled(false);
		itemProduits.setText("Produits");

		itemCollaborateurs = new ToolItem(menu, SWT.NONE);
		itemCollaborateurs.setEnabled(false);
		itemCollaborateurs.setText("Collaborateurs");

		Label lblLogo = new Label(accueil, SWT.NONE);
		fd_menuConnexion.bottom = new FormAttachment(lblLogo, 0, SWT.BOTTOM);
		lblLogo.setImage(SWTResourceManager.getImage(VAccueil.class, "/net/images/logo.PNG"));
		FormData fd_lblLogo = new FormData();
		fd_lblLogo.bottom = new FormAttachment(menu, -29);
		fd_lblLogo.top = new FormAttachment(0);
		fd_lblLogo.left = new FormAttachment(0);
		fd_lblLogo.right = new FormAttachment(0, 58);
		lblLogo.setLayoutData(fd_lblLogo);

		lblNomApplication = new Label(accueil, SWT.NONE);
		fd_menuConnexion.right = new FormAttachment(lblNomApplication, 209, SWT.RIGHT);
		lblNomApplication.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblNomApplication.setBackground(SWTResourceManager.getColor(255, 255, 240));
		FormData fd_lblNomApplication = new FormData();
		fd_lblNomApplication.left = new FormAttachment(lblLogo, 6);
		fd_lblNomApplication.right = new FormAttachment(100, -209);
		fd_lblNomApplication.top = new FormAttachment(0);
		lblNomApplication.setLayoutData(fd_lblNomApplication);
		lblNomApplication.setText("Scrum Tool");

		lblDescriptionApplication = new Label(accueil, SWT.NONE);
		fd_menuConnexion.left = new FormAttachment(lblDescriptionApplication, 6);
		fd_lblNomApplication.bottom = new FormAttachment(lblDescriptionApplication, -7);
		lblDescriptionApplication.setBackground(SWTResourceManager.getColor(255, 255, 240));
		FormData fd_lblDescriptionApplication = new FormData();
		fd_lblDescriptionApplication.left = new FormAttachment(lblLogo, 6);
		fd_lblDescriptionApplication.right = new FormAttachment(100, -209);
		fd_lblDescriptionApplication.bottom = new FormAttachment(menu, -29);
		fd_lblDescriptionApplication.top = new FormAttachment(0, 30);
		lblDescriptionApplication.setLayoutData(fd_lblDescriptionApplication);
		lblDescriptionApplication.setText("Outil de gestion de projets SCRUM");

		Label label = new Label(accueil, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(menu, -21);
		fd_label.top = new FormAttachment(menuConnexion, 6);
		fd_label.right = new FormAttachment(grpNotification, 998);
		fd_label.left = new FormAttachment(grpNotification, 0, SWT.LEFT);
		label.setLayoutData(fd_label);

	}
}
