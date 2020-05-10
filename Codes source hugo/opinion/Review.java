package opinion;

public class Review {

	private String comment; // Review's comment
	private float mark; // Review's mark
	private Member theMember;	// Member who did the review
	
	/**
	 * Review's constructor
	 * 
	 * @param comment
	 *            the review comment
	 * @param mark
	 *            the review mark
	 * @param theMember
	 *            the review member
	 * 
	 */
	public Review(String comment, float Mark, Member theMember)
	{
		this.comment = comment;
		this.mark = mark;
		this.theMember = theMember;
	}
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	public void setMark(float mark)
	{
		this.mark = mark;
	}
	
	public float getMark()
	{
		return this.mark;
	}
	
	public Member getMember()
	{
		return this.theMember;
	}
	
	/**
	 * Check if the member's login is equal to the given login
	 * 
	 * @param login
	 *            the member login
	 * @return true if the member's login is equal to the given login
	 * 
	 */
	public boolean checkMemberLogin(String login)
	{
		return this.theMember.checkLogin(login); // Check if the member's login is equal to the given login
	}
}
