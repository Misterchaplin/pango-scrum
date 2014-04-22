package net.vues;

import net.controller.ProductController;
import net.controller.ProduitController;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
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
	private Label lblAfficherPointProjet;

	private Label lblAfficherPointSprint;
	private Label lblAfficherCustomerName;
	private Label lblAfficherProjet;
	private Text textNom;
	private Text textDescription;
	private Table tableSprintRecentUtilisateur;
	private Text textDescriptionUtil;
	private Text textNomUtil;
	private Table tableToDoUtil;
	private Table tableInProgressUtil;
	private Table tableDoneUtil;
	private TableViewer tableViewer;
	private TableViewer tvToDoUtil;
	private TableViewer tvInProgressUtil;
	private TableViewer tvDoneUtil;
	private Label lblAfficherCustomerNameUtil;

	public Table getTableToDo() {
		return tableToDo;
	}

	public Table getTableInProgress() {
		return tableInProgress;
	}

	public Table getTableDone() {
		return tableDone;
	}

	public TableViewer getTvToDo() {
		return tvToDo;
	}

	public TableViewer getTvDone() {
		return tvDone;
	}

	public TableViewer getTvInProgress() {
		return tvInProgress;
	}

	public void setTextNom(Text textNom) {
		this.textNom = textNom;
	}

	public void setTextDescription(Text textDescription) {
		this.textDescription = textDescription;
	}

	public Text getTextNom() {
		return textNom;
	}

	public Text getTextDescription() {
		return textDescription;
	}

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
		ProduitController.nbOpenedWindowDetail = 0;
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlGestionDesProduits = new Shell();
		shlGestionDesProduits.setImage(SWTResourceManager.getImage(VOverview.class, "/net/images/logo.PNG"));
		shlGestionDesProduits.setSize(1024, 706);
		shlGestionDesProduits.setText("Gestion des produits");
		shlGestionDesProduits.setBackground(SWTResourceManager.getColor(255, 255, 240));
		shlGestionDesProduits.setLayout(new FillLayout(SWT.HORIZONTAL));
		TableColumnLayout layout = new TableColumnLayout();
		if ((DAOProduct.getProductOwner().getFirstname() != null) && (DAOProduct.getProductOwner().getLastname() != null)) {
			lblAfficherCustomerName.setText(DAOProduct.getProductOwner().getFirstname() + " " + DAOProduct.getProductOwner().getLastname());
			lblAfficherCustomerNameUtil.setText(DAOProduct.getProductOwner().getFirstname() + " " + DAOProduct.getProductOwner().getLastname());
		}

		TabFolder tabGestionDesProduits = new TabFolder(shlGestionDesProduits, SWT.NONE);

		TabItem tbtmGestionDesTousProduits = new TabItem(tabGestionDesProduits, SWT.NONE);
		tbtmGestionDesTousProduits.setText("Projet");

		SashForm sashFormContainOverview = new SashForm(tabGestionDesProduits, SWT.VERTICAL);
		tbtmGestionDesTousProduits.setControl(sashFormContainOverview);

		SashForm sashForm = new SashForm(sashFormContainOverview, SWT.NONE);

		SashForm sashFormSummary = new SashForm(sashForm, SWT.VERTICAL);

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
		lblPointSprint.setText("Total points réalisés");
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
		lblClient.setBounds(41, 75, 55, 15);
		lblClient.setText("Client :");
		lblClient.setBackground(SWTResourceManager.getColor(255, 255, 240));

		lblAfficherCustomerName = new Label(compositeSummaryProduct, SWT.NONE);
		lblAfficherCustomerName.setBounds(94, 81, 191, 15);
		lblAfficherCustomerName.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblProjet = new Label(compositeSummaryProduct, SWT.NONE);
		lblProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblProjet.setBounds(41, 54, 44, 15);
		lblProjet.setText("Projet :");
		lblProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));

		lblAfficherProjet = new Label(compositeSummaryProduct, SWT.NONE);
		lblAfficherProjet.setBounds(94, 54, 191, 15);
		lblAfficherProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblAfficherProjet.setText(ProductController.getSelectedProduct().getName());

		sashFormSummaryProduct.setWeights(new int[] { 1 });
		sashFormSummary.setWeights(new int[] { 309 });

		SashForm sashForm_1 = new SashForm(sashForm, SWT.VERTICAL);

		TableVOverview = new TableViewer(sashForm_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprintRecent = TableVOverview.getTable();
		tableSprintRecent.getParent().setLayout(layout);
		TableVOverview.setContentProvider(new ArrayContentProvider());
		TableVOverview.setInput(DAOProduct.getLesSprints());

		// Créer une colonne
		TableColumn col = new TableColumn(tableSprintRecent, SWT.CENTER);
		col.setWidth(548);
		col.setText("Sprints");
		// Afficher en-tête+lignes
		tableSprintRecent.setHeaderVisible(true);
		tableSprintRecent.setLinesVisible(true);

		sashForm_1.setWeights(new int[] { 244 });
		sashForm.setWeights(new int[] { 351, 430 });

		SashForm sashFormInformation = new SashForm(sashFormContainOverview, SWT.NONE);

		Composite compositeInformation = new Composite(sashFormInformation, SWT.NONE);
		compositeInformation.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Group group = new Group(compositeInformation, SWT.NONE);
		group.setBounds(238, 0, 503, 145);

		textNom = new Text(group, SWT.BORDER);
		textNom.setLocation(203, 19);
		textNom.setSize(127, 21);

		Label lblNom = new Label(group, SWT.NONE);
		lblNom.setLocation(129, 22);
		lblNom.setSize(55, 15);
		lblNom.setText("Nom :");

		Label lblDescription = new Label(group, SWT.NONE);
		lblDescription.setLocation(129, 43);
		lblDescription.setSize(68, 15);
		lblDescription.setText("Description");

		textDescription = new Text(group, SWT.BORDER);
		textDescription.setLocation(203, 46);
		textDescription.setSize(230, 76);

		sashFormInformation.setWeights(new int[] { 1 });

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
		btnToDo.setBounds(114, 10, 75, 25);
		btnToDo.setText("Voir tous");
		sashFormLinkToDo.setWeights(new int[] { 1 });

		SashForm sashFormLinkProgress = new SashForm(sashFormLink, SWT.NONE);

		Composite compositeLinkProgress = new Composite(sashFormLinkProgress, SWT.NONE);
		compositeLinkProgress.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnProgress = new Button(compositeLinkProgress, SWT.NONE);
		btnProgress.setBounds(123, 10, 75, 25);
		btnProgress.setText("Voir tous");
		sashFormLinkProgress.setWeights(new int[] { 1 });

		SashForm sashFormLinkDone = new SashForm(sashFormLink, SWT.NONE);

		Composite compositeLinkDone = new Composite(sashFormLinkDone, SWT.NONE);
		compositeLinkDone.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnDone = new Button(compositeLinkDone, SWT.NONE);
		btnDone.setBounds(123, 10, 75, 25);
		btnDone.setText("Voir tous");
		sashFormLinkDone.setWeights(new int[] { 1 });
		sashFormLink.setWeights(new int[] { 1, 1, 1 });
		sashFormProgression.setWeights(new int[] { 167, 76 });
		sashFormContainOverview.setWeights(new int[] { 267, 145, 250 });

		TabItem tbtmGestionDesProduitsUtilisateur = new TabItem(tabGestionDesProduits, SWT.NONE);
		tbtmGestionDesProduitsUtilisateur.setText("Utilisateur");

		SashForm sashFormCaintainOverviewUtilisateur = new SashForm(tabGestionDesProduits, SWT.VERTICAL);
		tbtmGestionDesProduitsUtilisateur.setControl(sashFormCaintainOverviewUtilisateur);

		SashForm sashFormUtilisateur = new SashForm(sashFormCaintainOverviewUtilisateur, SWT.NONE);

		SashForm sashFormSummaryUtilisateur = new SashForm(sashFormUtilisateur, SWT.NONE);

		Composite compositeSummaryUtilisateur = new Composite(sashFormSummaryUtilisateur, SWT.NONE);

		Label lblSummaryAvanceUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblSummaryAvanceUtil.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSummaryAvanceUtil.setBounds(26, 10, 158, 22);
		lblSummaryAvanceUtil.setText("Avancée dans le projet");
		lblSummaryAvanceUtil.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblPointProjetUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblPointProjetUtil.setBounds(26, 129, 121, 15);
		lblPointProjetUtil.setText("Total point du projet");

		Label lblAfficherPointProjetUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblAfficherPointProjetUtil.setBounds(176, 129, 55, 15);
		lblAfficherPointProjetUtil.setText("0");

		Label lblPointSprintUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblPointSprintUtil.setBounds(27, 160, 120, 15);
		lblPointSprintUtil.setText("Total points réalisés");

		Label lblAfficherPointSprintUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblAfficherPointSprintUtil.setBounds(176, 160, 55, 15);
		lblAfficherPointSprintUtil.setText("0");

		lblAfficherCustomerNameUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblAfficherCustomerNameUtil.setBounds(94, 81, 191, 15);

		Label lblprojetUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblprojetUtil.setBounds(41, 54, 55, 15);
		lblprojetUtil.setText("Projet :");

		Label lblAfficherProjetUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblAfficherProjetUtil.setBounds(94, 54, 191, 15);
		lblAfficherProjetUtil.setText(ProductController.getSelectedProduct().getName());

		Label lblClientUtil = new Label(compositeSummaryUtilisateur, SWT.NONE);
		lblClientUtil.setBounds(41, 75, 55, 15);
		lblClientUtil.setText("Client :");

		Label lblDfUtil = new Label(compositeSummaryUtilisateur, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_NONE);
		lblDfUtil.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblDfUtil.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDfUtil.setText("lblSeparatorSummary");
		lblDfUtil.setBounds(26, 102, 228, 2);
		sashFormSummaryUtilisateur.setWeights(new int[] { 1 });

		SashForm sashFormSprintUtilisateur = new SashForm(sashFormUtilisateur, SWT.NONE);

		tableViewer = new TableViewer(sashFormSprintUtilisateur, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprintRecentUtilisateur = tableViewer.getTable();
		sashFormSprintUtilisateur.setWeights(new int[] { 1 });
		sashFormUtilisateur.setWeights(new int[] { 427, 570 });

		tableSprintRecentUtilisateur.getParent().setLayout(layout);
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(DAOProduct.getLesSprints());

		// Créer une colonne
		TableColumn col11 = new TableColumn(tableSprintRecentUtilisateur, SWT.CENTER);
		col11.setWidth(548);
		col11.setText("Sprints");
		// Afficher en-tête+lignes
		tableSprintRecentUtilisateur.setHeaderVisible(true);
		tableSprintRecentUtilisateur.setLinesVisible(true);

		SashForm sashFormInformationUtilisateur = new SashForm(sashFormCaintainOverviewUtilisateur, SWT.NONE);

		Composite compositeInformationUtilisateur = new Composite(sashFormInformationUtilisateur, SWT.NONE);

		Group groupUtilisateur = new Group(compositeInformationUtilisateur, SWT.NONE);
		groupUtilisateur.setText("");
		groupUtilisateur.setBounds(409, 0, 367, 156);

		Label lblDescriptionUtil = new Label(groupUtilisateur, SWT.NONE);
		lblDescriptionUtil.setBounds(40, 61, 67, 15);
		lblDescriptionUtil.setText("Description :");

		Label lblNomUtil = new Label(groupUtilisateur, SWT.NONE);
		lblNomUtil.setBounds(40, 27, 55, 15);
		lblNomUtil.setText("Nom :");

		textDescriptionUtil = new Text(groupUtilisateur, SWT.BORDER);
		textDescriptionUtil.setBounds(128, 58, 229, 88);

		textNomUtil = new Text(groupUtilisateur, SWT.BORDER);
		textNomUtil.setBounds(128, 24, 115, 21);
		sashFormInformationUtilisateur.setWeights(new int[] { 1 });

		SashForm sashFormFormProgressionUtilisateur = new SashForm(sashFormCaintainOverviewUtilisateur, SWT.VERTICAL);

		SashForm sashFormTableProgressionUtil = new SashForm(sashFormFormProgressionUtilisateur, SWT.NONE);

		tvToDoUtil = new TableViewer(sashFormTableProgressionUtil, SWT.BORDER | SWT.FULL_SELECTION);
		tvToDoUtil.setContentProvider(new ArrayContentProvider());
		tvToDoUtil.setInput(DAOProduct.getLesUserstoriesAFaire());
		tableToDoUtil = tvToDoUtil.getTable();

		// Créer une colonne
		TableColumn col4 = new TableColumn(tableToDoUtil, SWT.CENTER);
		col4.setWidth(252);
		col4.setText("A faire");
		tableToDoUtil.setHeaderVisible(true);
		tableToDoUtil.setLinesVisible(true);

		tvInProgressUtil = new TableViewer(sashFormTableProgressionUtil, SWT.BORDER | SWT.FULL_SELECTION);
		tvInProgressUtil.setContentProvider(new ArrayContentProvider());
		tvInProgressUtil.setInput(DAOProduct.getLesUserstoriesAFaire());
		tableInProgressUtil = tvInProgressUtil.getTable();

		// Créer une colonne
		TableColumn col5 = new TableColumn(tableInProgressUtil, SWT.CENTER);
		col5.setWidth(252);
		col5.setText("En cours");
		tableInProgressUtil.setHeaderVisible(true);
		tableInProgressUtil.setLinesVisible(true);

		tvDoneUtil = new TableViewer(sashFormTableProgressionUtil, SWT.BORDER | SWT.FULL_SELECTION);
		tvDoneUtil.setContentProvider(new ArrayContentProvider());
		tvDoneUtil.setInput(DAOProduct.getLesUserstoriesAFaire());
		tableDoneUtil = tvDoneUtil.getTable();
		TableColumn col6 = new TableColumn(tableDoneUtil, SWT.CENTER);
		col6.setWidth(252);
		col6.setText("Fait");
		tableDoneUtil.setHeaderVisible(true);
		tableDoneUtil.setLinesVisible(true);

		sashFormTableProgressionUtil.setWeights(new int[] { 1, 1, 1 });

		SashForm sashFormLinkUtil = new SashForm(sashFormFormProgressionUtilisateur, SWT.NONE);

		SashForm sashFormLinkToDoUtil = new SashForm(sashFormLinkUtil, SWT.NONE);

		Composite compositeLinkToDoUtil = new Composite(sashFormLinkToDoUtil, SWT.NONE);

		Button btnToDoUtil = new Button(compositeLinkToDoUtil, SWT.NONE);
		btnToDoUtil.setBounds(118, 10, 75, 25);
		btnToDoUtil.setText("Voir tous");
		sashFormLinkToDoUtil.setWeights(new int[] { 1 });

		SashForm sashFormLinkProgressUtil = new SashForm(sashFormLinkUtil, SWT.NONE);

		Composite CompositeLinkProgressUtil = new Composite(sashFormLinkProgressUtil, SWT.NONE);

		Button btnProgressUtil = new Button(CompositeLinkProgressUtil, SWT.NONE);
		btnProgressUtil.setBounds(138, 10, 75, 25);
		btnProgressUtil.setText("Voir tous");
		sashFormLinkProgressUtil.setWeights(new int[] { 1 });

		SashForm sashFormLinkDoneUtil = new SashForm(sashFormLinkUtil, SWT.NONE);

		Composite compositeLinkDoneUtil = new Composite(sashFormLinkDoneUtil, SWT.NONE);

		Button btnDoneUtil = new Button(compositeLinkDoneUtil, SWT.NONE);
		btnDoneUtil.setBounds(128, 10, 75, 25);
		btnDoneUtil.setText("Voir tous");
		sashFormLinkDoneUtil.setWeights(new int[] { 1 });
		sashFormLinkUtil.setWeights(new int[] { 1, 1, 1 });
		sashFormFormProgressionUtilisateur.setWeights(new int[] { 133, 76 });
		sashFormCaintainOverviewUtilisateur.setWeights(new int[] { 242, 156, 236 });

	}

	public Table getTableSprintRecent() {
		return tableSprintRecent;
	}
}
