package net.vues;


import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
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
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;


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
	private Button btnValider;
	private SashForm sashForm;
	private TabFolder tabFolder;
	private TabItem tbtmSprint;
	private SashForm sashFormSprint;
	private SashForm sashLblPresentation;
	private SashForm sashTviewer;
	private SashForm sashGroupAction;
	private Label lblProduct;
	private Composite composite_1;
	private Group grpAjouterUnSprint;
	private Button btnAnnuler;
	private Label lblInfoTraitement;
	
	
	
	

	public Shell getShellSprint() {
		return shellSprint;
	}

	public void setShellSprint(Shell shellSprint) {
		this.shellSprint = shellSprint;
	}

	public Button getBtAddSprint() {
		return btAddSprint;
	}

	public void setBtAddSprint(Button btAddSprint) {
		this.btAddSprint = btAddSprint;
	}

	public Table getTableSprint() {
		return tableSprint;
	}

	public void setTableSprint(Table tableSprint) {
		this.tableSprint = tableSprint;
	}

	public TableViewer getTvSprint() {
		return tvSprint;
	}

	public void setTvSprint(TableViewer tvSprint) {
		this.tvSprint = tvSprint;
	}

	public TableColumnLayout gettLayout() {
		return tLayout;
	}

	public void settLayout(TableColumnLayout tLayout) {
		this.tLayout = tLayout;
	}

	public Text getNewNameSprint() {
		return newNameSprint;
	}

	public void setNewNameSprint(Text newNameSprint) {
		this.newNameSprint = newNameSprint;
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

	public Button getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(Button btnValider) {
		this.btnValider = btnValider;
	}

	public SashForm getSashForm() {
		return sashForm;
	}

	public void setSashForm(SashForm sashForm) {
		this.sashForm = sashForm;
	}

	public TabFolder getTabFolder() {
		return tabFolder;
	}

	public void setTabFolder(TabFolder tabFolder) {
		this.tabFolder = tabFolder;
	}

	public TabItem getTbtmSprint() {
		return tbtmSprint;
	}

	public void setTbtmSprint(TabItem tbtmSprint) {
		this.tbtmSprint = tbtmSprint;
	}

	public TabItem getTbtmEvenement() {
		return tbtmEvenement;
	}

	public void setTbtmEvenement(TabItem tbtmEvenement) {
		this.tbtmEvenement = tbtmEvenement;
	}

	public SashForm getSashFormSprint() {
		return sashFormSprint;
	}

	public void setSashFormSprint(SashForm sashFormSprint) {
		this.sashFormSprint = sashFormSprint;
	}

	public SashForm getSashLblPresentation() {
		return sashLblPresentation;
	}

	public void setSashLblPresentation(SashForm sashLblPresentation) {
		this.sashLblPresentation = sashLblPresentation;
	}


	public SashForm getSashTviewer() {
		return sashTviewer;
	}

	public void setSashTviewer(SashForm sashTviewer) {
		this.sashTviewer = sashTviewer;
	}

	public SashForm getSashGroupAction() {
		return sashGroupAction;
	}

	public void setSashGroupAction(SashForm sashGroupAction) {
		this.sashGroupAction = sashGroupAction;
	}

	public Label getLblNewLabel() {
		return lblProduct;
	}

	public void setLblNewLabel(Label lblNewLabel) {
		this.lblProduct = lblNewLabel;
	}

	public Composite getComposite_1() {
		return composite_1;
	}

	public void setComposite_1(Composite composite_1) {
		this.composite_1 = composite_1;
	}

	public Group getGrpAjouterUnSprint() {
		return grpAjouterUnSprint;
	}

	public void setGrpAjouterUnSprint(Group grpAjouterUnSprint) {
		this.grpAjouterUnSprint = grpAjouterUnSprint;
	}

	public Button getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(Button btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public Label getLblInfoTraitement() {
		return lblInfoTraitement;
	}

	public void setLblInfoTraitement(Label lblInfoTraitement) {
		this.lblInfoTraitement = lblInfoTraitement;
	}

	/**
	 * Launch the application.
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
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shellSprint = new Shell();
		shellSprint.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		shellSprint.setSize(800, 600);
		shellSprint.setText("Sprint");
	    TableColumnLayout layout = new TableColumnLayout();
	    Image imAdd=new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/addButton.png"));
	    shellSprint.setLayout(new FillLayout(SWT.HORIZONTAL));
	    
	    sashForm = new SashForm(shellSprint, SWT.NONE);
	    
	    tabFolder = new TabFolder(sashForm, SWT.NONE);
	    
	    tbtmSprint = new TabItem(tabFolder, SWT.NONE);
	    tbtmSprint.setText("Sprint");
	    
	    sashFormSprint = new SashForm(tabFolder, SWT.VERTICAL);
	    tbtmSprint.setControl(sashFormSprint);
	    
	    sashLblPresentation = new SashForm(sashFormSprint, SWT.NONE);
	    
	    lblProduct = new Label(sashLblPresentation, SWT.NONE);
	    lblProduct.setFont(SWTResourceManager.getFont("Tahoma", 14, SWT.ITALIC));
	    lblProduct.setText("Sprint du produit :");
	    sashLblPresentation.setWeights(new int[] {1});
	    
	    sashTviewer = new SashForm(sashFormSprint, SWT.NONE);
	    
        Composite composite = new Composite(sashTviewer, SWT.NONE);
        composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
        composite.setLayout(new FillLayout(SWT.VERTICAL));
        
        
        
        Group GrpSprint = new Group(composite, SWT.NONE);
        GrpSprint.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
        GrpSprint.setSize(120, 200);
        GrpSprint.setToolTipText("");
        GrpSprint.setText("Planifié");
        GrpSprint.setLayout(new FillLayout(SWT.VERTICAL));
        
        tvSprint = new TableViewer(GrpSprint, SWT.BORDER | SWT.FULL_SELECTION);
        tableSprint = tvSprint.getTable();
        tableSprint.getParent().setLayout(layout);
        
  
        TableViewerColumn TcLblSprint= new TableViewerColumn(tvSprint, SWT.NONE);
        TcLblSprint.getColumn().setText("Sprint");
        layout.setColumnData(TcLblSprint.getColumn(), new ColumnWeightData(1));
        
        
        TableViewerColumn cdateDebut= new TableViewerColumn(tvSprint, SWT.NONE);
        cdateDebut.getColumn().setText("Date de début");
        layout.setColumnData(cdateDebut.getColumn(), new ColumnWeightData(1));
       
        	    	    
        TableViewerColumn cdateFin= new TableViewerColumn(tvSprint, SWT.NONE);
        cdateFin.getColumn().setText("Date de fin");
        layout.setColumnData(cdateFin.getColumn(), new ColumnWeightData(1));
        
         
        tableSprint.setHeaderVisible(true);
        tableSprint.setLinesVisible(true);
        composite.layout(true, true);
	    sashTviewer.setWeights(new int[] {1});
	    
	    sashGroupAction = new SashForm(sashFormSprint, SWT.NONE);
	    
	    composite_1 = new Composite(sashGroupAction, SWT.NONE);
	    composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	      
	    grpAjouterUnSprint = new Group(composite_1, SWT.SHADOW_OUT);
	    grpAjouterUnSprint.setLocation(384, 0);
	    grpAjouterUnSprint.setSize(392, 262);
	    grpAjouterUnSprint.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    grpAjouterUnSprint.setText("\"\"");
	    grpAjouterUnSprint.setLayout(null);
	      
	    Label lblNom = new Label(grpAjouterUnSprint, SWT.NONE);
	    lblNom.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    lblNom.setBounds(47, 62, 70, 15);
	    lblNom.setText("Nom :");
	      
	    newNameSprint = new Text(grpAjouterUnSprint, SWT.BORDER);
	    newNameSprint.setBounds(150, 59, 93, 21);
	      
	    Label lblDateDeDbut = new Label(grpAjouterUnSprint, SWT.NONE);
	    lblDateDeDbut.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    lblDateDeDbut.setBounds(47, 99, 74, 15);
	    lblDateDeDbut.setText("Date de début");
	      
	    dateDebut = new DateTime(grpAjouterUnSprint,SWT.DATE);
	    dateDebut.setBounds(150, 93, 93, 21);
	      
	      
	    Label lblDateDeFin = new Label(grpAjouterUnSprint, SWT.NONE);
	    lblDateDeFin.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    lblDateDeFin.setBounds(47, 132, 74, 15);
	    lblDateDeFin.setText("Date de fin");
	      
	    dateFin = new DateTime(grpAjouterUnSprint,SWT.DATE);
	    dateFin.setBounds(150, 132, 93, 25);
	      
	       
	    btnValider = new Button(grpAjouterUnSprint, SWT.NONE);
	    btnValider.setBounds(152, 202, 74, 25);
	    btnValider.setText("Valider");
	       
	    btnAnnuler = new Button(grpAjouterUnSprint, SWT.NONE);
	    btnAnnuler.setBounds(238, 202, 75, 25);
	    btnAnnuler.setText("Annuler");
	    btAddSprint = new Button(composite_1, SWT.NONE);
	    btAddSprint.setLocation(0, 0);
	    btAddSprint.setSize(161, 34);
	    btAddSprint.setText("Ajouter Sprint");
	    btAddSprint.setImage(imAdd);	    
	       
	    btnModifierSprint = new Button(composite_1, SWT.NONE);
	    btnModifierSprint.setLocation(0, 88);
	    btnModifierSprint.setSize(161, 34);
	    btnModifierSprint.setText("Modifier sprint");
	       
	    btnSupprimer = new Button(composite_1, SWT.NONE);
	    btnSupprimer.setLocation(0, 128);
	    btnSupprimer.setSize(161, 34);
	    btnSupprimer.setText("Supprimer");
	       
	    Label lblInformation = new Label(composite_1, SWT.NONE);
	    lblInformation.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    lblInformation.setBounds(0, 193, 101, 15);
	    lblInformation.setText("Information :");
	       
	    lblInfoTraitement = new Label(composite_1, SWT.NONE);
	    lblInfoTraitement.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
	    lblInfoTraitement.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    lblInfoTraitement.setBounds(0, 214, 378, 48);
	    sashGroupAction.setWeights(new int[] {1});
	    sashFormSprint.setWeights(new int[] {34, 232, 262});
        sashForm.setWeights(new int[] {1});

	}
}

