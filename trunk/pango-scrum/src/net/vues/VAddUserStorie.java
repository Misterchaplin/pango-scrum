package net.vues;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

public class VAddUserStorie {

	protected Shell vAddUserStorie;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private TabItem tbtmInProgress;
	private TabItem tbtmDone;
	private TabItem tbtmTodo;
	private Table tblInProgress;
	private Table tblDone;
	private Table table;
	private ComboViewer cbvProjet;
	private TableViewer tableViewer;
	private Text txtNom;
	private Text txtDescription;
	private Text txtPtAttribue;
	private Text txtPriorite;
	private Combo cbSprint;
	private ComboViewer cbvSprint;
	private Button btnValider;
	private Button btnAnnuler;
	private Button btnSupprimerUserstory;
	private Button btnAjouterUserstorie;
	private TableViewer tblvUserStory;
	private Group grpUserstory;
	private Button btnModifierUserStory;
	

	public Shell getShlProductBacklog() {
		return vAddUserStorie;
	}
	public Table getTable() {
		return table;
	}
	public Group getGrpUserstory() {
		return grpUserstory;
	}
	public TableViewer getTblvUserStory() {
		return tblvUserStory;
	}
	public Text getTxtNom() {
		return txtNom;
	}
	public Text getTxtDescription() {
		return txtDescription;
	}
	public Text getTxtPtAttribue() {
		return txtPtAttribue;
	}
	public Combo getCbSprint() {
		return cbSprint;
	}
	public ComboViewer getCbvSprint() {
		return cbvSprint;
	}
	public ComboViewer getCbvProjet() {
		return cbvProjet;
	}
	public Text getTxtPriorite() {
		return txtPriorite;
	}
	public Button getBtnAjouterUserstorie() {
		return btnAjouterUserstorie;
	}
	public Button getBtnValider() {
		return btnValider;
	}
	public Button getBtnAnnuler() {
		return btnAnnuler;
	}
	public Button getBtnSupprimerUserstory() {
		return btnSupprimerUserstory;
	}
	public Button getBtnModifierUserStory() {
		return btnModifierUserStory;
	}
	public TabItem getTbtmInProgress() {
		return tbtmInProgress;
	}
	public TabItem getTbtmDone() {
		return tbtmDone;
	}
	public TabItem getTbtmTodo() {
		return tbtmTodo;
	}
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public void init() {
		createContents();
	}

