package opinion;

/**
 * Class of objects Members
 * 
 */

public class Member {
	
	private String login;
	private String password;
	private String profile;

	public Member(String login, String password, String profile) {
		this.login = login.trim();			//Initialise paramaters with no leading/trailing blanks except for password
		this.password = password;
		this.profile = profile.trim();
	  }

	
	
	public boolean checkExistingLogin(String login) {
		return (this.login.equalsIgnoreCase(login.trim())); // Replace spaces by nothing and put string to lower
	  }
	
	public int checkCredentials(String login, String password) {
		int flag = 0;
		if (this.login.equalsIgnoreCase(login.trim())) {
			flag = 1;
			if (this.password.equals(password) ) flag = 2;
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

	public Review getReviews() {
		return null;
	  }

	}