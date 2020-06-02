package opinion;
import java.util.LinkedList;

public class Review extends SimpleReview {
	
	private LinkedList<SimpleReview> reviewsList = new LinkedList<SimpleReview>();
	
	public Review(Member theMember, float mark, String comment) {
		super(theMember, mark, comment);
	}
	
	/**
	 * Adding the simple review to the list of review of this review.
	 * 
	 * @param theMember
	 * 		- login of the publisher of the review of review (SimpleReview). 
	 *
	 * @param theSimpleReview
	 * 		- theSimple review object to add in the review list.
	 * 
	 * @param theMember
	 * 		- login of the publisher of the review of review.
	 * 
	 */
	
	public void addToReviewsList(Member theMember, SimpleReview theSimpleReview, Member thePublisher) {
		
		SimpleReview thePotentialSimpleReview = this.checkMemberExistingReview(theMember);
		if(thePotentialSimpleReview==null) {
			
			this.reviewsList.add(theSimpleReview); //adding the new review in the review list		
			thePublisher.computeKarma(theSimpleReview.getMark(), thePublisher.getNbReviewsReceived());
			thePublisher.setNbReviewsReceived(thePublisher.getNbReviewsReceived()+1);
		}
		
		else {
			for(SimpleReview theSimpleReviewtoReplace : reviewsList) {
				if (theSimpleReviewtoReplace==thePotentialSimpleReview) {
					theSimpleReviewtoReplace.setComment(theSimpleReview.getComment()); //Substitute the previous comment with the new one 
					theSimpleReviewtoReplace.setMark(theSimpleReview.getMark()); //Substitute the previous mark with the new one 
				}
				
			}
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
	
	public SimpleReview checkMemberExistingReview(Member theMember) {

		if (this.reviewsList.size() == 0) return null;	//Return null if the book has no reviews

		for(SimpleReview theSimpleReview : reviewsList){
			if(theSimpleReview.getPublisher()==theMember) return theSimpleReview;	//Return the review if it exists
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
