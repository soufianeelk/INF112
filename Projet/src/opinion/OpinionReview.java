package opinion;

public class OpinionReview {
	
	private String comment;
	private float mark;
	private Member publisher;
	
	public OpinionReview(Member thePublisher, float mark, String comment) {
		
		this.publisher= thePublisher;
		this.mark = mark;
		this.comment = comment.trim();
	 }
	
	/**
	 * Returning the comment attribute of the review.
	 * 
	 * @return comment
	 * 
	 */
	public String getComment( ) {
		return this.comment;
	 }
	/**
	 * Returning the mark attribute of the review.
	 * 
	 * @return mark
	 * 
	 */
	public float getMark() {
		return this.mark;
	 }
	
	/**
	 * Returning the publisher's login of the review.
	 * 
	 * @return publisher's login
	 * 
	 */
	public Member getPublisher() {
		return this.publisher;
	  }
	
	/**
	 * Setting the comment attribute of the review.
	 *
	 */	
	public void setComment(String comment) {
		this.comment=comment;
	 }
	
	/**
	 * Setting the mark attribute of the review.
	 *
	 */
	public void setMark(float mark) {
		this.mark=mark;
	 }
	

	}
