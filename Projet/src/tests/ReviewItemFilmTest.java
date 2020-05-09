package tests;

import opinion.ISocialNetwork;

public class ReviewItemFilmTest {
	
	/**
	 * Check that trying to add a new review raises a
	 * BadEntry exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param pwd
	 *            - member's password
	 * @param title
	 *            - title's name	
	 * @param mark 
	 *            - mark given by the user 
	 * @param comment 
	 * 			  - comment given by the user
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *           
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addReviewItemFilmBadEntryTest(ISocialNetwork sn, String login,
			String pwd, String title, int mark, String comment,String testId,String errorMessage) {
		return 0;
		
	}
	
	/**
	 * Check that trying to add a new review with a non-existing user raises a
	 * NotMemberException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param pwd
	 *            - member's password
	 * @param title
	 *            - title's name	
	 * @param mark 
	 *            - mark given by the user 
	 * @param comment 
	 * 			  - comment given by the user
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *           
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addReviewItemFilmNotMemberExceptionTest(ISocialNetwork sn, String login,
			String pwd, String title, int mark, String comment,String testId,String errorMessage) {
		return 0; 

}

	/**
	 * Check that trying to add a new review with a non-registered film raises a
	 * FilmNotItemExceptionTest and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param pwd
	 *            - member's password
	 * @param title
	 *            - title's name	
	 * @param mark 
	 *            - mark given by the user 
	 * @param comment 
	 * 			  - comment given by the user
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *           
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addReviewItemFilmNotItemExceptionTest(ISocialNetwork sn, String login,
			String pwd, String title, int mark, String comment,String testId,String errorMessage) {
		return 0;
	
}
	/**
	 * Check that this new review can be (and <i>is</i>) added to 
	 * the <i>ISocialNetwork</i>. If OK, the method just returns 0
	 * : the new member was added.</br> If not OK, an error message is displayed
	 * and 1 is returned ; the new member was not correctly added.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param pwd
	 *            - member's password
	 * @param title
	 *            - title's name	
	 * @param mark 
	 *            - mark given by the user 
	 * @param comment 
	 * 			  - comment given by the user
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *            
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int addReviewItemFilmOKTest(ISocialNetwork sn, String login,
			String pwd, String title, int mark,String testId,String comment) {
		return 0;
	}
	
}