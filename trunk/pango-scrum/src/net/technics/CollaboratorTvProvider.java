package net.technics;

import net.models.Collaborator;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class CollaboratorTvProvider implements ITableLabelProvider {

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
	public Image getColumnImage(Object obj, int numCol) {
		if (numCol == 0) {
			return Utils.getImage(Utils.IMG_USER);
		}
		return null;
	}

	@Override
	public String getColumnText(Object obj, int numCol) {
		Collaborator aCollaborator = (Collaborator) obj;
		if (numCol == 1) {
			return aCollaborator.getFirstname() + " " + aCollaborator.getLastname();
		}
		return null;
	}

}
