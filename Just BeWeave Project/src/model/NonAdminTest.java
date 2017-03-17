package model;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NonAdminTest {
	
	Event e1 = new Event("e1");
	Event e2 = new Event("e2");
	Event e3 = new Event("e3", "location3", "description3", new Date(3,3,3));
	Event e4= new Event("e4", "location4", "description4", new Date(4,4,4));
	
	NonAdmin u1;
	NonAdmin u2;
	Admin u3;
	

	@Test
	public void testAddGetDeleteEvent() {
		u1 = new NonAdmin("u1", "p1", false);
		u2 = new NonAdmin("u2", "p2", false);
		
		u1.addEvent(e1);
		u1.addEvent(e2.getTitle());
		
		List <String> l = new ArrayList<String>();
		l.add(e1.getTitle());
		l.add(e2.getTitle());
		
		System.out.println(l.toString());
		System.out.println(u1.getEvents().toString());
		assertEquals(l, u1.getEvents());
	}


	@Test
	public void testGetSetUserName() {
		u1 = new NonAdmin("u1", "p1", false);
		u2 = new NonAdmin("u2", "p2", false);
		
		u1.setUserName("nu1");
		
		assertEquals("nu1", u1.getUserName());
		assertEquals("u2", u2.getUserName());
	}

	@Test
	public void testGetSetPassword() {
		u1 = new NonAdmin("u1", "p1", false);
		u2 = new NonAdmin("u2", "p2", false);
		
		u1.setPassword("np1");
		
		assertEquals("np1", u1.getPassword());
		assertEquals("p2", u2.getPassword());
	}

	@Test
	public void testIsAdmin() {
		u1 = new NonAdmin("u1", "p1", false);
		u3 = new Admin("u3", "p3", true);
		
		assertEquals(false, u1.isAdmin());
		assertEquals(true, u3.isAdmin());
	}


	@Test
	public void testEquals() {
		u1 = new NonAdmin("u1", "p1", false);
		u2 = new NonAdmin("u1", "p1", false);
		
		assertEquals(u2, u1);
	}
	
	@Test
	public void testToString() {
		u1 = new NonAdmin("u1", "p1", false);
		u3 = new Admin("u3", "p3", true);
		
		assertEquals("u1,p1,FALSE,", u1.toString());
		assertEquals("u3,p3,TRUE,", u3.toString());
		
		
	}

}
