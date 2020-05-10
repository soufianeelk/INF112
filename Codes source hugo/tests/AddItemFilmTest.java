package tests;

import opinion.ISocialNetwork; 
import opinion.SocialNetwork;

import exceptions.BadEntryException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
 
/**
 * Tests for the SocialNetwork.<i>addItemFilm()</i> method.
 * 
 * @author V. Tritarelli, H. Houillon
 * @version V1.0 - April 2020
 */

public class AddItemFilmTest {
	
	/**
	 * Check that trying to add this new film (login, pwd, title, kind, director, scriptwriter, duration) raises a
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
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 * 			  - new film's director
	 * @param scriptwriter
	 * 			  - new film's scriptwriter
	 * @param duration
	 * 			  - new film's duration
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int addItemFilmBadEntryException(ISocialNetwork sn, String login, String password, String title,String kind, String director, String scriptwriter, int duration, String testId, String errorMessage)
	{
		int nbFilms = sn.nbFilms(); // Number of films when starting to run this method
			
		try
		{
			sn.addItemFilm(login, password, title, kind, director, scriptwriter, duration); // Try to add this film
			// Reaching this point means that no exception was thrown by addItemFilm()
			
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			
			return 1;
		}
		catch(BadEntryException e)
		{
			if (sn.nbFilms() != nbFilms) { // The number of films has changed : this is an error case.
				System.out.println("Err " + testId + " : BadEntry was thrown but the number of films was changed"); // Display a specific error message
				return 1; // return "error" value
			} 
			else { // The number of films hasn't changed, which is considered a good indicator that 'sn' was not modified
				return 0; // return success value : everything seems OK, nothing to display
			}
		}
		catch(Exception e)// An exception was thrown by addMember(), but it was not the expected exception BadEntry
		{ 
			System.out.println("Err " + testId + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	}
	
	/**
	 * Check that trying to add this new film (login, pwd, title, kind, director, scriptwriter, duration) raises a
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
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 * 			  - new film's director
	 * @param scriptwriter
	 * 			  - new film's scriptwriter
	 * @param duration
	 * 			  - new film's duration
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int addItemFilmNotMemberException(ISocialNetwork sn, String login, String password, String title,String kind, String director, String scriptwriter, int duration, String testId, String errorMessage)
	{
		int nbFilms = sn.nbFilms(); // Number of films when starting to run this method
			
		try
		{
			sn.addItemFilm(login, password, title, kind, director, scriptwriter, duration); // Try to add this film
			// Reaching this point means that no exception was thrown by addItemFilm()
			
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			
			return 1;
		}
		catch(NotMemberException e)
		{
			if (sn.nbFilms() != nbFilms) { // The number of films has changed : this is an error case.
				System.out.println("Err " + testId + " : NotMemberException was thrown but the number of films was changed"); // Display a specific error message
				return 1; // return "error" value
			} 
			else { // The number of films hasn't changed, which is considered a good indicator that 'sn' was not modified
				return 0; // return success value : everything seems OK, nothing to display
			}
		}
		catch(Exception e)// An exception was thrown by addMember(), but it was not the expected exception NotMember
		{ 
			System.out.println("Err " + testId + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	}
	
	/**
	 * Check that trying to add this new film (login, pwd, title, kind, director, scriptwriter, duration) raises a
	 * ItemFilmAlreadyExists exception and does not change content of the
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
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 * 			  - new film's director
	 * @param scriptwriter
	 * 			  - new film's scriptwriter
	 * @param duration
	 * 			  - new film's duration
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int addItemFilmAlreadyExistsTest (ISocialNetwork sn, String login, String password, String title,String kind, String director, String scriptwriter, int duration, String testId, String errorMessage)
	{
		int nbFilms = sn.nbFilms(); // Number of films when starting to run this method
			
		try
		{
			sn.addItemFilm(login, password, title, kind, director, scriptwriter, duration); // Try to add this film
			// Reaching this point means that no exception was thrown by addItemFilm()
			
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			
			return 1;
		}
		catch(ItemFilmAlreadyExistsException  e)
		{
			if (sn.nbFilms() != nbFilms) { // The number of films has changed : this is an error case.
				System.out.println("Err " + testId + " : ItemFilmAlreadyExistsException was thrown but the number of films was changed"); // Display a specific error message
				return 1; // return "error" value
			} 
			else { // The number of films hasn't changed, which is considered a good indicator that 'sn' was not modified
				return 0; // return success value : everything seems OK, nothing to display
			}
		}
		catch(Exception e)// An exception was thrown by addMember(), but it was not the expected exception ItemFilmAlreadyExists
		{ 
			System.out.println("Err " + testId + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	}
	
	private static int addItemFilmOKTest(ISocialNetwork sn, String login, String password, String title,String kind, String director, String scriptwriter, int duration, String testId)
	{
		int nbFilms = sn.nbFilms();
		try
		{
			sn.addItemFilm(login, password, title, kind, director, scriptwriter, duration);
			
			if(sn.nbFilms() != nbFilms + 1)
			{
				System.out.println("Err " + testId
						+ " : the number of films (" + nbFilms
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
	
	public static TestReport test(){

		ISocialNetwork sn = new SocialNetwork();

		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
									// here)
		int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 0
									// here)

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing addItemFilm()");
		
		// Populate member with a new one
		try
		{
			sn.addMember("user", "password", "profile");
		}
		catch(Exception e)
		{
			
		}
		
		// <=> test n°1
		// check if incorrect parameters cause addItemFilm() to throw BadEntry exception

		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, null, "dcddc", "ccdds", "cdcds", "cdcds", "ccds", 132, "1.1", "addItemFilm() doesn't reject null login");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, " ", "cddsd", "ccdcdsds", "cdcds", "cdcds", "ccds", 132, "1.2", "addItemFilm() doesn't reject logins that don't contain at least one character");
		
		//nbTests++;
		//nbErrors += addItemFilmBadEntryException(sn, "ti ti", "dcdds", "cdcds", "cdcds", "cdcds", "ccds", 132, "1.3", "addItemFilm() doesn't reject logins that don't contain spaces");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", null, "ccdds", "cdcds", "cdcds", "ccds", 132, "1.4", "addItemFilm() doesn't reject null password");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", "m d p", "cdcdss", "cdcds", "cdcds", "ccds", 132, "1.5", "addItemFilm() doesn't reject passwords that don't contain at least four character without spaces");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", "password", null, "cdcds", "cdcds", "ccds", 132, "1.6", "addItemFilm() doesn't reject null title");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", "password", " ", "cdcds", "cdcds", "ccds", 132, "1.7", "addItemFilm() doesn't reject titles that don't contain at least one character who is not a space");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", "password", "cdcds", null, "cdcds", "ccds", 132, "1.8", "addItemFilm() doesn't reject null type");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", "password", "cdcds", "cd", null, "ccds", 132, "1.9", "addItemFilm() doesn't reject null director");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "user", "password", "cdcds", "cd", "dcd", null, 132, "1.10", "addItemFilm() doesn't reject null scriptwriter");
		
		nbTests++;
		nbErrors += addItemFilmBadEntryException(sn, "login", "cddsd", "cdcds", "cd", "cdscd", "ccds", -2, "1.11", "addItemFilm() doesn't reject negative duration");
		
		// <=> test n°2
		// check if incorrect parameters cause addItemFilm() to throw NotMember exception
		
		nbTests++;
		nbErrors += addItemFilmNotMemberException(sn, "toto", "password", "cdcds", "cd", "cdscd", "ccds", 3, "2.1", "addItemFilm() doesn't reject login who doesn' exists");
		
		nbTests++;
		nbErrors += addItemFilmNotMemberException(sn, "user", "cddsd", "cdcds", "cd", "cdscd", "ccds", 3, "2.2", "addItemFilm() doesn't reject wrong password for existing login");
		
		// <=> test n°3 : populate 'sn' with 3 films
		
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "user", "password", "avenger", "cd", "cdscd", "ccds", 3, "3.1");
		
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "user", "password", "avenger2", "cd", "cdscd", "ccds", 3, "3.1");
		
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "user", "password", "avenger3", "cd", "cdscd", "ccds", 3, "3.1");
		
		nbFilms = 3;
		
		// try to add already registered films
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "user", "password", "avenger", "cd", "cdscd", "ccds", 3, "4.2", "The title of the first film was accepted as title for a new film");
		
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "user", "password", "avenger3", "cd", "cdscd", "ccds", 3, "4.3", "The title of the last film was accepted as title for a new film");
		
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "user", "password", "AvEnGeR", "cd", "cdscd", "ccds", 3, "4.4", "An already registered film, but with different case, was accepted as title for a new film");
		
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "user", "password", " aven ger ", "cd", "cdscd", "ccds", 3, "4.5", "An already registered film, surrounded by leading/trailing blanks, was accepted as title for a new film");
		
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