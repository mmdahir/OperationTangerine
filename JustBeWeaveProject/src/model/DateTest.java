package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {
	
	Date d1;
	Date d2;

	@Test
	public void testEquals() {
		d1 = new Date(12,12,12);
		d2 = new Date(03,5,17);
		
		Date ds = new Date (3,5,17);
		
		assertEquals(ds, d2);
		assertEquals(d1, new Date(12,12,12));
	}

	@Test
	public void testToString() {
		d1 = new Date(12,12,12);
		d2 = new Date(03,5,17);
		
		String s1 = 12 + "," + 12 + "," + "12,";
		
		
		System.out.println(s1);
		System.out.println(d1.toString());
		assertEquals(s1, d1.toString());
		assertEquals(3 + "," + 5 + "," + "17,", d2.toString());
	}

}
