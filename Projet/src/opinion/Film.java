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


	public float MeanReviews() {
		return 0;
	  }

	public void setReview(String comment, int mark) {
	  }

	public boolean checkExistingTitle() {
		if (this.title.trim().equalsIgnoreCase(title.trim())) return true;
		else return false;
	  }

	public boolean checkMemberReviewExisting() {
		return false;
	  }

	}
