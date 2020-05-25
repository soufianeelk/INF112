package opinion;
import java.util.LinkedList;

public class Review extends SimpleReview {
	
	private LinkedList<SimpleReview> reviewsList = new LinkedList<SimpleReview>();
	
	public Review(Member theMember, float mark, String comment) {
		super(theMember, mark, comment);
	}
	
}
