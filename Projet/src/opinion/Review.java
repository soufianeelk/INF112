package opinion;
import java.util.LinkedList;

public class Review extends SimpleReview {
	
	private LinkedList<SimpleReview> reviewsList = new LinkedList<SimpleReview>();
	
	public Review(Member theMember, float mark, String comment) {
		super(theMember, mark, comment);
	}
	
	public void addToReviewsList(Member theMember, SimpleReview theSimpleReview) {
		
		SimpleReview thePotentialSimpleReview = this.checkMemberExistingReview(theMember);
		if(thePotentialSimpleReview==null) {
			
			this.reviewsList.add(theSimpleReview); //adding the new review in the review list		
			theMember.computeKarma(theSimpleReview.getMark(), theMember.getNbReviewsReceived());
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
	
	public int getNbReviewsList() {
		return this.reviewsList.size();
	}
	
	public SimpleReview checkMemberExistingReview(Member theMember) {

		if (this.reviewsList.size() == 0) return null;	//Return null if the book has no reviews

		for(SimpleReview theSimpleReview : reviewsList){
			if(theSimpleReview.getPublisher()==theMember) return theSimpleReview;	//Return the review if it exists
		}
		return null;
	}
	
}
