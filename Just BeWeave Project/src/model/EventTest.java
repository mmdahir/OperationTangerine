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
	public void testSetGetLocation() {
		myEvent1 = new Event("e1");
		myEvent2 = new Event("e2");
		myEvent3 = new Event("e3", "location3", "description3", new Date(3,3,3));
		myEvent4 = new Event("e4", "location4", "description4", new Date(4,4,4));
		
		assertEquals("", myEvent2.getLocation());
		assertEquals("location4", myEvent4.getLocation());
		
		myEvent1.setLocation("nl1");
		assertEquals("nl1", myEvent1.getLocation());
			
		myEvent3.setLocation("nl3");
		assertEquals("nl3", myEvent3.getLocation());
	}


	@Test
	public void testSetGetDescription() {
		myEvent1 = new Event("e1");
		myEvent2 = new Event("e2");
		myEvent3 = new Event("e3", "location3", "description3", new Date(3,3,3));
		myEvent4 = new Event("e4", "location4", "description4", new Date(4,4,4));
		
		assertEquals("", myEvent2.getDescription());
		assertEquals("description4", myEvent4.getDescription());
		
		myEvent1.setDescription("nl1");
		assertEquals("nl1", myEvent1.getDescription());
			
		myEvent3.setDescription("nl3");
		assertEquals("nl3", myEvent3.getDescription());
	}


	@Test
	public void testGetSetDate() {
		
		Date d3 = new Date(3,3,3);
		
		myEvent1 = new Event("e1");
		myEvent2 = new Event("e2");
		myEvent3 = new Event("e3", "location3", "description3", d3);
		myEvent4 = new Event("e4", "location4", "description4", new Date(4,4,4));
		
		assertEquals(null, myEvent2.getDate());
		assertEquals(new Date(4,4,4), myEvent4.getDate());
		
		myEvent1.setDate(1,1,1);
		assertEquals(new Date(1,1,1), myEvent1.getDate());
			
		assertEquals(d3, myEvent3.getDate());
	}

	@Test
	public void testAddRemoveGetUser() {
		myEvent1 = new Event("e1");
		
		myEvent3 = new Event("e3", "location3", "description3", new Date(3,3,3));
				
		User u1 = new NonAdmin("u1", "p1", false);
		User u2 = new NonAdmin("u2", "p2", false);
		User u3 = new NonAdmin("u3", "p3", false);
		User u4 = new NonAdmin("u4", "p4", false);
		
		myEvent1.addUser(u1);
		myEvent1.addUser(u2);
		myEvent1.addUser(u3);
		myEvent1.addUser(u4);

		myEvent3.addUser(u1);
		myEvent3.addUser(u4);
		myEvent3.addUser(u2);
		myEvent3.addUser(u3);
		
		assertEquals(u1, myEvent1.getUser(u1.getUserName()));
		assertEquals(u3, myEvent1.getUser(2));
		
		myEvent1.removeUser(u1);
		assertEquals(u2, myEvent1.getUser(0));		
		myEvent1.removeUser(1);
		assertEquals(u4, myEvent1.getUser(u4.getUserName()));
		
		
		assertEquals(u1, myEvent3.getUser(u1.getUserName()));
		assertEquals(u3, myEvent3.getUser(3));
		
		myEvent3.removeUser(u1);
		assertEquals(u4, myEvent3.getUser(0));
		
		myEvent3.removeUser(2);
		assertEquals(u4, myEvent3.getUser(u4.getUserName()));
		
	}

	@Test
	public void testToString() {
		myEvent1 = new Event("e1");
		myEvent1.addUser(new NonAdmin("u1", "p1", false));
		myEvent1.addUser(new NonAdmin("u2", "p1", false));
		
		StringBuilder b = new StringBuilder();
		b.append("e1" + "," );
		b.append("" + ",");
		b.append("" + ",");
		b.append(null + ",");
		
		b.append("u1,u2,");
		
		assertEquals(b.toString(), myEvent1.toString());
		
		myEvent3 = new Event("e3", "location3", "description3", new Date(3,3,3));
		myEvent3.addUser(new NonAdmin("u1", "p1", false));
		myEvent3.addUser(new NonAdmin("u2", "p1", false));
		myEvent3.removeUser(0);
		
		b = new StringBuilder();
		b.append("e3" + "," );
		b.append("location3" + ",");
		b.append("description3" + ",");
		b.append(new Date(3,3,3) + ",");
		
		b.append("u2,");
		
		assertEquals(b.toString(), myEvent3.toString());
	}

}
