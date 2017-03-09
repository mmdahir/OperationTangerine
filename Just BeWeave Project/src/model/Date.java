/**
 * @author Abdullah
 * @date 3/7/2017
 */
package model;

public class Date {
	
	int myYear;
	int myMonth;
	int myDate;
	
	/*
	 * 
	 */
	Date(int month, int date, int year) {
		myMonth = month;
		myDate = date;
		myYear = year;
	}
	
	public String toString() {
		return myMonth + "," + myDate + "," + myYear;
	}
}
