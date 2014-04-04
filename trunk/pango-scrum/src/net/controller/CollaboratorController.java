package net.controller;

import net.vues.VListCollaborators;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class CollaboratorController implements SelectionListener {
	private VListCollaborators vListCollaborator;

	public CollaboratorController(VListCollaborators vListCollaborator) {
		this.vListCollaborator = vListCollaborator;
	}

	public void init() {
		// listeners sur composants graphiques
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
