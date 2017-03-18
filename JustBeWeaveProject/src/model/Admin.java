package model;

import java.io.IOException;

public class Admin extends AbstractUser {

	public Admin(String theUserName, String thePassword, boolean theAdmin) {
		super(theUserName, thePassword, theAdmin);
	}
	
	public Event createEvent(String title, String location, Date date, String description) {
		Event e = new Event(title, location, description, date);
		try {
			DataBase.saveEvent(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return e;
	}
}