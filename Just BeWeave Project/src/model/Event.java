/**
 * @author Abdullah
 * @date 3/7/2017
 */

package model;

import java.util.ArrayList;
import java.util.List;
//
public class Event {
	
	/**
	 * This is the title of event.
	 */
	private String myTitle;
	
	/**
	 * This is the location of event.
	 */
	private String myLocation;
	
	/**
	 * A brief description of event.
	 */
	private String myDescription;
	
	/**
	 * The date when event will take place.
	 */
	private Date myDate;
	
	/**
	 * List of users participating in event.
	 */
	private List <User> myUsers;
	
	/**
	 *
	 */
	public Event(String theTitle) {
		myTitle = theTitle;
		myLocation = "";
		myDescription = "";
		myDate = null;
		myUsers = new ArrayList<User>();
	}
	
	/**
	 * 
	 */
	public Event(String theTitle, String theLocation, String theDescription, Date theDate) {
		myTitle = theTitle;
		myLocation = theLocation;
		myDescription = theDescription;
		myDate = theDate;
		myUsers = new ArrayList<User>();
	}
	
	/**
	 * 
	 */
	public void setTitle(String theTitle) {
		myTitle = theTitle;
	}
	
	/**
	 * 
	 */
	public String getTitle() {
		return myTitle;
	}
	
	/**
	 * 
	 */
	public void setLocation(String theLocation) {
		myLocation = theLocation;
	}
	
	/**
	 * 
	 */
	public String getLocation() {
		return myLocation;
	}
	
	/**
	 * 
	 */
	public void setDescription(String theDescription) {
		myDescription = theDescription;
	}
	
	/**
	 * 
	 */
	public String getDescription() {
		return myDescription;
	}
	
	/**
	 * 
	 */
	public void setDate(int month, int date, int year) {
		myDate = new Date(month, date, year);
	}
	
	/**
	 * 
	 */
	public Date getDate() {
		return myDate;
	}
	
	/**
	 * 
	 */
	public void addUser(User theUser) {
		if (!myUsers.contains(theUser)) {
			myUsers.add(theUser);
		}
	}
	
	/**
	 * 
	 */
	public void removeUser(User theUser) {
		for (int i = 0; i < myUsers.size(); i++) {
			if (myUsers.get(i).equals(theUser)) {
				myUsers.remove(i);
			}
		}
	}
	
	/**
	 * 
	 */
	public void removeUser(int theIndex) {
		if (theIndex < myUsers.size()) {
			myUsers.remove(theIndex);
		}
	}
	
	/**
	 * 
	 */
	public User getUser(int theIndex) {
		User u = null;
		if (theIndex < myUsers.size()) {
			u = myUsers.get(theIndex);
		}
		return u;
	}
	
	/**
	 * 
	 */
	public User getUser(String theUserName) {
		User u = null;
		for (int i = 0; i < myUsers.size(); i++) {
			if (myUsers.get(i).getUserName() == theUserName) {
				u = myUsers.get(i);
			}
		}
		return u;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(myTitle + "," );
		b.append(myLocation + ",");
		b.append(myDescription + ",");
		b.append(myDate + ",");
		
		for (User u : myUsers) 
			b.append(u.getUserName() + ",");
		
		return b.toString();
	}
}
