package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {
	
	Event myEvent1;
	Event myEvent2;
	Event myEvent3;
	Event myEvent4;


	@Test
	public void testSetGetTitle() {
		myEvent1 = new Event("e1");
		myEvent2 = new Event("e2");
		myEvent3 = new Event("e3", "location3", "description3", new Date(3,3,3));
		myEvent4 = new Event("e4", "location4", "description4", new Date(4,4,4));
		
		assertEquals("e2", myEvent2.getTitle());
		assertEquals("e4", myEvent4.getTitle());
		
		myEvent1.setTitle("ne1");
		assertEquals("ne1", myEvent1.getTitle());
			
		myEvent3.setTitle("ne3");
		assertEquals("ne3", myEvent3.getTitle());
		
		
	
	}


	@Test
	public void testSetLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveUserUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveUserInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserString() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
