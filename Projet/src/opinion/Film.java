package opinion;
import java.util.LinkedList;

public class Film {
	
	private String title;
	private String kind;
	private String director;
	private String scenarist;
	private int duration;
	private float meanReviews;
	private int nbReviews;
	private LinkedList<Review> reviewsList;

	public Film(String title, String kind, String director, String scenarist, int duration) {
		this.title=title;
		this.kind=kind;
		this.director=director;
		this.scenarist=scenarist;
		this.duration=duration;
	  }

	public String getTitle() {
		return null;
	  }

	public String getKind() {
		return null;
	  }

	public String getDirector() {
		return null;
	  }

	public String getScriptwriter() {
		return null;
	  }

	public int getDuration() {
		return 0;
	  }

	public void setKind(String kind) {
	  }

	public void setDirector(String director) {
	  }

	public void setScriptwriter(String scriptwriter) {
	  }

	public void setDuration(int duration) {
	  }


	public float getMeanReviews() {
		return 0;
	  }
	
	public int nbReviews() {
		return this.nbReviews;
	}
	/**
	 * Authenticate a member among the member list of the social network by using the given credentials (login, password). 
	 * 
	 * @param login
	 * 
	 * @param password
	 *           
	 * @return Member object if the the member is found, else null. 
	 */
	public void setReview(Member theMember,String comment, float mark) {
		
		reviewsList.add(new Review(mark,comment));
		this.meanReviews=(this.meanReviews+mark)/2;
		theMember.setReview(this.reviewsList.get(nbReviews-1));
		this.nbReviews++;
	}

	public boolean checkExistingTitle(String title) {
		return (this.title.equalsIgnoreCase(title.trim()));
	  }

	public boolean checkMemberExistingReview(String login) {
		for(Review thereview : reviewsList){ 
			if(thereview.getMember().checkExistingLogin(login)) return true;
		}
		return false;
	}
}
