package opinion;

import exceptions.BadEntryException;

/**
 * the Member class create members
 * 
 */

public class Member {
	
	private String login;
	private String password;
	private String profile;
	private float karma;
	private int nbReviewsReceived;

	public Member(String login, String password, String profile) {
		this.login = login.trim();			//Initialize parameters with no leading/trailing blanks except for password
		this.password = password;
		this.profile = profile.trim();
		this.karma=1;
	  }

	/**
	 * Compare a login in entry with the member's login
	 * 
	 * @param login
	 *            - the login to compare
	 * 
	 * @return 1 if the login correspond, 0 if not
	 */		
	public boolean compareLogin(String login) {
		return (this.login.equalsIgnoreCase(login.trim())); // Replace spaces by nothing and put string to lower
	  }
	
	/**
	 * Compare credentials in entry (login,password) with the member's credentials
	 * 
	 * @param login
	 *            - the login to compare
	 *            
	 * @param password
	 *            - the password to compare
	 *          
	 * @return the flag == 0 if the login doesn't match, flag == 1 if the login match but not the password, flag == 2 if login and password match
	 */	
	public int checkCredentials(String login, String password) {
		int flag = 0; // default value : the login doesn't match yet
		if (this.login.equalsIgnoreCase(login.trim())) {
			flag = 1; // value 1 : the login is found 
			if (this.password.equals(password) ) flag = 2; //value 2 : the login is found & the password match
		}
		return flag;
	 }

	/**
	 * Return the member's profile attribute
	 * 
	 * @return this.profile
	 */	
	public String getProfile() {
		return this.profile;
	 }
	
	/**
	 * Return the member's karma attribute
	 * 
	 * @return this.karma
	 */	
	public float getKarma() {
		return this.karma;
	 }
	/**
	 * Modify the member's karma attribute
	 * 
	 * @return this.karma
	 */	
	public void computeKarma(float mark, int nbReviewsReceived) {
		
		this.karma=(this.karma*nbReviewsReceived+mark)/(nbReviewsReceived+1);
	 }
	/**
	 * Modify the member's profile attribute
	 * 
	 * @param profile
	 *            - the new profile attribute
	 */	
	public void setProfile(String profile) {
		this.profile = profile.trim();
	}
	
	/**
	 * Modify the member's password attribute
	 * 
	 * @param profile
	 *            - the new password attribute
	 */	
	public void setPassword(String password) throws BadEntryException {
		if (password.trim().length() < 4) this.password = password.trim();
		else throw new BadEntryException("Password must contain at least 4 characters");
	}
	
	public int getNbReviewsReceived() {
		return this.nbReviewsReceived;
	}
	
	public String toString() {
		
		String result; 
		
		return "Username: "+this.login+" / "+"Profile :"+this.getKarma()+" / "+"Karma: "+this.getKarma();
		

}
	
	}