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
	private static int addReviewItemBookBadEntryTest(ISocialNetwork sn, String login,
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		float meanBook=0;
		
		try {
			sn.reviewItemBook(login, pwd, title, mark, comment); // Try to add a new review
			// Reaching this point means that no exception was thrown by reviewItemBook()
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
			
			if (meanBook!=0) {
				System.out.println("Err " + testId + " : the mean of review of this Book has changed");
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
	private static int addReviewItemBookNotMemberExceptionTest(ISocialNetwork sn, String login,
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		float meanBook=0;
		
		try {
			sn.reviewItemBook(login, pwd, title, mark, comment); // Try to add a new review and save the mean
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
			
			if (meanBook!=0) {
				System.out.println("Err " + testId + " : the mean of review of this Book has changed");
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
	private static int addReviewItemBookNotItemExceptionTest(ISocialNetwork sn, String login,
			String pwd, String title, float mark, String comment,String testId,String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		float meanBook=0;
		
		try {
			sn.reviewItemBook(login, pwd, title, mark, comment); // Try to add a new review and save the mean
			// Reaching this point means that no exception was thrown by reviewItemBook()
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
			if (meanBook!=0) {
				System.out.println("Err " + testId + " : the mean of review of this Book has changed");
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
	
	private static int addReviewItemBookOKTest(ISocialNetwork sn, String login,
			String pwd, String title, float mark,String testId,String comment) {
		
		try {
			
			float meanBook=sn.reviewItemBook(login, pwd, title, mark, comment);
			
			if (meanBook==0) {
				System.out.println("Err " + testId + " : the mean of the book hasn't changed, so the review was not added correctly.");
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
			sn.addMember("user2","password", "profile");
			sn.addMember("user3","password", "profile");
			sn.addItemBook("user1","password", "title","kind", "author", 120);
		}
		
		catch (Exception e) {
			
		}
		
		System.out.println("Testing reviewItemBookTest()");

		// 9.1 : Test with non instantiated login
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,null, new String("password"), new String("title"),5, new String("thecomment"),"1.1", "addReviewItemFilm() doesn't reject null login.");
				
		//9.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,"", new String("password"), new String("title"),5,  new String("thecomment"),"9.2", "addReviewItemFilm() doesn't reject logins that don't contain at least one character other than space.");
				
		//9.3: Test with non instantiated password
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"),null,new String("title"),5,  new String("thecomment"),"9.3", "addReviewItemFilm() doesn't reject null password.");
				
		//9.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"),"",new String("title"),5, new String("thecomment"),"9.4", "addReviewItemFilm() doesn't reject password that contains less than 4 characters.");
				
		//9.5: Test with a non instantiated title
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"),new String("password"),null,5, new String("thecomment"),"9.5", "addReviewItemFilm() doesn't reject non instanciated titles.");
				
		//9.6: Test with a title which contains less than one non-space character
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"), new String("password"),"",5, new String("thecomment"),"9.6", "addReviewItemFilm() doesn't reject non instanciated titles.");
			
		//9.7: Test with a mark lesser or equal to 0
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"), new String("password"), new String("title"),-4, new String("thecomment"),"9.7", "addReviewItemFilm() doesn't reject marks lesser or equal to 0");
		
		//9.8: Test with a mark greater or equal to 0
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"),new String("password"),new String("title"),10, new String("thecomment"),"9.8", "addReviewItemFilm() doesn't reject marks greater or equal to 5");

		//9.9: Test with a non instantiated comment 
		nbTests++;
		nbErrors+=addReviewItemBookBadEntryTest(sn,new String("user1"), new String("password"),new String("title"),10, null,"9.9", "addReviewItemFilm() doesn't reject non instantiated comment");
		
		
		//test n10 
		//OK Tests 
		
		nbTests++;
		nbErrors=addReviewItemBookOKTest(sn,new String("user1"),new String("password"),"title", (float) 1 ,"10.1a","Comment of the user 1");
		
		nbTests++;
		nbErrors=addReviewItemBookOKTest(sn,new String("user2"),new String("password"),"title", (float) 1 ,"10.1b","Comment of the user 2");
		
		nbTests++;
		nbErrors=addReviewItemBookOKTest(sn,new String("user3"),new String("password"),"title", (float) 1 ,"10.1c","Comment of the user 3");
		
		//10.2: Test with a non existing title 

		nbTests++;
		nbErrors+=addReviewItemBookNotItemExceptionTest(sn,new String("user1"),new String("password"),new String("non_existing_title"),4, new String("thecomment"),"10.2", "addReviewItemFilm() doesn't reject adding review for an unmatching film.");

		//10.3: Test with a non existing login 

		nbTests++;
		nbErrors+=addReviewItemBookNotMemberExceptionTest(sn,new String("fake_login"),new String("password"),new String("title"),4, new String("thecomment"),"10.3", "addReviewItemFilm() doesn't reject non registered user.");
		
		//10.4: Test with a unmatching password 

		nbTests++;
		nbErrors+=addReviewItemBookNotMemberExceptionTest(sn,new String("user1"), new String("false_password"),new String("title"),4, new String("thecomment"),"10.4", "addReviewItemFilm() doesn't reject users with unmatching password.");
			
				
		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("ReviewItemBook : " + tr);
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
