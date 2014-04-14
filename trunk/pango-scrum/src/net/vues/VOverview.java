package net.vues;

import net.controller.ProductController;
import net.technics.DAOProduct;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

public class VOverview {

	protected Shell shlGestionDesProduits;
	private Table tableToDo;
	private TableViewer tvToDo;
	private Table tableInProgress;
	private Table tableDone;
	private Table tableSprintRecent;
	private TableViewer TableVOverview;
	private TableViewer tvDone;
	private Button btnToDo;
	private Button btnDone;
	private Button btnProgress;
	private TableViewer tvInProgress;
	private Button btnSprintRecent;
	private Label lblAfficherPointProjet;
	private Label lblAfficherPointSprint;
	private Label lblAfficherCustomerName;
	private Label lblAfficherProjet;

	public TableViewer getTableViewer() {
		return tvToDo;
	}

	public void setTableViewer(TableViewer tableViewer) {
		this.tvToDo = tableViewer;
	}

	public TableViewer getTableViewer2() {
		return tvInProgress;
	}

	public void setTableViewer2(TableViewer tableViewer2) {
		this.tvInProgress = tableViewer2;
	}

	public TableViewer getTableViewer3() {
		return tvDone;
	}

	public void setTableViewer3(TableViewer tableViewer3) {
		this.tvDone = tableViewer3;
	}

	public Button getBtnToDo() {
		return btnToDo;
	}

	public Button getBtnDone() {
		return btnDone;
	}

	public Button getBtnProgress() {
		return btnProgress;
	}

	public Button getBtnSprintRecent() {
		return btnSprintRecent;
	}

	public TableViewer getTableVOverview() {
		return TableVOverview;
	}

	public Label getLblAfficherPointProjet() {
		return lblAfficherPointProjet;
	}

	public Label getLblAfficherPointSprint() {
		return lblAfficherPointSprint;
	}

	public void setLblAfficherPointProjet(Label lblAfficherPointProjet) {
		this.lblAfficherPointProjet = lblAfficherPointProjet;
	}

	public void setLblAfficherPointSprint(Label lblAfficherPointSprint) {
		this.lblAfficherPointSprint = lblAfficherPointSprint;
	}

	public Label getAfficherLblCustomerName() {
		return lblAfficherCustomerName;
	}

