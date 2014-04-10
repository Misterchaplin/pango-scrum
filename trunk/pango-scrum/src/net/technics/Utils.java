package net.technics;

import java.io.InputStream;

import net.vues.VListCollaborators;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class Utils {
	public static String IMG_FOLDER = "net/images";
	public static String IMG_USER = IMG_FOLDER + "/user.PNG";
	public static String IMG_PRODUCT = IMG_FOLDER + "/product.PNG";

	public static Image getImage(String filename) {
		Image img = null;
		try {
			InputStream input = VListCollaborators.class.getClassLoader().getResourceAsStream(filename);
			img = new Image(Display.getDefault(), input);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return img;
	}
}
