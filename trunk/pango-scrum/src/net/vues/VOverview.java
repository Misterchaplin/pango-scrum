package net.vues;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class VOverview {

	protected Shell shell;
	private Table tableToDo;
	private TableViewer tableViewer;

	private Table tableInProgress;
	private Table tableDone;
	private Table tableSprintRecent;
	private TableViewer TableVOverview;
	private TableViewer tableViewer2;

	private TableViewer tableViewer3;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VOverview window = new VOverview();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	public TableViewer getTableViewer2() {
		return tableViewer2;
	}

	public void setTableViewer2(TableViewer tableViewer2) {
		this.tableViewer2 = tableViewer2;
	}

	public TableViewer getTableViewer3() {
		return tableViewer3;
	}

	public void setTableViewer3(TableViewer tableViewer3) {
		this.tableViewer3 = tableViewer3;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashFormContainOverview = new SashForm(shell, SWT.VERTICAL);

		SashForm sashForm = new SashForm(sashFormContainOverview, SWT.NONE);

		SashForm sashForm_2 = new SashForm(sashForm, SWT.NONE);

		Label lblSummary = new Label(sashForm_2, SWT.NONE);
		lblSummary.setText("Summary");
		sashForm_2.setWeights(new int[] { 1 });

		SashForm sashForm_1 = new SashForm(sashForm, SWT.VERTICAL);

		TableVOverview = new TableViewer(sashForm_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprintRecent = TableVOverview.getTable();
		TableColumnLayout layout = new TableColumnLayout();
		tableSprintRecent.getParent().setLayout(layout);

		// Créer une colonne
		TableColumn col = new TableColumn(tableSprintRecent, SWT.CENTER);
		col.setWidth(415);

		// layout.setColumnData(col, new ColumnWeightData(1));
		col.setText("User case");

		// Afficher en-tête+lignes
		tableSprintRecent.setHeaderVisible(true);
		tableSprintRecent.setLinesVisible(true);

		sashForm_1.setWeights(new int[] { 244 });
		sashForm.setWeights(new int[] { 360, 421 });

		SashForm sashFormProgression = new SashForm(sashFormContainOverview, SWT.VERTICAL);

		SashForm sashFormTableProgression = new SashForm(sashFormProgression, SWT.NONE);

		tableViewer = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);

		tableToDo = tableViewer.getTable();
		// Créer une colonne
		TableColumn col1 = new TableColumn(tableToDo, SWT.CENTER);
		col1.setWidth(255);

		// layout.setColumnData(col, new ColumnWeightData(1));
		col1.setText("A faire");
		tableToDo.setHeaderVisible(true);
		tableToDo.setLinesVisible(true);

		tableViewer2 = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tableInProgress = tableViewer2.getTable();
		// Créer une colonne
		TableColumn col2 = new TableColumn(tableInProgress, SWT.CENTER);
		col2.setWidth(255);

		// layout.setColumnData(col, new ColumnWeightData(1));
		col2.setText("En cours");
		tableInProgress.setHeaderVisible(true);
		tableInProgress.setLinesVisible(true);

		tableViewer3 = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tableDone = tableViewer3.getTable();
		// Créer une colonne
		TableColumn col3 = new TableColumn(tableDone, SWT.CENTER);
		col3.setWidth(255);

		// layout.setColumnData(col, new ColumnWeightData(1));
		col3.setText("Fait");
		tableDone.setHeaderVisible(true);
		tableDone.setLinesVisible(true);

		sashFormTableProgression.setWeights(new int[] { 1, 1, 1 });
		sashFormProgression.setWeights(new int[] { 273 });
		sashFormContainOverview.setWeights(new int[] { 266, 293 });

	}

}
