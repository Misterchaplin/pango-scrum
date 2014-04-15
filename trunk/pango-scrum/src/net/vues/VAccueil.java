package net.vues;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAccueil {

	protected Shell accueil;
	private Label lblInformation;
	private ToolItem itemConnexion;
	private ToolItem itemMonProfil;
	private ToolItem itemLogin;
	private Label lblNomApplication;
	private Label lblDescriptionApplication;
	private Group grpCollaborateurs;
	private Button btnCollaborators;
	private Button btnProducts;
	private Group grpProduits;
	private Table tableMesProjets;
	private TableViewer tvMesProjets;

	public Shell getAccueil() {
		return accueil;
	}

	public ToolItem getItemConnexion() {
		return itemConnexion;
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

	public Button getBtnCollaborators() {
		return btnCollaborators;
	}

	public Button getBtnProducts() {
		return btnProducts;
	}

	public Group getGrpCollaborateurs() {
		return grpCollaborateurs;
	}

	public Group getGrpProduits() {
		return grpProduits;
	}

	public Table getTableMesProjets() {
		return tableMesProjets;
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
		fd_grpNotification.left = new FormAttachment(0, 10);
		fd_grpNotification.right = new FormAttachment(100, -10);
		fd_grpNotification.bottom = new FormAttachment(100, -496);
		grpNotification.setLayoutData(fd_grpNotification);

		lblInformation = new Label(grpNotification, SWT.NONE);
		lblInformation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblInformation.setBounds(10, 32, 988, 28);
		lblInformation.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));

		ToolBar menuConnexion = new ToolBar(accueil, SWT.FLAT | SWT.RIGHT);
		menuConnexion.setBackground(SWTResourceManager.getColor(255, 255, 240));
		FormData fd_menuConnexion = new FormData();
		fd_menuConnexion.top = new FormAttachment(0, 40);
		menuConnexion.setLayoutData(fd_menuConnexion);

		itemLogin = new ToolItem(menuConnexion, SWT.NONE);
		itemLogin.setEnabled(false);

		itemMonProfil = new ToolItem(menuConnexion, SWT.NONE);
		itemMonProfil.setEnabled(false);

		itemConnexion = new ToolItem(menuConnexion, SWT.NONE);
		itemConnexion.setText("Connexion");

		lblNomApplication = new Label(accueil, SWT.NONE);
		fd_menuConnexion.right = new FormAttachment(lblNomApplication, 209, SWT.RIGHT);
		lblNomApplication.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblNomApplication.setBackground(SWTResourceManager.getColor(255, 255, 240));
		FormData fd_lblNomApplication = new FormData();
		fd_lblNomApplication.right = new FormAttachment(100, -209);
		fd_lblNomApplication.left = new FormAttachment(0, 64);
		fd_lblNomApplication.top = new FormAttachment(0);
		lblNomApplication.setLayoutData(fd_lblNomApplication);
		lblNomApplication.setText("Scrum Tool");

		lblDescriptionApplication = new Label(accueil, SWT.NONE);
		fd_menuConnexion.left = new FormAttachment(lblDescriptionApplication, 6);
		fd_lblNomApplication.bottom = new FormAttachment(lblDescriptionApplication, -7);
		lblDescriptionApplication.setBackground(SWTResourceManager.getColor(255, 255, 240));
		FormData fd_lblDescriptionApplication = new FormData();
		fd_lblDescriptionApplication.top = new FormAttachment(0, 30);
		fd_lblDescriptionApplication.left = new FormAttachment(0, 64);
		fd_lblDescriptionApplication.right = new FormAttachment(100, -209);
		lblDescriptionApplication.setLayoutData(fd_lblDescriptionApplication);
		lblDescriptionApplication.setText("Outil de gestion de projets SCRUM");

		Label label = new Label(accueil, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_grpNotification.top = new FormAttachment(label, 34);
		fd_lblDescriptionApplication.bottom = new FormAttachment(label, -6);
		fd_menuConnexion.bottom = new FormAttachment(label, -6);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(100, -591);
		fd_label.top = new FormAttachment(0, 69);
		fd_label.right = new FormAttachment(100, -10);
		fd_label.left = new FormAttachment(0);
		label.setLayoutData(fd_label);

		grpProduits = new Group(accueil, SWT.BORDER | SWT.SHADOW_OUT);
		grpProduits.setText("Produits");
		FormData fd_grpProduits = new FormData();
		fd_grpProduits.bottom = new FormAttachment(100, -95);
		fd_grpProduits.top = new FormAttachment(grpNotification, 22);
		fd_grpProduits.left = new FormAttachment(0, 10);
		fd_grpProduits.right = new FormAttachment(0, 475);
		grpProduits.setLayoutData(fd_grpProduits);

		Label lblLogo = new Label(accueil, SWT.NONE);
		lblLogo.setLayoutData(new FormData());
		lblLogo.setImage(SWTResourceManager.getImage(VAccueil.class, "/net/images/logo.PNG"));

		grpCollaborateurs = new Group(accueil, SWT.BORDER | SWT.SHADOW_OUT);
		grpCollaborateurs.setText("Collaborateurs");
		FormData fd_grpCollaborateurs = new FormData();
		fd_grpCollaborateurs.bottom = new FormAttachment(100, -95);
		fd_grpCollaborateurs.top = new FormAttachment(grpNotification, 22);

		grpProduits.setVisible(false);
		grpCollaborateurs.setVisible(false);

		btnProducts = new Button(grpProduits, SWT.NONE);
		btnProducts.setImage(SWTResourceManager.getImage(VAccueil.class, "/net/images/product.PNG"));
		btnProducts.setBounds(10, 315, 200, 53);
		btnProducts.setText("Gestion des produits");

		tvMesProjets = new TableViewer(grpProduits, SWT.BORDER | SWT.FULL_SELECTION);
		tableMesProjets = tvMesProjets.getTable();
		tableMesProjets.setBounds(10, 29, 435, 339);
		tableMesProjets.setVisible(false);

		fd_grpCollaborateurs.left = new FormAttachment(100, -512);
		fd_grpCollaborateurs.right = new FormAttachment(100, -10);
		grpCollaborateurs.setLayoutData(fd_grpCollaborateurs);

		btnCollaborators = new Button(grpCollaborateurs, SWT.NONE);
		btnCollaborators.setImage(SWTResourceManager.getImage(VAccueil.class, "/net/images/user.PNG"));
		btnCollaborators.setBounds(10, 317, 193, 54);
		btnCollaborators.setText("Gestion des collaborateurs");

	}
}
