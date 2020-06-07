package opinion;
import java.util.LinkedList;

public class Review extends OpinionReview {
	
	private LinkedList<OpinionReview> reviewsList = new LinkedList<OpinionReview>();
	
	public Review(Member theMember, float mark, String comment) {
		
		super(theMember, mark, comment);
		
	}
	
	/**
	 * Adding the simple review to the list of review of this review.
	 * 
	 * @param the
	 * 		- login of the publisher of the review of review (OpinionReview). 
	 *
	 * @param theOpinionReview
	 * 		- theSimple review object to add in the review list.
	 * 
	 * @param theItemReviewer
	 * 		- login of the publisher of the review of review.
	 * 
	 */
	public void addToReviewsList(Member thePublisher, Member theItemReviewer, float mark, String comment) {
		
		OpinionReview thePotentialOpinionReview = this.checkMemberExistingReview(thePublisher);
		if(thePotentialOpinionReview==null) {
			
			this.reviewsList.add(new OpinionReview(thePublisher, mark, comment)); //adding the new review in the review list		
			theItemReviewer.computeKarma(mark, theItemReviewer.getNbReviewsReceived());
			theItemReviewer.setNbReviewsReceived(theItemReviewer.getNbReviewsReceived()+1);
		}
		
		else {
			thePotentialOpinionReview.setComment(comment); //Substitute the previous comment with the new one 
			thePotentialOpinionReview.setMark(mark); //Substitute the previous mark with the new one 	
		}
		
	}
	
	/**
	 * Check if a member has already added a review for a review.
	 * 
	 * @param theMember
	 *            - the Member about which we check the potential review on the film
	 *          
	 * @return the simple review if it exists, null if not
	 */	
	public OpinionReview checkMemberExistingReview(Member theMember) {

		if (this.reviewsList.size() == 0) return null;	//Return null if the book has no reviews

		for(OpinionReview theOpinionReview : reviewsList){
			if(theOpinionReview.getPublisher()==theMember) return theOpinionReview;	//Return the review if it exists
		}
		return null;
		
	}
	
	/**
	 * Returning the number of reviews for the item review of a member. 
	 * 
	 * @return the number of reviews for this review.
	 *            
	 */
	public int getNbReviewsList() {
		
		return this.reviewsList.size();
		
	}
	
}
