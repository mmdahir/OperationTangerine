package model;

public class NonAdmin extends AbstractUser {

	public NonAdmin(String theUserName, String thePassword, boolean theAdmin) {
		super(theUserName, thePassword, theAdmin);
	}

}
