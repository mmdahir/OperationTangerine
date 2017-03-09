package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
	
	/**
	 * 
	 * @throws IOException
	 */
	public static User[] getUsers() throws IOException  {
		
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
	
}
