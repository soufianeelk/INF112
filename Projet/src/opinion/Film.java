package opinion;
import java.util.LinkedList;

import exceptions.BadEntryException;

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
	
	private Member publisher;
	private String title;
	private String kind;
	private String director;
	private String scenarist;
	private int duration;
	private float meanReviews;
	private int nbReviews;
	private LinkedList<Review> reviewsList=new LinkedList<Review>();

	public Film(Member publisher, String title, String kind, String director, String scenarist, int duration) {

		this.publisher = publisher;
		this.title = title.trim();
		this.kind = kind.trim();
		this.director = director.trim();
		this.scenarist = scenarist.trim();
		this.duration = duration;
	  }
	
	/**
	 * Return the publisher attribute of the film
	 * 
	 * @return this.publisher
	 */	
	public Member getPublisher() {
		return this.publisher;
	}

	/**
	 * Return the title's film attribute
	 * 
	 * @return this.title
	 */	
	public String getTitle() {
		return this.title;
	  }

	/**
	 * Return the kind's film attribute
	 * 
	 * @return this.kind
	 */	
	public String getKind() {
		return this.kind;
	  }

	/**
	 * Return the director's film attribute
	 * 
	 * @return this.director
	 */		
	public String getDirector() {
		return this.director;
	  }

	/**
	 * Return the scenarist's film attribute
	 * 
	 * @return this.scenarist
	 */	
	
	public String getScenarist() {
		return this.scenarist;
	  }

	/**
	 * Return the duration's film attribute
	 * 
	 * @return this.duration
	 */	
	public int getDuration() {
		return duration;
	  }

	/**
	 * Modify the film's kind attribute
	 * 
	 * @param kind
	 *            - the new kind attribute
	 */	
	public void setKind(String kind) {
		this.kind = kind.trim();
	  }

	/**
	 * Modify the film's director attribute
	 * 
	 * @param kind
	 *            - the new director attribute
	 */	
	public void setDirector(String director) {
		this.director = director.trim();
	  }

	/**
	 * Modify the film's scenarist attribute
	 * 
	 * @param scenarist
	 *            - the new scenarist attribute
	 */	
	public void setScenarist(String scenarist) {
		this.scenarist = scenarist.trim();
	  }

	/**
	 * Modify the film's duration attribute
	 * 
	 * @param duration
	 *            - the new duration attribute
	 * 
	 */	
	public void setDuration(int duration) throws BadEntryException {
		if (duration > 0) this.duration = duration;		//The duration attribute must be positive
		else throw new BadEntryException("The duration must be positive");	//Throws a BadEntryException if negative
	  }

	/**
	 * Return the film's meanReview attribute
	 * 
	 * @return this.meanReviews
	 */	
	public float getMeanReviews() {
		return this.meanReviews;
	  }

	/**
	 * Return the film's nbReviews attribute
	 * 
	 * @return this.nbReviews
	 */	
	public int getNbReviews() {
		return this.nbReviews;
	}
	
	/**
	 * Add a Review on the film from a Member
	 * 
	 * @param theMember
	 *            - the Member adding the review
	 *            
	 * @param comment
	 *            - the review's comment
	 *            
	 * @param mark
	 *            - the review's mark
	 *            
	 */
	public void addReview(Member theMember, String comment, float mark) {
		
		Review thePotentialReview = this.checkMemberExistingReview(theMember);
		if(thePotentialReview==null) {
			
			reviewsList.add(new Review(theMember, this, mark,comment));//adding the new review in the review list
			this.nbReviews++; //incrementing the film number counter
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

	/**
	 * Compare a title in entry with the film's title
	 * 
	 * @param title
	 *            - the title to compare
	 * 
	 * @return 1 if the title correspond, 0 if not
	 */	
	public boolean compareTitle(String title) {
		return (this.title.equalsIgnoreCase(title.trim()));
	  }

	/**
	 * Check if a member has already added a review on the film
	 * 
	 * @param theMember
	 *            - the Member about which we check the potential review on the film
	 *          
	 * @return the review if it exists, null if not
	 */	
	public Review checkMemberExistingReview(Member theMember) {

		if (this.nbReviews == 0) return null;	//Return null if the book has no reviews

		for(Review theReview : reviewsList){
			if(theReview.getMember()==theMember) return theReview;	//Return the review if it exists
		}
		return null;
	}
	
	public boolean removeReview() {
		return true;
	}
}
