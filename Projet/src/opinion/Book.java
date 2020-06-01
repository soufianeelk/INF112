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
 * The Book class create books
 */

public class Book {
	
	private Member publisher;
	private String title;
	private String kind;
	private String author;
	private int nbPages;
	private int nbReviews;
	private float meanReviews;
	private LinkedList<Review> reviewsList=new LinkedList<Review>();
	
	public Book (Member publisher, String title, String kind, String author, int nbPages) {
		this.publisher = publisher;
		this.title = title;
		this.kind = kind;
		this.author = author;
		this.nbPages = nbPages;
		this.meanReviews = 0;
	}
	
	/**
	 * Return the publisher attribute of the book
	 * 
	 * @return this.publisher
	 */	
	public Member getPublisher() {
		return this.publisher;
	}
	
	/**
	 * Return the book's title attribute
	 * 
	 * @return this.title
	 */	
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Return the book's kind attribute
	 * 
	 * @return this.kind
	 */	
	public String getKind() {
		return this.kind;
	}
	
	/**
	 * Return the book's author attribute
	 * 
	 * @return this.author
	 */	
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * Return the book's nbPages attribute
	 * 
	 * @return this.nbPages
	 */	
	public int getNbPages() {
		return this.nbPages;
	}
	
	/**
	 * Modify the book's kind attribute
	 * 
	 * @param kind
	 *            - the new kind attribute
	 */		
	public void setKind(String kind) {
		this.kind = kind.trim();
	}
	
	/**
	 * Modify the book's author attribute
	 * 
	 * @param author
	 *            - the new author attribute
	 * 
	 */	
	public void setAuthor(String author) {
		this.author = author.trim();
	}
	
	/**
	 * Modify the book's nbPages attribute
	 * 
	 * @param nbPages
	 *            - the new nbPages attribute
	 * 
	 */	
	public void setNbPages(int nbPages)  throws BadEntryException{
		if (nbPages > 0) this.nbPages = nbPages;	//The nbPages attribute must be positive
		else throw new BadEntryException("The number of pages must be positive");  //Throws a BadEntryException if negative
	}
	
	/**
	 * Return the book's meanReview attribute
	 * 
	 * @return this.meanReviews
	 */	
	public float getMeanReviews() {
		return this.meanReviews;
	}
	
	/**
	 * Return the book's nbReviews attribute
	 * 
	 * @return this.nbReviews
	 */	
	public int getNbReviews() {
		return this.nbReviews;
	}
	
	/**
	 * Compare a title in entry with the book's title
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
	 * Add a Review on the book from a Member
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
			
			reviewsList.add(new Review(theMember,mark,comment));//adding the new review in the reviews list
			this.nbReviews++; //incrementing the book reviews counter
			this.meanReviews=((this.meanReviews*(nbReviews-1))+theMember.getKarma()*mark)/this.getKarmaReviewsMemberSum(); }//computing the new mean of the review for the book.
		
		else {
			for(Review theReviewtoReplace : reviewsList) {
				if (theReviewtoReplace==thePotentialReview) {
					this.meanReviews=(this.meanReviews*(nbReviews)-(theReviewtoReplace.getMark())+mark)/this.getKarmaReviewsMemberSum(); //Compute the new mean value
					theReviewtoReplace.setComment(comment); //Substitute the previous comment with the new one 
					theReviewtoReplace.setMark(mark); //Substitute the previous mark with the new one 
				}
				
		}
		}
	}
	
	/**
	 * Check if a member has already added a review on the book
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
	
	
	public void updateMeanReview(float theNewMean)  {
		 this.meanReviews = theNewMean;
}
	
	public float meanReview() {
		float sum = 0;
		float denominator =0;
		for(Review aReview: reviewsList) {
			sum += aReview.getMark()*aReview.getPublisher().getKarma();
			denominator += aReview.getPublisher().getKarma();
		}
		return sum/denominator;
	}
	
	public float getKarmaReviewsMemberSum() {
		float sum = 0;
		for(Review aReview: reviewsList) {
			sum += aReview.getPublisher().getKarma();
		}
		return sum;
	}
	
	public String toString() {
		
		return "Title: "+this.getTitle()+" / "+"Author: "+this.getKind()+" / "+"Kind: "+this.getKind()+" / "+"Number of pages: "+this.getNbPages()+" / "+"Mean of the reviews: "+this.meanReviews+"/5"+ " / "+"Published by: "+ this.getPublisher();
	}	
}