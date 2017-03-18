/**
 * @author Abdullah
 * @date 3/7/2017
 */
package model;

public class Date {
	//
	public final int myYear;
	public final int myMonth;
	public final int myDate;
	
	/*
	 * 
	 */
	public Date(int month, int date, int year) {
		myMonth = month;
		myDate = date;
		myYear = year;
	}
	
	
//	public int getDate() {
//		return myDate;
//	}
//
//	public int getMonth() {
//		return myMonth;
//	}
//
//	public int getYear() {	
//		return myYear;
//	}
	
	@Override
	public boolean equals(Object o) {
		
		Date theDate = (Date) (o);
		return (this.myYear == theDate.myYear 
				&& this.myMonth == theDate.myMonth
				&& this.myDate == theDate.myDate);
		
	}

	public String toString() {
		return myMonth + "," + myDate + "," + myYear + ",";
	}
}
