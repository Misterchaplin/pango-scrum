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
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.hibernate.Session;

public class VListCollaborators {

	protected Shell listCollaborators;
	private Composite composite;
	private Table tableCollaborators;
	private TableViewer tableViewerCollaborators;
	private TableColumnLayout tLayout;
	private SashForm sashForm;
	private Composite compositeTable;

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

		createColumn(tableCollaborators, "Nom", 2);
		createColumn(tableCollaborators, "Couleur", 1);

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

		Button btnAjouter = new Button(listCollaborators, SWT.NONE);
		FormData fd_btnAjouter = new FormData();
		fd_btnAjouter.top = new FormAttachment(compositeTable, 12);
		fd_btnAjouter.left = new FormAttachment(0, 10);
		btnAjouter.setLayoutData(fd_btnAjouter);
		btnAjouter.setText("Ajouter un collaborateur");

	}

	public void createColumn(Table table, String caption, int weight) {
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setText(caption);
		tLayout.setColumnData(col, new ColumnWeightData(weight));
	}
}
