package net.controller;

import java.util.ArrayList;
import java.util.List;

import net.models.Userstory;
import net.technics.HibernateUtil;
import net.vues.VOverview;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Query;
import org.hibernate.Session;

public class OverviewController {
	private VOverview vOverview;
	private Shell shell;

	public OverviewController(VOverview vOverview) {
		this.vOverview = vOverview;
	}

	public void init() {
		List<Userstory> userstories = new ArrayList<Userstory>();
		userstories = getUserstory();
		vOverview.getTableViewer().setContentProvider(new ArrayContentProvider());
		vOverview.getTableViewer().setInput(userstories);

	}

	private List<Userstory> getUserstory() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Userstory");
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;

	}

}
