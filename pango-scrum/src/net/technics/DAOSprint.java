package net.technics;

import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.controller.SprintController;
import net.models.Event;
import net.models.Eventtype;
import net.models.Product;
import net.models.Sprint;
import net.models.Userstory;
import net.vues.VSprint;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.icu.text.SimpleDateFormat;


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
	
	@SuppressWarnings("unused")
	public static Event getEventDateDeb(Sprint sprint){
		Set<Event> events = new HashSet<Event>();
		events = sprint.getEvents();
		Iterator<Event> it= events.iterator();
	    Event ev = new Event();
	    Event ev2=new Event();
	    Event dateD = null;
		Date dateDeb = null;
		while (it.hasNext()){
			ev=it.next();
			ev2=it.next();
			Date date1=ev.getEventDate();
			Date date2=ev2.getEventDate();

			// traitement du cas date1 < date2	
			if (date1.compareTo(date2 ) == -1){
				if(dateDeb==null){
				dateDeb=date1;
				dateD=ev;
				}
				else if(dateDeb!=null && date1.compareTo(dateDeb) == -1)
					dateDeb=date1;
					dateD=ev;
				
			}
			// traitement du cas date1 > date2
			if (date1.compareTo(date2 ) == 1 ) {
				if (dateDeb==null){
					dateDeb=date2;
					dateD=ev2;
				}
				else if (dateDeb!=null && dateDeb.compareTo(date2)==1 )
				if(dateDeb==null){
				   dateDeb=date2;
				   dateD=ev2;
				}
				else if (date1.compareTo(date2 ) == 1 && dateDeb.compareTo(date2 ) == 1){
				dateDeb=date2;
				dateD=ev2;
				}
						
			}	
			date1=null;
			date2=null;

		}
		return dateD;	
	}
	
	public static Event getEventDateFin(Sprint sprint){
		Set<Event> events = new HashSet<Event>();
		events = sprint.getEvents();
		Iterator<Event> it= events.iterator();
	    Event ev = new Event();
	    Event ev2=new Event();
	    Date  dateFin = null;
	    Event dateF = null;
	    while (it.hasNext()){
	    	ev=it.next();
			ev2=it.next();
			Date date1=ev.getEventDate();
			Date date2=ev2.getEventDate();
			if (date1.compareTo(date2 ) == -1 ){
				if (dateFin==null){
					dateFin=date2;
					dateF=ev2;
				}
				else if(dateFin!=null && dateFin.compareTo(date1)==-1){
					dateFin=date2;
					dateF=ev2;
				}
				// traitement du cas date1 < date2
			}
			// traitement du cas date1 > date2
			if (date1.compareTo(date2 ) == 1 ) {
				if (dateFin==null){
					dateFin=date1;
					dateF=ev;
				}
				else if (dateFin !=null && dateFin.compareTo(date2)==1 ){
				
				dateFin=date1;
				dateF=ev;
				}
			}
	    }
	    return dateF;
	}

	
	
	public static Sprint addSprint(VSprint sprint,int idProduct){
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		
		@SuppressWarnings("deprecation")
		Date dateDeb = new Date(sprint.getDateDebut().getYear()-1900,sprint.getDateDebut().getMonth(),sprint.getDateDebut().getDay());
		@SuppressWarnings("deprecation")
		Date dateFin = new Date(sprint.getDateFin().getYear()-1900,sprint.getDateFin().getMonth(),sprint.getDateFin().getDay());
		Product product;
		Event event=null;
		Event event1=null;
		Set<Event> evenements = new HashSet<Event>();
		
		product = (Product) session.get(Product.class, idProduct);
		Sprint sprint1 = new Sprint(product);
		sprint1.setLabel(sprint.getNewNameSprint().getText());
		session.persist(sprint1);
		
	    event=new Event(sprint1,(Eventtype)session.get(Eventtype.class, 1),dateDeb);
		evenements.add(event);
		session.persist(event);
		
		event1=new Event(sprint1,(Eventtype)session.get(Eventtype.class, 2),dateFin);
		evenements.add(event1);
		session.persist(event1);
		sprint1.setEvents(evenements);
		if(DAOSprint.VerifSprint(sprint1, idProduct)==false){
			//trans.wasCommitted()
			//session.clear();
			session.delete(event);
			session.delete(event1);
			session.delete(sprint1);
			
			session.close();
			return null;
		}
		else {
		
		trans.commit();
		session.close();
		return sprint1;
		}
		
		
		
	}
	
	public static Boolean VerifSprint(Sprint sprint,int idProduct) {
		Session session = HibernateUtil.getSession();
		Query query=session.createQuery("From Sprint Where product.id=:activeProduct");
		query.setParameter("activeProduct",idProduct);
		List<Sprint> lesSprints=query.list();
		//Set<Event> lesEventsSprintAAjouter= new HashSet<Event>();
		//lesEventsSprintAAjouter=sprint.getEvents();
		//Iterator<Event> it= lesEventsSprintAAjouter.iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		boolean result = false;
		Date DateDebNewSprint = null;
		Date DateFinNewSprint= null;
		try {
			DateDebNewSprint = sdf.parse(DAOSprint.getDateDebut(sprint));
			DateFinNewSprint = sdf.parse(DAOSprint.getDateFin(sprint));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date dateDebut = null;
		Date dateFin = null;
		
		for (Sprint s:lesSprints){
			try {
				dateDebut=sdf.parse(DAOSprint.getDateDebut(s));
				dateFin=sdf.parse(DAOSprint.getDateFin(s));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*// traitement du cas date1 < date2	
			if (date1.compareTo(date2 ) == -1){*/
			if (DateDebNewSprint.compareTo(dateDebut) == 1 && DateDebNewSprint.compareTo(dateFin) == -1){
				result = false;
			}
			else if (DateFinNewSprint.compareTo(dateDebut) == 1 && DateFinNewSprint.compareTo(dateFin) == -1){
				result = false;
			}
			else if (DateDebNewSprint.compareTo(dateDebut) == 0 || DateDebNewSprint.compareTo(dateFin) == 0){
				result = false;
			}
			else if (DateFinNewSprint.compareTo(dateDebut) == 0 || DateFinNewSprint.compareTo(dateFin) == 0){
				result = false;
			}
			
			else{
				result = true;
			}
		
	
		}
		return result;
		
	}
	
	public static void deleteSprint(int id){
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Sprint s = (Sprint) session.get(Sprint.class, id);
		session.delete(s);
		trans.commit();
		session.close();
	}
	
	public static void updateName(Sprint sprint,String newLabel){
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("update Sprint set label=:newLbl where id=:idSprint");
		query.setParameter("newLbl", newLabel);
		query.setParameter("idSprint", sprint.getId());
		query.executeUpdate();
		trans.commit();
		session.close();
	}
	
	public static void updateDate(Sprint sprint,Date newDate,Boolean debut){
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query=null;
		if(debut==true){
		query= session.createQuery("update Event set eventDate=:newDate where sprint.id=:idSprint and eventtype.id=:idEventtype");
		query.setParameter("idEventtype", 1);
		}
		else{
			query= session.createQuery("update Event set eventDate=:newDate where sprint.id=:idSprint and eventtype.id=:idEventtype");
			query.setParameter("idEventtype", 2);	
		}
		query.setParameter("newDate", newDate);
		query.setParameter("idSprint", sprint.getId());		
		
		query.executeUpdate();
		trans.commit();
		session.close();
				
	}
}
