package net.vues;

import net.technics.CollaboratorTvProvider;
import net.technics.DAOCollaborator;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAffectationCollaborator {

	protected Shell shell;
	private Text txtProjet;
	private Text txtScrumMaster;
	private Table table;
	private Table tableAffectedCollaborators;
	private TableColumnLayout tLayout;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VAffectationCollaborator window = new VAffectationCollaborator();
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
		shell.setSize(1024, 706);
		shell.setText("SWT Application");

		Label lblAffecterDesCollaborateurs = new Label(shell, SWT.NONE);
		lblAffecterDesCollaborateurs.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		lblAffecterDesCollaborateurs.setBounds(0, 0, 253, 22);
		lblAffecterDesCollaborateurs.setText("Affectation de collaborateurs au projet\r\n");

		Label lblProjet = new Label(shell, SWT.NONE);
		lblProjet.setBounds(10, 42, 55, 15);
		lblProjet.setText("Projet :");

		Label lblScrumMaster = new Label(shell, SWT.NONE);
		lblScrumMaster.setBounds(10, 102, 91, 15);
		lblScrumMaster.setText("Scrum master :");

		Label lblCollaborateur = new Label(shell, SWT.NONE);
		lblCollaborateur.setBounds(10, 203, 163, 15);
		lblCollaborateur.setText("Collaborateurs affectés :");

		txtProjet = new Text(shell, SWT.BORDER);
		txtProjet.setBounds(111, 42, 174, 21);

		txtScrumMaster = new Text(shell, SWT.BORDER);
		txtScrumMaster.setBounds(10, 123, 275, 21);

		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(621, 224, 377, 434);

		Button btnReturnListProject = new Button(shell, SWT.NONE);
		btnReturnListProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReturnListProject.setBounds(291, 42, 174, 25);
		btnReturnListProject.setText("Revenir à la liste des projets");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(291, 121, 95, 25);
		btnNewButton_1.setText("Définir");

		TableViewer tvAffectedCollaborators = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableAffectedCollaborators = tvAffectedCollaborators.getTable();
		tableAffectedCollaborators.setBounds(10, 224, 377, 434);
		tableAffectedCollaborators.setHeaderVisible(true);
		tableAffectedCollaborators.setLinesVisible(true);
		tvAffectedCollaborators.setContentProvider(new ArrayContentProvider());
		tvAffectedCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvAffectedCollaborators.setInput(DAOCollaborator.getAffectedCollaborators());

		createColumn(tableAffectedCollaborators, "Nom", 1);

		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(453, 246, 75, 25);
		btnNewButton_2.setText("<<Ajouter");

		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.setBounds(453, 295, 75, 25);
		btnNewButton_3.setText(">>Retirer");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(621, 203, 179, 15);
		lblNewLabel.setText("Collaborateurs non affectés :");

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
