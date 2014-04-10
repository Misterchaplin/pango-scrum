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
	private Button btnValider;
	
	
	public Button getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(Button btnValider) {
		this.btnValider = btnValider;
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
	    
  
	    TableViewerColumn TcLblSprint= new TableViewerColumn(tvSprint, SWT.NONE);
	    TcLblSprint.getColumn().setText("Sprint");
	    layout.setColumnData(TcLblSprint.getColumn(), new ColumnWeightData(1));
	    //TcLblSprint.setLabelProvider(new ColSprintLP());
	    
	    TableViewerColumn cdateDebut= new TableViewerColumn(tvSprint, SWT.NONE);
	    cdateDebut.getColumn().setText("Date de début");
	    layout.setColumnData(cdateDebut.getColumn(), new ColumnWeightData(1));
	    //cdateDebut.setLabelProvider(new ColDebLP());
	    	    	    
	    TableViewerColumn cdateFin= new TableViewerColumn(tvSprint, SWT.NONE);
	    cdateFin.getColumn().setText("Date de fin");
	    layout.setColumnData(cdateFin.getColumn(), new ColumnWeightData(1));
	   // cdateFin.setLabelProvider(new ColFinLP());
	    
	    tableSprint.setHeaderVisible(true);
	    tableSprint.setLinesVisible(true);
	    
	    Composite composite_1 = new Composite(composite, SWT.NONE);
	    composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    
	    Composite composite_2 = new Composite(composite_1, SWT.NONE);
	    composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    composite_2.setBounds(0, 0, 766, 271);
	    
	    Group grpAjouterUnSprint = new Group(composite_2, SWT.SHADOW_OUT);
	    grpAjouterUnSprint.setLocation(384, 0);
	    grpAjouterUnSprint.setSize(382, 271);
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
	    
	    dateDebut = new DateTime(grpAjouterUnSprint,SWT.DATE);
	    dateDebut.setBounds(150, 100, 93, 25);
	    
	    
	    Label lblDateDeFin = new Label(grpAjouterUnSprint, SWT.NONE);
	    lblDateDeFin.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
	    lblDateDeFin.setBounds(51, 151, 74, 15);
	    lblDateDeFin.setText("Date de fin");
	    
	    dateFin = new DateTime(grpAjouterUnSprint,SWT.DATE);
	    dateFin.setBounds(150, 142, 93, 24);
	    
	    btnValider = new Button(grpAjouterUnSprint, SWT.NONE);
	    btnValider.setBounds(152, 202, 74, 25);
	    btnValider.setText("Valider");
	    Image imAdd=new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/addButton.png"));
	    composite.layout(true, true);
	    btAddSprint = new Button(composite_2, SWT.NONE);
	    btAddSprint.setBounds(10, 39, 191, 54);
	    btAddSprint.setText("Ajouter Sprint");
	    btAddSprint.setImage(imAdd);	    
	    
	    btnModifierSprint = new Button(composite_2, SWT.NONE);
	    btnModifierSprint.setBounds(10, 99, 191, 56);
	    btnModifierSprint.setText("Modifier sprint");
	    
	    btnSupprimer = new Button(composite_2, SWT.NONE);
	    btnSupprimer.setBounds(10, 161, 191, 48);
	    btnSupprimer.setText("Supprimer");

	  
	
	  
		}
}

