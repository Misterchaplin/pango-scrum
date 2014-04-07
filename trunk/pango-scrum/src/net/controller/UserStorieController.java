package net.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;
import org.hibernate.Session;

import net.models.Sprint;
import net.models.Userstory;
import net.technics.HibernateUtil;
import net.vues.VAddUserStorie;
import net.vues.VListCollaborators;
import net.vues.VLogin;
import net.vues.VSprint;
import net.vues.VUserStorie;

public class UserStorieController implements SelectionListener{
	
	private VAddUserStorie vAddUserStorie;

	public UserStorieController(VAddUserStorie vAddUserStorie) {
		this.vAddUserStorie = vAddUserStorie;
	}

	public void init() {
		final List <String> userstorie = new ArrayList<String>();
		vAddUserStorie.getTableViewer().setContentProvider(new ArrayContentProvider());
		vAddUserStorie.getTableViewer().setInput(getUserstories());
		vAddUserStorie.getBtnAddUserStorie().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String storie = vAddUserStorie.getTxtaddUserstorie().getText();
				if(storie != ""){
					userstorie.add(storie);
				}
				vAddUserStorie.getTableViewer().setContentProvider(new ArrayContentProvider());
				vAddUserStorie.getTableViewer().setInput(userstorie);
			}
		});
	}

	private List<Userstory> getUserstories() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Userstory WHERE idStatus= 1");
		List<Userstory> userStories = query.list();
		return userStories;
		
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