	public Label getLblAfficherProjet() {
		return lblAfficherProjet;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public void init() {
		createContents();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		shlGestionDesProduits.open();
		shlGestionDesProduits.layout();
		while (!shlGestionDesProduits.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlGestionDesProduits = new Shell();
		shlGestionDesProduits.setImage(SWTResourceManager.getImage(VOverview.class, "/net/images/logo.PNG"));
		shlGestionDesProduits.setSize(800, 600);
		shlGestionDesProduits.setText("Gestion des produits");
		shlGestionDesProduits.setLayout(new FillLayout(SWT.HORIZONTAL));
		shlGestionDesProduits.setBackground(SWTResourceManager.getColor(255, 255, 240));

		SashForm sashFormContainOverview = new SashForm(shlGestionDesProduits, SWT.VERTICAL);

		SashForm sashForm = new SashForm(sashFormContainOverview, SWT.NONE);
		TableColumnLayout layout = new TableColumnLayout();

		SashForm sashFormSummary = new SashForm(sashForm, SWT.VERTICAL);

		SashForm sashFormSummaryLabel = new SashForm(sashFormSummary, SWT.NONE);

		Composite compositeSummaryLabel = new Composite(sashFormSummaryLabel, SWT.NONE);
		compositeSummaryLabel.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblSummary = new Label(compositeSummaryLabel, SWT.NONE);
		lblSummary.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblSummary.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblSummary.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblSummary.setBounds(26, 23, 100, 28);
		lblSummary.setText("Summary");
		sashFormSummaryLabel.setWeights(new int[] { 1 });

		SashForm sashFormSummaryProduct = new SashForm(sashFormSummary, SWT.NONE);

		Composite compositeSummaryProduct = new Composite(sashFormSummaryProduct, SWT.NONE);
		compositeSummaryProduct.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		compositeSummaryProduct.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblSummaryAvance = new Label(compositeSummaryProduct, SWT.NONE);
		lblSummaryAvance.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSummaryAvance.setBounds(26, 10, 158, 22);
		lblSummaryAvance.setText("Avancée dans le projet");
		lblSummaryAvance.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblPointProjet = new Label(compositeSummaryProduct, SWT.NONE);
		lblPointProjet.setBounds(26, 129, 121, 15);
		lblPointProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblPointProjet.setText("Total point du projet");

		lblAfficherPointProjet = new Label(compositeSummaryProduct, SWT.NONE);
		lblAfficherPointProjet.setBounds(176, 129, 55, 15);
		lblAfficherPointProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblAfficherPointProjet.setText(DAOProduct.getUserstoryTotalPoint() + "");

		Label lblPointSprint = new Label(compositeSummaryProduct, SWT.NONE);
		lblPointSprint.setBounds(27, 160, 120, 15);
		lblPointSprint.setText("Total point des sprints");
		lblPointSprint.setBackground(SWTResourceManager.getColor(255, 255, 240));

		lblAfficherPointSprint = new Label(compositeSummaryProduct, SWT.NONE);
		lblAfficherPointSprint.setBounds(176, 160, 55, 15);
		lblAfficherPointSprint.setText(DAOProduct.getUserstoryDonePoint() + "");
		lblAfficherPointSprint.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblDf = new Label(compositeSummaryProduct, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_NONE);
		lblDf.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblDf.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDf.setText("lblSeparatorSummary");
		lblDf.setBounds(26, 102, 228, 2);

		Label lblClient = new Label(compositeSummaryProduct, SWT.NONE);
		lblClient.setBounds(41, 81, 44, 15);
		lblClient.setText("Client :");
		lblClient.setBackground(SWTResourceManager.getColor(255, 255, 240));

		lblAfficherCustomerName = new Label(compositeSummaryProduct, SWT.NONE);
		lblAfficherCustomerName.setBounds(94, 81, 191, 15);
		lblAfficherCustomerName.setBackground(SWTResourceManager.getColor(255, 255, 240));
		if ((DAOProduct.getProductOwner().getFirstname() != null) && (DAOProduct.getProductOwner().getLastname() != null)) {
			lblAfficherCustomerName.setText(DAOProduct.getProductOwner().getFirstname() + " " + DAOProduct.getProductOwner().getLastname());
		}

		Label lblProjet = new Label(compositeSummaryProduct, SWT.NONE);
		lblProjet.setBounds(41, 54, 44, 15);
		lblProjet.setText("Projet :");

		lblAfficherProjet = new Label(compositeSummaryProduct, SWT.NONE);
		lblAfficherProjet.setBounds(94, 54, 191, 15);
		lblAfficherProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblAfficherProjet.setText(ProductController.getSelectedProduct().getName());

		sashFormSummaryProduct.setWeights(new int[] { 1 });
		sashFormSummary.setWeights(new int[] { 61, 244 });

		SashForm sashForm_1 = new SashForm(sashForm, SWT.VERTICAL);

		TableVOverview = new TableViewer(sashForm_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprintRecent = TableVOverview.getTable();
		tableSprintRecent.getParent().setLayout(layout);
		TableVOverview.setContentProvider(new ArrayContentProvider());
		TableVOverview.setInput(DAOProduct.getLesSprints());

		// Créer une colonne
		TableColumn col = new TableColumn(tableSprintRecent, SWT.CENTER);
		col.setWidth(423);
		col.setText("Sprints");
		// Afficher en-tête+lignes
		tableSprintRecent.setHeaderVisible(true);
		tableSprintRecent.setLinesVisible(true);

		sashForm_1.setWeights(new int[] { 244 });
		sashForm.setWeights(new int[] { 351, 430 });

		SashForm sashForm_3 = new SashForm(sashFormContainOverview, SWT.NONE);

		Composite composite = new Composite(sashForm_3, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnSprintRecent = new Button(composite, SWT.NONE);
		btnSprintRecent.setBounds(526, 10, 88, 25);
		btnSprintRecent.setText("Voir les sprints");
		sashForm_3.setWeights(new int[] { 1 });

		SashForm sashFormProgression = new SashForm(sashFormContainOverview, SWT.VERTICAL);
		sashFormProgression.setSashWidth(7);

		SashForm sashFormTableProgression = new SashForm(sashFormProgression, SWT.NONE);
		sashFormTableProgression.setSashWidth(7);

		tvToDo = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tvToDo.setContentProvider(new ArrayContentProvider());
		tvToDo.setInput(DAOProduct.getLesUserstoriesAFaire());
		tableToDo = tvToDo.getTable();
		// Créer une colonne
		TableColumn col1 = new TableColumn(tableToDo, SWT.CENTER);
		col1.setWidth(252);
		col1.setText("A faire");
		tableToDo.setHeaderVisible(true);
		tableToDo.setLinesVisible(true);

		tvInProgress = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tvInProgress.setContentProvider(new ArrayContentProvider());
		tvInProgress.setInput(DAOProduct.getLesUserstoriesEnCours());
		tableInProgress = tvInProgress.getTable();
		// Créer une colonne
		TableColumn col2 = new TableColumn(tableInProgress, SWT.CENTER);
		col2.setWidth(252);
		col2.setText("En cours");
		tableInProgress.setHeaderVisible(true);
		tableInProgress.setLinesVisible(true);

		tvDone = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tvDone.setContentProvider(new ArrayContentProvider());
		tvDone.setInput(DAOProduct.getLesUserstoriesFinies());
		tableDone = tvDone.getTable();
		// Créer une colonne
		TableColumn col3 = new TableColumn(tableDone, SWT.CENTER);
		col3.setWidth(250);
		col3.setText("Fait");
		tableDone.setHeaderVisible(true);
		tableDone.setLinesVisible(true);

		sashFormTableProgression.setWeights(new int[] { 1, 1, 1 });

		SashForm sashFormLink = new SashForm(sashFormProgression, SWT.NONE);
		sashFormLink.setSashWidth(7);

		SashForm sashFormLinkToDo = new SashForm(sashFormLink, SWT.NONE);

		Composite compositeLinkToDo = new Composite(sashFormLinkToDo, SWT.NONE);
		compositeLinkToDo.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnToDo = new Button(compositeLinkToDo, SWT.NONE);
		btnToDo.setBounds(87, 10, 75, 25);
		btnToDo.setText("Voir tous");
		sashFormLinkToDo.setWeights(new int[] { 1 });

		SashForm sashFormLinkProgress = new SashForm(sashFormLink, SWT.NONE);

		Composite compositeLinkProgress = new Composite(sashFormLinkProgress, SWT.NONE);
		compositeLinkProgress.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnProgress = new Button(compositeLinkProgress, SWT.NONE);
		btnProgress.setBounds(86, 10, 75, 25);
		btnProgress.setText("Voir tous");
		sashFormLinkProgress.setWeights(new int[] { 1 });

		SashForm sashFormLinkDone = new SashForm(sashFormLink, SWT.NONE);

		Composite compositeLinkDone = new Composite(sashFormLinkDone, SWT.NONE);
		compositeLinkDone.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnDone = new Button(compositeLinkDone, SWT.NONE);
		btnDone.setBounds(88, 10, 75, 25);
		btnDone.setText("Voir tous");
		sashFormLinkDone.setWeights(new int[] { 1 });
		sashFormLink.setWeights(new int[] { 1, 1, 1 });
		sashFormProgression.setWeights(new int[] { 233, 57 });
		sashFormContainOverview.setWeights(new int[] { 309, 45, 202 });

	}
}
