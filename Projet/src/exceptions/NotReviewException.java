package exceptions;

/**
 * <i>NotReviewException</i> is raised when a review can not be found in the
 * <i>ISocialNetwork</i>
 * 
 */
public class NotReviewException extends Exception {

	public NotReviewException(String message) {
		super(message);
	}
	
}
