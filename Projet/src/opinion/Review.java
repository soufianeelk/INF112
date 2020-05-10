package opinion;

public class Review {
	
	private String comment;
	private float mark;
	private Member member;
	private Film film;

	public Review(float mark, String comment) {
		this.mark=mark;
		this.comment=comment;
	 }

	public  Review(float mark) {
	 }

	public String getComment( ) {
		return null;
	 }

	public int getMark( ) {
		return 0;
	 }

	public void setComment(String comment) {
	 }

	public void setMark(float mark) {
	 }

	public Member getMember() {
		return null;
	  }

	}
