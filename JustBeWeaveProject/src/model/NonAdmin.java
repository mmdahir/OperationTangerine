package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NonAdmin extends AbstractUser {
//
	private List<String> myEvents;
	
	public NonAdmin(String theUserName, String thePassword, boolean theAdmin) {
		super(theUserName, thePassword, theAdmin);
		
		myEvents = new ArrayList<String>();
	}
	
	public List<String> getEvents() {
		return myEvents;
	}
	
//	public List<Event> getEvents() {
//		List<Event> events = new ArrayList<Event>();
//		for (int i = 0; i < myEvents.size(); i++) {
//			try {
//				events.add(DataBase.getEvent(myEvents.get(i)));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return events;
//	}
	
	public void addEvent(String theEventTitle) {
		for (int i = 0; i < myEvents.size(); i++) {
			if (myEvents.get(i).equals(theEventTitle)) {
				return;
			} 
		}
		myEvents.add(theEventTitle);
	}
	
	public void addEvent(Event theEvent) {
		addEvent(theEvent.getTitle());
	}

	public void deleteEvent(String theEventTitle) {
		for (int i = 0; i < myEvents.size(); i++) {
			if (myEvents.get(i).equals(theEventTitle)) {
				myEvents.remove(i);
				break;
			}	
		}
	}
	
	public void deleteEvent(Event theEvent) {
		deleteEvent(theEvent.getTitle());
	}
	
	@Override
	public String toString() {
		String s1 = super.toString();
		for (String s2 : myEvents)
			s1 += s2 + ",";
		return s1;
	}
}
