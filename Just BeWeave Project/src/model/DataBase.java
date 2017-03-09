/*
 TCSS 360
 Instructor: Professor Jeffery Weiss
 */

package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
		BufferedReader brFile = new BufferedReader(usrFile);
		
		String line = "";
		String comma = ",";
		String[] lineArr;
		
		while ((line = brFile.readLine()) != null) {
			
			boolean hasSkipLine = line.contains("sKiPtHiS!@#");
			
			//if (line.contains(confVar) && (lineArr = line.split(comma)).length > 1) {
			if(getAll && !hasSkipLine) {			
				lineArr = line.split(comma); 
				list.add(lineArr);
				
			} else if (line.contains(confVar) && !hasSkipLine) {	
				
				lineArr = line.split(comma); 	/* This line is repeated. If I'm looking
				   								for a specific variable, I don't want to waste
				   								time splitting a String unnecessarily. */
				list.add(lineArr);
				
				usrFile.close();
				brFile.close();
				
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
		
		Event e = null;
		
		//List<User> users = new ArrayList<User>();
		
		LinkedList<String[]> list = checkCSV(myEventCSV, theEvent, false);
		
		if (list.size() < 1) return e;
		
		String[] lineArr = list.get(0);
		
		final int usrNameStartIdx = 6;
		
		if (lineArr.length > 1) {
			//Event(String theTitle, String theLocation, String theDescription, Date theDate)
			String title = lineArr[0];
			String location = lineArr[1];
			String description = lineArr[2];
			Date date = new Date(Integer.parseInt(lineArr[3]), Integer.parseInt(lineArr[4]),
					Integer.parseInt(lineArr[5]));
			
			e = new Event(title, location, description, date);
			
			for(int i = usrNameStartIdx; i < lineArr.length; i++) {
				String username = lineArr[i];
				
				User user = getUser(username);
				
				e.addUser(user);
			}
			
			//e.myUsers = users;
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
	
	/**
	 * Verifies is a username and password is correct.
	 * @param userName: the user name in string form.
	 * @param password: the password in string form.
	 * @return: a User object if valid (null otherwise).
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static User verifyUser(String userName, String password) 
			throws FileNotFoundException, IOException {
		User u = getUser(userName);
		
		if(u == null) return null;
	
		if(u.getPassword().compareTo(password) == 0) {
			//System.out.println("Valid");
			return u;
		}
		
		return null;
	}
	
	/**
	 * Gets a user.
	 * @param userName: String form of the user name.
	 * @return a valid User object (if it exists).
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private static User getUser(String userName) throws FileNotFoundException, IOException {
		
		User u = null;
		
		LinkedList<String[]> list = checkCSV(myUserCSV, userName, false);
		
		if(list.size() < 1) return u;
		
		String[] arr = list.get(0);
		
		//System.out.println(Arrays.toString(arr));
		
		if(arr[2].toLowerCase().contains("f")) {
			u = new NonAdmin(arr[0], arr[1], false);
		} else {
			u = new Admin(arr[0], arr[1], true);
		}
		
		return u;
	}
	
	
	/**
	 * Appends an Event onto the CSV.
	 * @param theEvent: The Event object to be saved.
	 * @throws IOException
	 */
	public static void saveEvent(Event theEvent) throws IOException {
		
		FileWriter usrFile = new FileWriter(new File(myEventCSV), true);
		BufferedWriter brFile = new BufferedWriter(usrFile);
		
		brFile.append(theEvent.toString() + "\n");
		
		brFile.close();
		usrFile.close();
	}
	
	/**
	 * Appends the User to the CSV.
	 * @param theUser: The user object to be saved.
	 * @throws IOException
	 */
	public static void saveUser(User theUser) throws IOException {
		
		FileWriter usrFile = new FileWriter(new File(myUserCSV), true);
		BufferedWriter brFile = new BufferedWriter(usrFile);
		
		brFile.append(theUser.getUserName() + ",");
		brFile.append(theUser.getPassword() + ",");
		
		if (theUser.isAdmin()) {
			brFile.append("TRUE");
		} else {
			brFile.append("FALSE");
		}
		
		brFile.newLine();
		
		brFile.close();
		usrFile.close();
	}
		
}


/*
		public static void main(String[] args) throws FileNotFoundException, IOException {
	
			Event f = getEvent("Event1");
			saveEvent(f);
		}
		
		System.out.println("Start:");
		
		
		//TEST CASE FOR checkCSV
		LinkedList<String[]> u = checkCSV(myEventCSV, "Event1", false);
		System.out.println(Arrays.deepToString(u.get(0)));
		
		System.out.println("\n______________________\n");
		
		
		
		//TEST CASE FOR getEvents
		List<Event> e = getEvents();
		
		for(int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).toString());
		}
		
		System.out.println("\n______________________\n");
		
		//TEST CASE FOR getEvent
		Event f = getEvent("Event1");
		System.out.println(f.toString());
		System.out.println("\nEnd");
		
		
		System.out.println("\n______________________\n");
		
		//TESTCASE FOR verifyUser
		verifyUser("BOB", "PSWDBOB");
		verifyUser("KAKA", "PSWDKAKA");
		verifyUser("KAKA", "PSWDBOB");
		//TESTCASE FOR getUSer
		User ex = getUser("BOB");
		System.out.println(ex.getUserName().compareTo("BOB")); //0
		System.out.println(ex.getUserName().compareTo("BB")); //not 0
		
		System.out.println("\n______________________\n");
		
		saveEvent(f);
		saveUser(new NonAdmin("NICOLE", "PSWDNICOLE", false));	
*/
