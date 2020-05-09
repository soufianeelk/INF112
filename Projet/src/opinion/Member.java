package opinion;

public class Member {
	
	private String login;
	private String password;
	private String profile;
	
	public Member(String login, String password) {
	  }

	public Member(String login, String password, String profile) {
	  }

	public boolean checkExistingLogin(String login) {
		return true;
	  }
	
	public boolean checkCredentials() {
		return true;
	 }

	public String getProfile() {
		return null;
	 }
	
	public void setProfile(String profile) {
	}
	
	public void setLogin(String login) {
	}

	public Review getReviews() {
		return null;
	  }

	}