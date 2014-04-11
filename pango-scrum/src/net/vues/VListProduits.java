package net.vues;

import net.controller.AccueilController;
import net.controller.AppController;
import net.technics.DAOProduct;
import net.technics.ProductTvProvider;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VListProduits {

	protected Shell VListProduits;
	private Composite composite;
	private Table tableProduits;
	private TableViewer tableViewerProduits;
	private TableColumnLayout tLayout;
	private SashForm sashForm;
	private Composite compositeTable;
	private Text txtNomProduit;
	private Text txtDescriptif;
	private Button btnSupprimerProduits;
	private Button btnAjouterProduits;
	private Button btnValider;
	private Button btnAnnuler;
	private Button btndetail;
	private Group grpProduits;
	private Label lblInformation;

	public TableViewer getTableViewerProduits() {
		return tableViewerProduits;
	}

	public Shell getListProduits() {
		return VListProduits;
	}

	public Text gettxtNomProduit() {
		return txtNomProduit;
	}

	public Text getTxtDescriptif() {
		return txtDescriptif;
	}

	public Button getBtnSupprimerProduits() {
		return btnSupprimerProduits;
	}

	public Button getBtndetail() {
		return btndetail;
	}

	public Button getBtnAjouterProduits() {
		return btnAjouterProduits;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}

	public Table getTableProduits() {
		return tableProduits;
	}

	public Group getGrpProduits() {
		return grpProduits;
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
		VListProduits.open();
		VListProduits.layout();
		while (!VListProduits.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		AccueilController.nbOpenedWindowProduit = 0;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		VListProduits = new Shell();
		VListProduits.setSize(1024, 706);
		VListProduits.setText("Scrum tool");
		VListProduits.setBackground(SWTResourceManager.getColor(255, 255, 240));
		VListProduits.setLayout(null);

		grpProduits = new Group(VListProduits, SWT.BORDER | SWT.SHADOW_IN);
		grpProduits.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpProduits.setBounds(10, 375, 978, 169);
		grpProduits.setText("Produit");
		grpProduits.setVisible(true);

		compositeTable = new Composite(VListProduits, SWT.NONE);
		compositeTable.setBounds(0, 0, 1337, 305);

		sashForm = new SashForm(compositeTable, SWT.NONE);
		sashForm.setLocation(0, 0);
		sashForm.setSize(1005, 305);

		Group grpInformation = new Group(VListProduits, SWT.BORDER | SWT.SHADOW_IN);
		grpInformation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpInformation.setText("Information");
		grpInformation.setBounds(10, 615, 978, 43);
		grpInformation.setVisible(false);
		if (AppController.getActiveUser().getAdministrator()) {
			grpInformation.setVisible(true);
		}

		lblInformation = new Label(grpInformation, SWT.NONE);
		lblInformation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblInformation.setBounds(10, 20, 958, 15);

		btnSupprimerProduits = new Button(grpProduits, SWT.NONE);
		btnSupprimerProduits.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/delete.png"));
		btnSupprimerProduits.setBounds(509, 113, 194, 40);
		btnSupprimerProduits.setText("Supprimer ce produit");

		composite = new Composite(sashForm, SWT.NONE);
		tLayout = new TableColumnLayout();
		composite.setLayout(tLayout);

		tableViewerProduits = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableProduits = tableViewerProduits.getTable();
		tableProduits.setHeaderVisible(true);
		tableProduits.setLinesVisible(true);
		tableViewerProduits.setContentProvider(new ArrayContentProvider());
		tableViewerProduits.setLabelProvider(new ProductTvProvider());
		tableViewerProduits.setInput(DAOProduct.getProducts());

		createColumn(tableProduits, "Nom", 1);

		sashForm.setWeights(new int[] { 1 });

		if (AppController.getActiveUser().getAdministrator()) {
			btnAjouterProduits = new Button(VListProduits, SWT.NONE);
			btnAjouterProduits.setBounds(10, 311, 183, 45);
			btnAjouterProduits.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/produit.PNG"));
			btnAjouterProduits.setText("Ajouter un produit");
		}
		btndetail = new Button(VListProduits, SWT.NONE);
		btndetail.setBounds(250, 311, 183, 45);
		btndetail.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/produit.PNG"));
		btndetail.setText("detail");
		btndetail.setVisible(false);
		Label lblNom = new Label(grpProduits, SWT.NONE);
		lblNom.setBounds(29, 35, 39, 15);
		lblNom.setText("Nom :");

		Label lbdescriptif = new Label(grpProduits, SWT.NONE);
		lbdescriptif.setBounds(29, 69, 73, 15);
		lbdescriptif.setText("Description :");

		txtNomProduit = new Text(grpProduits, SWT.BORDER);
		txtNomProduit.setBounds(106, 32, 239, 21);

		txtDescriptif = new Text(grpProduits, SWT.BORDER);
		txtDescriptif.setBounds(108, 66, 238, 21);

		btnValider = new Button(grpProduits, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/accept.png"));
		btnValider.setBounds(730, 113, 109, 40);
		btnValider.setText("Valider");

		btnAnnuler = new Button(grpProduits, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/cancel.png"));
		btnAnnuler.setBounds(845, 113, 109, 40);
		btnAnnuler.setText("Annuler");

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
