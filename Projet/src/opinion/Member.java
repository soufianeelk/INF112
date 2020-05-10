package opinion;
import java.util.LinkedList;

/**
 * Class of objects Members
 * 
 */

public class Member {
	
	private String login;
	private String password;
	private String profile;
	private LinkedList<Review> memberReviewsList=new LinkedList<Review>();

	public Member(String login, String password, String profile) {
		this.login = login.trim();			//Initialize parameters with no leading/trailing blanks except for password
		this.password = password;
		this.profile = profile.trim();
	  }

	
	public boolean checkExistingLogin(String login) {
		return (this.login.equalsIgnoreCase(login.trim())); // Replace spaces by nothing and put string to lower
	  }
	
	public int checkCredentials(String login, String password) {
		int flag = 0; // default value : the login is not found yet
		if (this.login.equalsIgnoreCase(login.trim())) {
			flag = 1; // value 1 : the login is found 
			if (this.password.equals(password) ) flag = 2; //value 2 : the login is found & the password match
		}
		return flag;
	 }

	public String getProfile() {
		return this.profile;
	 }
	
	public void setProfile(String profile) {
	}
	
	public void setLogin(String login) {
	}
	
	public void addReview(Review theReview) {
		this.memberReviewsList.add(theReview);
	}

	public Review getReviews() {
		return null;
	  }

	}