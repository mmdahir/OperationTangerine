package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// NOTE THAT THE CSV WILL BE FORMATTED AS: EVENTNAME, USER1, USER2, ETC...

public class DataBase {
	
	/**
	 * This method gets the users from an event.
	 * @param theEvent: The String event name.
	 * @return The Array of Users in theEvent.
	 * @throws IOException
	 * Pre: Expects a valid string of a valid event.
	 * Post: A valid List of Users.
	 */
	public static List<User> getUsers(String theEvent) throws IOException {
		
		List<User> users = new ArrayList<User>();
		
		boolean found = false;
		
		try {
			FileReader usrFile = new FileReader(new File("UserFile.csv"));
			BufferedReader brFile = new BufferedReader(usrFile);
			
			String line = "";
			String comma = ",";
			
			while ((line = brFile.readLine()) != null) {
				
				
				if (line.contains(theEvent)) {
					found = true;
					String[] lineArr = line.split(comma);
					
					//for()
					
					break;
				}
				
			}
			
			usrFile.close();
			brFile.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		
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
