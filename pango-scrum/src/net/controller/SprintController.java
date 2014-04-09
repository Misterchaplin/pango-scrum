package net.controller;

import java.util.ArrayList;
import java.util.List;
import net.models.Sprint;
import net.vues.VSprint;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;

public class SprintController implements SelectionListener {
	private VSprint vSprint;

	public SprintController(VSprint vSprint) {
		this.vSprint = vSprint;
	}

	public void init() {
		List<Sprint> sprints = new ArrayList<Sprint>();
		sprints = getSprint();
		vSprint.getTvSprint().setContentProvider(new ArrayContentProvider());
		vSprint.getTvSprint().setInput(sprints);

	}





	// chargement d'un product , en attendant la partie d'Anthony
	private List<Sprint> getSprint() {
		Query query = AppController.session.createQuery("from Sprint where product.name='Plan2Tests'");
		List<Sprint> lesSprints = query.list();

		return lesSprints;

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
