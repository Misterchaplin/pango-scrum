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
	private static Event e1;
	private static Event e2;
	//private static Date DateDebut;
	
	
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
				
			if (date2.compareTo(date1 ) == -1){
				dateDebut=date1;
				// traitement du cas date1 < date2
			}
			
			if (date1.compareTo(date2 ) == 1) {
				// traitement du cas date1 > date2
				dateDebut=date2;
			}
			
			date1=null;
			date2=null;
		 
		
		}
		
		
		Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		//formatter.format(e.getEventDate());
		//parcour hashset
		/*Hashset<TonObjet> hs = new Hashset<TonObjet>();
		Iterator<TonObjet> it = hs.iterator();
		while (it.hasNext()) {
		 System.out.println(it.next());
		}*/
		
		String result="";
		if(dateDebut!=null)
		result= formatter.format(dateDebut);
		return result;
	}
}
