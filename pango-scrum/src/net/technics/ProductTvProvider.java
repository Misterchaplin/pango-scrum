package net.technics;

import net.models.Product;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class ProductTvProvider implements ITableLabelProvider {

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
			return Utils.getImage(Utils.IMG_PRODUCT);
		}
		return null;
	}

	@Override
	public String getColumnText(Object obj, int numCol) {
		Product aProduct = (Product) obj;
		if (numCol == 0) {
			return aProduct.getName();
		}
		return null;
	}
}
