package net.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import net.vues.VAddUserStorie;
import net.vues.VLogin;
import net.vues.VSprint;
import net.vues.VUserStorie;

public class UserStorieController implements SelectionListener{

	private VAddUserStorie vAddUserStorie;

	public UserStorieController(VAddUserStorie vAddUserStorie) {
		this.vAddUserStorie = vAddUserStorie;
	}

	public void init() {
		vAddUserStorie.getTxtaddUserstorie();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
