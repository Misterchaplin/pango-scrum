package net.vues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Canvas;
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
		accueil.setSize(1024, 700);
		accueil.setText("Scrum tool");
		accueil.setLayout(new FormLayout());
		accueil.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Group grpNotification = new Group(accueil, SWT.BORDER | SWT.SHADOW_OUT);
		grpNotification.setText("Information");
		FormData fd_grpNotification = new FormData();
		fd_grpNotification.bottom = new FormAttachment(100, -549);
		fd_grpNotification.left = new FormAttachment(0);
		fd_grpNotification.right = new FormAttachment(100);
		grpNotification.setLayoutData(fd_grpNotification);

		lblInformation = new Label(grpNotification, SWT.NONE);
		lblInformation.setBounds(10, 25, 988, 25);

		ToolBar menuConnexion = new ToolBar(accueil, SWT.FLAT | SWT.RIGHT);
		FormData fd_menuConnexion = new FormData();
		fd_menuConnexion.right = new FormAttachment(100);
		fd_menuConnexion.top = new FormAttachment(0);
		menuConnexion.setLayoutData(fd_menuConnexion);

		itemLogin = new ToolItem(menuConnexion, SWT.NONE);
		itemLogin.setEnabled(false);

		itemMonProfil = new ToolItem(menuConnexion, SWT.NONE);
		itemMonProfil.setEnabled(false);

		Canvas canvas = new Canvas(accueil, SWT.NONE);
		fd_menuConnexion.left = new FormAttachment(0, 805);
		FormData fd_canvas = new FormData();
		fd_canvas.right = new FormAttachment(100, -209);
		fd_canvas.left = new FormAttachment(0);
		fd_canvas.bottom = new FormAttachment(0, 39);
		fd_canvas.top = new FormAttachment(0);
		canvas.setLayoutData(fd_canvas);

		ToolBar menu = new ToolBar(accueil, SWT.FLAT | SWT.RIGHT);
		fd_menuConnexion.bottom = new FormAttachment(menu);

		itemConnexion = new ToolItem(menuConnexion, SWT.NONE);
		itemConnexion.setText("Connexion");
		fd_grpNotification.top = new FormAttachment(menu, 6);
		FormData fd_menu = new FormData();
		fd_menu.top = new FormAttachment(0, 39);
		fd_menu.left = new FormAttachment(0);
		fd_menu.right = new FormAttachment(100);
		menu.setLayoutData(fd_menu);

		itemProduits = new ToolItem(menu, SWT.NONE);
		itemProduits.setEnabled(false);
		itemProduits.setText("Produits");

		itemCollaborateurs = new ToolItem(menu, SWT.NONE);
		itemCollaborateurs.setEnabled(false);
		itemCollaborateurs.setText("Collaborateurs");
	}

}
