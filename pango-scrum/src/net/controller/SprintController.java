package net.controller;

import java.util.ArrayList;
import java.util.List;

import net.models.Sprint;
import net.technics.HibernateUtil;
import net.technics.TvSprintProvider;
import net.vues.VSprint;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;
import org.hibernate.Session;

public class SprintController implements SelectionListener{
	private VSprint vSprint;
	
	

	public SprintController(VSprint vSprint) {
		this.vSprint = vSprint;
	}
	
	public void init(){
		List <Sprint> sprints = new ArrayList<Sprint>();
		sprints = getProduct();
		for (int i =0;i==1;i++){
			System.out.println(sprints.get(i));
		}
		vSprint.getTvSprint().setContentProvider(new ArrayContentProvider());
		vSprint.getTvSprint().setLabelProvider(new TvSprintProvider());
		vSprint.getTvSprint().setInput(sprints);
		
	}
	
	private List<Sprint> getProduct(){
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Sprint");
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
