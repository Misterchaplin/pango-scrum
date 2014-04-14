package net.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.models.Event;
import net.models.Sprint;
import net.technics.DAOSprint;
import net.technics.TvSprintProvider;
import net.vues.VSprint;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.hibernate.Query;

public class SprintController implements SelectionListener {
	private VSprint vSprint;
	private List<Sprint> sprints;
	private String oldDateDeb;
	private String olDateFin;
	private Date newDateDeb;
	private Date newDateFin;
	private Sprint activeSprint;
	private int IdActiveProduct=ProductController.getSelectedProduct().getId();

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
				sprints.add(DAOSprint.addSprint(vSprint,IdActiveProduct));
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
				activeSprint = (Sprint) sel.getFirstElement();
				oldDateDeb=DAOSprint.getDateDebut(activeSprint);
			    olDateFin=DAOSprint.getDateFin(activeSprint);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Calendar calDeb = null;
				Calendar calFin = null;
				vSprint.getnewNameSprint().setText(activeSprint.getLabel());
				
				try {
					calDeb = Calendar.getInstance();
					
					calDeb.setTime(sdf.parse(oldDateDeb));
					vSprint.getDateDebut().setDay(calDeb.get(Calendar.DAY_OF_MONTH));
					vSprint.getDateDebut().setMonth(calDeb.get(Calendar.MONTH));
					vSprint.getDateDebut().setYear(calDeb.get(Calendar.YEAR));
					
				} catch (ParseException e1) {
						e1.printStackTrace();
				}
				
				try {
					calFin = Calendar.getInstance();
					calFin.setTime(sdf.parse(olDateFin));
					vSprint.getDateFin().setDay(calFin.get(Calendar.DATE));
					vSprint.getDateFin().setMonth(calFin.get(Calendar.MONTH));
					vSprint.getDateFin().setYear(calFin.get(Calendar.YEAR));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vSprint.getBtnModifierSprint().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent evt) {	
				// maj dans la bdd
				newDateDeb=getDateDeb();
				newDateFin=getDateFin();
				DAOSprint.updateName(activeSprint, vSprint.getnewNameSprint().getText());
				DAOSprint.updateDate(activeSprint, newDateDeb, true);
				DAOSprint.updateDate(activeSprint, newDateFin, false);
				//maj tableviewer
				activeSprint.setLabel(vSprint.getnewNameSprint().getText());
				Event debut= DAOSprint.getEventDateDeb(activeSprint);
				Event fin = DAOSprint.getEventDateFin(activeSprint);
				debut.setEventDate(newDateDeb);
				fin.setEventDate(newDateFin);
				vSprint.getTvSprint().refresh(activeSprint);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vSprint.getBtnSupprimer().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				DAOSprint.deleteSprint(activeSprint.getId());
				vSprint.getTvSprint().remove(activeSprint);
				vSprint.getTvSprint().refresh(activeSprint);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
				
			}
		});;
	}
	
	
	
	
	
	
	

	// chargement d'un product , en attendant la partie d'Anthony
	private List<Sprint> getSprint() {
		Query query = AppController.session.createQuery("from Sprint where product.id="+ProductController.getSelectedProduct().getId());
		List<Sprint> lesSprints = query.list();

		return lesSprints;

	}
	private Date getDateDeb(){
		Calendar c = Calendar.getInstance();
		c.set(vSprint.getDateDebut().getYear(),vSprint.getDateDebut().getMonth(),vSprint.getDateDebut().getDay());		
		Date d = c.getTime();
		return d;		
	}
	private Date getDateFin(){
		Calendar c = Calendar.getInstance();
		c.set(vSprint.getDateFin().getYear(),vSprint.getDateFin().getMonth(),vSprint.getDateFin().getDay());		
		Date d = c.getTime();
		return d;		
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
