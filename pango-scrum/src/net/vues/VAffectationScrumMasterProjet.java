package net.vues;

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
import org.eclipse.wb.swt.SWTResourceManager;

public class VAffectationScrumMasterProjet {

	protected Shell vAffectationScrumMasterProjet;
	private TableColumnLayout tLayout;
	private Table tableScrumMasterCollaborators;
	private Button btnValider;
	private Button btnAnnuler;
	private TableViewer tvScrumMasterCollaborators;
	private Label label;

	public Shell getvAffectationScrumMasterProjet() {
		return vAffectationScrumMasterProjet;
	}

	public Table getTableScrumMasterCollaborators() {
		return tableScrumMasterCollaborators;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}

	public TableViewer getTvScrumMasterCollaborators() {
		return tvScrumMasterCollaborators;
	}

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
		vAffectationScrumMasterProjet.open();
		vAffectationScrumMasterProjet.layout();
		while (!vAffectationScrumMasterProjet.isDisposed()) {
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
		vAffectationScrumMasterProjet = new Shell();
		vAffectationScrumMasterProjet.setImage(SWTResourceManager.getImage(VAffectationScrumMasterProjet.class, "/net/images/user.PNG"));
		vAffectationScrumMasterProjet.setSize(345, 448);
		vAffectationScrumMasterProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));
		vAffectationScrumMasterProjet.setText("Scrum Tool - Choix Scrum Master");
		vAffectationScrumMasterProjet.setLayout(new FormLayout());

		Label lblAffecterScrumMasterProjet = new Label(vAffectationScrumMasterProjet, SWT.NONE);
		lblAffecterScrumMasterProjet.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		FormData fd_lblAffecterScrumMasterProjet = new FormData();
		fd_lblAffecterScrumMasterProjet.top = new FormAttachment(0);
		fd_lblAffecterScrumMasterProjet.right = new FormAttachment(0, 211);
		lblAffecterScrumMasterProjet.setLayoutData(fd_lblAffecterScrumMasterProjet);
		lblAffecterScrumMasterProjet.setText("Affecter un Scrum Master au projet");
		lblAffecterScrumMasterProjet.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblChoisirUnScrumMaster = new Label(vAffectationScrumMasterProjet, SWT.NONE);
		fd_lblAffecterScrumMasterProjet.left = new FormAttachment(lblChoisirUnScrumMaster, 0, SWT.LEFT);
		FormData fd_lblChoisirUnScrumMaster = new FormData();
		fd_lblChoisirUnScrumMaster.right = new FormAttachment(0, 244);
		fd_lblChoisirUnScrumMaster.top = new FormAttachment(0, 45);
		fd_lblChoisirUnScrumMaster.left = new FormAttachment(0);
		lblChoisirUnScrumMaster.setLayoutData(fd_lblChoisirUnScrumMaster);
		lblChoisirUnScrumMaster.setText("Choisir un Scrum Master pour le projet :");
		lblChoisirUnScrumMaster.setBackground(SWTResourceManager.getColor(255, 255, 240));
		tLayout = new TableColumnLayout();

		btnValider = new Button(vAffectationScrumMasterProjet, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VAffectationScrumMasterProjet.class, "/net/images/accept.png"));
		FormData fd_btnValider = new FormData();
		btnValider.setLayoutData(fd_btnValider);
		btnValider.setText("Valider");

		btnAnnuler = new Button(vAffectationScrumMasterProjet, SWT.NONE);
		fd_btnValider.right = new FormAttachment(100, -171);
		btnAnnuler.setImage(SWTResourceManager.getImage(VAffectationScrumMasterProjet.class, "/net/images/cancel.png"));
		FormData fd_btnAnnuler = new FormData();
		fd_btnAnnuler.top = new FormAttachment(btnValider, 0, SWT.TOP);
		fd_btnAnnuler.left = new FormAttachment(btnValider, 6);
		btnAnnuler.setLayoutData(fd_btnAnnuler);
		btnAnnuler.setText("Annuler");

		Composite composite = new Composite(vAffectationScrumMasterProjet, SWT.NONE);
		fd_btnValider.top = new FormAttachment(composite, 14);
		composite.setLayout(new TableColumnLayout());
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(lblChoisirUnScrumMaster, 302, SWT.BOTTOM);
		fd_composite.right = new FormAttachment(0, 329);
		fd_composite.top = new FormAttachment(lblChoisirUnScrumMaster, 6);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);

		tvScrumMasterCollaborators = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableScrumMasterCollaborators = tvScrumMasterCollaborators.getTable();
		tableScrumMasterCollaborators.setHeaderVisible(true);
		tableScrumMasterCollaborators.setLinesVisible(true);

		label = new Label(vAffectationScrumMasterProjet, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(lblAffecterScrumMasterProjet, 8, SWT.BOTTOM);
		fd_label.top = new FormAttachment(lblAffecterScrumMasterProjet, 6);
		fd_label.right = new FormAttachment(lblAffecterScrumMasterProjet, 309);
		fd_label.left = new FormAttachment(lblAffecterScrumMasterProjet, 0, SWT.LEFT);
		label.setLayoutData(fd_label);
		tvScrumMasterCollaborators.setContentProvider(new ArrayContentProvider());
		tvScrumMasterCollaborators.setLabelProvider(new CollaboratorTvProvider());
		tvScrumMasterCollaborators.setInput(DAOCollaborator.getCollaborators());

		createColumn(tableScrumMasterCollaborators, "Nom", 1);
	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
