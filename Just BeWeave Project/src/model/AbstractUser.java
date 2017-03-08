package model;

public abstract class AbstractUser implements User {
	
	private String myUserName;
	
	@Override
	public boolean equals(AbstractUser user1) {
		
		return user1.myUserName == this.myUserName;
		
	}
}
