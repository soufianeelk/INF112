package opinion;

public class Review {
	
	private String comment;
	private float mark;
	private Member member;

	public Review(Member theMember,float mark, String comment) {
		this.member=theMember;
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
	 }

	public void setMark(float mark) {
	 }

	public Member getMember() {
		return this.member;
	  }

	}
