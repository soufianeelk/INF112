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
	private LinkedList<Review> reviewsList=new LinkedList<Review>();

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
		reviewsList.add(new Review(theMember,mark,comment,this));//adding the new review in the review list
		this.nbReviews++; //incrementing the film number counter
		theMember.addReview(this.reviewsList.getLast()); //adding the new review in the member's list
		this.meanReviews=(this.meanReviews+mark)/nbReviews; //computing the new mean of the review for the film. 
	}

	public boolean checkExistingTitle(String title) {
		return (this.title.equalsIgnoreCase(title.trim()));

	  }

	public Member checkMemberExistingReview(String login) {

		//if (this.reviewsList.size()==0) return false;

		for(Review theReview : reviewsList){
			if(theReview.getMember().checkExistingLogin(login)) return theReview;
		}
		return false;
	}
}
