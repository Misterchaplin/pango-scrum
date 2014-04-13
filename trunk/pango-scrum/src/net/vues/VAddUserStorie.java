package net.vues;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAddUserStorie {

	/**
	 * Membres général
	 */
	
	protected Shell vAddUserStorie;
	private TabFolder tbfProductBacklog;
	private TabItem tbtmTodo;
	private TabItem tbtmInProgress;
	private TabItem tbtmDone;
	private TableColumnLayout tLayout;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	/**
	 * Membres de l'onglet To-Do
	 */
	
	private Text txtNom;
	private Text txtDescription;
	private Text txtPtAttribue;
	private Text txtPriorite;
	
	private Combo cbSprint;
	private ComboViewer cbvSprint;
	private Combo cbProjet;
	private ComboViewer cbvProjet;
	
	private Button btnAjouterUserstorie;
	private Button btnModifierUserStory;
	private Button btnSupprimerUserstory;
	private Button btnInProgress;
	private Button btnDone;
	private Button btnValider;
	private Button btnAnnuler;

	private Group grpParametreUserstory;
	private Group grpChangementDtat;
	private Group grpUserstory;
	
	private Table tblUserStory;
	private TableViewer tblvUserStory;
	
	/**
	 * Membres de l'onglet In-Progress
	 */
	
	private Text txtNomInProgress;
	private Text txtDescriptionInProgress;
	private Text txtPtattribueInProgress;
	private Text txtPrioriteInProgress;

	private Combo cbSprintInProgress;
	private ComboViewer cbvSprintInProgress;
	private Combo cbProjetInProgress;
	private ComboViewer cbvProjetInProgress;

	private Button btncloturerInProgress;

	private Group grpRcapitulatifInProgress;

	private Table tblInProgress;
	private TableViewer tblvInProgress;
	
	/**
	 * Membres de l'onglet Done
	 */
	
	private Text txtNomDone;
	private Text txtDescriptionDone;
	private Text txtPtAttribueDone;
	private Text txtPrioriteDone;
	
	private Combo cbSprintDone;
	private ComboViewer cbvSprintDone;
	private Combo cbProjetDone;
	private ComboViewer cbvProjetDone;

	private Group grpChangementEtatInProgress;
	private Group grpRcapitulatifUserStory;

	private Table tblDone;
	private TableViewer tblvDone;
	
	/**
	 * Getteurs Général
	 */
	
	public Shell getShlProductBacklog() {
		return vAddUserStorie;
	}
	
	public TabFolder getTbfProductBacklog() {
		return tbfProductBacklog;
	}
	
	public TabItem getTbtmTodo() {
		return tbtmTodo;
	}
	
	public TabItem getTbtmInProgress() {
		return tbtmInProgress;
	}

	public TabItem getTbtmDone() {
		return tbtmDone;
	}
	
	
	/**
	 * Getteurs To-Do
	 */
	public Text getTxtNom() {
		return txtNom;
	}

	public Text getTxtDescription() {
		return txtDescription;
	}

	public Text getTxtPtAttribue() {
		return txtPtAttribue;
	}

	public Text getTxtPriorite() {
		return txtPriorite;
	}
	
	public Combo getCbSprint() {
		return cbSprint;
	}

	public ComboViewer getCbvSprint() {
		return cbvSprint;
	}

	public Combo getCbProjet() {
		return cbProjet;
	}

	public ComboViewer getCbvProjet() {
		return cbvProjet;
	}
	
	public Button getBtnAjouterUserstorie() {
		return btnAjouterUserstorie;
	}
	
	public Button getBtnModifierUserStory() {
		return btnModifierUserStory;
	}
	
	public Button getBtnSupprimerUserstory() {
		return btnSupprimerUserstory;
	}
	
	public Button getBtnInProgress() {
		return btnInProgress;
	}
	
	public Button getBtnDone() {
		return btnDone;
	}
	
	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}
	
	public Group getGrpParametreUserstory() {
		return grpParametreUserstory;
	}
	
	public Group getGrpChangementDtat() {
		return grpChangementDtat;
	}
	
	public Group getGrpUserstory() {
		return grpUserstory;
	}
	
	public Table getTable() {
		return tblUserStory;
	}

	public TableViewer getTblvUserStory() {
		return tblvUserStory;
	}
	
	/**
	 * Getteurs In-Progress
	 */
	
	public Text getTxtNomInProgress() {
		return txtNomInProgress;
	}

	public Text getTxtDescriptionInProgress() {
		return txtDescriptionInProgress;
	}
	
	public Text getTxtPtattribueInProgress() {
		return txtPtattribueInProgress;
	}
	
	public Text getTxtPrioriteInProgress() {
		return txtPrioriteInProgress;
	}

	public Combo getCbSprintInProgress() {
		return cbSprintInProgress;
	}

	public ComboViewer getCbvSprintInProgress() {
		return cbvSprintInProgress;
	}

	public Combo getCbProjetInProgress() {
		return cbProjetInProgress;
	}
	
	public ComboViewer getCbvProjetInProgress() {
		return cbvProjetInProgress;
	}

	public Button getBtncloturerInProgress() {
		return btncloturerInProgress;
	}
	
	public Group getGrpRcapitulatifInProgress() {
		return grpRcapitulatifInProgress;
	}

	public Table getTblInProgress() {
		return tblInProgress;
	}

	public TableViewer getTblvInProgress() {
		return tblvInProgress;
	}
	
	/**
	 * Getteurs Done
	 */
	public Text getTxtNomDone() {
		return txtNomDone;
	}

	public Text getTxtDescriptionDone() {
		return txtDescriptionDone;
	}
	
	public Text getTxtPtAttribueDone() {
		return txtPtAttribueDone;
	}
	
	public Text getTxtPrioriteDone() {
		return txtPrioriteDone;
	}
	
	public Combo getCbSprintDone() {
		return cbSprintDone;
	}
	
	public ComboViewer getCbvSprintDone() {
		return cbvSprintDone;
	}

	public Combo getCbProjetDone() {
		return cbProjetDone;
	}
	
	public ComboViewer getCbvProjetDone() {
		return cbvProjetDone;
	}
	
	public Group getGrpChangementEtatInProgress() {
		return grpChangementEtatInProgress;
	}

	public Group getGrpRcapitulatifUserStory() {
		return grpRcapitulatifUserStory;
	}
	
	public Table getTblDone() {
		return tblDone;
	}
	
	public TableViewer getTblvDone() {
		return tblvDone;
	}

	public void init() {
		createContents();
	}

	/**
	 * Open the window
	 */
	public void open() {

		Display display = Display.getDefault();
		vAddUserStorie.open();
		vAddUserStorie.layout();
		while (!vAddUserStorie.isDisposed()) {
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
		vAddUserStorie = new Shell();
		vAddUserStorie.setSize(800, 600);
		vAddUserStorie.setText("SWT Application");
		vAddUserStorie.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashGeneralProductBackLog = new SashForm(vAddUserStorie, SWT.NONE);

		tbfProductBacklog = new TabFolder(sashGeneralProductBackLog, SWT.NONE);

		tbtmTodo = new TabItem(tbfProductBacklog, SWT.NONE);
		tbtmTodo.setText("To-Do");

		SashForm sashToDo = new SashForm(tbfProductBacklog, SWT.VERTICAL);
		tbtmTodo.setControl(sashToDo);

		SashForm sashTo3 = new SashForm(sashToDo, SWT.NONE);
		sashTo3.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		sashTo3.setFont(SWTResourceManager.getFont("Segoe UI Black", 12, SWT.ITALIC));
		formToolkit.adapt(sashTo3);
		formToolkit.paintBordersFor(sashTo3);

		Label lblProductBacklogItems = new Label(sashTo3, SWT.NONE);
		lblProductBacklogItems.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblProductBacklogItems.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblProductBacklogItems.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.ITALIC));
		lblProductBacklogItems.setTouchEnabled(true);
		formToolkit.adapt(lblProductBacklogItems, true, true);
		lblProductBacklogItems.setText("Product Backlog Items - To-do");
		sashTo3.setWeights(new int[] { 1 });

		SashForm sashTo2 = new SashForm(sashToDo, SWT.NONE);
		tLayout = new TableColumnLayout();
		sashTo2.setLayout(tLayout);

		tblvUserStory = new TableViewer(sashTo2, SWT.BORDER | SWT.FULL_SELECTION);
		tblUserStory = tblvUserStory.getTable();
		tblUserStory.setLinesVisible(true);
		tblUserStory.setHeaderVisible(true);
		formToolkit.paintBordersFor(tblUserStory);

		createColumn(tblUserStory, "Nom des UserStory", 1);

		sashTo2.setWeights(new int[] { 1 });

		SashForm sashTo1 = new SashForm(sashToDo, SWT.NONE);

		Composite composite = new Composite(sashTo1, SWT.NONE);
		composite.setLayout(null);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		btnAjouterUserstorie = new Button(composite, SWT.NONE);
		btnAjouterUserstorie.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/addButton.png"));
		btnAjouterUserstorie.setText("  Ajouter UserStory");
		btnAjouterUserstorie.setBounds(10, 10, 151, 34);
		formToolkit.adapt(btnAjouterUserstorie, true, true);

		grpUserstory = new Group(composite, SWT.NONE);
		grpUserstory.setText("UserStory");
		grpUserstory.setBounds(186, 10, 580, 238);
		formToolkit.adapt(grpUserstory);
		formToolkit.paintBordersFor(grpUserstory);
		grpUserstory.setVisible(true);

		Label lblNom = new Label(grpUserstory, SWT.NONE);
		lblNom.setBounds(10, 35, 39, 15);
		lblNom.setText("Nom :");
		formToolkit.adapt(lblNom, true, true);

		txtNom = new Text(grpUserstory, SWT.BORDER);
		txtNom.setBounds(119, 32, 245, 23);
		formToolkit.adapt(txtNom, true, true);

		txtDescription = new Text(grpUserstory, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtDescription.setBounds(119, 61, 245, 72);
		txtDescription.setTextLimit(120);
		formToolkit.adapt(txtDescription, true, true);

		txtPtAttribue = new Text(grpUserstory, SWT.BORDER);
		txtPtAttribue.setBounds(482, 90, 91, 23);
		formToolkit.adapt(txtPtAttribue, true, true);

		Label lblDescription = new Label(grpUserstory, SWT.NONE);
		lblDescription.setBounds(10, 64, 69, 15);
		formToolkit.adapt(lblDescription, true, true);
		lblDescription.setText("Description : ");

		Label lblPtAttribue = new Label(grpUserstory, SWT.NONE);
		lblPtAttribue.setBounds(385, 93, 91, 15);
		formToolkit.adapt(lblPtAttribue, true, true);
		lblPtAttribue.setText("Points attribu\u00E9s : ");

		Label lblSprint = formToolkit.createLabel(grpUserstory, "Sprint : ", SWT.NONE);
		lblSprint.setBounds(385, 35, 45, 15);

		Label lblProjet = new Label(grpUserstory, SWT.NONE);
		lblProjet.setBounds(385, 64, 40, 15);
		lblProjet.setText("Projet : ");
		formToolkit.adapt(lblProjet, true, true);

		Label lblPriorite = new Label(grpUserstory, SWT.NONE);
		lblPriorite.setBounds(385, 122, 49, 15);
		formToolkit.adapt(lblPriorite, true, true);
		lblPriorite.setText("Priorit\u00E9 :");

		cbvSprint = new ComboViewer(grpUserstory, SWT.NONE);
		cbSprint = cbvSprint.getCombo();
		cbSprint.setBounds(482, 32, 91, 23);
		formToolkit.paintBordersFor(cbSprint);

		cbvProjet = new ComboViewer(grpUserstory, SWT.NONE);
		cbProjet = cbvProjet.getCombo();
		cbProjet.setBounds(482, 61, 91, 23);
		formToolkit.paintBordersFor(cbProjet);

		txtPriorite = new Text(grpUserstory, SWT.BORDER);
		txtPriorite.setBounds(482, 119, 91, 23);
		formToolkit.adapt(txtPriorite, true, true);

		btnValider = new Button(grpUserstory, SWT.NONE);
		btnValider.setBounds(349, 188, 109, 40);
		btnValider.setText("Valider");
		btnValider.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/accept.png"));
		formToolkit.adapt(btnValider, true, true);
		btnValider.setVisible(false);
		// composite.setTabList(new Control[]{btnAjouterUserstorie, txtNom,
		// txtDescription, txtPtAttribue, cbSprint, cbProjet, txtPriorite,
		// btnValider, btnAnnuler, btnSupprimerUserstory});

		btnAnnuler = new Button(grpUserstory, SWT.NONE);
		btnAnnuler.setBounds(464, 188, 109, 40);
		btnAnnuler.setText("Annuler");
		btnAnnuler.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/cancel.png"));
		formToolkit.adapt(btnAnnuler, true, true);
		btnAnnuler.setVisible(false);
		
		grpParametreUserstory = new Group(composite, SWT.NONE);
		grpParametreUserstory.setText("Param\u00E8tre UserStory");
		grpParametreUserstory.setBounds(0, 48, 170, 99);
		grpParametreUserstory.setVisible(false);
		formToolkit.adapt(grpParametreUserstory);
		formToolkit.paintBordersFor(grpParametreUserstory);
		
		btnModifierUserStory = new Button(grpParametreUserstory, SWT.NONE);
		btnModifierUserStory.setBounds(10, 20, 152, 33);
		btnModifierUserStory.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/Modifier_UserStory.png"));
		formToolkit.adapt(btnModifierUserStory, true, true);
		btnModifierUserStory.setText("Modifier UserStory");
		btnModifierUserStory.setVisible(true);
				
		btnSupprimerUserstory = new Button(grpParametreUserstory, SWT.NONE);
		btnSupprimerUserstory.setBounds(10, 60, 152, 33);
		btnSupprimerUserstory.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/delete_UserStory.png"));
		formToolkit.adapt(btnSupprimerUserstory, true, true);
		btnSupprimerUserstory.setText("Supprimer UserStory");
		btnSupprimerUserstory.setVisible(true);
				
		grpChangementDtat = new Group(composite, SWT.NONE);
		grpChangementDtat.setText("Changement d'\u00E9tat");
		grpChangementDtat.setBounds(0, 154, 170, 99);
		grpChangementDtat.setVisible(false);
		formToolkit.adapt(grpChangementDtat);
		formToolkit.paintBordersFor(grpChangementDtat);
				
		btnDone = new Button(grpChangementDtat, SWT.NONE);
		btnDone.setBounds(10, 60, 152, 33);
		btnDone.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/done_UserStory.png"));
		formToolkit.adapt(btnDone, true, true);
		btnDone.setText("Cloturer UserStory");
		btnDone.setVisible(true);
				
		btnInProgress = new Button(grpChangementDtat, SWT.NONE);
		btnInProgress.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/In_Progress_UserStory.png"));
		btnInProgress.setBounds(10, 20, 152, 33);
		formToolkit.adapt(btnInProgress, true, true);
		btnInProgress.setText("En cours UserStory");
		sashTo1.setWeights(new int[] { 1 });
		sashToDo.setWeights(new int[] {31, 240, 256});

		tbtmInProgress = new TabItem(tbfProductBacklog, SWT.NONE);
		tbtmInProgress.setText("In Progress");

		SashForm sashInProgress = new SashForm(tbfProductBacklog, SWT.VERTICAL);
		tbtmInProgress.setControl(sashInProgress);
		formToolkit.paintBordersFor(sashInProgress);

		SashForm sashIn3 = new SashForm(sashInProgress, SWT.NONE);
		formToolkit.adapt(sashIn3);
		formToolkit.paintBordersFor(sashIn3);

		Label lblProductBacklogItems_1 = new Label(sashIn3, SWT.NONE);
		lblProductBacklogItems_1.setTouchEnabled(true);
		lblProductBacklogItems_1.setText("Product Backlog Items - In Progress");
		lblProductBacklogItems_1.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.ITALIC));
		lblProductBacklogItems_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		formToolkit.adapt(lblProductBacklogItems_1, true, true);
		sashIn3.setWeights(new int[] { 1 });

		SashForm sashIn2 = new SashForm(sashInProgress, SWT.NONE);
		tLayout = new TableColumnLayout();
		sashIn2.setLayout(tLayout);
		formToolkit.adapt(sashIn2);
		formToolkit.paintBordersFor(sashIn2);

		tblvInProgress = new TableViewer(sashIn2, SWT.BORDER | SWT.FULL_SELECTION);
		tblInProgress = tblvInProgress.getTable();
		tblInProgress.setLinesVisible(true);
		tblInProgress.setHeaderVisible(true);
		formToolkit.paintBordersFor(tblInProgress);
		sashIn2.setWeights(new int[] { 1 });
		
		createColumn(tblInProgress, "Nom des UserStory en cours", 1);
		
		SashForm sashIn1 = new SashForm(sashInProgress, SWT.NONE);
		formToolkit.adapt(sashIn1);
		formToolkit.paintBordersFor(sashIn1);
		
		Composite composite_3 = new Composite(sashIn1, SWT.NONE);
		formToolkit.adapt(composite_3);
		formToolkit.paintBordersFor(composite_3);
		
		grpRcapitulatifInProgress = new Group(composite_3, SWT.NONE);
		grpRcapitulatifInProgress.setEnabled(false);
		grpRcapitulatifInProgress.setText("R\u00E9capitulatif de la UserStory en cours");
		grpRcapitulatifInProgress.setBounds(176, 10, 592, 185);
		grpRcapitulatifInProgress.setVisible(false);
		formToolkit.adapt(grpRcapitulatifInProgress);
		formToolkit.paintBordersFor(grpRcapitulatifInProgress);
		
		Label lblNomInProgress = new Label(grpRcapitulatifInProgress, SWT.NONE);
		lblNomInProgress.setText("Nom : ");
		lblNomInProgress.setBounds(10, 80, 55, 15);
		formToolkit.adapt(lblNomInProgress, true, true);
		
		Label lblDescriptionInProgress = new Label(grpRcapitulatifInProgress, SWT.NONE);
		lblDescriptionInProgress.setText("Description : ");
		lblDescriptionInProgress.setBounds(10, 130, 69, 15);
		formToolkit.adapt(lblDescriptionInProgress, true, true);
		
		Label lblSprintInProgress = new Label(grpRcapitulatifInProgress, SWT.NONE);
		lblSprintInProgress.setText("Sprint :");
		lblSprintInProgress.setBounds(365, 40, 42, 15);
		formToolkit.adapt(lblSprintInProgress, true, true);
		
		Label lblProjetInProgress = new Label(grpRcapitulatifInProgress, SWT.NONE);
		lblProjetInProgress.setText("Projet : ");
		lblProjetInProgress.setBounds(10, 41, 42, 15);
		formToolkit.adapt(lblProjetInProgress, true, true);
		
		Label lblPtattribueInProgress = new Label(grpRcapitulatifInProgress, SWT.NONE);
		lblPtattribueInProgress.setText("Points attribu\u00E9s : ");
		lblPtattribueInProgress.setBounds(365, 109, 91, 15);
		formToolkit.adapt(lblPtattribueInProgress, true, true);
		
		Label lblPrioriteInProgress = new Label(grpRcapitulatifInProgress, SWT.NONE);
		lblPrioriteInProgress.setText("Priorit\u00E9 : ");
		lblPrioriteInProgress.setBounds(365, 82, 55, 15);
		formToolkit.adapt(lblPrioriteInProgress, true, true);
		
		cbvProjetInProgress = new ComboViewer(grpRcapitulatifInProgress, SWT.NONE);
		cbProjetInProgress = cbvProjetInProgress.getCombo();
		cbProjetInProgress.setBounds(85, 38, 244, 23);
		formToolkit.paintBordersFor(cbProjetInProgress);
		
		cbvSprintInProgress = new ComboViewer(grpRcapitulatifInProgress, SWT.NONE);
		cbSprintInProgress = cbvSprintInProgress.getCombo();
		cbSprintInProgress.setBounds(466, 37, 116, 23);
		formToolkit.paintBordersFor(cbSprintInProgress);
		
		txtNomInProgress = new Text(grpRcapitulatifInProgress, SWT.BORDER);
		txtNomInProgress.setBounds(85, 77, 244, 21);
		formToolkit.adapt(txtNomInProgress, true, true);
		
		txtDescriptionInProgress = new Text(grpRcapitulatifInProgress, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtDescriptionInProgress.setBounds(84, 104, 245, 72);
		formToolkit.adapt(txtDescriptionInProgress, true, true);
		
		txtPrioriteInProgress = new Text(grpRcapitulatifInProgress, SWT.BORDER);
		txtPrioriteInProgress.setBounds(466, 79, 116, 21);
		formToolkit.adapt(txtPrioriteInProgress, true, true);
		
		txtPtattribueInProgress = new Text(grpRcapitulatifInProgress, SWT.BORDER);
		txtPtattribueInProgress.setBounds(466, 106, 116, 21);
		formToolkit.adapt(txtPtattribueInProgress, true, true);
		
		grpChangementEtatInProgress = new Group(composite_3, SWT.NONE);
		grpChangementEtatInProgress.setVisible(false);
		grpChangementEtatInProgress.setText("Changement d'\u00E9tat");
		grpChangementEtatInProgress.setBounds(0, 10, 170, 66);
		formToolkit.adapt(grpChangementEtatInProgress);
		formToolkit.paintBordersFor(grpChangementEtatInProgress);
		
		btncloturerInProgress = new Button(grpChangementEtatInProgress, SWT.NONE);
		btncloturerInProgress.setVisible(true);
		btncloturerInProgress.setText("Cloturer UserStory");
		btncloturerInProgress.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/done_UserStory.png"));
		btncloturerInProgress.setBounds(10, 22, 152, 33);
		formToolkit.adapt(btncloturerInProgress, true, true);
		sashIn1.setWeights(new int[] { 1 });
		sashInProgress.setWeights(new int[] {30, 275, 222});

		tbtmDone = new TabItem(tbfProductBacklog, SWT.NONE);
		tbtmDone.setText("Done");

		SashForm sashDone = new SashForm(tbfProductBacklog, SWT.VERTICAL);
		tbtmDone.setControl(sashDone);

		SashForm sashDone3 = new SashForm(sashDone, SWT.NONE);
		formToolkit.adapt(sashDone3);
		formToolkit.paintBordersFor(sashDone3);

		Label lblProductBacklogItems_2 = new Label(sashDone3, SWT.NONE);
		lblProductBacklogItems_2.setTouchEnabled(true);
		lblProductBacklogItems_2.setText("Product Backlog Items - Done");
		lblProductBacklogItems_2.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.ITALIC));
		lblProductBacklogItems_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		formToolkit.adapt(lblProductBacklogItems_2, true, true);
		sashDone3.setWeights(new int[] { 1 });

		SashForm sashDone2 = new SashForm(sashDone, SWT.NONE);
		tLayout = new TableColumnLayout();
		sashDone2.setLayout(tLayout);

		
		tblvDone = new TableViewer(sashDone2, SWT.BORDER | SWT.FULL_SELECTION);
		tblDone = tblvDone.getTable();
		tblDone.setHeaderVisible(true);
		tblDone.setLinesVisible(true);
		formToolkit.paintBordersFor(tblDone);
		sashDone2.setWeights(new int[] { 1, });
		sashGeneralProductBackLog.setWeights(new int[] { 1 });
		

		createColumn(tblDone, "Nom des UserStory cloturées", 1);
		
		SashForm sashForm = new SashForm(sashDone, SWT.NONE);
		formToolkit.adapt(sashForm);
		formToolkit.paintBordersFor(sashForm);
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		formToolkit.adapt(composite_2);
		formToolkit.paintBordersFor(composite_2);
		
		grpRcapitulatifUserStory = new Group(composite_2, SWT.NONE);
		grpRcapitulatifUserStory.setText("R\u00E9capitulatif de la UserStory Clotur\u00E9");
		grpRcapitulatifUserStory.setBounds(0, 10, 597, 175);
		grpRcapitulatifUserStory.setVisible(false);
		grpRcapitulatifUserStory.setEnabled(false);
		formToolkit.adapt(grpRcapitulatifUserStory);
		formToolkit.paintBordersFor(grpRcapitulatifUserStory);
		
		Label lblNomDone = new Label(grpRcapitulatifUserStory, SWT.NONE);
		lblNomDone.setBounds(10, 68, 55, 15);
		formToolkit.adapt(lblNomDone, true, true);
		lblNomDone.setText("Nom : ");
		
		Label lblDescriptionDone = new Label(grpRcapitulatifUserStory, SWT.NONE);
		lblDescriptionDone.setBounds(10, 118, 69, 15);
		formToolkit.adapt(lblDescriptionDone, true, true);
		lblDescriptionDone.setText("Description : ");
		
		Label lblSprintDone = new Label(grpRcapitulatifUserStory, SWT.NONE);
		lblSprintDone.setBounds(364, 29, 42, 15);
		formToolkit.adapt(lblSprintDone, true, true);
		lblSprintDone.setText("Sprint :");
		
		Label lblProjetDone = new Label(grpRcapitulatifUserStory, SWT.NONE);
		lblProjetDone.setBounds(10, 29, 42, 15);
		formToolkit.adapt(lblProjetDone, true, true);
		lblProjetDone.setText("Projet : ");
		
		Label lblPointsAttribueDone = new Label(grpRcapitulatifUserStory, SWT.NONE);
		lblPointsAttribueDone.setBounds(364, 98, 91, 15);
		formToolkit.adapt(lblPointsAttribueDone, true, true);
		lblPointsAttribueDone.setText("Points attribu\u00E9s : ");
		
		Label lblPrioriteDone = new Label(grpRcapitulatifUserStory, SWT.NONE);
		lblPrioriteDone.setBounds(364, 71, 55, 15);
		formToolkit.adapt(lblPrioriteDone, true, true);
		lblPrioriteDone.setText("Priorit\u00E9 : ");
		
		cbvProjetDone = new ComboViewer(grpRcapitulatifUserStory, SWT.NONE);
		cbProjetDone = cbvProjetDone.getCombo();
		cbProjetDone.setBounds(85, 26, 244, 23);
		formToolkit.paintBordersFor(cbProjetDone);
		
		cbvSprintDone = new ComboViewer(grpRcapitulatifUserStory, SWT.NONE);
		cbSprintDone = cbvSprintDone.getCombo();
		cbSprintDone.setBounds(465, 26, 116, 23);
		formToolkit.paintBordersFor(cbSprintDone);
		
		txtNomDone = new Text(grpRcapitulatifUserStory, SWT.BORDER);
		txtNomDone.setBounds(85, 65, 244, 21);
		formToolkit.adapt(txtNomDone, true, true);
		
		txtDescriptionDone = new Text(grpRcapitulatifUserStory, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtDescriptionDone.setBounds(84, 92, 245, 72);
		formToolkit.adapt(txtDescriptionDone, true, true);
		
		txtPrioriteDone = new Text(grpRcapitulatifUserStory, SWT.BORDER);
		txtPrioriteDone.setBounds(465, 68, 116, 21);
		formToolkit.adapt(txtPrioriteDone, true, true);
		
		txtPtAttribueDone = new Text(grpRcapitulatifUserStory, SWT.BORDER);
		txtPtAttribueDone.setBounds(465, 95, 116, 21);
		formToolkit.adapt(txtPtAttribueDone, true, true);
		sashForm.setWeights(new int[] {1});
		sashDone.setWeights(new int[] {30, 240, 258});

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setWidth(773);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
