package net.vues;

import net.controller.AppController;
import net.controller.Prog;
import net.models.Collaborator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Transaction;

public class VMdpModification {

	protected Shell shlScrumTool;
	private Text txtOldMdp;
	private Text txtNewMdp;
	private Text txtNewMdpConfirm;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VMdpModification window = new VMdpModification();
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
		shlScrumTool.open();
		shlScrumTool.layout();
		while (!shlScrumTool.isDisposed()) {
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
		shlScrumTool = new Shell();
		shlScrumTool.setImage(SWTResourceManager.getImage(VMdpModification.class, "/net/images/logo.PNG"));
		shlScrumTool.setSize(538, 337);
		shlScrumTool.setBackground(SWTResourceManager.getColor(255, 255, 240));
		shlScrumTool.setText("Scrum Tool");

		Group grpChangementDeMot = new Group(shlScrumTool, SWT.NONE);
		grpChangementDeMot.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpChangementDeMot.setText("Changement de mot de passe");
		grpChangementDeMot.setBackground(SWTResourceManager.getColor(255, 255, 240));
		grpChangementDeMot.setBounds(20, 23, 491, 267);

		Label lblMdpActuel = new Label(grpChangementDeMot, SWT.NONE);
		lblMdpActuel.setAlignment(SWT.RIGHT);
		lblMdpActuel.setBounds(10, 37, 204, 15);
		lblMdpActuel.setText("Mot de passe actuel :");
		lblMdpActuel.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblNewMdp = new Label(grpChangementDeMot, SWT.NONE);
		lblNewMdp.setAlignment(SWT.RIGHT);
		lblNewMdp.setBounds(10, 69, 204, 15);
		lblNewMdp.setText("Nouveau mot de passe :");
		lblNewMdp.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Label lblConfirmationNewMdp = new Label(grpChangementDeMot, SWT.NONE);
		lblConfirmationNewMdp.setAlignment(SWT.RIGHT);
		lblConfirmationNewMdp.setBounds(10, 104, 204, 15);
		lblConfirmationNewMdp.setText("Confirmation nouveau mot de passe :");
		lblConfirmationNewMdp.setBackground(SWTResourceManager.getColor(255, 255, 240));

		txtOldMdp = new Text(grpChangementDeMot, SWT.BORDER);
		txtOldMdp.setBounds(220, 34, 177, 21);

		txtNewMdp = new Text(grpChangementDeMot, SWT.BORDER);
		txtNewMdp.setBounds(220, 66, 177, 21);

		txtNewMdpConfirm = new Text(grpChangementDeMot, SWT.BORDER);
		txtNewMdpConfirm.setBounds(220, 101, 177, 21);

		final Label lblInformation = new Label(grpChangementDeMot, SWT.NONE);
		lblInformation.setBounds(10, 214, 471, 35);
		lblInformation.setBackground(SWTResourceManager.getColor(255, 255, 240));

		Button btnValider = new Button(grpChangementDeMot, SWT.NONE);
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Collaborator activeUser = AppController.getActiveUser();
				lblInformation.setText("");
				// mot de passe actuel non renseigné
				if (txtOldMdp.getText() == "") {
					lblInformation.setText("Saisir mot de passe actuel");
				}
				// mot de passe actuel non correct
				else if (!txtOldMdp.getText().equals(activeUser.getPassword())) {
					lblInformation.setText("Mot de passe actuel incorrect");
				}
				else {
					if (!txtNewMdp.getText().equals(txtNewMdpConfirm.getText())) {
						lblInformation.setText("Nouveau mot de passe et confirmation différents");
					}
					else if (txtNewMdp.getText().length() < 8) {
						lblInformation.setText("Le nouveau mot de passe doit contenir au moins 8 caractères");
					}
					else {
						// mise à jour du mot de passe de l'utilisateur connecté
						activeUser.setPassword(txtNewMdp.getText());
						Transaction trans = AppController.session.beginTransaction();
						AppController.session.update(activeUser);
						trans.commit();
						Prog.vAccueil.getLblInformation().setText("Votre mot de passe a été modifié avec succès.");
						shlScrumTool.close();
					}
				}
			}
		});
		btnValider.setImage(SWTResourceManager.getImage(VMdpModification.class, "/net/images/accept.png"));
		btnValider.setBounds(289, 171, 93, 37);
		btnValider.setText("Valider");

		Button btnAnnuler = new Button(grpChangementDeMot, SWT.NONE);
		btnAnnuler.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlScrumTool.close();
			}
		});
		btnAnnuler.setImage(SWTResourceManager.getImage(VMdpModification.class, "/net/images/cancel.png"));
		btnAnnuler.setBounds(388, 171, 93, 37);
		btnAnnuler.setText("Annuler");

		Label label = new Label(grpChangementDeMot, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 166, 471, 2);

	}
}
