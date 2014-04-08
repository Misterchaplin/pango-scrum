package net.vues;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VAffectationCollaborator {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Table table;
	private Table table_1;

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

		text = new Text(shell, SWT.BORDER);
		text.setBounds(111, 42, 174, 21);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(10, 123, 275, 21);

		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(621, 224, 377, 434);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(291, 42, 174, 25);
		btnNewButton.setText("Revenir à la liste des projets");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(292, 123, 95, 25);
		btnNewButton_1.setText("Définir");

		TableViewer tableViewer_1 = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer_1.getTable();
		table_1.setBounds(10, 224, 377, 434);

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
}
