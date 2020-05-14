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

public class Book {
	
	private String title;
	private String kind;
	private String author;
	private int nbPages;
	private int nbReviews;
	private float meanReviews;
	private LinkedList<Review> reviewsList=new LinkedList<Review>();
	
	public Book (String title, String kind, String author, int nbPages) {
		this.title = title;
		this.kind = kind;
		this.author = author;
		this.nbPages = nbPages;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public int getNbPages() {
		return this.nbPages;
	}
	
	public float getMeanReviews() {
		return this.meanReviews;
	}
	
	public int getNbReviews() {
		return this.nbReviews;
	}
	
	
	public boolean compareTitle(String title) {
		return (this.title.equalsIgnoreCase(title.trim()));
	  }
	
	public void addReview(Member theMember, String comment, float mark) {
		
		Review thePotentialReview = this.checkMemberExistingReview(theMember);
		if(thePotentialReview==null) {
			
			reviewsList.add(new Review(theMember,mark,comment));//adding the new review in the reviews list
			this.nbReviews++; //incrementing the book reviews counter
			this.meanReviews=(this.meanReviews+mark)/nbReviews; }//computing the new mean of the review for the film.
		
		else {
			for(Review theReviewtoReplace : reviewsList) {
				if (theReviewtoReplace==thePotentialReview) {
					this.meanReviews=(this.meanReviews*(nbReviews)-(theReviewtoReplace.getMark())+mark)/nbReviews; //Compute the new mean value
					theReviewtoReplace.setComment(comment); //Substitute the previous comment with the new one 
					theReviewtoReplace.setMark(mark); //Substitute the previous mark with the new one 
				}
				
		}
		}
	}
	
	public Review checkMemberExistingReview(Member theMember) {

		if (this.reviewsList.size()==0) return null;

		for(Review theReview : reviewsList){
			if(theReview.getMember()==theMember) return theReview;
		}
		return null;
	}

}
