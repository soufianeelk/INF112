package opinion;

public class Review {
	
	private String comment;
	private float mark;
	private Member member;
	private Film film;

	public Review(float mark, String comment) {
		this.mark = mark;
		this.comment = comment.trim();
	 }

	public Review(float mark) {
	 }

	public String getComment( ) {
		return this.comment;
	 }

	public float getMark() {
		return this.mark;
	 }

	public void setComment(String comment) {
	 }

	public void setMark(float mark) {
	 }

	public Member getMember() {
		return this.member;
	  }

	}
