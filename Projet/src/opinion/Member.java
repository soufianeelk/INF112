package opinion;
import java.util.LinkedList;

public class Member {
	
	private String login;
	private String password;
	private String profile;
	private LinkedList<Review> memberReviewsList=new LinkedList<Review>();

	public Member(String login, String password, String profile) {
		this.login=login;
		this.password=password;
		this.profile=profile;
	  }

	public boolean checkExistingLogin(String login) {
		return true;
	  }
	
	public boolean checkCredentials(String login, String password) {
		return (this.login.equalsIgnoreCase(login.trim()) && this.password.equals(password));
	 }

	public String getProfile() {
		return null;
	 }
	
	public void setProfile(String profile) {
	}
	
	public void setLogin(String login) {
	}
	
	public void setReview(Review theReview) {
		this.memberReviewsList.add(theReview);
	}

	public Review getReviews() {
		return null;
	  }

	}