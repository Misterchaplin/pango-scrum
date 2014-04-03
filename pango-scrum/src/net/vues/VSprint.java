package net.vues;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Point;

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
		createContents();
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
		shellSprint.setSize(450, 300);
		shellSprint.setText("Sprint");
		
        Composite composite = new Composite(shellSprint, SWT.NONE);
        composite.setBounds(133, 25, 521, 457);
	    
	    tvSprint = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
	    tableSprint = tvSprint.getTable();
	    TableColumnLayout layout = new TableColumnLayout();
	    tableSprint.getParent().setLayout(layout);

	    
	    TableColumn col = new TableColumn(tableSprint, SWT.NONE);
	    layout.setColumnData(col,new ColumnWeightData(2));
	    col.setText("Nom");
	    
	    TableColumn col2 = new TableColumn(tableSprint, SWT.NONE);
	    layout.setColumnData(col2, new ColumnWeightData(1));
	    col2.setText("date de début");
	    
	    TableColumn col3 = new TableColumn(tableSprint, SWT.NONE);
	    layout.setColumnData(col3, new ColumnWeightData(1));
	    col3.setText("Date de fin");
		
	    tableSprint.setBounds(0, 0, 521, 457);
	    tableSprint.setHeaderVisible(true);
	    tableSprint.setLinesVisible(true);
	    composite.layout(true, true);
	    
	    
        

	}
}
