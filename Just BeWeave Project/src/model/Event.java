package model;

import java.util.ArrayList;
import java.util.List;

public class Event {
	
	String myTitle;
	String myLocation;
	String myDescription;
	Date myDate;
	List <AbstractUser> myUsers;
	
	public Event(String theTitle) {
		myTitle = theTitle;
		myUsers = new ArrayList<AbstractUser>();
	}
	
	public void setLocation(String theLocation) {
		myLocation = theLocation;
	}
	
	public String getLocation(String theLocation) {
		return theLocation;
	}
	
	public void setDescription(String theDescription) {
		myDescription = theDescription;
	}
	
	public String getDescription() {
		return myDescription;
	}
	
	public void setDate(int month, int date, int year) {
		myDate = new Date(month, date, year);
	}
	
	public Date getDate() {
		return myDate;
	}
	
	public void addUser(AbstractUser theUser) {
		myUsers.add(theUser);
	}
	
	public void removeUser(AbstractUser theUser) {
		for (int i = 0; i < myUsers.size(); i++) {
			if (myUsers.get(i).equals(theUser)) {
				myUsers.remove(i);
			}
		}
	}
	
	public void removeUser(int theIndex) {
		if (theIndex < myUsers.size()) {
			myUsers.remove(theIndex);
		}
	}
	
	public AbstractUser getUser(int theIndex) {
		if (theIndex < myUsers.size()) {
			return myUsers.get(theIndex);
		}
		return null;
	}
	
	public AbstractUser getUser(String theUserName) {
		for (int i = 0; i < myUsers.size(); i++) {
			if (myUsers.get(i).getUserName() == theUserName) {
				return myUsers.get(i);
			}
		}
		return null;
	}
}
