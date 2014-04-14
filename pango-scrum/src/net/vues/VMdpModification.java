package net.vues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VMdpModification {

	protected Shell shlScrumTool;
	private Text txtOldMdp;
	private Text txtNewMdp;
	private Text txtNewMdpConfirm;
	private Button btnValider;
	private Button btnAnnuler;
	private Label lblInformation;
	private Label lblConfirmationNewMdp;
	private Label lblNewMdp;
	private Label lblMdpActuel;

	public Shell getShlScrumTool() {
		return shlScrumTool;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}

	public Text getTxtOldMdp() {
		return txtOldMdp;
	}

	public Text getTxtNewMdp() {
		return txtNewMdp;
	}

	public Text getTxtNewMdpConfirm() {
		return txtNewMdpConfirm;
	}

	public Label getLblInformation() {
		return lblInformation;
	}

	public Label getLblMdpActuel() {
		return lblMdpActuel;
	}

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

		lblMdpActuel = new Label(grpChangementDeMot, SWT.NONE);
		lblMdpActuel.setAlignment(SWT.RIGHT);
		lblMdpActuel.setBounds(10, 37, 204, 15);
		lblMdpActuel.setText("Mot de passe actuel :");
		lblMdpActuel.setBackground(SWTResourceManager.getColor(255, 255, 240));

		lblNewMdp = new Label(grpChangementDeMot, SWT.NONE);
		lblNewMdp.setAlignment(SWT.RIGHT);
		lblNewMdp.setBounds(10, 69, 204, 15);
		lblNewMdp.setText("Nouveau mot de passe :");
		lblNewMdp.setBackground(SWTResourceManager.getColor(255, 255, 240));

		lblConfirmationNewMdp = new Label(grpChangementDeMot, SWT.NONE);
		lblConfirmationNewMdp.setAlignment(SWT.RIGHT);
		lblConfirmationNewMdp.setBounds(10, 104, 204, 15);
		lblConfirmationNewMdp.setText("Confirmation nouveau mot de passe :");
		lblConfirmationNewMdp.setBackground(SWTResourceManager.getColor(255, 255, 240));

		txtOldMdp = new Text(grpChangementDeMot, SWT.BORDER | SWT.PASSWORD);
		txtOldMdp.setBounds(220, 34, 177, 21);

		txtNewMdp = new Text(grpChangementDeMot, SWT.BORDER | SWT.PASSWORD);
		txtNewMdp.setBounds(220, 66, 177, 21);

		txtNewMdpConfirm = new Text(grpChangementDeMot, SWT.BORDER | SWT.PASSWORD);
		txtNewMdpConfirm.setBounds(220, 101, 177, 21);

		lblInformation = new Label(grpChangementDeMot, SWT.NONE);
		lblInformation.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblInformation.setBounds(10, 214, 471, 35);
		lblInformation.setBackground(SWTResourceManager.getColor(255, 255, 240));
		lblInformation.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));

		btnValider = new Button(grpChangementDeMot, SWT.NONE);
		btnValider.setImage(SWTResourceManager.getImage(VMdpModification.class, "/net/images/accept.png"));
		btnValider.setBounds(289, 171, 93, 37);
		btnValider.setText("Valider");

		btnAnnuler = new Button(grpChangementDeMot, SWT.NONE);
		btnAnnuler.setImage(SWTResourceManager.getImage(VMdpModification.class, "/net/images/cancel.png"));
		btnAnnuler.setBounds(388, 171, 93, 37);
		btnAnnuler.setText("Annuler");

		Label label = new Label(grpChangementDeMot, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 166, 471, 2);

	}
}
