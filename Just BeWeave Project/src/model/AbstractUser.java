package model;

public abstract class AbstractUser implements User {
	
	private String myUserName;
	
	private String myPassword;
	
	private boolean isAdmin;
	
	
	public AbstractUser(String theUserName, String thePassword, boolean theAdmin) {
		myUserName = theUserName;
		myPassword = thePassword;
		isAdmin = theAdmin;
	}
	
	public String getUserName() {
		return myUserName;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	@Override
	public boolean equals(AbstractUser user1) {
		
		return user1.myUserName == this.myUserName;
		
	}
}
