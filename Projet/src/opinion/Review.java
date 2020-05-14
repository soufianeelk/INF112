package opinion;

public class Review {
	
	private String comment;
	private float mark;
	private Member member;
	private Film film;

	public Review(Member theMember,float mark, String comment, Film theFilm) {
		this.member=theMember;
		this.mark = mark;
		this.comment = comment.trim();
		this.film=theFilm;
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

	public Member getMember() {
		return this.member;
	  }

	}
