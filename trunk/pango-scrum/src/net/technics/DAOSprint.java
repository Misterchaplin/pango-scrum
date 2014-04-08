package net.technics;

import java.text.Format;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ibm.icu.text.SimpleDateFormat;

import net.models.Event;
import net.models.Sprint;

public class DAOSprint {
	
	public static String getDateDebut(Sprint sprint) {
		Set<Event> events = new HashSet<Event>();
		events = sprint.getEvents();
		Iterator<Event> it= events.iterator();
	    Event ev = new Event();
	    Event ev2=new Event();
	    Date  dateDebut = null;
		
		while (it.hasNext()){
			ev=it.next();
			ev2=it.next();
			Date date1=ev.getEventDate();
			Date date2=ev2.getEventDate();
			// traitement du cas date1 < date2	
			if (date1.compareTo(date2 ) == -1){
				if(dateDebut==null){
				dateDebut=date1;
				}
				else if(dateDebut!=null && date1.compareTo(dateDebut) == -1)
					dateDebut=date1;
				
			}
			// traitement du cas date1 > date2
			if (date1.compareTo(date2 ) == 1) {
				if(dateDebut==null){
				   dateDebut=date2;
				}
				else if (date1.compareTo(date2 ) == 1 && dateDebut.compareTo(date2 ) == 1){
				dateDebut=date2;
				}
						
			}	
			date1=null;
			date2=null;

		}
			
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String result="";
		if(dateDebut!=null)
		result= formatter.format(dateDebut);
		return result;
	}
	
	public static String getDateFin(Sprint sprint){
		Set<Event> events = new HashSet<Event>();
		events = sprint.getEvents();
		Iterator<Event> it= events.iterator();
	    Event ev = new Event();
	    Event ev2=new Event();
	    Date  dateDebut = null;
	    
	    while (it.hasNext()){
			ev=it.next();
			ev2=it.next();
			Date date1=ev.getEventDate();
			Date date2=ev2.getEventDate();
			// traitement du cas date1 < date2	
			if (date1.compareTo(date2 ) == -1){
				if(dateDebut==null){
				dateDebut=date2;
				}
				else if(dateDebut!=null && date1.compareTo(dateDebut) == -1)
					dateDebut=date2;
				
			}
			// traitement du cas date1 > date2
			if (date1.compareTo(date2 ) == 1) {
				if(dateDebut==null){
				   dateDebut=date1;
				}
				else if (date1.compareTo(date2 ) == 1 && dateDebut.compareTo(date2 ) == 1){
				dateDebut=date1;
				}
						
			}	
			date1=null;
			date2=null; 
		
	    
	    }
		
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String result="";
		if(dateDebut!=null)
		result= formatter.format(dateDebut);
		return result;
	}
}
