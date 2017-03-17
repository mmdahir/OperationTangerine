package model;

public interface User {

	public String getUserName();
	
	public String getPassword();
	
	public void setUserName(String theUserName);
	
	public void setPassword(String thePassword);
	
	public boolean isAdmin();
	
	////boolean equals(AbstractUser user1);	
}
