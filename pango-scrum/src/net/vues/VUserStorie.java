package net.vues;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;

public class VUserStorie {

	protected Shell userStorie;
	private Table tblProductBacklog;
	private Table tblSprintBacklog;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VUserStorie window = new VUserStorie();
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
		userStorie.open();
		userStorie.layout();
		while (!userStorie.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		userStorie = new Shell();
		userStorie.setSize(800, 600);
		userStorie.setText("Planning");
		userStorie.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashPlanning = new SashForm(userStorie, SWT.VERTICAL);
		
		SashForm sashProductBacklog = new SashForm(sashPlanning, SWT.NONE);
		
		Composite descProductBacklog = new Composite(sashProductBacklog, SWT.NONE);
		
		Label lblProductBacklogOf = new Label(descProductBacklog, SWT.NONE);
		lblProductBacklogOf.setBounds(21, 42, 110, 15);
		lblProductBacklogOf.setText("Product Backlog of");
		
		ComboViewer cbvProductBacklog = new ComboViewer(descProductBacklog, SWT.NONE);
		Combo cbProductBacklog = cbvProductBacklog.getCombo();
		cbProductBacklog.setBounds(137, 31, 91, 23);
		
		Label lblSelect = new Label(descProductBacklog, SWT.NONE);
		lblSelect.setBounds(21, 87, 55, 15);
		lblSelect.setText("Select : ");
		
		Button btnAddUserStorie = new Button(descProductBacklog, SWT.NONE);
		btnAddUserStorie.setBounds(305, 87, 75, 25);
		btnAddUserStorie.setText("add");
		
		Composite descSprintBacklog = new Composite(sashProductBacklog, SWT.NONE);
		
		Label lblSprintBacklog = new Label(descSprintBacklog, SWT.NONE);
		lblSprintBacklog.setBounds(27, 47, 85, 15);
		lblSprintBacklog.setText("Sprint Backlog");
		sashProductBacklog.setWeights(new int[] {1, 1});
		
		
		
		SashForm sashSprintBacklog = new SashForm(sashPlanning, SWT.NONE);
		
		Composite lstProductBacklog = new Composite(sashSprintBacklog, SWT.NONE);
		lstProductBacklog.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TableViewer tblvProductBacklog = new TableViewer(lstProductBacklog, SWT.BORDER | SWT.FULL_SELECTION);
		tblProductBacklog = tblvProductBacklog.getTable();
		tblProductBacklog.setLinesVisible(true);
		tblProductBacklog.setHeaderVisible(true);
		
		Composite lstSprintBacklog = new Composite(sashSprintBacklog, SWT.NONE);
		lstSprintBacklog.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TableViewer tblvSprintBacklog = new TableViewer(lstSprintBacklog, SWT.BORDER | SWT.FULL_SELECTION);
		tblSprintBacklog = tblvSprintBacklog.getTable();
		tblSprintBacklog.setLinesVisible(true);
		tblSprintBacklog.setHeaderVisible(true);
		sashSprintBacklog.setWeights(new int[] {1, 1});
		sashPlanning.setWeights(new int[] {121, 437});

	}
}
