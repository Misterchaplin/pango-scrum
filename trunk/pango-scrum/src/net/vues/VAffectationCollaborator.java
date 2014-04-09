package net.vues;

import net.controller.AppController;
import net.controller.ProductController;
import net.models.Collaborator;
import net.models.Playrole;
import net.models.PlayroleId;
import net.models.Role;
import net.technics.CollaboratorTvProvider;
import net.technics.DAOCollaborator;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VAffectationCollaborator {

	protected Shell shell;
	private Text txtProjet;
	private Text txtScrumMaster;
	private TableColumnLayout tLayout;
	private Table tableAffectedCollaborators;
	private Table tableUnaffectedCollaborators;

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
		shell.setLayout(new FormLayout());

		Label lblAffecterDesCollaborateurs = new Label(shell, SWT.NONE);
		FormData fd_lblAffecterDesCollaborateurs = new FormData();
		fd_lblAffecterDesCollaborateurs.bottom = new FormAttachment(0, 22);
		fd_lblAffecterDesCollaborateurs.right = new FormAttachment(0, 253);
		fd_lblAffecterDesCollaborateurs.top = new FormAttachment(0);
		fd_lblAffecterDesCollaborateurs.left = new FormAttachment(0);
		lblAffecterDesCollaborateurs.setLayoutData(fd_lblAffecterDesCollaborateurs);
		lblAffecterDesCollaborateurs.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		lblAffecterDesCollaborateurs.setText("Affectation de collaborateurs au projet\r\n");

		Label lblProjet = new Label(shell, SWT.NONE);
		FormData fd_lblProjet = new FormData();
		fd_lblProjet.right = new FormAttachment(0, 65);
		fd_lblProjet.top = new FormAttachment(0, 42);
		fd_lblProjet.left = new FormAttachment(0, 10);
		lblProjet.setLayoutData(fd_lblProjet);
		lblProjet.setText("Projet :");

		Label lblScrumMaster = new Label(shell, SWT.NONE);
		FormData fd_lblScrumMaster = new FormData();
		fd_lblScrumMaster.right = new FormAttachment(0, 101);
		fd_lblScrumMaster.top = new FormAttachment(0, 102);
		fd_lblScrumMaster.left = new FormAttachment(0, 10);
		lblScrumMaster.setLayoutData(fd_lblScrumMaster);
		lblScrumMaster.setText("Scrum master :");

		Label lblAffectedCollaborators = new Label(shell, SWT.NONE);
		FormData fd_lblAffectedCollaborators = new FormData();
		fd_lblAffectedCollaborators.right = new FormAttachment(0, 173);
		fd_lblAffectedCollaborators.top = new FormAttachment(0, 203);
		fd_lblAffectedCollaborators.left = new FormAttachment(0, 10);
		lblAffectedCollaborators.setLayoutData(fd_lblAffectedCollaborators);
		lblAffectedCollaborators.setText("Collaborateurs affectés :");

		txtProjet = new Text(shell, SWT.BORDER);
		txtProjet.setEnabled(false);
		FormData fd_txtProjet = new FormData();
		fd_txtProjet.top = new FormAttachment(lblProjet, -3, SWT.TOP);
		fd_txtProjet.left = new FormAttachment(lblProjet, 6);
		fd_txtProjet.right = new FormAttachment(0, 245);
		txtProjet.setLayoutData(fd_txtProjet);
		txtProjet.setText(ProductController.getSelectedProduct().getName());

		txtScrumMaster = new Text(shell, SWT.BORDER);
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

		Button btnReturnListProject = new Button(shell, SWT.NONE);
		FormData fd_btnReturnListProject = new FormData();
		fd_btnReturnListProject.top = new FormAttachment(lblProjet, -5, SWT.TOP);
		fd_btnReturnListProject.left = new FormAttachment(txtProjet, 6);
		fd_btnReturnListProject.right = new FormAttachment(0, 425);
		btnReturnListProject.setLayoutData(fd_btnReturnListProject);
		btnReturnListProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReturnListProject.setText("Revenir à la liste des projets");

		Button btnDefineScrumMaster = new Button(shell, SWT.NONE);
		FormData fd_btnDefineScrumMaster = new FormData();
		fd_btnDefineScrumMaster.right = new FormAttachment(0, 386);
		fd_btnDefineScrumMaster.top = new FormAttachment(0, 121);
		fd_btnDefineScrumMaster.left = new FormAttachment(0, 291);
		btnDefineScrumMaster.setLayoutData(fd_btnDefineScrumMaster);
		btnDefineScrumMaster.setText("Définir");

		final Button btnAddCollaborators = new Button(shell, SWT.NONE);
		FormData fd_btnAddCollaborators = new FormData();
		fd_btnAddCollaborators.right = new FormAttachment(0, 528);
		fd_btnAddCollaborators.top = new FormAttachment(0, 246);
		fd_btnAddCollaborators.left = new FormAttachment(0, 453);
		btnAddCollaborators.setLayoutData(fd_btnAddCollaborators);
		btnAddCollaborators.setText("<<Ajouter");
		btnAddCollaborators.setVisible(false);

		final Button btnRemoveCollaborators = new Button(shell, SWT.NONE);
		FormData fd_btnRemoveCollaborators = new FormData();
		fd_btnRemoveCollaborators.right = new FormAttachment(0, 528);
		fd_btnRemoveCollaborators.top = new FormAttachment(0, 295);
		fd_btnRemoveCollaborators.left = new FormAttachment(0, 453);
		btnRemoveCollaborators.setLayoutData(fd_btnRemoveCollaborators);
		btnRemoveCollaborators.setText(">>Retirer");
		btnRemoveCollaborators.setVisible(false);

		Label lblUnaffectedCollaborators = new Label(shell, SWT.NONE);
		FormData fd_lblUnaffectedCollaborators = new FormData();
		fd_lblUnaffectedCollaborators.right = new FormAttachment(0, 800);
		fd_lblUnaffectedCollaborators.top = new FormAttachment(0, 203);
		fd_lblUnaffectedCollaborators.left = new FormAttachment(0, 621);
		lblUnaffectedCollaborators.setLayoutData(fd_lblUnaffectedCollaborators);
		lblUnaffectedCollaborators.setText("Collaborateurs non affectés :");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new TableColumnLayout());
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(lblAffectedCollaborators, 440, SWT.BOTTOM);
		fd_composite.right = new FormAttachment(0, 403);
		fd_composite.top = new FormAttachment(lblAffectedCollaborators, 6);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);

		final TableViewer tvAffectedCollaborators = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableAffectedCollaborators = tvAffectedCollaborators.getTable();
		tableAffectedCollaborators.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnRemoveCollaborators.setVisible(true);
				btnAddCollaborators.setVisible(false);
			}
		});
		tableAffectedCollaborators.setHeaderVisible(true);
		tableAffectedCollaborators.setLinesVisible(true);
		tvAffectedCollaborators.setContentProvider(new ArrayContentProvider());
		tvAffectedCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvAffectedCollaborators.setInput(DAOCollaborator.getAffectedCollaborators());

		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new TableColumnLayout());
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(composite, 0, SWT.BOTTOM);
		fd_composite_1.top = new FormAttachment(lblUnaffectedCollaborators, 6);
		fd_composite_1.left = new FormAttachment(btnAddCollaborators, 91);
		fd_composite_1.right = new FormAttachment(100, -32);
		composite_1.setLayoutData(fd_composite_1);

		final TableViewer tvUnaffectedCollaborators = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableUnaffectedCollaborators = tvUnaffectedCollaborators.getTable();
		tableUnaffectedCollaborators.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnAddCollaborators.setVisible(true);
				btnRemoveCollaborators.setVisible(false);
			}
		});
		tableUnaffectedCollaborators.setHeaderVisible(true);
		tableUnaffectedCollaborators.setLinesVisible(true);
		tvUnaffectedCollaborators.setContentProvider(new ArrayContentProvider());
		tvUnaffectedCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvUnaffectedCollaborators.setInput(DAOCollaborator.getUnaffectedCollaborators());

		btnAddCollaborators.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// récupération collaborateur sélectionné
				StructuredSelection selection = (StructuredSelection) tvUnaffectedCollaborators.getSelection();
				Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();

				// création instance de playroleId
				int idRole = 3;
				Integer idProduct = ProductController.getSelectedProduct().getId();
				Integer idCollaborator = selectedCollaborator.getId();
				PlayroleId playroleId = new PlayroleId(idCollaborator, idRole, idProduct);

				// récupération du rôle
				Session session = AppController.session;
				Transaction trans = session.beginTransaction();
				Role role = (Role) AppController.session.get(Role.class, 3);
				trans.commit();

				// création instance de playrole
				Playrole playrole = new Playrole(playroleId, role, ProductController.getSelectedProduct(), selectedCollaborator);
				Transaction transSave = session.beginTransaction();
				session.persist(playrole);
				transSave.commit();

				tvAffectedCollaborators.setInput(DAOCollaborator.getAffectedCollaborators());
				tvUnaffectedCollaborators.setInput(DAOCollaborator.getUnaffectedCollaborators());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnRemoveCollaborators.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// récupération du collaborateur sélectionné
				StructuredSelection selection = (StructuredSelection) tvAffectedCollaborators.getSelection();
				Collaborator selectedCollaborator = (Collaborator) selection.getFirstElement();

				// récupération id collaborateur
				Integer idCollaborator = selectedCollaborator.getId();

				// récupération id produit
				Integer idProduct = ProductController.getSelectedProduct().getId();

				// instanciation nouvel objet
				PlayroleId roleJoueId = new PlayroleId(idCollaborator, 3, idProduct);

				// enregistrement dans la base de données
				Session session = AppController.session;
				Transaction trans = session.beginTransaction();
				Playrole playrole = (Playrole) session.get(Playrole.class, roleJoueId);
				session.delete(playrole);
				trans.commit();

				// mise à jour tableViewer
				tvAffectedCollaborators.setInput(DAOCollaborator.getAffectedCollaborators());
				tvUnaffectedCollaborators.setInput(DAOCollaborator.getUnaffectedCollaborators());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
