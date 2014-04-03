package net.vues;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
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
		shell.setLayout(null);

		tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableToDo = tableViewer.getTable();
		tableToDo.setBounds(10, 343, 242, 209);

		TableViewer tableViewer_1 = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableInProgress = tableViewer_1.getTable();
		tableInProgress.setBounds(270, 343, 242, 209);

		TableViewer tableViewer_2 = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableDone = tableViewer_2.getTable();
		tableDone.setBounds(532, 343, 242, 209);

		Label lblToDo = new Label(shell, SWT.NONE);
		lblToDo.setBounds(33, 322, 55, 15);
		lblToDo.setText("To do");

		Label lblInProgress = new Label(shell, SWT.NONE);
		lblInProgress.setBounds(287, 322, 63, 15);
		lblInProgress.setText("In progress");

		Label lblDone = new Label(shell, SWT.NONE);
		lblDone.setBounds(547, 322, 55, 15);
		lblDone.setText("Done");

		TableViewer tableViewer_3 = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprintRecent = tableViewer_3.getTable();
		tableSprintRecent.setBounds(270, 72, 504, 209);

		Label lblSprintRecent = new Label(shell, SWT.NONE);
		lblSprintRecent.setBounds(287, 38, 90, 15);
		lblSprintRecent.setText("Sprint recent");

	}
}
