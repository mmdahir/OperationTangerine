package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// NOTE THAT THE CSV WILL BE FORMATTED AS: EVENTNAME, USER1Name, USER1pswd, USER1boolean, UETC...
//NonAdmin(String theUserName, String thePassword, boolean theAdmin)

public class DataBase {
	
	/**
	 * Grabs either one line or all the lines from a csv file.
	 * @param theFile: the name of the csv file I want to check.
	 * @param confVar: Identifying string if I'm looking for a specific line in the csv.
	 * @param getAll: A boolean to see if I want all lines in the csv file.
	 * @return A LinkedList of String arrays.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static LinkedList<String[]> checkCSV(String theFile, String confVar, boolean getAll) 
			throws IOException, FileNotFoundException {
		
		LinkedList<String[]> list = new LinkedList<String[]>();
		
		FileReader usrFile = new FileReader(new File(theFile));
		BufferedReader brFile = new BufferedReader(usrFile);
		
		String line = "";
		String comma = ",";
		String[] lineArr;
		
		while ((line = brFile.readLine()) != null) {
			
			
			//if (line.contains(confVar) && (lineArr = line.split(comma)).length > 1) {
			if(getAll) {			
				lineArr = line.split(comma); 
				list.add(lineArr);
				
			} else if (line.contains(confVar)) {	
				lineArr = line.split(comma); 	/* This line is repeated. If I'm looking
				   								for a specific variable, I don't want to waste
				   								time splitting a String unnecessarily. */
				
				list.add((String[]) lineArr.clone());
				break;
			}
			
		}
		
		usrFile.close();
		brFile.close();
		
		return list;
	}
	
	/**
	 * This method gets the users for an event.
	 * @param theEvent: The String event name.
	 * @return The Array of Users in theEvent.
	 * @throws IOException
	 * Pre: Expects a valid string of a valid event.
	 * Post: A valid List of Users.
	 */
	public static List<User> getUsers(String theEvent) throws IOException {
		
		List<User> users = new ArrayList<User>();
		
		LinkedList<String[]> list = checkCSV("Events.csv", theEvent, false);
		
		String[] lineArr;
		
		if (list.size() > 0 && (lineArr = list.get(0)).length > 1) {
			
			for(int i = 1; i < lineArr.length; i++) {
				//NonAdmin(String theUserName, String thePassword, boolean theAdmin)
				String username = lineArr[i];
				String pswd = lineArr[++i];
				
				boolean isAdmin = false;
				if(lineArr[++i].contains("t")) {
					isAdmin = true;
				}
				
				NonAdmin user = new NonAdmin(username, pswd, isAdmin);
				users.add(user);
			}
		}	
		
		return users;
	}
	
	/**
	 * Get a list of events.
	 * @return A List of Events.
	 * Post: a valid list of Events.
	 */
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


/*
//getUser sample
List<User> users = new ArrayList<User>();
		
		boolean found = false;
		
		try {
			FileReader usrFile = new FileReader(new File("Events.csv"));
			BufferedReader brFile = new BufferedReader(usrFile);
			
			String line = "";
			String comma = ",";
			String[] lineArr;
			
			while ((line = brFile.readLine()) != null) {
				
				if (line.contains(theEvent) && (lineArr = line.split(comma)).length > 1) {
					
					found = true;
					
					for(int i = 1; i < lineArr.length; i++) {
						//NonAdmin(String theUserName, String thePassword, boolean theAdmin)
						String username = lineArr[i];
						String pswd = lineArr[++i];
						
						boolean isAdmin = false;
						if(lineArr[++i].contains("t")) {
							isAdmin = true;
						}
						
						NonAdmin user = new NonAdmin(username, pswd, isAdmin);
						users.add(user);
					}
					break;
				}
				
			}
			
			usrFile.close();
			brFile.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		return users;

*/