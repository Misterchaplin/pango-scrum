package net.vues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAccueil {

	protected Shell accueil;
	private MenuItem itemConnexion;
	private MenuItem itemProduits;
	private MenuItem itemCollaborateurs;
	private MenuItem itemMonProfil;
	private Label lblInformation;

	public MenuItem getMntmConnexion() {
		return itemConnexion;
	}

	public Shell getAccueil() {
		return accueil;
	}

	public MenuItem getItemConnexion() {
		return itemConnexion;
	}

	public MenuItem getItemCollaborateurs() {
		return itemCollaborateurs;
	}

	public MenuItem getItemProduits() {
		return itemProduits;
	}

	public MenuItem getItemMonProfil() {
		return itemMonProfil;
	}

	public Label getLblInformation() {
		return lblInformation;
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

		Menu menu = new Menu(accueil, SWT.BAR);
		accueil.setMenuBar(menu);

		itemProduits = new MenuItem(menu, SWT.NONE);
		itemProduits.setEnabled(false);

		itemCollaborateurs = new MenuItem(menu, SWT.NONE);
		itemCollaborateurs.setEnabled(false);

		MenuItem menuItem = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_1 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_2 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_5 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_6 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_7 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_8 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_9 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_10 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_11 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_12 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_13 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_14 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_15 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_16 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_17 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_18 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_19 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_20 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_21 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_22 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_23 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_24 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_25 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_26 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_27 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_28 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_29 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_30 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_31 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_32 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_33 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_34 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_35 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_36 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_37 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_38 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_39 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_40 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_41 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_44 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_48 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_4 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_51 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_52 = new MenuItem(menu, SWT.SEPARATOR);

		MenuItem menuItem_53 = new MenuItem(menu, SWT.SEPARATOR);

		itemMonProfil = new MenuItem(menu, SWT.NONE);
		itemMonProfil.setEnabled(false);

		itemConnexion = new MenuItem(menu, SWT.NONE);
		itemConnexion.setImage(SWTResourceManager.getImage(VAccueil.class, "/net/images/connexion.PNG"));
		itemConnexion.setText("Connexion");

		Group grpNotification = new Group(accueil, SWT.NONE);
		grpNotification.setText("Information");
		FormData fd_grpNotification = new FormData();
		fd_grpNotification.top = new FormAttachment(0);
		fd_grpNotification.left = new FormAttachment(0);
		fd_grpNotification.bottom = new FormAttachment(0, 60);
		fd_grpNotification.right = new FormAttachment(0, 1008);
		grpNotification.setLayoutData(fd_grpNotification);

		lblInformation = new Label(grpNotification, SWT.NONE);
		lblInformation.setBounds(10, 25, 988, 25);
	}
}
