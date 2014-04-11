package net.vues;

import net.controller.AccueilController;
import net.controller.AppController;
import net.technics.CollaboratorTvProvider;
import net.technics.DAOCollaborator;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VListCollaborators {

	protected Shell VListCollaborators;
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
	private Label lblInformation;
	private Button btnSupprimerCollaborateur;
	private Link linkReinitMdp;
	private Button btnAjouterCollaborator;
	private Button btnValider;
	private Button btnAnnuler;
	private Button btnAdmin;
	private Group grpCollaborateur;
	private Label label;

	public TableViewer getTableViewerCollaborators() {
		return tableViewerCollaborators;
	}

	public Shell getListCollaborators() {
		return VListCollaborators;
	}

	public Text getTxtLogin() {
		return txtLogin;
	}

	public Text getTxtNom() {
		return txtNom;
	}

	public Text getTxtPrenom() {
		return txtPrenom;
	}

	public Text getTxtEMail() {
		return txtEMail;
	}

	public Label getLblInformation() {
		return lblInformation;
	}

	public Button getBtnSupprimerCollaborateur() {
		return btnSupprimerCollaborateur;
	}

	public Link getLinkReinitMdp() {
		return linkReinitMdp;
	}

	public Button getBtnAjouterCollaborator() {
		return btnAjouterCollaborator;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}

	public Table getTableCollaborators() {
		return tableCollaborators;
	}

	public Group getGrpCollaborateur() {
		return grpCollaborateur;
	}

	public Button getBtnAdmin() {
		return btnAdmin;
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
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		VListCollaborators.open();
		VListCollaborators.layout();
		while (!VListCollaborators.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		AccueilController.nbOpenedWindowCollaborator = 0;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		VListCollaborators = new Shell();
		VListCollaborators.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/user.PNG"));
		VListCollaborators.setSize(1024, 706);
		VListCollaborators.setText("Scrum Tool - Gestion des collaborateurs");
		VListCollaborators.setBackground(SWTResourceManager.getColor(255, 255, 240));
		VListCollaborators.setLayout(null);

		grpCollaborateur = new Group(VListCollaborators, SWT.BORDER | SWT.SHADOW_IN);
		grpCollaborateur.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpCollaborateur.setBounds(10, 375, 978, 229);
		grpCollaborateur.setText("Collaborateur");
		grpCollaborateur.setVisible(false);

		btnAdmin = new Button(grpCollaborateur, SWT.CHECK);
		btnAdmin.setBounds(153, 121, 93, 16);

		compositeTable = new Composite(VListCollaborators, SWT.NONE);
		compositeTable.setBounds(0, 0, 1337, 305);

		sashForm = new SashForm(compositeTable, SWT.NONE);
		sashForm.setLocation(0, 0);
		sashForm.setSize(1005, 305);

		Group grpInformation = new Group(VListCollaborators, SWT.BORDER | SWT.SHADOW_IN);
		grpInformation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpInformation.setText("Information");
		grpInformation.setBounds(10, 615, 978, 43);
		grpInformation.setVisible(false);
		if (AppController.getActiveUser().getAdministrator()) {
			grpInformation.setVisible(true);
		}

		lblInformation = new Label(grpInformation, SWT.NONE);
		lblInformation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblInformation.setBounds(10, 20, 958, 15);

		btnSupprimerCollaborateur = new Button(grpCollaborateur, SWT.NONE);
		btnSupprimerCollaborateur.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/delete.png"));
		btnSupprimerCollaborateur.setBounds(516, 179, 194, 40);
		btnSupprimerCollaborateur.setText("Supprimer ce collaborateur");

		linkReinitMdp = new Link(grpCollaborateur, SWT.NONE);
		linkReinitMdp.setBounds(456, 122, 163, 15);
		linkReinitMdp.setText("<a>Réinitialiser le mot de passe</a>");

		composite = new Composite(sashForm, SWT.NONE);
		tLayout = new TableColumnLayout();
		composite.setLayout(tLayout);

		tableViewerCollaborators = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableCollaborators = tableViewerCollaborators.getTable();
		tableCollaborators.setHeaderVisible(true);
		tableCollaborators.setLinesVisible(true);
		tableViewerCollaborators.setContentProvider(new ArrayContentProvider());
		tableViewerCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tableViewerCollaborators.setInput(DAOCollaborator.getCollaborators());

		createColumn(tableCollaborators, "Nom", 1);

		sashForm.setWeights(new int[] { 1 });

		if (AppController.getActiveUser().getAdministrator()) {
			btnAjouterCollaborator = new Button(VListCollaborators, SWT.NONE);
			btnAjouterCollaborator.setBounds(10, 311, 183, 45);
			btnAjouterCollaborator.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/user.PNG"));
			btnAjouterCollaborator.setText("Ajouter un collaborateur");
		}

		Label lblLogin = new Label(grpCollaborateur, SWT.NONE);
		lblLogin.setBounds(43, 28, 39, 15);
		lblLogin.setText("Login :");

		Label lblNom = new Label(grpCollaborateur, SWT.NONE);
		lblNom.setBounds(43, 60, 39, 15);
		lblNom.setText("Nom :");

		Label lblPrenom = new Label(grpCollaborateur, SWT.NONE);
		lblPrenom.setBounds(456, 87, 55, 15);
		lblPrenom.setText("Prénom :");

		Label lblEMail = new Label(grpCollaborateur, SWT.NONE);
		lblEMail.setBounds(43, 87, 39, 15);
		lblEMail.setText("Email :");

		Label lblAdministrateur = new Label(grpCollaborateur, SWT.NONE);
		lblAdministrateur.setBounds(43, 122, 104, 15);
		lblAdministrateur.setText("Administrateur ? :");

		txtLogin = new Text(grpCollaborateur, SWT.BORDER);
		txtLogin.setBounds(88, 25, 239, 21);

		txtNom = new Text(grpCollaborateur, SWT.BORDER);
		txtNom.setBounds(88, 57, 238, 21);

		txtPrenom = new Text(grpCollaborateur, SWT.BORDER);
		txtPrenom.setBounds(516, 84, 239, 21);

		txtEMail = new Text(grpCollaborateur, SWT.BORDER);
		txtEMail.setBounds(88, 84, 328, 21);

		btnValider = new Button(grpCollaborateur, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/accept.png"));
		btnValider.setBounds(738, 179, 109, 40);
		btnValider.setText("Valider");

		btnAnnuler = new Button(grpCollaborateur, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VListCollaborators.class, "/net/images/cancel.png"));
		btnAnnuler.setBounds(853, 179, 109, 40);
		btnAnnuler.setText("Annuler");

		label = new Label(grpCollaborateur, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 167, 952, 2);

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}