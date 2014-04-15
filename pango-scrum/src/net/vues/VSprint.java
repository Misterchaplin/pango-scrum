package net.vues;

import net.controller.ProduitController;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.ole.win32.COMObject;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class VSprint {

	protected Shell shellSprint;
	private Button btAddSprint;
	private Table tableSprint;
	private TableViewer tvSprint;
	private TableColumnLayout tLayout;
	private Text newNameSprint;
	private DateTime dateDebut;
	private DateTime dateFin;
	private Button btnModifierSprint;
	private Button btnSupprimer;
	private Composite composite_2;
	private Button btnValider;
	private Label lblInformation;
	private Group grpAjouterUnSprint;

	public Group getGrpAjouterUnSprint() {
		return grpAjouterUnSprint;
	}

	public void setGrpAjouterUnSprint(Group grpAjouterUnSprint) {
		this.grpAjouterUnSprint = grpAjouterUnSprint;
	}

	public Button getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(Button btnValider) {
		this.btnValider = btnValider;
	}

	public Composite getComposite_2() {
		return composite_2;
	}

	public void setComposite_2(Composite composite_2) {
		this.composite_2 = composite_2;
	}



	public Text getnewNameSprint() {
		return newNameSprint;
	}

	public Button getBtnModifierSprint() {
		return btnModifierSprint;
	}

	public void setBtnModifierSprint(Button btnModifierSprint) {
		this.btnModifierSprint = btnModifierSprint;
	}

	public Button getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(Button btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public void setnewNameSprint(Text text) {
		this.newNameSprint = text;
	}

	public DateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(DateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public DateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(DateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Button getBtAddSprint() {
		return btAddSprint;
	}

	public void setBtAddSprint(Button btAddSprint) {
		this.btAddSprint = btAddSprint;
	}

	public Shell getShellSprint() {
		return shellSprint;
	}

	public void setShellSprint(Shell shellSprint) {
		this.shellSprint = shellSprint;
	}

	public Table getTableSprint() {
		return tableSprint;
	}

	public void setTableSprint(Table tableSprint) {
		this.tableSprint = tableSprint;
	}

	public TableColumnLayout gettLayout() {
		return tLayout;
	}

	public void settLayout(TableColumnLayout tLayout) {
		this.tLayout = tLayout;
	}

	public TableViewer getTvSprint() {
		return tvSprint;
	}

	public void setTvSprint(TableViewer tvSprint) {
		this.tvSprint = tvSprint;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public void init() {
		createContents();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		shellSprint.open();
		shellSprint.layout();
		while (!shellSprint.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		ProduitController.nbOpenedWindowsprint=0;
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shellSprint = new Shell();
		shellSprint.setImage(SWTResourceManager.getImage(VSprint.class, "/net/images/logo.PNG"));
		shellSprint.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		shellSprint.setSize(800, 681);
		shellSprint.setText("Gestion des sprints");
		shellSprint.setLayout(new FormLayout());

		Composite composite = new Composite(shellSprint, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 562);
		fd_composite.right = new FormAttachment(0, 766);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		TableColumnLayout layout = new TableColumnLayout();

		Group GrpSprint = new Group(composite, SWT.NONE);
		GrpSprint.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		GrpSprint.setSize(120, 200);
		GrpSprint.setToolTipText("");
		GrpSprint.setText("Planifié");
		GrpSprint.setLayout(new FillLayout(SWT.VERTICAL));

		tvSprint = new TableViewer(GrpSprint, SWT.BORDER | SWT.FULL_SELECTION);
		tableSprint = tvSprint.getTable();
		tableSprint.getParent().setLayout(layout);

		TableViewerColumn TcLblSprint = new TableViewerColumn(tvSprint, SWT.NONE);
		TcLblSprint.getColumn().setText("Sprint");
		layout.setColumnData(TcLblSprint.getColumn(), new ColumnWeightData(1));
		// TcLblSprint.setLabelProvider(new ColSprintLP());

		TableViewerColumn cdateDebut = new TableViewerColumn(tvSprint, SWT.NONE);
		cdateDebut.getColumn().setText("Date de début");
		layout.setColumnData(cdateDebut.getColumn(), new ColumnWeightData(1));
		// cdateDebut.setLabelProvider(new ColDebLP());

		TableViewerColumn cdateFin = new TableViewerColumn(tvSprint, SWT.NONE);
		cdateFin.getColumn().setText("Date de fin");
		layout.setColumnData(cdateFin.getColumn(), new ColumnWeightData(1));
		// cdateFin.setLabelProvider(new ColFinLP());

		tableSprint.setHeaderVisible(true);
		tableSprint.setLinesVisible(true);

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));

	    composite_2 = new Composite(composite_1, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		composite_2.setBounds(0, 57, 766, 214);
		//composite_2.setVisible(false);
		

	    grpAjouterUnSprint = new Group(composite_2, SWT.SHADOW_OUT);
		grpAjouterUnSprint.setLocation(0, 0);
		grpAjouterUnSprint.setSize(766, 209);
		grpAjouterUnSprint.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		grpAjouterUnSprint.setText("Ajouter/Modifier un sprint");
		grpAjouterUnSprint.setLayout(null);

		Label lblNom = new Label(grpAjouterUnSprint, SWT.NONE);
		lblNom.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		lblNom.setBounds(51, 48, 70, 15);
		lblNom.setText("Nom :");

		newNameSprint = new Text(grpAjouterUnSprint, SWT.BORDER);
		newNameSprint.setBounds(150, 45, 93, 21);

		Label lblDateDeDbut = new Label(grpAjouterUnSprint, SWT.NONE);
		lblDateDeDbut.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		lblDateDeDbut.setBounds(51, 110, 74, 15);
		lblDateDeDbut.setText("Date de début");

		dateDebut = new DateTime(grpAjouterUnSprint, SWT.DATE);
		dateDebut.setBounds(150, 100, 93, 25);

		Label lblDateDeFin = new Label(grpAjouterUnSprint, SWT.NONE);
		lblDateDeFin.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		lblDateDeFin.setBounds(51, 151, 74, 15);
		lblDateDeFin.setText("Date de fin");
		
		Image imgModSprint= new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/Modifier_UserStory.png"));
		

		Image imgSupSprint= new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/cancel.png"));
		
		dateFin = new DateTime(grpAjouterUnSprint, SWT.DATE);
		dateFin.setBounds(150, 142, 93, 24);
		btnModifierSprint = new Button(grpAjouterUnSprint, SWT.NONE);
		btnModifierSprint.setBounds(259, 142, 191, 56);
		btnModifierSprint.setText("Modifier sprint");
		btnModifierSprint.setImage(imgModSprint);
		btnSupprimer = new Button(grpAjouterUnSprint, SWT.NONE);
		btnSupprimer.setBounds(476, 146, 191, 48);
		btnSupprimer.setText("Supprimer");
		btnSupprimer.setImage(imgSupSprint);
		
		btnValider = new Button(grpAjouterUnSprint, SWT.NONE);
		btnValider.setBounds(150, 173, 75, 25);
		btnValider.setText("Ajouter");
		
		
		Image imgAdd = new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/addButton.png"));
		composite.layout(true, true);
		

		btAddSprint = new Button(composite_1, SWT.NONE);
		btAddSprint.setBounds(0, 0, 191, 45);
		btAddSprint.setText("Ajouter Sprint");
		btAddSprint.setImage(imgAdd);
		
		lblInformation = new Label(shellSprint, SWT.NONE);
		FormData fd_lblInformation = new FormData();
		fd_lblInformation.bottom = new FormAttachment(100, -10);
		fd_lblInformation.right = new FormAttachment(composite, 0, SWT.RIGHT);
		fd_lblInformation.top = new FormAttachment(composite, 26);
		fd_lblInformation.left = new FormAttachment(0, 10);
		lblInformation.setLayoutData(fd_lblInformation);
		
		Label lblInformation_1 = new Label(shellSprint, SWT.NONE);
		FormData fd_lblInformation_1 = new FormData();
		fd_lblInformation_1.top = new FormAttachment(composite, 6);
		fd_lblInformation_1.left = new FormAttachment(composite, 10, SWT.LEFT);
		lblInformation_1.setLayoutData(fd_lblInformation_1);
		lblInformation_1.setText("Information");
		

	}

	public Label getLblInformation() {
		return lblInformation;
	}

	public void setLblInformation(Label lblInformation) {
		this.lblInformation = lblInformation;
	}
}
