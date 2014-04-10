package net.technics;

import java.text.Format;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import net.models.Event;
import net.models.Eventtype;
import net.models.Participate;
import net.models.Product;
import net.models.Sprint;
import net.models.Userstory;
import net.vues.VSprint;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

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
			if (date1.compareTo(date2 ) == 1 ) {
				if (dateDebut==null){
					dateDebut=date2;
				}
				else if (dateDebut!=null && dateDebut.compareTo(date2)==1 )
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
	    Date  dateFin = null;
	    while (it.hasNext()){
	    	ev=it.next();
			ev2=it.next();
			Date date1=ev.getEventDate();
			Date date2=ev2.getEventDate();
			if (date1.compareTo(date2 ) == -1 ){
				if (dateFin==null){
					dateFin=date2;
				}
				else if(dateFin!=null && dateFin.compareTo(date1)==-1){
					dateFin=date2;
				}
				// traitement du cas date1 < date2
			}
			
			if (date1.compareTo(date2 ) == 1 ) {
				if (dateFin==null){
					dateFin=date1;
				}
				else if (dateFin !=null && dateFin.compareTo(date2)==1 )
				// traitement du cas date1 > date2
				dateFin=date1;
			}
	    }
	    Format formatter = new SimpleDateFormat("dd-MM-yyyy");
		String result="";
		if(dateFin!=null)
		result= formatter.format(dateFin);
		return result;
	}
	

	
	
	public static Sprint addSprint(VSprint sprint){
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		
		@SuppressWarnings("deprecation")
		Date dateDeb = new Date(sprint.getDateDebut().getYear()-1900,sprint.getDateDebut().getMonth(),sprint.getDateDebut().getDay());
		@SuppressWarnings("deprecation")
		Date dateFin = new Date(sprint.getDateFin().getYear()-1900,sprint.getDateFin().getMonth(),sprint.getDateFin().getDay());
		Product product;
		Event event;
		Userstory userStory;
		Set<Event> evenements = new HashSet<Event>();
		Set<Participate> participants = new HashSet<Participate>();
		Set<Userstory> stories = new HashSet<Userstory>();
		product = (Product) session.get(Product.class, 3);
		Sprint sprint1 = new Sprint(product);
		sprint1.setLabel(sprint.getnewNameSprint().getText());
		session.persist(sprint1);
		
	    event=new Event(sprint1,(Eventtype)session.get(Eventtype.class, 1),dateDeb);
		evenements.add(event);
		session.persist(event);
		
		event=new Event(sprint1,(Eventtype)session.get(Eventtype.class, 2),dateFin);
		evenements.add(event);
		session.persist(event);
		sprint1.setEvents(evenements);

		
		
		trans.commit();
		session.close();
		
		return sprint1;
		
		
		
		
		
	}
}
