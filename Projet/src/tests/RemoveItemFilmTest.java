package tests;

import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


public class RemoveItemFilmTest {
	
	/**
	 * Tests for the SocialNetwork.<i>removeItemFilm()</i> method.
	 * 
	 * @author S. EL KALDAOUI, H. MEZAZIGH
	 * @version V2.0 - April 2020
	 */
	
	/**
	 * Check that trying to remove a film by giving bad entries raises a
	 * BadEntry exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 *            - title's name	
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *           
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int removeItemFilmBadEntryTest(SocialNetwork sn, String title, String login, String password, String testId,
			String errorMessage) {
		
		int nbFilms = sn.nbFilms();		//Get the nbFilms before addItemFilm to compare after
		
		try {
			sn.removeItemFilm(title,login, password); //Trying to remove the film with the given title
			System.out.println("Err " + testId + " : " + errorMessage);	//If the film is removed print error message
			return 1;

		} catch (BadEntryException e) {		//Check if the BadEntryException is correctly caught
			if (sn.nbFilms() != nbFilms) {	//Check if no films were added by comparing nbFilms before and now
				System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of films was changed");	//If yes print error message
				return 1;
			} else
				return 0;
		} catch (Exception e) {		//Check if an unexpected exception has been caught
			
			System.out.println("Err " + testId + " : unexpected exception. "+ e);
			e.printStackTrace();
			return 1;
		}
		
	}
	
	/**
	 * Check that trying to remove a film by using a non registered member raises a
	 * NotMemberException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 *            - title's name	
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *           
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int removeItemFilmNotMemberExceptionTest(SocialNetwork sn, String title, String login, String password, String testId,
			String errorMessage) {
		
		int nbFilms = sn.nbFilms(); 	//Get the nbFilms before addItemFilm to compare after
		
		try {
			sn.removeItemFilm(title,login, password); //Trying to remove the film with the given title
			System.out.println("Err " + testId + " : " + errorMessage);		//If the film is added print error message
			return 1;

		} catch (NotMemberException e) {		//Check if the NotMemberException is correctly caught
			if (sn.nbFilms() != nbFilms) {		//Check if no films were added by comparing nbFilms before and now
				System.out.println("Err "+ testId+ " : NotMemberException was thrown but the number of films was changed");
				return 1;
			} else
				return 0;
		} catch (Exception e) {		//Check if an unexpected exception has been caught
			System.out.println("Err " + testId + " : unexpected exception. "+ e);
			e.printStackTrace();
			return 1;
		}
	}
	
	/**
	 * Check that trying to remove a non existing film raises a
	 * NotItemException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 *            - title's name	
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 *           
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int removeItemFilmNotItemExceptionTest(SocialNetwork sn, String title, String login, String password, String testId,
			String errorMessage) {
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		
		try {
			sn.removeItemFilm(title,login, password); // Try to remove a film
			// Reaching this point means that no exception was thrown by removeItemFilm()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotItemException e) {
			
			if (sn.nbFilms() != nbFilms) {
				System.out.println("Err " + testId + " : the number of Films (" + nbFilms + ") changed");
				return 1;
			}	
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") changed");
				return 1;
			}
			
		} catch (Exception e) {		//Check if an unexpected exception has been caught
			System.out.println("Err " + testId + " : unexpected exception. "+ e);
			e.printStackTrace();
			return 1;
		}
			
			return 0;
		}
	
	private static int removeItemFilmOKTest(SocialNetwork sn, String title, String login, String password, String testId) {
		
		int nbFilms = sn.nbFilms();		//Get the nbFilms before addItemFilm to compare after
		
		try {
			 sn.removeItemFilm(title,login, password); // Try to remove a film
			
			if (sn.nbFilms() != nbFilms-1) {	//Check if the film was correctly added by comparing nbFilms before removing and now
				System.out.println("Err " + testId + " : the number of films (" + nbFilms + ") was not removed");	//If no print error message
				return 1;
			} else
				return 0; 
		} catch (Exception e) {		//Check if an unexpected exception has been caught
			System.out.println("Err " + testId + " : unexpected exception " + e);
			e.printStackTrace();
			return 1;
		}

	}	
	
	
	
	
	
	public static TestReport test(){

		SocialNetwork sn = new SocialNetwork();

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests
		
		int nbFilms=sn.nbFilms();
		int nbBooks=sn.nbBooks();
		
		// Creating a user and a film in order to realize tests
		try {
			sn.addMember("user1","password", "profile");
			sn.addMember("user4","password", "profile");
			sn.addItemFilm("user1","password", "title1","kind", "director", "scripwriter", 120);
			nbFilms++;
			sn.addItemFilm("user1","password", "title_to_remove","kind", "director", "scripwriter", 120);
			nbFilms++;
			
		}
		
		catch (Exception e) {
			
		}
		
		
		System.out.println("Testing removeItemFilm()");
		
		// <=> test n°1 : Bad Entries test
		
		// 1.1 : Test with non instantiated login
		nbTests++;
		nbErrors += removeItemFilmBadEntryTest(sn,"title_to_remove", null,"password", "1.1", "removeItemFilm() doesn't reject null login.");
		
		//1.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors += removeItemFilmBadEntryTest(sn,"title_to_remove"," ","password", "1.2", "removeItemFilm() doesn't reject logins that don't contain at least one character other than space.");
		
		//1.3: Test with non instantiated password
		nbTests++;
		nbErrors += removeItemFilmBadEntryTest(sn,"title_to_remove", "user1",null, "1.3", "removeItemFilm() doesn't reject null password.");	
		
		//1.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors += removeItemFilmBadEntryTest(sn,"title_to_remove", "user1","pas", "1.5", "removeItemFilm() doesn't reject password that contains less than 4 characters.\");");
		
		//1.5: Test with a non instantiated title
		nbTests++;
		nbErrors += removeItemFilmBadEntryTest(sn,null, "user1","password", "1.6", "removeItemFilm() doesn't reject password that contains less than 4 characters.\");");
		
		
		// <=> test n°2 : NotMemberException tests
		
		nbTests++;
		nbErrors += removeItemFilmNotMemberExceptionTest(sn,"title_to_remove", "user2","password", "2.1", "removeItemFilm() doesn't reject non registered user.");
		
		nbTests++;
		nbErrors += removeItemFilmNotMemberExceptionTest(sn,"title_to_remove", "user1","false_password", "2.2", "removeItemFilm() doesn't reject users with unmatching password.");
		
		//test n°3 : NotItemException tests 		
		nbTests++;
		nbErrors+=removeItemFilmNotItemExceptionTest(sn,"fake_title", "user1","password", "3.1", "removeItemFilm() doesn't reject removing film action for an unmatching film.");
		
		//Test n°4 : Trying to remove the film of a user with another user. 
		try {
			sn.removeItemFilm("title_to_remove", "user2","password");
			nbTests++;
			if (nbFilms!=sn.nbFilms()) nbErrors+=1;
		}
		
		catch (Exception e) {	
		}
		
		//OK Test
		nbTests++;
		nbErrors += removeItemFilmOKTest(sn,"title_to_remove", "user1","password", "4.1");
		nbFilms--;
		
		// check that 'sn' was correctly modified
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Error : the number of films was uncorrectly changed by removeItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by removeItemFilm()");
			nbErrors++;
		}

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


