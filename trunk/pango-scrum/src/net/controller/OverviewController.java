package net.controller;

import java.util.ArrayList;
import java.util.List;

import net.models.Collaborator;
import net.models.Sprint;
import net.models.Userstory;
import net.technics.HibernateUtil;
import net.vues.VAddUserStorie;
import net.vues.VOverview;
import net.vues.VSprint;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;
import org.hibernate.Session;

public class OverviewController implements SelectionListener {
	private VOverview vOverview;
	private VAddUserStorie vAddUserStorie;
	private int i;
	private Integer totalPoint;
	private Integer point;
	private Integer totalPointFinished;

	private String collab;

	public OverviewController(VOverview vOverview) {
		this.vOverview = vOverview;
	}

	public void init() {

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
				// vAddUserStorie.getTbfProductBacklog().setSelection(vAddUserStorie.getTbtmInProgress());

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getBtnDone().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VAddUserStorie vAddUserStorie = new VAddUserStorie();
				new AppController(vAddUserStorie);
				vAddUserStorie.open();
				vAddUserStorie.getTbfProductBacklog().setSelection(2);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		vOverview.getBtnSprintRecent().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				VSprint vSprint = new VSprint();
				new AppController(vSprint);
				vSprint.open();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		List<Userstory> userstories = new ArrayList<Userstory>();
		userstories = getUserstory();
		vOverview.getTableViewer().setContentProvider(new ArrayContentProvider());
		vOverview.getTableViewer().setInput(userstories);

	}

	private List<Userstory> getUserstory() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Userstory WHERE idstatus = 2");
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

	public void initSprint() {
		List<Sprint> sprint = new ArrayList<Sprint>();
		sprint = getSprint();
		vOverview.getTableVOverview().setContentProvider(new ArrayContentProvider());
		vOverview.getTableVOverview().setInput(sprint);

	}

	private List<Sprint> getSprint() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Sprint");
		List<Sprint> lesSprints = query.list();
		return lesSprints;

	}

	public void initTotalPoint() {

		vOverview.getLblAfficherPointProjet().setText(getUserstoryTotalPoint() + "");
	}

	private int getUserstoryTotalPoint() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("SELECT SUM(storyPoints) FROM Userstory WHERE idproduct =3");
		if (query.uniqueResult() == null) {
			totalPoint = 0;
		}
		else {
			totalPoint = Integer.valueOf(query.uniqueResult() + "");
		}
		return totalPoint;

	}

	public void initDonePoint() {
		vOverview.getLblAfficherPointSprint().setText(getUserstoryDonePoint() + "");
	}

	private int getUserstoryDonePoint() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("SELECT SUM(storyPoints) FROM Userstory WHERE idproduct =3 AND finishedAt IS NOT Null");
		if (query.uniqueResult() == null) {
			totalPointFinished = 0;
		}
		else {
			totalPointFinished = Integer.valueOf(query.uniqueResult() + "");
		}

		return totalPointFinished;

	}

	public void initCustomer() {
		vOverview.getAfficherLblCustomerName().setText(getCustomer() + "");
	}

	private String getCustomer() {
		Session session = HibernateUtil.getSession();

		String sql = "SELECT c FROM Collaborator AS c JOIN c.playroles AS pl "
				+ "JOIN pl.product AS p "
				+ "JOIN pl.role AS r "
				+ "WHERE p.id=3 AND r.id=2";

		Query query = session.createQuery(sql);

		if (query.uniqueResult() == null) {
			collab = "Personne";
		}
		else {
			Collaborator collaborators = (Collaborator) query.uniqueResult();

			collab = collaborators.getFirstname() + " " + collaborators.getLastname();
		}

		return collab;

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
