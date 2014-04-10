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
		vAffectationScrumMasterProjet.setSize(355, 448);
		vAffectationScrumMasterProjet.setText("SWT Application");
		vAffectationScrumMasterProjet.setLayout(new FormLayout());

		Label lblAffecterScrumMasterProjet = new Label(vAffectationScrumMasterProjet, SWT.NONE);
		FormData fd_lblAffecterScrumMasterProjet = new FormData();
		fd_lblAffecterScrumMasterProjet.right = new FormAttachment(0, 269);
		fd_lblAffecterScrumMasterProjet.top = new FormAttachment(0);
		fd_lblAffecterScrumMasterProjet.left = new FormAttachment(0, 58);
		lblAffecterScrumMasterProjet.setLayoutData(fd_lblAffecterScrumMasterProjet);
		lblAffecterScrumMasterProjet.setText("Affecter un scrum master au projet");

		Label lblChoisirUnScrumMaster = new Label(vAffectationScrumMasterProjet, SWT.NONE);
		FormData fd_lblChoisirUnScrumMaster = new FormData();
		fd_lblChoisirUnScrumMaster.right = new FormAttachment(0, 244);
		fd_lblChoisirUnScrumMaster.top = new FormAttachment(0, 45);
		fd_lblChoisirUnScrumMaster.left = new FormAttachment(0);
		lblChoisirUnScrumMaster.setLayoutData(fd_lblChoisirUnScrumMaster);
		lblChoisirUnScrumMaster.setText("Choisir un Scrum Master pour le projet :");
		tLayout = new TableColumnLayout();

		btnValider = new Button(vAffectationScrumMasterProjet, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VAffectationScrumMasterProjet.class, "/net/images/accept.png"));
		FormData fd_btnValider = new FormData();
		btnValider.setLayoutData(fd_btnValider);
		btnValider.setText("Valider");

		btnAnnuler = new Button(vAffectationScrumMasterProjet, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VAffectationScrumMasterProjet.class, "/net/images/cancel.png"));
		fd_btnValider.top = new FormAttachment(btnAnnuler, 0, SWT.TOP);
		fd_btnValider.right = new FormAttachment(btnAnnuler, -6);
		FormData fd_btnAnnuler = new FormData();
		fd_btnAnnuler.top = new FormAttachment(lblChoisirUnScrumMaster, 316);
		fd_btnAnnuler.left = new FormAttachment(0, 175);
		btnAnnuler.setLayoutData(fd_btnAnnuler);
		btnAnnuler.setText("Annuler");

		Composite composite = new Composite(vAffectationScrumMasterProjet, SWT.NONE);
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
