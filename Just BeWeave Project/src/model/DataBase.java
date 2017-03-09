/*
 TCSS 360
 Instructor: Professor Jeffery Weiss
 */

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// NOTE THAT THE Events CSV WILL BE FORMATTED AS: TITLE, LOCATION, DESCRIPTION, MONTH, DATE, YEAR
//public Event(String theTitle, String theLocation, String theDescription, Date theDate)

//NOTE THAT THE Users CSV WILL BE FORMATTED AS: USER1NAME, USER2PSWD, USER1BOOLEAN, ETC...
//NonAdmin(String theUserName, String thePassword, boolean theAdmin)



/**
 * The DataBase class the will read and write to and from a CSV file.
 * 
 * @author Peter
 */
public class DataBase {
	
	/**
	 * Grabs either one line or all the lines from a csv file.
	 * @param theFile: the name of the csv file I want to check.
	 * @param confVar: Identifying string if I'm looking for a specific line in the csv.
	 * @param getAll: A boolean to see if I want all lines in the csv file.
	 * @return A String array.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static String[] checkCSV(String theFile, String confVar, boolean getAll) 
			throws IOException, FileNotFoundException {
		
		LinkedList<String> list = new LinkedList<String>();
		
		FileReader usrFile = new FileReader(new File(theFile));
		BufferedReader brFile = new BufferedReader(usrFile);
		
		String line = "";
		String comma = ",";
		String[] lineArr;
		
		while ((line = brFile.readLine()) != null) {
			
			//if (line.contains(confVar) && (lineArr = line.split(comma)).length > 1) {
			if(getAll) {			
				lineArr = line.split(comma); 
				list.addAll(Arrays.asList(lineArr));
				
			} else if (line.contains(confVar)) {	
				lineArr = line.split(comma); 	/* This line is repeated. If I'm looking
				   								for a specific variable, I don't want to waste
				   								time splitting a String unnecessarily. */
				return lineArr;
			}
			
		}
		
		usrFile.close();
		brFile.close();
		
		return (String[]) list.toArray();
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
		
		String[] lineArr = checkCSV("Events.csv", theEvent, false);
		
		
		if (lineArr.length > 1) {
			
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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static List<Event> getEvents() throws FileNotFoundException, IOException {
		List<Event> events = new ArrayList<Event>();
		
		String[] list = checkCSV("Events.csv", "", true);
		
		
		for(int i = 0; i < list.length; i++) {
			//public Event(String theTitle, String theLocation, String theDescription, Date theDate)
			String title = list[i];
			String loc = list[++i];
			String des = list[++i];
			String sDate = list[++i];
			
			Date date = new Date(Integer.parseInt(list[++i]), Integer.parseInt(list[++i]), 
					Integer.parseInt(list[++i]));
			
			Event e = new Event(title, loc, des, date);
			events.add(e);
		}
		
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
	
	public static void main(String[] args) {
		
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