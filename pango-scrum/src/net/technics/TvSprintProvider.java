package net.technics;

import java.text.Format;
import java.util.HashSet;
import java.util.Set;

import net.models.Event;
import net.models.Sprint;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ibm.icu.text.SimpleDateFormat;

public class TvSprintProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object obj, int numcol) {
		String result ="";
		Sprint s = (Sprint) obj;
		if (numcol==0){
			result = s.getLabel();	
		}
		
		if (numcol==1){	

			result = DAOSprint.getDateDebut(s);
		}
		
		if (numcol==2){
			result = DAOSprint.getDateFin(s);

		}
		return result;
	}

	

}
