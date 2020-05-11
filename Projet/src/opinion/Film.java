package opinion;
import java.util.LinkedList;

/** 
 * @author - S. EL KALDAOUI
 * @author - H. MEZAZIGH
 * @date 2019-2020
 * @version V2020.1
 */

/**
 * The Film class create films
 */

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

		this.title = title.trim();
		this.kind = kind.trim();
		this.director = director.trim();
		this.scenarist = scenarist.trim();
		this.duration = duration;
	  }

	public String getTitle() {
		return this.title;
	  }

	public String getKind() {
		return this.kind;
	  }

	public String getDirector() {
		return this.director;
	  }

	public String getScenarist() {
		return this.scenarist;
	  }

	public int getDuration() {
		return duration;
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
		return this.meanReviews;
	  }
	
	public int getNbReviews() {
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
	public void addReview(Member theMember,String comment, float mark) {
		reviewsList.add(new Review(mark,comment));
		this.meanReviews=(this.meanReviews+mark)/2;
		theMember.addReview(this.reviewsList.get(nbReviews-1));
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
