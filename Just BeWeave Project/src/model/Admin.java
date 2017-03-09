package model;

public class Admin extends AbstractUser {

	public Admin(String theUserName, String thePassword) {
		super(theUserName, thePassword, true);
	}
}
