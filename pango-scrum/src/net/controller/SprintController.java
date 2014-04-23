package net.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.models.Event;
import net.models.Product;
import net.models.Sprint;
import net.technics.DAOSprint;
import net.technics.TvSprintProvider;
import net.vues.VSprint;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.hibernate.Query;
import org.hibernate.property.Getter;

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
	
	public int getIdActiveProduct() {
		return IdActiveProduct;
	}


	public void init() {
	    final Color red = new Color(vSprint.getShellSprint().getDisplay(), 247, 35, 12);
		final Color vert = new Color(vSprint.getShellSprint().getDisplay(), 0, 255, 0);
		final Calendar calDateActuel=Calendar.getInstance();
		sprints = new ArrayList<Sprint>();
		sprints = getSprint();
		vSprint.getTvSprint().setContentProvider(new ArrayContentProvider());
		vSprint.getTvSprint().setLabelProvider(new TvSprintProvider());
		vSprint.getTvSprint().setInput(sprints);
		vSprint.getGrpAjouterUnSprint().setVisible(false);
		
	
		vSprint.getBtAddSprint().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent evt) {
				vSprint.getGrpAjouterUnSprint().setVisible(true);
				vSprint.getBtnValider().setVisible(true);
				vSprint.getBtnModifierSprint().setVisible(false);		
				vSprint.getBtnSupprimer().setVisible(false);
				vSprint.getLblNewLabel().setText("Sprint du produit : "+ProductController.getSelectedProduct().getName());
				vSprint.getDateDebut().setDate(calDateActuel.get(Calendar.YEAR),calDateActuel.get(Calendar.MONTH),calDateActuel.get(Calendar.DAY_OF_MONTH));
				vSprint.getDateFin().setDate(calDateActuel.get(Calendar.YEAR),calDateActuel.get(Calendar.MONTH),calDateActuel.get(Calendar.DAY_OF_MONTH));
				vSprint.getGrpAjouterUnSprint().setText("Nouveau sprint");
				vSprint.getNewNameSprint().setText("");
				
											
			}	
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vSprint.getBtnValider().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Product leProduit = DAOSprint.getProduct(IdActiveProduct);
				Sprint newSprint = new Sprint(leProduit);
				newSprint.setLabel(vSprint.getNewNameSprint().getText());
				Set<Event> evenements = new HashSet<Event>();
				Date dateDebNvSprint=getDateDeb();
				Date dateFinNvSprint=getDateFin();
				Event debut = new Event(newSprint,DAOSprint.getEventType(1), dateDebNvSprint);
				Event fin = new Event(newSprint,DAOSprint.getEventType(2), dateFinNvSprint);
				evenements.add(debut);
				evenements.add(fin);
				newSprint.setEvents(evenements);
				if (DAOSprint.VerifSprint(newSprint, IdActiveProduct) == true){
					DAOSprint.addSprint(newSprint,debut,fin);
					sprints.add(newSprint);
					vSprint.getTvSprint().refresh();
					vSprint.getLblInfoTraitement().setForeground(vert);
					vSprint.getLblInfoTraitement().setText("Ajout réussi");
					vSprint.getGrpAjouterUnSprint().setVisible(false);
				}
				else {
					/*if (getDateDeb().compareTo(getDateFin()) == 0){
						vSprint.getLblInfoTraitement().setForeground(red);
						vSprint.getLblInfoTraitement().setText("Les date de début et de fin doivent être différentes");
					}
					else if (getDateDeb().compareTo(getDateFin()) == 1){
						vSprint.getLblInfoTraitement().setForeground(red);
						vSprint.getLblInfoTraitement().setText("La date de fin du sprint ne peut avoir lieu avant la date de début... ");
					}
					else{*/
					vSprint.getLblInfoTraitement().setForeground(red);
					vSprint.getLblInfoTraitement().setText("Impossible d'ajouter ce sprint car la date de debut et/ou de fin interfère sur la date d'un autre sprint");
					
				}
			
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		vSprint.getTableSprint().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent evt) {
				vSprint.getGrpAjouterUnSprint().setVisible(true);
				vSprint.getLblInfoTraitement().setText("");
				vSprint.getBtnValider().setVisible(false);
				vSprint.getBtnModifierSprint().setVisible(true);
				vSprint.getBtnSupprimer().setVisible(true);
				
				StructuredSelection sel = (StructuredSelection) vSprint.getTvSprint().getSelection();
				activeSprint = (Sprint) sel.getFirstElement();
				vSprint.getGrpAjouterUnSprint().setText("Information "+activeSprint.getLabel());
				oldDateDeb=DAOSprint.getDateDebut(activeSprint);
			    olDateFin=DAOSprint.getDateFin(activeSprint);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Calendar calDeb = null;
				Calendar calFin = null;
				vSprint.getNewNameSprint().setText(activeSprint.getLabel());
				
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
				DAOSprint.updateName(activeSprint, vSprint.getNewNameSprint().getText());
				DAOSprint.updateDate(activeSprint, newDateDeb, true);
				DAOSprint.updateDate(activeSprint, newDateFin, false);
				//maj tableviewer
				activeSprint.setLabel(vSprint.getNewNameSprint().getText());
				Event debut= DAOSprint.getEventDateDeb(activeSprint);
				Event fin = DAOSprint.getEventDateFin(activeSprint);
				debut.setEventDate(newDateDeb);
				fin.setEventDate(newDateFin);
				vSprint.getTvSprint().refresh(activeSprint);
				vSprint.getLblInfoTraitement().setText("Modification effectué");
				vSprint.getNewNameSprint().setText("");
				vSprint.getGrpAjouterUnSprint().setVisible(false);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vSprint.getBtnSupprimer().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vSprint.getGrpAjouterUnSprint().setVisible(true);
				DAOSprint.deleteSprint(activeSprint.getId());
				vSprint.getTvSprint().remove(activeSprint);
				vSprint.getTvSprint().refresh(activeSprint);
				sprints.remove(activeSprint);
				vSprint.getLblInfoTraitement().setForeground(vert);
				vSprint.getLblInfoTraitement().setText("Sprint Suprimmé");
				vSprint.getGrpAjouterUnSprint().setVisible(false);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
				
			}
		});
		
		
		vSprint.getBtnAnnuler().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				vSprint.getBtnModifierSprint().setVisible(true);
				vSprint.getBtnSupprimer().setVisible(true);
				vSprint.getGrpAjouterUnSprint().setVisible(false);
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

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
