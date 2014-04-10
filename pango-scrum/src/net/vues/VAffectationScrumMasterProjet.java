package net.vues;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class VAffectationScrumMasterProjet {

	protected Shell shell;
	private Table tableCollaboratorsScrumMaster;
	private TableViewer tvCollaboratorsScrumMaster;
	private TableColumnLayout tLayout;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VAffectationScrumMasterProjet window = new VAffectationScrumMasterProjet();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void init() {
		createContents();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(355, 391);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());

		Label lblAffecterScrumMasterProjet = new Label(shell, SWT.NONE);
		FormData fd_lblAffecterScrumMasterProjet = new FormData();
		fd_lblAffecterScrumMasterProjet.right = new FormAttachment(0, 269);
		fd_lblAffecterScrumMasterProjet.top = new FormAttachment(0);
		fd_lblAffecterScrumMasterProjet.left = new FormAttachment(0, 58);
		lblAffecterScrumMasterProjet.setLayoutData(fd_lblAffecterScrumMasterProjet);
		lblAffecterScrumMasterProjet.setText("Affecter un scrum master au projet");

		Label lblChoisirUnScrumMaster = new Label(shell, SWT.NONE);
		FormData fd_lblChoisirUnScrumMaster = new FormData();
		fd_lblChoisirUnScrumMaster.right = new FormAttachment(0, 244);
		fd_lblChoisirUnScrumMaster.top = new FormAttachment(0, 45);
		fd_lblChoisirUnScrumMaster.left = new FormAttachment(0);
		lblChoisirUnScrumMaster.setLayoutData(fd_lblChoisirUnScrumMaster);
		lblChoisirUnScrumMaster.setText("Choisir un Scrum Master pour le projet :");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 66, 64, 64);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0, 66);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		tLayout = new TableColumnLayout();
		composite.setLayout(new TableColumnLayout());

		tvCollaboratorsScrumMaster = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableCollaboratorsScrumMaster = tvCollaboratorsScrumMaster.getTable();
		tableCollaboratorsScrumMaster.setHeaderVisible(true);
		tableCollaboratorsScrumMaster.setLinesVisible(true);

		createColumn(tableCollaboratorsScrumMaster, "Nom", 1);

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
