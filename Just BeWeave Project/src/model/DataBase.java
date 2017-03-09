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

// NOTE THAT THE Events CSV WILL BE FORMATTED AS: TITLE, LOCATION, DESCRIPTION, MONTH, DATE, YEAR, USR1, USR2, etc
//public Event(String theTitle, String theLocation, String theDescription, Date theDate)

//NOTE THAT THE Users CSV WILL BE FORMATTED AS: USER1NAME, USER2PSWD, USER1BOOLEAN, ETC...
//NonAdmin(String theUserName, String thePassword, boolean theAdmin)



/**
 * The DataBase class the will read and write to and from a CSV file.
 * 
 * @author Peter
 */
public class DataBase {
	
	/** The directory to the Events.csv */
	private static String myEventCSV = "src/model/Events.csv";
	
	/** The directory to the Events.csv */
	private static String myUserCSV = "src/model/Users.csv";
	
	/**
	 * Grabs either one line or all the lines from a csv file.
	 * @param theFile: the name of the csv file I want to check.
	 * @param confVar: Identifying string if I'm looking for a specific line in the csv.
	 * @param getAll: A boolean to see if I want all lines in the csv file.
	 * @return A String array.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static LinkedList<String[]> checkCSV(String theFile, String confVar, boolean getAll) 
			throws IOException, FileNotFoundException {
		
		LinkedList<String[]> list = new LinkedList<String[]>();
		
		FileReader usrFile = new FileReader(new File(theFile));
		
		@SuppressWarnings("resource")
		BufferedReader brFile = new BufferedReader(usrFile);
		
		String line = "";
		String comma = ",";
		String[] lineArr;
		
		while ((line = brFile.readLine()) != null && !line.contains("sKiPtHiS!@#")) {
			
			//if (line.contains(confVar) && (lineArr = line.split(comma)).length > 1) {
			if(getAll) {			
				lineArr = line.split(comma); 
				list.add(lineArr);
				
			} else if (line.contains(confVar)) {	
				lineArr = line.split(comma); 	/* This line is repeated. If I'm looking
				   								for a specific variable, I don't want to waste
				   								time splitting a String unnecessarily. */
				list.add(lineArr);
				return list;
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
	public static Event getEvent(String theEvent) throws IOException {
		
		Event e = new Event("");
		
		List<User> users = new ArrayList<User>();
		
		LinkedList<String[]> list = checkCSV(myEventCSV, theEvent, false);
		
		if (list.size() < 1) return e;
		
		String[] lineArr = list.get(0);
		
		if (lineArr.length > 1) {
			
			for(int i = 1; i < lineArr.length; i++) {
				//NonAdmin(String theUserName, String thePassword, boolean theAdmin)
				String username = lineArr[i];
				String pswd = lineArr[++i];
				
				boolean isAdmin = false;
				if(lineArr[++i].toLowerCase().contains("t")) {
					isAdmin = true;
				}
				
				NonAdmin user = new NonAdmin(username, pswd, isAdmin);
				users.add(user);
			}
		}	
		
		
		
		return e;
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
		
		LinkedList<String[]> eventList = checkCSV(myEventCSV, "", true);
		
		
		
		for(int i = 0; i < eventList.size(); i++) {
			//public Event(String theTitle, String theLocation, String theDescription, Date theDate)
			
			String[] list = eventList.get(i);
			
			String title = list[0];
			String loc = list[1];
			String des = list[2];
			Date date = new Date(Integer.parseInt(list[3]), Integer.parseInt(list[4]), 
					Integer.parseInt(list[5]));
			
			Event e = new Event(title, loc, des, date);
			events.add(e);
		}
		
		return events;
	}
	
	public static User verifyUser(String userName, String password) {
		User u = null;
		
		return u;
	}
	
	private static User verifyUser(String userName) {
		User u = null;
		
		return u;
	}
	
	public static void saveEvent(Event theEvent) {
		
	}
	
	public static void saveUser(User theUser) {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//checkCSV(String theFile, String confVar, boolean getAll)
		System.out.println("Start");
		
		LinkedList<String[]> u = checkCSV("src/model/Events.csv", "Event1", false);
		
		System.out.println(Arrays.deepToString(u.get(0)));
		
		/////////////////////
		System.out.println("\nMiddle\n");
		/////////////////////
		
		LinkedList<Event> e = new LinkedList<Event>();
		
		for(int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).toString());
		}
		
		System.out.println("End");
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