	/**
	 * Open the window.
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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		vAddUserStorie = new Shell();
		vAddUserStorie.setSize(800, 600);
		vAddUserStorie.setText("SWT Application");
		vAddUserStorie.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashGeneralProductBackLog = new SashForm(vAddUserStorie, SWT.NONE);
		
		TabFolder tbfProductBacklog = new TabFolder(sashGeneralProductBackLog, SWT.NONE);
		
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
		sashTo3.setWeights(new int[] {1});
		
		SashForm sashTo2 = new SashForm(sashToDo, SWT.NONE);
		
		tblvUserStory = new TableViewer(sashTo2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tblvUserStory.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		formToolkit.paintBordersFor(table);
		sashTo2.setWeights(new int[] {1});
		
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
		
		btnSupprimerUserstory = new Button(composite, SWT.NONE);
		btnSupprimerUserstory.setBounds(9, 60, 152, 40);
		btnSupprimerUserstory.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/delete_UserStory.png"));
		formToolkit.adapt(btnSupprimerUserstory, true, true);
		btnSupprimerUserstory.setText("Supprimer UserStory");
		
		grpUserstory = new Group(composite, SWT.NONE);
		grpUserstory.setText("UserStory");
		grpUserstory.setBounds(213, 10, 553, 238);
		formToolkit.adapt(grpUserstory);
		formToolkit.paintBordersFor(grpUserstory);
		grpUserstory.setVisible(false);
		
		Label lblNom = new Label(grpUserstory, SWT.NONE);
		lblNom.setBounds(10, 35, 39, 15);
		lblNom.setText("Nom :");
		formToolkit.adapt(lblNom, true, true);
		
		txtNom = new Text(grpUserstory, SWT.BORDER);
		txtNom.setBounds(119, 32, 171, 23);
		formToolkit.adapt(txtNom, true, true);
		
		txtDescription = new Text(grpUserstory, SWT.BORDER);
		txtDescription.setBounds(119, 72, 171, 59);
		formToolkit.adapt(txtDescription, true, true);
		
		txtPtAttribue = new Text(grpUserstory, SWT.BORDER);
		txtPtAttribue.setBounds(119, 148, 171, 23);
		formToolkit.adapt(txtPtAttribue, true, true);
		
		Label lblDescription = new Label(grpUserstory, SWT.NONE);
		lblDescription.setBounds(10, 75, 69, 15);
		formToolkit.adapt(lblDescription, true, true);
		lblDescription.setText("Description : ");
		
		Label lblPtAttribue = new Label(grpUserstory, SWT.NONE);
		lblPtAttribue.setBounds(10, 151, 91, 15);
		formToolkit.adapt(lblPtAttribue, true, true);
		lblPtAttribue.setText("Points attribu\u00E9s : ");
		
		Label lblSprint = formToolkit.createLabel(grpUserstory, "Sprint : ", SWT.NONE);
		lblSprint.setBounds(350, 35, 45, 15);
		
		Label lblProjet = new Label(grpUserstory, SWT.NONE);
		lblProjet.setBounds(350, 91, 40, 15);
		lblProjet.setText("Projet : ");
		formToolkit.adapt(lblProjet, true, true);
		
		Label lblPriorite = new Label(grpUserstory, SWT.NONE);
		lblPriorite.setBounds(350, 137, 49, 15);
		formToolkit.adapt(lblPriorite, true, true);
		lblPriorite.setText("Priorit\u00E9 :");
		
		cbvSprint = new ComboViewer(grpUserstory, SWT.NONE);
		cbSprint = cbvSprint.getCombo();
		cbSprint.setBounds(414, 32, 91, 23);
		formToolkit.paintBordersFor(cbSprint);
		
		cbvProjet = new ComboViewer(grpUserstory, SWT.NONE);
		Combo cbProjet = cbvProjet.getCombo();
		cbProjet.setBounds(414, 88, 91, 23);
		formToolkit.paintBordersFor(cbProjet);
		
		txtPriorite = new Text(grpUserstory, SWT.BORDER);
		txtPriorite.setBounds(414, 134, 91, 23);
		formToolkit.adapt(txtPriorite, true, true);
		
		btnValider = new Button(grpUserstory, SWT.NONE);
		btnValider.setBounds(322, 188, 109, 40);
		btnValider.setText("Valider");
		btnValider.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/accept.png"));
		formToolkit.adapt(btnValider, true, true);
		btnValider.setVisible(false);
		//composite.setTabList(new Control[]{btnAjouterUserstorie, txtNom, txtDescription, txtPtAttribue, cbSprint, cbProjet, txtPriorite, btnValider, btnAnnuler, btnSupprimerUserstory});
		
		btnAnnuler = new Button(grpUserstory, SWT.NONE);
		btnAnnuler.setBounds(434, 188, 109, 40);
		btnAnnuler.setText("Annuler");
		btnAnnuler.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/cancel.png"));
		formToolkit.adapt(btnAnnuler, true, true);
		btnAnnuler.setVisible(false);
		
		btnModifierUserStory = new Button(composite, SWT.NONE);
		btnModifierUserStory.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/Modifier_UserStory.png"));
		btnModifierUserStory.setBounds(10, 112, 152, 40);
		formToolkit.adapt(btnModifierUserStory, true, true);
		btnModifierUserStory.setText("Modifier UserStory");
		sashTo1.setWeights(new int[] {1});
		sashToDo.setWeights(new int[] {31, 239, 257});
		
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
		sashIn3.setWeights(new int[] {1});
		
		SashForm sashIn2 = new SashForm(sashInProgress, SWT.NONE);
		formToolkit.adapt(sashIn2);
		formToolkit.paintBordersFor(sashIn2);
		
		TableViewer tableViewer_1 = new TableViewer(sashIn2, SWT.BORDER | SWT.FULL_SELECTION);
		tblInProgress = tableViewer_1.getTable();
		tblInProgress.setLinesVisible(true);
		tblInProgress.setHeaderVisible(true);
		formToolkit.paintBordersFor(tblInProgress);
		sashIn2.setWeights(new int[] {1});
		
		SashForm sashIn1 = new SashForm(sashInProgress, SWT.NONE);
		formToolkit.adapt(sashIn1);
		formToolkit.paintBordersFor(sashIn1);
		
		Composite composite_1 = new Composite(sashIn1, SWT.NONE);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);
		sashIn1.setWeights(new int[] {1});
		sashInProgress.setWeights(new int[] {31, 275, 221});
		
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
		sashDone3.setWeights(new int[] {1});
		
		SashForm sashDone2 = new SashForm(sashDone, SWT.NONE);
		
		tblDone = new Table(sashDone2, SWT.BORDER | SWT.FULL_SELECTION);
		formToolkit.adapt(tblDone);
		formToolkit.paintBordersFor(tblDone);
		tblDone.setHeaderVisible(true);
		tblDone.setLinesVisible(true);
		sashDone2.setWeights(new int[] {1});
		
		SashForm sashDone1 = new SashForm(sashDone, SWT.NONE);
		
		Composite composite_2 = new Composite(sashDone1, SWT.NONE);
		formToolkit.adapt(composite_2);
		formToolkit.paintBordersFor(composite_2);
		sashDone1.setWeights(new int[] {1});
		sashDone.setWeights(new int[] {31, 282, 214});
		sashGeneralProductBackLog.setWeights(new int[] {1});

	}
}
