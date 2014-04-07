package net.controller;

import java.util.ArrayList;
import java.util.List;

import net.models.Userstory;
import net.technics.HibernateUtil;
import net.vues.VAddUserStorie;
import net.vues.VOverview;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;
import org.hibernate.Session;

public class OverviewController implements SelectionListener {
	private VOverview vOverview;
	private VAddUserStorie vAddUserStorie;

	public OverviewController(VOverview vOverview) {
		this.vOverview = vOverview;
	}

	public void init() {
		List<Userstory> userstories = new ArrayList<Userstory>();
		userstories = getUserstory();
		vOverview.getTableViewer().setContentProvider(new ArrayContentProvider());
		vOverview.getTableViewer().setInput(userstories);
		vOverview.getTableViewer().setInput(new String[] { "Test1", "Test2" });

		vOverview.getBtnToDo().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);
				vAddUserStorie.open();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getBtnProgress().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);
				vAddUserStorie.open();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getBtnProgress().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);
				vAddUserStorie.open();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	private List<Userstory> getUserstory() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Userstory WHERE idstatus = 1");
		List<Userstory> lesUserstories = query.list();

		return lesUserstories;

	}

	public void init1() {
		List<Userstory> userstories = new ArrayList<Userstory>();
		userstories = getUserstory1();
		vOverview.getTableViewer2().setContentProvider(new ArrayContentProvider());
		vOverview.getTableViewer2().setInput(userstories);

	}

	private List<Userstory> getUserstory1() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Userstory WHERE idstatus = 2");
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;

	}

	public void init2() {
		List<Userstory> userstories = new ArrayList<Userstory>();
		userstories = getUserstory2();
		vOverview.getTableViewer3().setContentProvider(new ArrayContentProvider());
		vOverview.getTableViewer3().setInput(userstories);

	}

	private List<Userstory> getUserstory2() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Userstory WHERE idstatus = 3");
		List<Userstory> lesUserstories = query.list();
		return lesUserstories;

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
