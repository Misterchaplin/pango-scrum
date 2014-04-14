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
	private Button btnSupprimerProduits;
	private Button btnAjouterProduits;
	private Button btnValider;
	private Button btnAnnuler;
	private Button btnOverview;
	private Group grpProduits;
	private Label lblInformation;
	private Button btnAffectationCollaborators;
	private Button btnSprints;
	private Text txtDescriptif;
	private Group grpActions;

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

	public Button getBtnOverview() {
		return btnOverview;
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

	public Button getBtnAffectationCollaborators() {
		return btnAffectationCollaborators;
	}

	public Group getGrpActions() {
		return grpActions;
	}

	public Button getBtnSprints() {
		return btnSprints;
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
		VListProduits.setImage(SWTResourceManager.getImage(VListProduits.class, "/net/images/product.PNG"));
		VListProduits.setSize(1024, 706);
		VListProduits.setText("Scrum Tool - Gestion des produits");
		VListProduits.setBackground(SWTResourceManager.getColor(255, 255, 240));
		VListProduits.setLayout(null);

		grpProduits = new Group(VListProduits, SWT.BORDER | SWT.SHADOW_IN);
		grpProduits.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpProduits.setBounds(10, 374, 763, 211);
		grpProduits.setText("Produit");
		grpProduits.setVisible(false);

		compositeTable = new Composite(VListProduits, SWT.NONE);
		compositeTable.setBounds(0, 0, 1337, 317);

		sashForm = new SashForm(compositeTable, SWT.NONE);
		sashForm.setLocation(0, 0);
		sashForm.setSize(1005, 317);

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

		btnAjouterProduits = new Button(VListProduits, SWT.NONE);
		btnAjouterProduits.setImage(SWTResourceManager.getImage(VListProduits.class, "/net/images/addProduct.PNG"));
		btnAjouterProduits.setBounds(10, 323, 183, 45);
		btnAjouterProduits.setText("Ajouter un produit");
		if (AppController.getActiveUser().getAdministrator()) {

		}
		Label lblNom = new Label(grpProduits, SWT.NONE);
		lblNom.setBounds(29, 35, 39, 15);
		lblNom.setText("Nom :");

		Label lbdescriptif = new Label(grpProduits, SWT.NONE);
		lbdescriptif.setBounds(29, 69, 73, 15);
		lbdescriptif.setText("Description :");

		txtNomProduit = new Text(grpProduits, SWT.BORDER);
		txtNomProduit.setBounds(106, 32, 241, 21);

		btnValider = new Button(grpProduits, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/accept.png"));
		btnValider.setBounds(529, 158, 109, 40);
		btnValider.setText("Valider");

		btnAnnuler = new Button(grpProduits, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/cancel.png"));
		btnAnnuler.setBounds(644, 158, 109, 40);
		btnAnnuler.setText("Annuler");

		Label label_1 = new Label(grpProduits, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(139, 150, 614, 2);

		txtDescriptif = new Text(grpProduits, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtDescriptif.setBounds(108, 66, 239, 52);
		txtDescriptif.setTextLimit(120);

		btnSupprimerProduits = new Button(grpProduits, SWT.NONE);
		btnSupprimerProduits.setBounds(296, 158, 203, 40);
		btnSupprimerProduits.setText("Supprimer ce produit");

		grpActions = new Group(VListProduits, SWT.BORDER | SWT.SHADOW_OUT);
		grpActions.setText("Actions");
		grpActions.setBounds(797, 374, 201, 211);
		grpActions.setVisible(false);

		btnOverview = new Button(grpActions, SWT.NONE);
		btnOverview.setBounds(10, 22, 183, 45);
		btnOverview.setImage(SWTResourceManager.getImage(VListProduits.class, "/net/images/product.PNG"));
		btnOverview.setText("Présentation \r\ndu produit");
		btnOverview.setVisible(true);

		btnAffectationCollaborators = new Button(grpActions, SWT.NONE);
		btnAffectationCollaborators.setBounds(10, 87, 183, 45);
		btnAffectationCollaborators.setImage(SWTResourceManager.getImage(VListProduits.class, "/net/images/addCollaborator.png"));
		btnAffectationCollaborators.setText("Affectation de collaborateurs");

		btnSprints = new Button(grpActions, SWT.NONE);
		btnSprints.setImage(SWTResourceManager.getImage(VListProduits.class, "/net/images/sprint.PNG"));
		btnSprints.setBounds(10, 147, 183, 43);
		btnSprints.setText("Voir les sprints");

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
