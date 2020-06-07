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
	
	private Member publisher;
	private String title;
	private String kind;
	private String director;
	private String scenarist;
	private int duration;
	private float meanReviews;
	private int nbReviews;
	private LinkedList<Review> reviewsList=new LinkedList<Review>();
	
	public Film(Member thePublisher, String title, String kind, String director, String scenarist, int duration) {
	
		this.publisher = thePublisher;
		this.title = title.trim();
		this.kind = kind.trim();
		this.director = director.trim();
		this.scenarist = scenarist.trim();
		this.duration = duration;
		this.meanReviews = 0;
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
	 * @param thePublisher
	 *            - the Member adding the review
	 *            
	 * @param comment
	 *            - the review's comment
	 *            
	 * @param mark
	 *            - the review's mark
	 *            
	 * @return 	the mean of the film
	 */
	public float addReview(Member thePublisher, String comment, float mark) {
		
		Review thePotentialReview = this.checkMemberExistingReview(thePublisher);
		if(thePotentialReview==null) {
			
			reviewsList.add(new Review(thePublisher, thePublisher.getKarma()*mark, comment));//adding the new review in the review list

			this.nbReviews++; //incrementing the film number counter
			
			this.meanReviews=((this.meanReviews*(nbReviews-1))+thePublisher.getKarma()*mark)/this.karmaReviewsMemberSum(); } //computing the new mean of the review for the film. 
		
		else {
			for(Review theReviewtoReplace : reviewsList) {
				if (theReviewtoReplace==thePotentialReview) {
					this.meanReviews=(this.meanReviews*(nbReviews)-(theReviewtoReplace.getMark())+mark)/this.karmaReviewsMemberSum(); //Compute the new mean value
					theReviewtoReplace.setComment(comment); //Substitute the previous comment with the new one 
					theReviewtoReplace.setMark(mark); //Substitute the previous mark with the new one 
				}
				
			}
		}
		return this.meanReviews;
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
			if(theReview.getPublisher()==theMember) return theReview;	//Return the review if it exists
		}
		return null;
	}

	/**
	 * Updating the mean review attribute by the one given in parameters. 
	 * 
	 * @return the mean of the film
	 *            
	 */
	
	public float updateMeanReview()  {
		 this.meanReviews = this.meanReview();
		 return this.meanReviews;
}

	/**
	 * Computing the mean review attribute of a film by considering the karma. 
	 * 
	 * @return the new mean of the film         
	 */
	
	public float meanReview() {
		float sum = 0;
		float denominator =0;
		for(Review aReview: reviewsList) {
			sum += aReview.getMark()*aReview.getPublisher().getKarma();
			denominator += aReview.getPublisher().getKarma();
		}
		return sum/denominator;
	}
	
	/**
	 * Computing the total karma of all the members whom a review exists for this film. 
	 * 
	 * @return the sum of the karma of all members. 
	 */	
	
	private float karmaReviewsMemberSum() {
		float sum = 0;
		for(Review aReview: reviewsList) {
			sum += aReview.getPublisher().getKarma();
		}
		return sum;
	}
	
	/**
	 * Concatenate into a string value all the characteristics of a Film
	 * 
	 * @return the string with all the characteristics of the Film
	 */	
	
	public String toString() {
		
		return "Title: "+this.getTitle()+" / "+"Director: "+this.getDirector()+" / "+"Scenarist: "+this.getScenarist()+" / "+"Kind: "+this.getKind()+" / "+"Duration: "+this.getDuration()+" / "+"Mean of the Reviews: "+this.meanReviews+"/5"+" / "+"Published by: "+this.getPublisher();
		
	}
}

