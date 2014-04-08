package net.technics;



import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;

import net.vues.VSprint;



public class ColLbProvider extends ColumnLabelProvider implements IBaseLabelProvider{
private VSprint vSprint;
	public ColLbProvider(VSprint vSprint) {
	
	this.vSprint = vSprint;
}

	@Override
	public void update(ViewerCell cell) {
		// TODO Auto-generated method stub
		 TableItem item = (TableItem) cell.getItem();
		 
	     Composite buttonPane = new Composite(vSprint.getTvSprint().getTable(), SWT.NONE);
	     buttonPane.setLayout(new FillLayout());

	     Button button = new Button(buttonPane,SWT.None);
	     button.setText("Open");

	     button = new Button(buttonPane,SWT.NONE);
	     button.setText("Edit");

	     button = new Button(buttonPane,SWT.NONE);
	     button.setText("Delete");

	     TableEditor editor = new TableEditor(vSprint.getTableSprint());
	     editor.grabHorizontal  = true;
	     editor.grabVertical  = true;
	     editor.setEditor(buttonPane, item, 3);
	     editor.layout();
	}
	
	
}
