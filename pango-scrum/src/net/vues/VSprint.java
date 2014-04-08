package net.vues;

import java.util.ArrayList;
import java.util.List;

import net.models.Sprint;
import net.technics.ColDebLP;
import net.technics.ColFinLP;
import net.technics.ColLbProvider;
import net.technics.ColSprintLP;
import net.technics.HibernateUtil;
import net.technics.TvSprintProvider;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;


public class VSprint {
	

	protected Shell shellSprint;
	private Table tableSprint;
	private TableViewer tvSprint;
	private TableColumnLayout tLayout;
	
	
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
        fd_composite.right = new FormAttachment(0, 784);
        fd_composite.top = new FormAttachment(0);
        fd_composite.left = new FormAttachment(0);
        composite.setLayoutData(fd_composite);
	    composite.setLayout(new FillLayout(SWT.VERTICAL));
	    TableColumnLayout layout = new TableColumnLayout();
	    
	    
	    
	    Group GrpSprint = new Group(composite, SWT.NONE);
	    GrpSprint.setToolTipText("");
	    GrpSprint.setText("Planifié");
	    GrpSprint.setLayout(null);
	    
	    tvSprint = new TableViewer(GrpSprint, SWT.BORDER | SWT.FULL_SELECTION);
	    tableSprint = tvSprint.getTable();
	    tableSprint.setBounds(0, 28, 778, 263);
	    tableSprint.getParent().setLayout(layout);
	    
  
	    TableViewerColumn TcLblSprint= new TableViewerColumn(tvSprint, SWT.NONE);
	    TcLblSprint.getColumn().setText("Sprint");
	    layout.setColumnData(TcLblSprint.getColumn(), new ColumnWeightData(1));
	    TcLblSprint.setLabelProvider(new ColSprintLP());
	    
	    TableViewerColumn dateDebut= new TableViewerColumn(tvSprint, SWT.NONE);
	    dateDebut.getColumn().setText("Date de début");
	    layout.setColumnData(dateDebut.getColumn(), new ColumnWeightData(1));
	    dateDebut.setLabelProvider(new ColDebLP());
	    	    	    
	    TableViewerColumn dateFin= new TableViewerColumn(tvSprint, SWT.NONE);
	    dateFin.getColumn().setText("Date de fin");
	    layout.setColumnData(dateFin.getColumn(), new ColumnWeightData(1));
	    dateFin.setLabelProvider(new ColFinLP());
	    
	    
	    TableViewerColumn action= new TableViewerColumn(tvSprint, SWT.NONE);
	    action.getColumn().setText("Actions #");
	    layout.setColumnData(action.getColumn(), new ColumnWeightData(1));
	    action.setLabelProvider(new ColLbProvider(this));
	    
	    
	    tableSprint.setHeaderVisible(true);
	    tableSprint.setLinesVisible(true);
	    
	    Image imAdd=new Image(Display.getCurrent(), getClass().getResourceAsStream("/net/images/addButton.png"));
	    Button btnNewButton = new Button(shellSprint, SWT.NONE);
	    FormData fd_btnNewButton = new FormData();
	    fd_btnNewButton.top = new FormAttachment(0, 148);
	    fd_btnNewButton.right = new FormAttachment(100);
	    btnNewButton.setLayoutData(fd_btnNewButton);
	    btnNewButton.setText("Ajouter Sprint");
	    btnNewButton.setImage(imAdd);	    
	    composite.layout(true, true);
	
			
		}

	public TableColumnLayout gettLayout() {
		return tLayout;
	}

	public void settLayout(TableColumnLayout tLayout) {
		this.tLayout = tLayout;
	}
}

