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
	
	public String getPassword() {
		return myPassword;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setUserName(String theUserName) {
		myUserName = theUserName;
	}
	
	public void setPassword(String thePassword) {
		myPassword = thePassword;
	}
 	
	@Override
	public boolean equals(AbstractUser user1) {
		return user1.myUserName == this.myUserName;
	}
	
	@Override
	public String toString() {
		return myUserName + "," + myPassword + "," + isAdmin + ",";
	}
}
