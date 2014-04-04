package net.vues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class VAccueil {

	protected Shell accueil;
	private MenuItem itemCollaborateurs;
	private MenuItem itemProduits;
	private MenuItem itemConnexion;
	private MenuItem itemOverview;

	public MenuItem getItemOverview() {
		return itemOverview;
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
		accueil.setSize(1353, 717);
		accueil.setText("Scrum tool");

		Menu menu = new Menu(accueil, SWT.BAR);
		menu.setLocation(new Point(0, 0));
		accueil.setMenuBar(menu);

		itemConnexion = new MenuItem(menu, SWT.NONE);
		itemConnexion.setText("Connexion");

		itemProduits = new MenuItem(menu, SWT.NONE);
		itemProduits.setText("Produits");

		itemCollaborateurs = new MenuItem(menu, SWT.NONE);
		itemCollaborateurs.setText("Collaborateurs");

		itemOverview = new MenuItem(menu, SWT.NONE);
		itemOverview.setText("Overview");

	}
}
