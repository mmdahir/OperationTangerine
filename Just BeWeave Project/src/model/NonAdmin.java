package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NonAdmin extends AbstractUser {

	private List<String> myEvents;
	
	public NonAdmin(String theUserName, String thePassword, boolean theAdmin) {
		super(theUserName, thePassword, theAdmin);
		myEvents = null;
	}
	
	public List<Event> getEvents() {
		List<Event> events = new ArrayList<Event>();
		for (int i = 0; i < myEvents.size(); i++) {
			try {
				events.add(DataBase.getEvent(myEvents.get(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return events;
	}
	
	public void addEvent(Event theEvent) {
		myEvents.add(theEvent.myTitle);
	}
	
	public void addEvent(String theEventTitle) {
		myEvents.add(theEventTitle);
	}
	
	public void deleteEvent(Event theEvent) {
		for (int i = 0; i < myEvents.size(); i++) {
			if (myEvents.get(i).equals(theEvent.myTitle)) {
				myEvents.remove(i);
				break;
			}
		}
	}
	
	public void deleteEvent(String theEventTitle) {
		for (int i = 0; i < myEvents.size(); i++) {
			if (myEvents.get(i).equals(theEventTitle)) {
				myEvents.remove(i);
				break;
			}
		}
	}
}
