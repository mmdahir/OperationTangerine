package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NonAdmin extends AbstractUser {

	List<String> myEvents;
	
	public NonAdmin(String theUserName, String thePassword) {
		super(theUserName, thePassword, false);
		
		myEvents = new ArrayList<String>();
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
	
	public void addEvent(String myEventTitle) {
		myEvents.add(myEventTitle);
	}
	
	public void addEvent(Event myEvent) {
		myEvents.add(myEvent.myTitle);
	}

	public void deleteEvent(String myEventTitle) {
		for (int i = 0; i < myEvents.size(); i++) {
			if (myEvents.get(i).equals(myEventTitle)) {
				myEvents.remove(i);
				break;
			}	
		}
	}
	
	public void deleteEvent(Event myEvent) {
		for (int i = 0; i < myEvents.size(); i++) {
			if (myEvents.get(i).equals(myEvent.myTitle)) {
				myEvents.remove(i);
				break;
			}	
		}
	}
	
	@Override
	public String toString() {
		String s1 = super.toString();
		for (String s2 : myEvents) 
			s1.concat("," + s2 + ",");
		return s1;
	}
}
