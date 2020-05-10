package tests;

import opinion.ISocialNetwork; 
import opinion.SocialNetwork;
import opinion.Film;
import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
 
/**
 * Tests for the SocialNetwork.<i>reviewItemFilm()</i> method.
 * 
 * @author V. Tritarelli, H. Houillon
 * @version V1.0 - May 2020
 */

public class ReviewItemFilmTest {
	
	/**
	 * Check that trying to add this new review (login, pwd, title, mark, comment,testID, errorMessage) raises a
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
	 *            - film's title
	 * @param mark
	 *            - new review's mark
	 * @param comment
	 * 			  - new review's comment
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int reviewItemFilmBadEntryException(ISocialNetwork sn, String login, String password, String title, float mark, String comment, String testId, String errorMessage)
	{
		try
		{
			sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this review
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			
			return 1;
		}
		catch(BadEntryException e)
		{
			return 0;
		}
		catch(Exception e)// An exception was thrown by reviewItemFilm(), but it was not the expected exception BadEntry
		{ 
			System.out.println("Err " + testId + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	}
	
	/**
	 * Check that trying to add this new review (login, pwd, title, mark, comment,testID, errorMessage) raises a
	 * NotMember exception and does not change content of the
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
	 *            - film's title
	 * @param mark
	 *            - new review's mark
	 * @param comment
	 * 			  - new review's comment
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int reviewItemFilmNotMemberException(ISocialNetwork sn, String login, String password, String title, float mark, String comment, String testId, String errorMessage)
	{
		try
		{
			sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this review
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			
			return 1;
		}
		catch(NotMemberException e)
		{
			return 0;
		}
		catch(Exception e)// An exception was thrown by reviewItemFilm(), but it was not the expected exception NotMember
		{ 
			System.out.println("Err " + testId + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	}
	
	/**
	 * Check that trying to add this new review (login, pwd, title, mark, comment,testID, errorMessage) raises a
	 * NotItem exception and does not change content of the
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
	 *            - film's title
	 * @param mark
	 *            - new review's mark
	 * @param comment
	 * 			  - new review's comment
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int reviewItemFilmNotItemException(ISocialNetwork sn, String login, String password, String title, float mark, String comment, String testId, String errorMessage)
	{
		try
		{
			sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this review
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			
			return 1;
		}
		catch(NotItemException e)
		{
			return 0;
		}
		catch(Exception e)// An exception was thrown by reviewItemFilm(), but it was not the expected exception NotItem
		{ 
			System.out.println("Err " + testId + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	}
	
	
	/**
	 * Check that trying to add this new review (login, pwd, title, mark, comment,testID, errorMessage) add properly a new review
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
	 *            - film's title
	 * @param mark
	 *            - new review's mark
	 * @param comment
	 * 			  - new review's comment
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int reviewItemFilmOKTestNEW(SocialNetwork sn, String login, String password, String title, float mark, String comment, String testId)
	{
		int nbReviews = sn.getFilmFromTitle(title).nbReviews();
		
		try
		{
			sn.reviewItemFilm(login, password, title, mark, comment);
			
			if(sn.getFilmFromTitle(title).nbReviews() != nbReviews + 1)
			{
				System.out.println("Err " + testId
						+ " : the number of reviews (" + nbReviews
						+ ") was not incremented"); // Error message displayed
				return 1; // return error code
			}
			else {
				return 0;
			}
			
		}
		catch(Exception e)
		{
			return 1;
		}
	}
	
	/**
	 * Check that trying to add this new review (login, pwd, title, mark, comment,testID, errorMessage) edit properly an existing review
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
	 *            - film's title
	 * @param mark
	 *            - new review's mark
	 * @param comment
	 * 			  - new review's comment
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int reviewItemFilmOKTestEDIT(SocialNetwork sn, String login, String password, String title, float mark, String comment, String testId)
	{
		int nbReviews = sn.getFilmFromTitle(title).nbReviews();
		
		try
		{
			sn.reviewItemFilm(login, password, title, mark, comment);
			
			if(sn.getFilmFromTitle(title).nbReviews() != nbReviews)
			{
				System.out.println("Err " + testId
						+ " : the number of reviews (" + nbReviews
						+ ") was incremented"); // Error displayed
				return 1; // return error code
			}
			else {
				return 0;
			}
			
		}
		catch(Exception e)
		{
			return 1;
		}
	}
	
	public static TestReport test(){

		SocialNetwork sn = new SocialNetwork();
		
		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
									// here)
		int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 0
									// here)

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing reviewItemFilm()");
		
		// Populate member with a new one and film with a new one
		try
		{
			sn.addMember("user", "password", "profile");
			sn.addItemFilm("user", "password", "title", "kind", "director", "scenarist", 5);
			
			nbFilms++;
		}
		catch(Exception e)
		{
			
		}
		
		// <=> test n°1
		// check if incorrect parameters cause reviewItemFilm() to throw BadEntry exception

		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, null, "dcddc", "title", 0, "thecomment", "1.1", "addItemFilm() doesn't reject null login");

		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, " ", "dcddc", "title", 0, "thecomment", "1.2", "addItemFilm() doesn't reject login with less than 1 character");
		
		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", null, "title", 0, "thecomment", "1.3", "addItemFilm() doesn't reject null password");

		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", "ab c", "title", 0, "thecomment", "1.4", "addItemFilm() doesn't reject password with less than 4 character");
		
		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", "password", null, 0, "thecomment", "1.5", "addItemFilm() doesn't reject null title");

		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", "password", " ", 0, "thecomment", "1.6", "addItemFilm() doesn't reject title with less than 1 character");
		
		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", "password", "title", -7, "thecomment", "1.7", "addItemFilm() doesn't reject mark lower than 0");
		
		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", "password", "title", 12, "thecomment", "1.8", "addItemFilm() doesn't reject mark greater than 5");
		
		nbTests++;
		nbErrors += reviewItemFilmBadEntryException(sn, "user", "password", "title", 1, null, "1.9", "addItemFilm() doesn't reject null comment");
		
		// <=> test n°2
		// check if incorrect parameters cause reviewItemFilm() to throw NotMember exception
		
		nbTests++;
		nbErrors += reviewItemFilmNotMemberException(sn, "toto", "password", "title", 1, "cdscd", "2.1", "addItemFilm() doesn't reject login who doesn' exists");
		
		nbTests++;
		nbErrors += reviewItemFilmNotMemberException(sn, "user", "cddsd", "title", 1, "cdscd", "2.2", "addItemFilm() doesn't reject wrong password for existing login");
		
		// <=> test n°3
		// check if incorrect parameters cause reviewItemFilm() to throw NotItem exception
		
		nbTests++;
		nbErrors += reviewItemFilmNotItemException(sn, "user", "password", "les 4 fantastiques", 2, "comment", "3.1", "addItemFilm() doesn't reject film's title who doesn't exists");
		
		// <=> test n°4 : populate 'sn.theFilm' with 2
		
		nbTests++;
		nbErrors += reviewItemFilmOKTestNEW(sn, "user", "password", "title", 4, "c'est vachement cool", "4.1");
		
		nbTests++;
		nbErrors += reviewItemFilmOKTestEDIT(sn, "user", "password", "title", 4, "c'est vachement pas cool", "4.2");
		
		nbTests++;
		// check that 'sn' was not modified
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by addItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out
					.println("Error : the number of books was unexepectedly changed by addItemFilm()");
			nbErrors++;
		}

		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("AddItemFilmTest : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in AddItemFilmTest test code - Can't return valuable test results");
			return null;
			}
		}
	
	/**
	 * Launches test()
	 * @param args not used
	 */
	public static void main(String[] args) {
		test();
	}
}


/**
 * Tests for the SocialNetwork.<i>addItemFilm()</i> method.
 * 
 * @author V. Tritarelli, H. Houillon
 * @version V1.0 - April 2020
 */