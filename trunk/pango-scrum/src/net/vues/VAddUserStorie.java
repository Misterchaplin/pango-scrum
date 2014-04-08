package net.vues;

import java.util.List;

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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Control;

public class VAddUserStorie {

	protected Shell ShlProductBacklog;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private TabItem tbtmInProgress;
	private TabItem tbtmDone;
	private TabItem tbtmTodo;
	private Table tblInProgress;
	private Table tblDone;
	private ComboViewer cbvProjet;
	private TableViewer tableViewer;
	private Text txtaddUserstorie;
	private Button btnAddUserStorie;
	private Label lblAddUserstorie;
	private Text text;
	private Table table;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	
	
	public TabItem getTbtmInProgress() {
		return tbtmInProgress;
	}
	public TabItem getTbtmDone() {
		return tbtmDone;
	}
	public TabItem getTbtmTodo() {
		return tbtmTodo;
	}
	public ComboViewer getCbvProjet() {
		return cbvProjet;
	}
	public TableViewer getTableViewer() {
		return tableViewer;
	}
	public Text getTxtaddUserstorie() {
		return txtaddUserstorie;
	}

	public Button getBtnAddUserStorie() {
		return btnAddUserStorie;
	}

	public Label getLblAddUserstorie() {
		return lblAddUserstorie;
	}

	public void init() {
		createContents();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		ShlProductBacklog.open();
		ShlProductBacklog.layout();
		while (!ShlProductBacklog.isDisposed()) {
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
		ShlProductBacklog = new Shell();
		ShlProductBacklog.setSize(800, 600);
		ShlProductBacklog.setText("SWT Application");
		ShlProductBacklog.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashGeneralProductBackLog = new SashForm(ShlProductBacklog, SWT.NONE);
		
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
		
		TableViewer tableViewer_2 = new TableViewer(sashTo2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer_2.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		formToolkit.paintBordersFor(table);
		sashTo2.setWeights(new int[] {1});
		
		SashForm sashTo1 = new SashForm(sashToDo, SWT.NONE);
		
		Composite composite = new Composite(sashTo1, SWT.NONE);
		composite.setLayout(null);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		
		Button btnAjouterUneUserstorie = new Button(composite, SWT.NONE);
		btnAjouterUneUserstorie.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/addButton.png"));
		btnAjouterUneUserstorie.setText("  Ajouter UserStory");
		btnAjouterUneUserstorie.setBounds(10, 10, 151, 34);
		formToolkit.adapt(btnAjouterUneUserstorie, true, true);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(292, 31, 171, 23);
		formToolkit.adapt(text, true, true);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Nom :");
		label_1.setBounds(195, 34, 39, 15);
		formToolkit.adapt(label_1, true, true);
		
		ComboViewer comboViewer = new ComboViewer(composite, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(607, 67, 91, 23);
		formToolkit.paintBordersFor(combo);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("Projet : ");
		label_2.setBounds(514, 75, 40, 15);
		formToolkit.adapt(label_2, true, true);
		
		Label lblDescription = new Label(composite, SWT.NONE);
		lblDescription.setBounds(195, 70, 69, 15);
		formToolkit.adapt(lblDescription, true, true);
		lblDescription.setText("Description : ");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(292, 67, 171, 59);
		formToolkit.adapt(text_1, true, true);
		
		Label lblStoryPoints = new Label(composite, SWT.NONE);
		lblStoryPoints.setBounds(195, 171, 91, 15);
		formToolkit.adapt(lblStoryPoints, true, true);
		lblStoryPoints.setText("Points attribu\u00E9 : ");
		
		Label lblPriorit = new Label(composite, SWT.NONE);
		lblPriorit.setBounds(514, 111, 49, 15);
		formToolkit.adapt(lblPriorit, true, true);
		lblPriorit.setText("Priorit\u00E9 :");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(292, 168, 171, 23);
		formToolkit.adapt(text_2, true, true);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(607, 105, 91, 23);
		formToolkit.adapt(text_3, true, true);
		
		Label lblDateDeFin = formToolkit.createLabel(composite, "Date de Fin :", SWT.NONE);
		lblDateDeFin.setBounds(514, 154, 75, 15);
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(607, 145, 91, 23);
		formToolkit.adapt(dateTime);
		formToolkit.paintBordersFor(dateTime);
		
		Label lblSprint = formToolkit.createLabel(composite, "Sprint : ", SWT.NONE);
		lblSprint.setBounds(514, 34, 45, 15);
		
		ComboViewer comboViewer_1 = new ComboViewer(composite, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(607, 28, 91, 23);
		formToolkit.paintBordersFor(combo_1);
		
		Button button = new Button(composite, SWT.NONE);
		button.setText("Valider");
		button.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/accept.png"));
		button.setBounds(498, 207, 109, 40);
		formToolkit.adapt(button, true, true);
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Annuler");
		button_1.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/cancel.png"));
		button_1.setBounds(613, 207, 109, 40);
		formToolkit.adapt(button_1, true, true);
		
		Button btnSupprimerUserstory = new Button(composite, SWT.NONE);
		btnSupprimerUserstory.setImage(SWTResourceManager.getImage(VAddUserStorie.class, "/net/images/delete_UserStory.png"));
		btnSupprimerUserstory.setBounds(333, 207, 152, 40);
		formToolkit.adapt(btnSupprimerUserstory, true, true);
		btnSupprimerUserstory.setText("Supprimer UserStory");
		composite.setTabList(new Control[]{btnAjouterUneUserstorie, text, text_1, text_2, combo_1, combo, text_3, dateTime, button, button_1, btnSupprimerUserstory});
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
