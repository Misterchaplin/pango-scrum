package net.vues;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class VOverview {

	protected Shell shell;
	private Table tableToDo;
	private TableViewer tableViewer;
	private Table tableInProgress;
	private Table tableDone;
	private Table tableSprintRecent;

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
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
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

		Label lblSprintRecent = new Label(sashForm_1, SWT.NONE);
		lblSprintRecent.setText("Sprint recent");

		TableViewer tableViewer_3 = new TableViewer(sashForm_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprintRecent = tableViewer_3.getTable();
		sashForm_1.setWeights(new int[] { 46, 244 });
		sashForm.setWeights(new int[] { 1, 1 });

		SashForm sashFormProgression = new SashForm(sashFormContainOverview, SWT.VERTICAL);

		SashForm sashFormTableProgressionLabel = new SashForm(sashFormProgression, SWT.NONE);

		Label lblToDo = new Label(sashFormTableProgressionLabel, SWT.CENTER);
		lblToDo.setText("To do");

		Label lblInProgress = new Label(sashFormTableProgressionLabel, SWT.CENTER);
		lblInProgress.setText("In progress");

		Label lblDone = new Label(sashFormTableProgressionLabel, SWT.CENTER);
		lblDone.setText("Done");
		sashFormTableProgressionLabel.setWeights(new int[] { 1, 1, 1 });

		SashForm sashFormTableProgression = new SashForm(sashFormProgression, SWT.NONE);

		tableViewer = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tableToDo = tableViewer.getTable();

		TableViewer tableViewer_1 = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tableInProgress = tableViewer_1.getTable();

		TableViewer tableViewer_2 = new TableViewer(sashFormTableProgression, SWT.BORDER | SWT.FULL_SELECTION);
		tableDone = tableViewer_2.getTable();
		sashFormTableProgression.setWeights(new int[] { 1, 1, 1 });
		sashFormProgression.setWeights(new int[] { 52, 233 });
		sashFormContainOverview.setWeights(new int[] { 266, 293 });

	}
}
