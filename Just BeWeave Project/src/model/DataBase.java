package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	/**
	 * This method gets the users from an event.
	 * @param theEvent: The Event I want the users for.
	 * @return The Array of Users in theEvent.
	 * @throws IOException
	 */
	public static User[] getEventUsers(Event theEvent) throws IOException  {
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader usrFile = new FileReader(new File("UserFile.csv"));
			BufferedReader brFile = new BufferedReader(usrFile);
			
			String line = "";
			String comma = ",";
			
			while ((line = brFile.readLine()) != null) {
				String[] lineArr = line.split(comma);
			}
			
			usrFile.close();
			brFile.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		return (User[]) users.toArray();
	
	}
	
	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		return users;
	}
	
	public static List<Event> getEvents() {
		List<Event> events = new ArrayList<Event>();
		
		return events;
	}
	
	public static User verifyUser(String userName, String password) {
		User u = null;
		
		return u;
	}
	
	public static void saveEvent(Event theEvent) {
		
	}
	
	public static void saveUser(User theUser) {
		
	}
	
}
