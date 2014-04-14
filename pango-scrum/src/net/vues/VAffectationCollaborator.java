package net.vues;

import net.controller.ProductController;
import net.controller.ProduitController;
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
import org.eclipse.swt.widgets.Group;
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
	private Group grpProjet;
	private Label label;

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

	public Shell getvAffectationCollaborator() {
		return vAffectationCollaborator;
	}

	public Text getTxtScrumMaster() {
		return txtScrumMaster;
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
		ProduitController.nbOpenedWindowaffectation=0;
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
		vAffectationCollaborator.setImage(SWTResourceManager.getImage(VAffectationCollaborator.class, "/net/images/logo.PNG"));
		vAffectationCollaborator.setSize(764, 556);
		vAffectationCollaborator.setText("Scrum Tool - Gestion des produits");
		vAffectationCollaborator.setLayout(new FormLayout());
		vAffectationCollaborator.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblAffecterDesCollaborateurs = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblAffecterDesCollaborateurs = new FormData();
		fd_lblAffecterDesCollaborateurs.top = new FormAttachment(0);
		fd_lblAffecterDesCollaborateurs.bottom = new FormAttachment(0, 15);
		fd_lblAffecterDesCollaborateurs.right = new FormAttachment(0, 263);
		lblAffecterDesCollaborateurs.setLayoutData(fd_lblAffecterDesCollaborateurs);
		lblAffecterDesCollaborateurs.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblAffecterDesCollaborateurs.setText("Affectation de collaborateurs au projet\r\n");
		lblAffecterDesCollaborateurs.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblAffectedCollaborators = new Label(vAffectationCollaborator, SWT.NONE);
		fd_lblAffecterDesCollaborateurs.left = new FormAttachment(lblAffectedCollaborators, 0, SWT.LEFT);
		FormData fd_lblAffectedCollaborators = new FormData();
		fd_lblAffectedCollaborators.top = new FormAttachment(0, 117);
		fd_lblAffectedCollaborators.left = new FormAttachment(0, 10);
		fd_lblAffectedCollaborators.right = new FormAttachment(0, 173);
		lblAffectedCollaborators.setLayoutData(fd_lblAffectedCollaborators);
		lblAffectedCollaborators.setText("Collaborateurs affectés :");
		lblAffectedCollaborators.setBackground(SWTResourceManager.getColor(255, 255, 240));

		btnAddCollaborators = new Button(vAffectationCollaborator, SWT.NONE);
		FormData fd_btnAddCollaborators = new FormData();
		btnAddCollaborators.setLayoutData(fd_btnAddCollaborators);
		btnAddCollaborators.setText("<<Ajouter");
		btnAddCollaborators.setVisible(true);

		btnRemoveCollaborators = new Button(vAffectationCollaborator, SWT.NONE);
		fd_btnAddCollaborators.bottom = new FormAttachment(100, -256);
		FormData fd_btnRemoveCollaborators = new FormData();
		fd_btnRemoveCollaborators.top = new FormAttachment(btnAddCollaborators, 22);
		fd_btnRemoveCollaborators.right = new FormAttachment(btnAddCollaborators, 0, SWT.RIGHT);
		fd_btnRemoveCollaborators.bottom = new FormAttachment(100, -209);
		btnRemoveCollaborators.setLayoutData(fd_btnRemoveCollaborators);
		btnRemoveCollaborators.setText(">>Retirer");
		btnRemoveCollaborators.setVisible(true);

		Label lblUnaffectedCollaborators = new Label(vAffectationCollaborator, SWT.NONE);
		FormData fd_lblUnaffectedCollaborators = new FormData();
		fd_lblUnaffectedCollaborators.top = new FormAttachment(lblAffectedCollaborators, 0, SWT.TOP);
		fd_lblUnaffectedCollaborators.right = new FormAttachment(100, -77);
		fd_lblUnaffectedCollaborators.bottom = new FormAttachment(100, -379);
		lblUnaffectedCollaborators.setLayoutData(fd_lblUnaffectedCollaborators);
		lblUnaffectedCollaborators.setText("Collaborateurs non affectés :");
		lblUnaffectedCollaborators.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Composite composite = new Composite(vAffectationCollaborator, SWT.NONE);
		fd_btnRemoveCollaborators.left = new FormAttachment(composite, 28);
		fd_btnAddCollaborators.left = new FormAttachment(composite, 28);
		composite.setLayout(new TableColumnLayout());
		tLayout = new TableColumnLayout();
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(lblAffectedCollaborators, 13);
		fd_composite.left = new FormAttachment(lblAffectedCollaborators, 0, SWT.LEFT);
		fd_composite.bottom = new FormAttachment(100, -10);
		fd_composite.right = new FormAttachment(0, 301);
		composite.setLayoutData(fd_composite);

		tvAffectedCollaborators = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableAffectedCollaborators = tvAffectedCollaborators.getTable();
		tableAffectedCollaborators.setHeaderVisible(true);
		tableAffectedCollaborators.setLinesVisible(true);
		tvAffectedCollaborators.setContentProvider(new ArrayContentProvider());
		tvAffectedCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvAffectedCollaborators.setInput(DAOCollaborator.getAffectedCollaborators());

		Composite composite_1 = new Composite(vAffectationCollaborator, SWT.NONE);
		fd_lblUnaffectedCollaborators.left = new FormAttachment(composite_1, 0, SWT.LEFT);
		fd_btnAddCollaborators.right = new FormAttachment(composite_1, -40);
		composite_1.setLayout(new TableColumnLayout());
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(100, -10);
		fd_composite_1.top = new FormAttachment(lblUnaffectedCollaborators, 6);
		fd_composite_1.right = new FormAttachment(0, 738);
		fd_composite_1.left = new FormAttachment(0, 447);
		composite_1.setLayoutData(fd_composite_1);

		tvUnaffectedCollaborators = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableUnaffectedCollaborators = tvUnaffectedCollaborators.getTable();
		tableUnaffectedCollaborators.setHeaderVisible(true);
		tableUnaffectedCollaborators.setLinesVisible(true);

		grpProjet = new Group(vAffectationCollaborator, SWT.NONE);
		grpProjet.setText("Projet");
		FormData fd_grpProjet = new FormData();
		fd_grpProjet.bottom = new FormAttachment(lblAffectedCollaborators, -6);
		fd_grpProjet.left = new FormAttachment(0, 10);
		fd_grpProjet.right = new FormAttachment(100, -10);
		grpProjet.setLayoutData(fd_grpProjet);
		grpProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));

		txtProjet = new Text(grpProjet, SWT.BORDER);
		txtProjet.setBounds(10, 30, 174, 21);
		txtProjet.setEnabled(false);
		txtProjet.setText(ProductController.getSelectedProduct().getName());

		btnReturnListProject = new Button(grpProjet, SWT.NONE);
		btnReturnListProject.setBounds(190, 28, 174, 25);
		btnReturnListProject.setText("Revenir à la liste des projets");

		Label lblScrumMaster = new Label(grpProjet, SWT.NONE);
		lblScrumMaster.setBounds(397, 9, 91, 15);
		lblScrumMaster.setText("Scrum master :");
		lblScrumMaster.setBackground(SWTResourceManager.getColor(255, 255, 240));

		txtScrumMaster = new Text(grpProjet, SWT.BORDER);
		txtScrumMaster.setBounds(397, 30, 242, 21);
		txtScrumMaster.setEnabled(false);

		btnDefineScrumMaster = new Button(grpProjet, SWT.NONE);
		btnDefineScrumMaster.setBounds(645, 28, 73, 25);
		btnDefineScrumMaster.setText("Définir...");

		label = new Label(vAffectationCollaborator, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_grpProjet.top = new FormAttachment(label, 21);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(lblAffecterDesCollaborateurs, 6);
		fd_label.left = new FormAttachment(lblAffecterDesCollaborateurs, 0, SWT.LEFT);
		fd_label.bottom = new FormAttachment(100, -495);
		fd_label.right = new FormAttachment(0, 685);
		label.setLayoutData(fd_label);
		// récupération du scrum master
		Collaborator scrumMaster = DAOCollaborator.getScrumMaster();
		if ((scrumMaster.getFirstname() != null) && (scrumMaster.getLastname() != null)) {
			txtScrumMaster.setText(scrumMaster.getFirstname() + " " + scrumMaster.getLastname());
		}

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