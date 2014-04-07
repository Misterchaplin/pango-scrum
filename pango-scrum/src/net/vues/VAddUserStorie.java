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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class VAddUserStorie {

	protected Shell ShlProductBacklog;
	private Table tblTodo;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtaddUserstorie;
	private Button btnAddUserStorie;
	private Label lblAddUserstorie;
	private TableViewer tableViewer;

	
	
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
		
		TabItem tbtmTodo = new TabItem(tbfProductBacklog, SWT.NONE);
		tbtmTodo.setText("To-Do");
		
		SashForm sashToDo = new SashForm(tbfProductBacklog, SWT.VERTICAL);
		tbtmTodo.setControl(sashToDo);
		
		SashForm sashTo1 = new SashForm(sashToDo, SWT.NONE);
		
		Composite composite = new Composite(sashTo1, SWT.NONE);
		composite.setLayout(null);
		
		btnAddUserStorie = new Button(composite, SWT.NONE);
		btnAddUserStorie.setBounds(212, 51, 75, 25);
		btnAddUserStorie.setText("add");
		
		txtaddUserstorie = new Text(composite, SWT.BORDER);
		txtaddUserstorie.setBounds(91, 53, 91, 21);
		formToolkit.adapt(txtaddUserstorie, true, true);
		
		lblAddUserstorie = new Label(composite, SWT.NONE);
		lblAddUserstorie.setBounds(10, 56, 75, 15);
		formToolkit.adapt(lblAddUserstorie, true, true);
		lblAddUserstorie.setText("Userstories :");
		
		ComboViewer cbvProjet = new ComboViewer(composite, SWT.NONE);
		Combo cbProjet = cbvProjet.getCombo();
		cbProjet.setBounds(91, 10, 91, 23);
		formToolkit.paintBordersFor(cbProjet);
		
		Label lblProjet = new Label(composite, SWT.NONE);
		lblProjet.setBounds(30, 13, 40, 15);
		formToolkit.adapt(lblProjet, true, true);
		lblProjet.setText("Projet : ");
		sashTo1.setWeights(new int[] {1});
		
		SashForm sashTo2 = new SashForm(sashToDo, SWT.NONE);
		
		tableViewer = new TableViewer(sashTo2, SWT.BORDER | SWT.FULL_SELECTION);
		tblTodo = tableViewer.getTable();
		tblTodo.setLinesVisible(true);
		tblTodo.setHeaderVisible(true);
		sashTo2.setWeights(new int[] {1});
		sashToDo.setWeights(new int[] {86, 444});
		
		TabItem tbtmInProgress = new TabItem(tbfProductBacklog, SWT.NONE);
		tbtmInProgress.setText("In Progress");
		
		SashForm sashInProgress = new SashForm(tbfProductBacklog, SWT.VERTICAL);
		tbtmInProgress.setControl(sashInProgress);
		
		SashForm sashIn1 = new SashForm(sashInProgress, SWT.NONE);
		
		SashForm sashIn2 = new SashForm(sashInProgress, SWT.NONE);
		sashInProgress.setWeights(new int[] {1, 3});
		
		SashForm sashForm_6 = new SashForm(tbfProductBacklog, SWT.NONE);
		tbtmInProgress.setControl(sashForm_6);
		
		SashForm sashForm_7 = new SashForm(tbfProductBacklog, SWT.NONE);
		tbtmInProgress.setControl(sashForm_7);
		
		TabItem tbtmDone = new TabItem(tbfProductBacklog, SWT.NONE);
		tbtmDone.setText("Done");
		
		SashForm sashDone = new SashForm(tbfProductBacklog, SWT.VERTICAL);
		tbtmDone.setControl(sashDone);
		
		SashForm sashDone1 = new SashForm(sashDone, SWT.NONE);
		
		SashForm sashDone2 = new SashForm(sashDone, SWT.NONE);
		sashDone.setWeights(new int[] {79, 451});
		sashGeneralProductBackLog.setWeights(new int[] {1});

	}
}
