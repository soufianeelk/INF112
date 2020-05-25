package opinion;

public class SimpleReview {
	
	private String comment;
	private float mark;
	private Member publisher;
	
	public SimpleReview(Member publisher, float mark, String comment) {
		
		this.publisher= publisher;
		this.mark = mark;
		this.comment = comment.trim();
	 }
	
	public String getComment( ) {
		return this.comment;
	 }

	public float getMark() {
		return this.mark;
	 }

	public void setComment(String comment) {
		this.comment=comment;
	 }

	public void setMark(float mark) {
		this.mark=mark;
	 }

	public Member getPublisher() {
		return this.publisher;
	  }

	}
