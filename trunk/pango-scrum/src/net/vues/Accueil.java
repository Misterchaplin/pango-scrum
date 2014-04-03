package net.vues;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class Accueil {

	protected Shell accueil;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Accueil window = new Accueil();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		accueil.open();
		accueil.layout();
		while (!accueil.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		accueil = new Shell();
		accueil.setSize(450, 300);
		accueil.setText("SWT Application");
		
		Label lblAccueilParDfault = new Label(accueil, SWT.NONE);
		lblAccueilParDfault.setBounds(160, 132, 117, 15);
		lblAccueilParDfault.setText("Accueil par d\u00E9fault");

	}
}
