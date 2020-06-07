package opinion;


/**
 * the Member class create members
 * 
 */

public class Member {
	
	private String login;
	private String password;
	private String profile;
	private float karma;		//Lot2
	private int nbReviewsReceived;		//Lot2

	public Member(String login, String password, String profile) {
		
		this.login = login.trim();			//Initialize parameters with no leading/trailing blanks except for password
		this.password = password;
		this.profile = profile.trim();
		this.nbReviewsReceived=0;
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
	 * @return the profile of the member
	 */	
	public String getProfile() {
		
		return this.profile;
		
	 }
	
	/**
	 * Return the member's karma attribute
	 * 
	 * @return the karma of the member
	 */	
	public float getKarma() {
		
		return this.karma;
		
	 }
	/**
	 * Modify the member's karma attribute
	 * 
	 * @return the new karma of the member
	 */	
	public void computeKarma(float mark, int nbReviewsReceived) {
		
		if (nbReviewsReceived==0) {
			this.karma=(this.karma+mark)/(nbReviewsReceived+2);
		}
		else {
			this.karma=(this.karma*(nbReviewsReceived+1)+mark)/(nbReviewsReceived+2);
		}
		
	}
	/**
	 * Modify the member's profile attribute
	 * 
	 * @param profile
	 *            - the new profile attribute
	 */		
	
	public int getNbReviewsReceived() {
		
		return this.nbReviewsReceived;
		
	}
	
	/**
	 * Setting the number of Opinion's reviews received for a member;
	 * 
	 */	
	public void setNbReviewsReceived(int nbReviewsReceived) {
		
		this.nbReviewsReceived=nbReviewsReceived;
		
	}
	
	public String toString() {
		
		return "Username: "+this.login+" / "+"Profile: "+this.getProfile()+" / "+"Karma: "+this.getKarma()+"/5";
	
	}
	
}