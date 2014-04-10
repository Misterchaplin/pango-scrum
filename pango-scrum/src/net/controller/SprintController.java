package net.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.models.Sprint;
import net.technics.DAOSprint;
import net.technics.TvSprintProvider;
import net.vues.VSprint;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;

public class SprintController implements SelectionListener {
	private VSprint vSprint;
	private List<Sprint> sprints;
	private Boolean modifier;

	public SprintController(VSprint vSprint) {
		this.vSprint = vSprint;
	}

	public void init() {
		sprints = new ArrayList<Sprint>();
		sprints = getSprint();
		vSprint.getTvSprint().setContentProvider(new ArrayContentProvider());
		vSprint.getTvSprint().setLabelProvider(new TvSprintProvider());
		vSprint.getTvSprint().setInput(sprints);
	
		vSprint.getBtAddSprint().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent evt) {
				modifier = false;
				sprints.add(DAOSprint.addSprint(vSprint));
				vSprint.getTvSprint().refresh();
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vSprint.getTableSprint().addSelectionListener(new SelectionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void widgetSelected(SelectionEvent evt) {
				
				StructuredSelection sel = (StructuredSelection) vSprint.getTvSprint().getSelection();
				Sprint sprint = (Sprint) sel.getFirstElement();
				String dateDeb=DAOSprint.getDateDebut(sprint);
				String dateFin=DAOSprint.getDateFin(sprint);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				Date dateD=null;
				try {
					dateD = sdf.parse(dateDeb);
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				Date dateF = null;
				try {
					dateF = sdf.parse(dateFin);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
				vSprint.getnewNameSprint().setText(sprint.getLabel());
				vSprint.getDateDebut().setDate(dateD.getDay()-1900,dateD.getMonth(), dateD.getYear());
				vSprint.getDateFin().setDate(dateF.getDay()-1900, dateF.getMonth(), dateF.getYear());
				
						
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vSprint.getBtnModifierSprint().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent evt) {
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	
			


		

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
