package net.vues;

import net.controller.ProductController;
import net.models.Collaborator;
import net.technics.CollaboratorTvProvider;
import net.technics.DAOCollaborator;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAffectationCollaborator {

	protected Shell vAffectationCollaborator;
	private Text txtProjet;
	private Text txtScrumMaster;
	private TableColumnLayout tLayout;
	private Table tableAffectedCollaborators;
	private Table tableUnaffectedCollaborators;
	private Button btnReturnListProject;
	private Button btnDefineScrumMaster;
	private Button btnAddCollaborators;
	private Button btnRemoveCollaborators;
	private TableViewer tvAffectedCollaborators;
	private TableViewer tvUnaffectedCollaborators;

	public Table getTableAffectedCollaborators() {
		return tableAffectedCollaborators;
	}

	public Table getTableUnaffectedCollaborators() {
		return tableUnaffectedCollaborators;
	}

	public Button getBtnReturnListProject() {
		return btnReturnListProject;
	}

	public Button getBtnDefineScrumMaster() {
		return btnDefineScrumMaster;
	}

	public Button getBtnAddCollaborators() {
		return btnAddCollaborators;
	}

	public Button getBtnRemoveCollaborators() {
		return btnRemoveCollaborators;
	}

	public TableViewer getTvAffectedCollaborators() {
		return tvAffectedCollaborators;
	}

	public TableViewer getTvUnaffectedCollaborators() {
		return tvUnaffectedCollaborators;
	}

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
		vAffectationCollaborator.open();
		vAffectationCollaborator.layout();
		while (!vAffectationCollaborator.isDisposed()) {
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
		vAffectationCollaborator = new Shell();
		vAffectationCollaborator.setSize(1024, 706);
		vAffectationCollaborator.setText("SWT Application");
		vAffectationCollaborator.setLayout(new FormLayout());

		Label lblAffecterDesCollaborateurs = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblAffecterDesCollaborateurs = new FormData();
		fd_lblAffecterDesCollaborateurs.bottom = new FormAttachment(0, 22);
		fd_lblAffecterDesCollaborateurs.right = new FormAttachment(0, 253);
		fd_lblAffecterDesCollaborateurs.top = new FormAttachment(0);
		fd_lblAffecterDesCollaborateurs.left = new FormAttachment(0);
		lblAffecterDesCollaborateurs.setLayoutData(fd_lblAffecterDesCollaborateurs);
		lblAffecterDesCollaborateurs.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		lblAffecterDesCollaborateurs.setText("Affectation de collaborateurs au projet\r\n");

		Label lblProjet = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblProjet = new FormData();
		fd_lblProjet.right = new FormAttachment(0, 65);
		fd_lblProjet.top = new FormAttachment(0, 42);
		fd_lblProjet.left = new FormAttachment(0, 10);
		lblProjet.setLayoutData(fd_lblProjet);
		lblProjet.setText("Projet :");

		Label lblScrumMaster = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblScrumMaster = new FormData();
		fd_lblScrumMaster.right = new FormAttachment(0, 101);
		fd_lblScrumMaster.top = new FormAttachment(0, 102);
		fd_lblScrumMaster.left = new FormAttachment(0, 10);
		lblScrumMaster.setLayoutData(fd_lblScrumMaster);
		lblScrumMaster.setText("Scrum master :");

		Label lblAffectedCollaborators = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblAffectedCollaborators = new FormData();
		fd_lblAffectedCollaborators.right = new FormAttachment(0, 173);
		fd_lblAffectedCollaborators.top = new FormAttachment(0, 203);
		fd_lblAffectedCollaborators.left = new FormAttachment(0, 10);
		lblAffectedCollaborators.setLayoutData(fd_lblAffectedCollaborators);
		lblAffectedCollaborators.setText("Collaborateurs affectés :");

		txtProjet = new Text(vAffectationCollaborator, SWT.BORDER);
		txtProjet.setEnabled(false);
		FormData fd_txtProjet = new FormData();
		fd_txtProjet.top = new FormAttachment(lblProjet, -3, SWT.TOP);
		fd_txtProjet.left = new FormAttachment(lblProjet, 6);
		fd_txtProjet.right = new FormAttachment(0, 245);
		txtProjet.setLayoutData(fd_txtProjet);
		txtProjet.setText(ProductController.getSelectedProduct().getName());

		txtScrumMaster = new Text(vAffectationCollaborator, SWT.BORDER);
		txtScrumMaster.setEnabled(false);
		FormData fd_txtScrumMaster = new FormData();
		fd_txtScrumMaster.right = new FormAttachment(0, 285);
		fd_txtScrumMaster.top = new FormAttachment(0, 123);
		fd_txtScrumMaster.left = new FormAttachment(0, 10);
		txtScrumMaster.setLayoutData(fd_txtScrumMaster);
		// récupération du scrum master
		Collaborator scrumMaster = DAOCollaborator.getScrumMaster();
		if ((scrumMaster.getFirstname() != null) && (scrumMaster.getLastname() != null)) {
			txtScrumMaster.setText(scrumMaster.getFirstname() + " " + scrumMaster.getLastname());
		}

		btnReturnListProject = new Button(vAffectationCollaborator, SWT.NONE);
		FormData fd_btnReturnListProject = new FormData();
		fd_btnReturnListProject.top = new FormAttachment(lblProjet, -5, SWT.TOP);
		fd_btnReturnListProject.left = new FormAttachment(txtProjet, 6);
		fd_btnReturnListProject.right = new FormAttachment(0, 425);
		btnReturnListProject.setLayoutData(fd_btnReturnListProject);
		btnReturnListProject.setText("Revenir à la liste des projets");

		btnDefineScrumMaster = new Button(vAffectationCollaborator, SWT.NONE);
		FormData fd_btnDefineScrumMaster = new FormData();
		fd_btnDefineScrumMaster.right = new FormAttachment(0, 386);
		fd_btnDefineScrumMaster.top = new FormAttachment(0, 121);
		fd_btnDefineScrumMaster.left = new FormAttachment(0, 291);
		btnDefineScrumMaster.setLayoutData(fd_btnDefineScrumMaster);
		btnDefineScrumMaster.setText("Définir");

		btnAddCollaborators = new Button(vAffectationCollaborator, SWT.NONE);
		FormData fd_btnAddCollaborators = new FormData();
		fd_btnAddCollaborators.right = new FormAttachment(0, 528);
		fd_btnAddCollaborators.top = new FormAttachment(0, 246);
		fd_btnAddCollaborators.left = new FormAttachment(0, 453);
		btnAddCollaborators.setLayoutData(fd_btnAddCollaborators);
		btnAddCollaborators.setText("<<Ajouter");
		btnAddCollaborators.setVisible(false);

		btnRemoveCollaborators = new Button(vAffectationCollaborator, SWT.NONE);
		FormData fd_btnRemoveCollaborators = new FormData();
		fd_btnRemoveCollaborators.right = new FormAttachment(0, 528);
		fd_btnRemoveCollaborators.top = new FormAttachment(0, 295);
		fd_btnRemoveCollaborators.left = new FormAttachment(0, 453);
		btnRemoveCollaborators.setLayoutData(fd_btnRemoveCollaborators);
		btnRemoveCollaborators.setText(">>Retirer");
		btnRemoveCollaborators.setVisible(false);

		Label lblUnaffectedCollaborators = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblUnaffectedCollaborators = new FormData();
		fd_lblUnaffectedCollaborators.right = new FormAttachment(0, 800);
		fd_lblUnaffectedCollaborators.top = new FormAttachment(0, 203);
		fd_lblUnaffectedCollaborators.left = new FormAttachment(0, 621);
		lblUnaffectedCollaborators.setLayoutData(fd_lblUnaffectedCollaborators);
		lblUnaffectedCollaborators.setText("Collaborateurs non affectés :");

		Composite composite = new Composite(vAffectationCollaborator, SWT.NONE);
		composite.setLayout(new TableColumnLayout());
		tLayout = new TableColumnLayout();
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(lblAffectedCollaborators, 440, SWT.BOTTOM);
		fd_composite.right = new FormAttachment(0, 403);
		fd_composite.top = new FormAttachment(lblAffectedCollaborators, 6);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);

		tvAffectedCollaborators = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableAffectedCollaborators = tvAffectedCollaborators.getTable();
		tableAffectedCollaborators.setHeaderVisible(true);
		tableAffectedCollaborators.setLinesVisible(true);
		tvAffectedCollaborators.setContentProvider(new ArrayContentProvider());
		tvAffectedCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvAffectedCollaborators.setInput(DAOCollaborator.getAffectedCollaborators());

		Composite composite_1 = new Composite(vAffectationCollaborator, SWT.NONE);
		composite_1.setLayout(new TableColumnLayout());
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(composite, 0, SWT.BOTTOM);
		fd_composite_1.top = new FormAttachment(lblUnaffectedCollaborators, 6);
		fd_composite_1.left = new FormAttachment(btnAddCollaborators, 91);
		fd_composite_1.right = new FormAttachment(100, -32);
		composite_1.setLayoutData(fd_composite_1);

		tvUnaffectedCollaborators = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableUnaffectedCollaborators = tvUnaffectedCollaborators.getTable();
		tableUnaffectedCollaborators.setHeaderVisible(true);
		tableUnaffectedCollaborators.setLinesVisible(true);
		tvUnaffectedCollaborators.setContentProvider(new ArrayContentProvider());
		tvUnaffectedCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvUnaffectedCollaborators.setInput(DAOCollaborator.getUnaffectedCollaborators());

		createColumn(tableAffectedCollaborators, "Nom", 1);
		createColumn(tableUnaffectedCollaborators, "Nom", 1);

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
