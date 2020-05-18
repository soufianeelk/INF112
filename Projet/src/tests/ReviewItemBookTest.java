package tests;

import exceptions.BadEntryException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import exceptions.NotItemException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addReviewItemBook()</i> method.
 * 
 * @author S. EL KALDAOUI, H. MEZAZIGH
 * @version V2.0 - April 2020
 */

public class ReviewItemBookTest {
	
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
	private static int addReviewItemBookBadEntryTest(SocialNetwork sn, String login,
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		if (sn.searchBookByTitle(title)==null) return 0;
		int nbReview=sn.searchBookByTitle(title).getNbReviews(); //Retrieving the number of review of the book before adding a new one.
		
		try {
			sn.reviewItemBook(login, pwd, title, mark, comment); // Try to add a new review
			// Reaching this point means that no exception was thrown by reviewItemBook()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (BadEntryException e) { 

			
			if (sn.searchBookByTitle(title).getNbReviews() != nbReview) {
				System.out.println("Err " + testId + " : the number of reviews (" + nbReview + ") was incremented");
				return 1;
			}
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") was incremented");
				return 1;
			}	
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was incremented");
				return 1;
			}
			
			return 0; 
		}
		catch (Exception e) {// An exception was thrown by reviewItemBook(), but
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
	private static int addReviewItemBookNotMemberExceptionTest(SocialNetwork sn, String login,
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		int nbReview=sn.searchBookByTitle(title).getNbReviews();
		
		try {
			sn.reviewItemBook(login, pwd, title, mark, comment); // Try to add a new review and save the mean
			// Reaching this point means that no exception was thrown by reviewItemFilm()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotMemberException e) {
			
			if (sn.searchBookByTitle(title).getNbReviews() != nbReview) {
				System.out.println("Err " + testId + " : the number of reviews (" + nbReview + ") was incremented");
				return 1;
			}
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") was incremented");
				return 1;
			}	
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was incremented");
				return 1;
			}
			
			return 0;
		}
		
		catch (Exception e) {// An exception was thrown by reviewItemBook(), but
			// it was not the expected exception NotMemberException
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
}

	/**
	 * Check that trying to add a new review with a non-registered film raises a
	 * NotItemException and does not change content of the
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
	private static int addReviewItemBookNotItemExceptionTest(SocialNetwork sn, String login,
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		if (sn.searchBookByTitle(title)==null) return 0;
		int nbReview=sn.searchBookByTitle(title).getNbReviews();
		
		try {
			sn.reviewItemBook(login, pwd, title, mark, comment); // Try to add a new review and save the mean
			// Reaching this point means that no exception was thrown by reviewItemBook()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotItemException e) {
			
			if (sn.searchFilmByTitle(title).getNbReviews() != nbReview) {
				System.out.println("Err " + testId + " : the number of reviews (" + nbReview + ") was incremented");
				return 1;
			}
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") was incremented");
				return 1;
			}	
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was incremented");
				return 1;
			}
			
			return 0;
		}
		
		catch (Exception e) {// An exception was thrown by reviewItemBook(), but
			// it was not the expected exception NotItemException
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
	
	private static int addReviewItemBookOKTest(SocialNetwork sn, String login,
			String pwd, String title, float mark,String testId,String comment) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		int nbReview=sn.searchBookByTitle(title).getNbReviews();
		
		try {
			int nbReviews;
			nbReviews = sn.searchBookByTitle(title).getNbReviews(); // get the number of review for the book
			sn.reviewItemBook(login, pwd, title, mark, comment);
			
			if (sn.searchBookByTitle(title).getNbReviews() != nbReviews+1) {
				System.out.println("Err " + testId + " : the number of reviews (" + nbReviews + ") was not incremented");
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
		
		
		// Creating a user and a book in order to realize tests
		try {
			sn.addMember("user1","password", "profile");
			sn.addMember("user5","password","profile");
			sn.addItemBook("user1","password", "title","kind", "author", 120);
		}
		
		catch (Exception e) {
			
		}
		
		System.out.println("Testing reviewItemFilmTest()");
		//OK Tests 
		
		nbTests++;
		nbErrors=addReviewItemBookOKTest(sn,"user1","password","title", (float) 4 ,"1.a","Commentaire 1");
		
		// 1.1 : Test with non instantiated login
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,null,"password","title",5, "thecomment","1.1", "addReviewItemFilm() doesn't reject null login.");
				
		//1.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"","password","title",5, "thecomment","1.2", "addReviewItemFilm() doesn't reject logins that don't contain at least one character other than space.");
				
		//1.3: Test with non instantiated password
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1",null,"title",5, "thecomment","1.3", "addReviewItemFilm() doesn't reject null password.");
				
		//1.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1","","title",5, "thecomment","1.4", "addReviewItemFilm() doesn't reject password that contains less than 4 characters.");
				
		//1.5: Test with a non instantiated title
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1","password",null,5, "thecomment","1.5", "addReviewItemFilm() doesn't reject non instanciated titles.");
				
		//1.6: Test with a title which contains less than one non-space character
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1","password","",5, "thecomment","1.6", "addReviewItemFilm() doesn't reject non instanciated titles.");
			
		//1.7: Test with a mark lesser or equal to 0
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1","password","title",-4, "thecomment","1.7", "addReviewItemFilm() doesn't reject marks lesser or equal to 0");
		
		//1.8: Test with a mark lesser or equal to 0
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1","password","title",10, "thecomment","1.8", "addReviewItemFilm() doesn't reject marks greater or equal to 5");

		//1.9: Test with a non instantiated comment 
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"user1","password","title",10, null,"1.9", "addReviewItemFilm() doesn't reject non instantiated comment");
		
		
		//test n°2 : NotMemberException tests
		
		nbTests++;
		nbErrors+=addReviewItemBookNotMemberExceptionTest(sn,"user2","password","title",4, "thecomment","2.1", "addReviewItemFilm() doesn't reject non registered user.");
		
		nbTests++;
		nbErrors+=addReviewItemBookNotMemberExceptionTest(sn,"user1","false_password","title",4, "thecomment","2.2", "addReviewItemFilm() doesn't reject users with unmatching password.");
		
		//test n°3 : NotItemException tests 		
		nbTests++;
		nbErrors+=addReviewItemBookNotItemExceptionTest(sn,"user1","password","non_existing_title",4, "thecomment","3.1", "addReviewItemFilm() doesn't reject adding review for an unmatching film.");

				
		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("AddMemberTest : " + tr);
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
