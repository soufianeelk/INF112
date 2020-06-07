package tests;

import exceptions.BadEntryException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import exceptions.NotItemException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addReviewItemFilm()</i> method.
 * 
 * @author S. EL KALDAOUI, H. MEZAZIGH
 * @version V2.0 - April 2020
 */

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
	 *            - user's mark 
	 * @param comment 
	 * 			  - user's comment
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
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		float meanFilm=0;
		
		try {
			meanFilm=sn.reviewItemFilm(login, pwd, title, mark, comment); // Try to add a new review
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (BadEntryException e) { 

			
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") was incremented");
				return 1;
			}	
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was incremented");
				return 1;
			}
			
			if (meanFilm!=0) {
				System.out.println("Err " + testId + " : the mean of review of this Book has changed");
				return 1;
			}
			
			return 0; 
		}
		catch (Exception e) {// An exception was thrown by reviewItemFilm(), but
			// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
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
	 *            - user's mark 
	 * @param comment 
	 * 			  - user's comment
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
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		float meanFilm=0;
		
		try {
			sn.reviewItemFilm(login, pwd, title, mark, comment); // Try to add a new review and save the mean
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotMemberException e) {

			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") was incremented");
				return 1;
			}	
			
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was incremented");
				return 1;
			}
			
			if (meanFilm!=0) {
				System.out.println("Err " + testId + " : the mean of review of this Book has changed");
				return 1;
			}
			return 0;
		}
		
		catch (Exception e) {// An exception was thrown by reviewItemFilm(), but
			// it was not the expected exception NotMemberException
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
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
	 *            - user's mark 
	 * @param comment 
	 * 			  - user's comment
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
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		float meanFilm=0;
		try {
			sn.reviewItemFilm(login, pwd, title, mark, comment); // Try to add a new review and save the mean
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotItemException e) {
			
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") was incremented");
				return 1;
			}	
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was incremented");
				return 1;
			}
			
			if (meanFilm!=0) {
				System.out.println("Err " + testId + " : the mean of review of this Book has changed");
				return 1;
			}
			return 0;
		}
		
		catch (Exception e) {// An exception was thrown by reviewItemFilm(), but
			// it was not the expected exception ItemFilmNotItemException
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	
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
	 *            - user's mark 
	 * @param comment 
	 * 			  - user's comment
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *            
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int addReviewItemFilmOKTest(ISocialNetwork sn, String login,
			String pwd, String title, float mark,String testId,String comment) {
		

		float meanFilm=0;
		
		try {
			meanFilm=sn.reviewItemFilm(login, pwd, title, mark, comment); // Try to add a new review and save the mean
			if (meanFilm==0) {
				System.out.println("Err " + testId + " : the mean of the film hasn't changed, so the review was not added correctly.");
				return 1;
			} else {
				return 0; 
			}
		}
				
		catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception " + e);
			e.printStackTrace();
			return 1;
		}

	}
	
	public static TestReport test(){

		SocialNetwork sn = new SocialNetwork();

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests
		
		
		// Creating a user and a film in order to realize tests
		try {
			sn.addMember("user1","password", "profile");
			sn.addMember("user2","password", "profile");
			sn.addMember("user3","password", "profile");
			sn.addItemFilm("user1","password", "title","kind", "director", "scriptwriter", 120);
		}
		
		catch (Exception e) {
			
		}
		
		System.out.println("Testing reviewItemFilmTest()");

		//7.1 : Test with non instantiated login
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,null,new String("password"),new String("title"),5, new String("thecomment"),"7.1", "addReviewItemFilm() doesn't reject null login.");
				
		//7.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String(""),new String("password"),new String("title"),5,new String("thecomment"),"7.2", "addReviewItemFilm() doesn't reject logins that don't contain at least one character other than space.");
				
		//7.3: Test with non instantiated password
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"),null,new String("title"),5,new String("thecomment"),"7.3", "addReviewItemFilm() doesn't reject null password.");
				
		//7.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"),new String(""),new String("title"),5,new String("thecomment"),"7.4", "addReviewItemFilm() doesn't reject password that contains less than 4 characters.");
				
		//7.5: Test with a non instantiated title
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"),new String("password"),null,5,new String("thecomment"),"7.5", "addReviewItemFilm() doesn't reject non instanciated titles.");
				
		//7.6: Test with a title which contains less than one non-space character
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"), new String("password"),new String(""),5, new String("thecomment"),"7.6", "addReviewItemFilm() doesn't reject non instanciated titles.");
			
		//7.7: Test with a negative mark
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"),new String("password"),new String("title"),-4, new String("thecomment"),"7.7", "addReviewItemFilm() doesn't reject marks lesser or equal to 0");
		

		//7.8: Test with a mark higher than 5
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"),new String("password"),new String("title"),10,new String("thecomment"),"7.8", "addReviewItemFilm() doesn't reject marks greater or equal to 5");

		//7.9: Test with a non instantiated comment 
		nbTests++;
		nbErrors+=addReviewItemFilmBadEntryTest(sn,new String("user1"),new String("password"),new String("title"),10, null,"7.9", "addReviewItemFilm() doesn't reject non instantiated comment");
		
		//test n 8 
		
		//OK Test
		nbTests++;
		nbErrors=addReviewItemFilmOKTest(sn,new String("user1"),new String("password"),new String("title"), (float) 1 ,"8.1a",new String("User 1 comment"));
		
		nbTests++;
		nbErrors=addReviewItemFilmOKTest(sn,new String("user2"),new String("password"),new String("title"), (float) 1 ,"8.1b",new String("User 2 comment"));
		
		nbTests++;
		nbErrors=addReviewItemFilmOKTest(sn,new String("user3"),new String("password"),new String("title"), (float) 1 ,"8.1c",new String("User 3 comment"));
		
		//8.2: Test with a non existing title 
	
		nbTests++;
		nbErrors+=addReviewItemFilmNotItemExceptionTest(sn,new String("user1"),new String("password"),new String("non_existing_title"),4,new String("thecomment"),"3.1", "addReviewItemFilm() doesn't reject adding review for an unmatching film.");
		
		//8.3: Test with a non existing login 

		nbTests++;
		nbErrors+=addReviewItemFilmNotMemberExceptionTest(sn,new String("false_login"),new String("password"),new String("title"),4, new String("thecomment"),"2.1", "addReviewItemFilm() doesn't reject non registered user.");
		
		//8.4: Test with an unmatching password 

		nbTests++;
		nbErrors+=addReviewItemFilmNotMemberExceptionTest(sn,new String("user1"),new String("false_password"),new String("title"),4,new String("thecomment"),"2.2", "addReviewItemFilm() doesn't reject users with unmatching password.");
		

				
		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("ReviewItemFilmTest : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in addItemFilmTest test code - Can't return valuable test results");
			return null;
			}
	}
	
	public static void main(String args[]) {
		test();
	}
}
