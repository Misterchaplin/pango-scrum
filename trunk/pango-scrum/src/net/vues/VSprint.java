package net.vues;

import java.util.GregorianCalendar;

import net.technics.ColDebLP;
import net.technics.ColFinLP;
import net.technics.ColLbProvider;
import net.technics.ColSprintLP;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class VSprint {
	

	protected Shell shellSprint;
	private Button btAddSprint;
	private Table tableSprint;
	private TableViewer tvSprint;
	private TableColumnLayout tLayout;
	private Text newNameSprint;
	private DateTime dateDebut;
	private DateTime dateFin;
	private GregorianCalendar gc;
	
	
	public Text getnewNameSprint() {
		return newNameSprint;
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
		shellSprint.setMinimumSize(new Point(800, 600));
		shellSprint.setSize(922, 600);
		shellSprint.setText("Sprint");
        shellSprint.setLayout(new FormLayout());
		
        Composite composite = new Composite(shellSprint, SWT.NONE);
        FormData fd_composite = new FormData();
        fd_composite.bottom = new FormAttachment(0, 562);
        fd_composite.right = new FormAttachment(0, 766);
        fd_composite.top = new FormAttachment(0);
        fd_composite.left = new FormAttachment(0);
        composite.setLayoutData(fd_composite);
	    composite.setLayout(new FillLayout(SWT.VERTICAL));
	    TableColumnLayout layout = new TableColumnLayout();
	    
	    
	    
	    Group GrpSprint = new Group(composite, SWT.NONE);
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
	    TcLblSprint.setLabelProvider(new ColSprintLP());
	    
	    TableViewerColumn cdateDebut= new TableViewerColumn(tvSprint, SWT.NONE);
	    cdateDebut.getColumn().setText("Date de début");
	    layout.setColumnData(cdateDebut.getColumn(), new ColumnWeightData(1));
	    cdateDebut.setLabelProvider(new ColDebLP());
	    	    	    
	    TableViewerColumn cdateFin= new TableViewerColumn(tvSprint, SWT.NONE);
	    cdateFin.getColumn().setText("Date de fin");
	    layout.setColumnData(cdateFin.getColumn(), new ColumnWeightData(1));
	    cdateFin.setLabelProvider(new ColFinLP());
	    
	    tableSprint.setHeaderVisible(true);
	    tableSprint.setLinesVisible(true);
	    
	    Group grpAjouterUnSprint = new Group(composite, SWT.SHADOW_OUT);
	    grpAjouterUnSprint.setText("Ajouter un sprint");
	    grpAjouterUnSprint.setLayout(new FormLayout());
	    
	    Label lblNom = new Label(grpAjouterUnSprint, SWT.NONE);
	    FormData fd_lblNom = new FormData();
	    fd_lblNom.left = new FormAttachment(0, 10);
	    lblNom.setLayoutData(fd_lblNom);
	    lblNom.setText("Nom :");
	    
	    newNameSprint = new Text(grpAjouterUnSprint, SWT.BORDER);
	    fd_lblNom.right = new FormAttachment(newNameSprint, -19);
	    FormData fd_text = new FormData();
	    fd_text.top = new FormAttachment(lblNom, -3, SWT.TOP);
	    fd_text.left = new FormAttachment(0, 78);
	    fd_text.right = new FormAttachment(100, -567);
	    newNameSprint.setLayoutData(fd_text);
	    
	    Label lblDateDeDbut = new Label(grpAjouterUnSprint, SWT.NONE);
	    fd_lblNom.bottom = new FormAttachment(100, -219);
	    FormData fd_lblDateDeDbut = new FormData();
	    fd_lblDateDeDbut.left = new FormAttachment(lblNom, 0, SWT.LEFT);
	    lblDateDeDbut.setLayoutData(fd_lblDateDeDbut);
	    lblDateDeDbut.setText("Date de début");
	    
	    dateDebut = new DateTime(grpAjouterUnSprint,SWT.DATE);
	    FormData fd_dateDebut = new FormData();
	    fd_dateDebut.top = new FormAttachment(newNameSprint, 29);
	    fd_dateDebut.right = new FormAttachment(newNameSprint, 0, SWT.RIGHT);
	    dateDebut.setLayoutData(fd_dateDebut);
	    dateDebut.setSize(50, 10);
	    
	    
	    Label lblDateDeFin = new Label(grpAjouterUnSprint, SWT.NONE);
	    fd_lblDateDeDbut.bottom = new FormAttachment(lblDateDeFin, -26);
	    FormData fd_lblDateDeFin = new FormData();
	    fd_lblDateDeFin.top = new FormAttachment(0, 117);
	    fd_lblDateDeFin.left = new FormAttachment(0, 10);
	    lblDateDeFin.setLayoutData(fd_lblDateDeFin);
	    lblDateDeFin.setText("Date de fin");
	    
	    dateFin = new DateTime(grpAjouterUnSprint,SWT.DATE);
	    fd_dateDebut.bottom = new FormAttachment(dateFin, -20);
	    fd_dateDebut.left = new FormAttachment(dateFin, 0, SWT.LEFT);
	    fd_lblDateDeFin.right = new FormAttachment(dateFin, -28);
	    FormData fd_dateFin = new FormData();
	    fd_dateFin.left = new FormAttachment(0, 101);
	    fd_dateFin.top = new FormAttachment(0, 117);
	    dateFin.setLayoutData(fd_dateFin);

	    
	    Image imAdd=new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/addButton.png"));
	    btAddSprint = new Button(shellSprint, SWT.NONE);
	    FormData fd_btnNewButton = new FormData();
	    fd_btnNewButton.top = new FormAttachment(0, 81);
	    fd_btnNewButton.right = new FormAttachment(100);
	    btAddSprint.setLayoutData(fd_btnNewButton);
	    btAddSprint.setText("Ajouter Sprint");
	    btAddSprint.setImage(imAdd);	    
	    
	    Button btnModifierSprint = new Button(shellSprint, SWT.NONE);
	    FormData fd_btnModifierSprint = new FormData();
	    fd_btnModifierSprint.right = new FormAttachment(btAddSprint, 0, SWT.RIGHT);
	    fd_btnModifierSprint.top = new FormAttachment(btAddSprint, 24);
	    fd_btnModifierSprint.left = new FormAttachment(btAddSprint, 0, SWT.LEFT);
	    btnModifierSprint.setLayoutData(fd_btnModifierSprint);
	    btnModifierSprint.setText("Modifier sprint");
	    
	    Button btnSupprimer = new Button(shellSprint, SWT.NONE);
	    FormData fd_btnSupprimer = new FormData();
	    fd_btnSupprimer.right = new FormAttachment(btAddSprint, 0, SWT.RIGHT);
	    fd_btnSupprimer.top = new FormAttachment(btnModifierSprint, 25);
	    fd_btnSupprimer.left = new FormAttachment(btAddSprint, 0, SWT.LEFT);
	    btnSupprimer.setLayoutData(fd_btnSupprimer);
	    btnSupprimer.setText("Supprimer");
	    composite.layout(true, true);
	
	  
		}
}

