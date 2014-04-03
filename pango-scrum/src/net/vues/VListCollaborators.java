package net.vues;

import java.util.List;

import net.models.Collaborator;
import net.technics.CollaboratorTvProvider;
import net.technics.HibernateUtil;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.hibernate.Session;

public class VListCollaborators {

	protected Shell listCollaborators;
	private Composite composite;
	private Table tableCollaborators;
	private TableViewer tableViewerCollaborators;
	private TableColumnLayout tLayout;
	private SashForm sashForm;
	private Composite compositeTable;
	private Text txtLogin;
	private Text txtNom;
	private Text txtPrenom;
	private Text txtEMail;

	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void init() {
		createContents();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		listCollaborators.open();
		listCollaborators.layout();
		while (!listCollaborators.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		listCollaborators = new Shell();
		listCollaborators.setSize(1353, 717);
		listCollaborators.setText("Scrum tool");
		listCollaborators.setLayout(new FormLayout());

		compositeTable = new Composite(listCollaborators, SWT.NONE);
		compositeTable.setLayoutData(new FormData());

		sashForm = new SashForm(compositeTable, SWT.NONE);
		sashForm.setLocation(0, 0);
		sashForm.setSize(1337, 305);

		composite = new Composite(sashForm, SWT.NONE);
		tLayout = new TableColumnLayout();
		composite.setLayout(tLayout);

		tableViewerCollaborators = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableCollaborators = tableViewerCollaborators.getTable();
		tableCollaborators.setHeaderVisible(true);
		tableCollaborators.setLinesVisible(true);
		tableViewerCollaborators.setContentProvider(new ArrayContentProvider());
		tableViewerCollaborators.setLabelProvider(new CollaboratorTvProvider());
		Session session = HibernateUtil.getSession();
		org.hibernate.Query query = session.createQuery("from Collaborator");
		List<Collaborator> lesCollaborateurs = query.list();
		tableViewerCollaborators.setInput(lesCollaborateurs);

		createColumn(tableCollaborators, "", 2);
		createColumn(tableCollaborators, "Nom", 1);

		sashForm.setWeights(new int[] { 1 });

		Menu menu = new Menu(listCollaborators, SWT.BAR);
		listCollaborators.setMenuBar(menu);

		MenuItem mntmProduits = new MenuItem(menu, SWT.NONE);
		mntmProduits.setText("Produits");

		MenuItem mntmCollaborateurs = new MenuItem(menu, SWT.NONE);
		mntmCollaborateurs.setText("Collaborateurs");

		Menu menuAngle = new Menu(listCollaborators);
		listCollaborators.setMenu(menuAngle);

		MenuItem menuAngleItem = new MenuItem(menuAngle, SWT.NONE);
		menuAngleItem.setText("\r\n");

		Button btnAjouterCollaborator = new Button(listCollaborators, SWT.NONE);
		FormData fd_btnAjouterCollaborator = new FormData();
		fd_btnAjouterCollaborator.top = new FormAttachment(compositeTable, 6);
		fd_btnAjouterCollaborator.left = new FormAttachment(compositeTable, 10, SWT.LEFT);
		btnAjouterCollaborator.setLayoutData(fd_btnAjouterCollaborator);
		btnAjouterCollaborator.setText("Ajouter un collaborateur");

		Group grpCollaborateur = new Group(listCollaborators, SWT.NONE);
		grpCollaborateur.setText("Collaborateur");
		FormData fd_grpCollaborateur = new FormData();
		fd_grpCollaborateur.top = new FormAttachment(btnAjouterCollaborator, 6);
		fd_grpCollaborateur.left = new FormAttachment(0, 10);
		fd_grpCollaborateur.right = new FormAttachment(0, 1327);
		fd_grpCollaborateur.bottom = new FormAttachment(100, -10);
		grpCollaborateur.setLayoutData(fd_grpCollaborateur);

		Label lblLogin = new Label(grpCollaborateur, SWT.NONE);
		lblLogin.setBounds(119, 46, 39, 15);
		lblLogin.setText("Login :");

		Label lblNom = new Label(grpCollaborateur, SWT.NONE);
		lblNom.setBounds(119, 81, 39, 15);
		lblNom.setText("Nom :");

		Label lblPrenom = new Label(grpCollaborateur, SWT.NONE);
		lblPrenom.setBounds(103, 124, 55, 15);
		lblPrenom.setText("Prénom :");

		Label lblEMail = new Label(grpCollaborateur, SWT.NONE);
		lblEMail.setBounds(103, 167, 55, 15);
		lblEMail.setText("Email :");

		Label lblAdministrateur = new Label(grpCollaborateur, SWT.NONE);
		lblAdministrateur.setBounds(67, 207, 104, 15);
		lblAdministrateur.setText("Administrateur ? :");

		txtLogin = new Text(grpCollaborateur, SWT.BORDER);
		txtLogin.setBounds(185, 46, 239, 21);

		txtNom = new Text(grpCollaborateur, SWT.BORDER);
		txtNom.setBounds(186, 81, 238, 21);

		txtPrenom = new Text(grpCollaborateur, SWT.BORDER);
		txtPrenom.setBounds(185, 124, 239, 21);

		txtEMail = new Text(grpCollaborateur, SWT.BORDER);
		txtEMail.setBounds(188, 167, 236, 21);

		Button btnCheckButton = new Button(grpCollaborateur, SWT.CHECK);
		btnCheckButton.setBounds(192, 207, 93, 16);

		Button btnReinitMdp = new Button(grpCollaborateur, SWT.NONE);
		btnReinitMdp.setBounds(159, 242, 194, 25);
		btnReinitMdp.setText("Réinitialiser le mot de passe");

		Button btnValider = new Button(grpCollaborateur, SWT.NONE);
		btnValider.setBounds(119, 282, 75, 25);
		btnValider.setText("Valider");

		Button btnAnnuler = new Button(grpCollaborateur, SWT.NONE);
		btnAnnuler.setBounds(210, 282, 75, 25);
		btnAnnuler.setText("Annuler");

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
