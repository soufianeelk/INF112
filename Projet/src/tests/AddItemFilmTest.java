package tests;

import exceptions.BadEntryException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addItemFilm()</i> method.
 * 
 * @author S. EL KALDAOUI, H. MEZAZIGH
 * @version V2.0 - April 2020
 */

public class AddItemFilmTest {
	
	/**
	 * Check that trying to add this new film (login, password, title, kind, director, scenarist, duration) raises a
	 * BadEntry exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - film's title
	 * @param kind
	 *            - film's kind            
	 * @param director
	 *            - film's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemFilmBadEntryTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String director, String scenarist, int duration, String testId, String errorMessage) {
		
		int nbFilms = sn.nbFilms();		//Get the nbFilms before addItemFilm to compare after
		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenarist, duration); //Trying to add the film
			System.out.println("Err " + testId + " : " + errorMessage);	//If the film is added print error message
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
	 * Check that trying to add this new film (login, password, title, kind, director, scenarist, duration) raises an
	 * ItemFilmAlreadyExists Exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - film's title
	 * @param kind
	 *            - film's kind            
	 * @param director
	 *            - film's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemFilmAlreadyExistsTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String director, String scenarist, int duration, String testId, String errorMessage) {
		int nbFilms = sn.nbFilms();		//Get the nbFilms before addItemFilm to compare after
		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenarist, duration);	//Trying to add the film
			System.out.println("Err " + testId + " : " + errorMessage);		//If the film is added print error message
			return 1;

		} catch (ItemFilmAlreadyExistsException e) {	//Check if the ItemFilmAlreadyExistsException is correctly caught
			if (sn.nbFilms() != nbFilms) {		//Check if no films were added by comparing nbFilms before and now
				System.out.println("Err "+ testId+ " : ItemFilmAlreadyExistsException was thrown but the number of films was changed");
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
	 * Check that trying to add this new film (login, password, title, kind, director, scenarist, duration) raises an
	 * NotMember Exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - film's title
	 * @param kind
	 *            - film's kind            
	 * @param director
	 *            - film's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemFilmNotMemberExceptionTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String director, String scenarist, int duration, String testId, String errorMessage) {
		
		int nbFilms = sn.nbFilms(); 	//Get the nbFilms before addItemFilm to compare after
		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenarist, duration);	//Trying to add the film
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
	 * Check that this new film (login, password, title, kind, director, scenarist, duration) can be (and <i>is</i>)
	 * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
	 * : the new film was added.</br> If not OK, an error message is displayed
	 * and 1 is returned ; the new film was not correctly added.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - film's title
	 * @param kind
	 *            - film's kind            
	 * @param director
	 *            - film's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemFilmOKTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String director, String scenarist, int duration, String testId) {
		
		int nbFilms = sn.nbFilms();		//Get the nbFilms before addItemFilm to compare after
		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenarist, duration);	//Trying to add the film
			
			if (sn.nbFilms() != nbFilms + 1) {	//Check if the film was correctly added by comparing nbFilms before +1 and now
				System.out.println("Err " + testId + " : the number of films (" + nbFilms + ") was not incremented");	//If no print error message
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
		
		ISocialNetwork sn = new SocialNetwork();
		
		int nbBooks = sn.nbBooks();

		int nbFilms = sn.nbFilms(); 


		int nbTests = 0;
		int nbErrors = 0;

		System.out.println("Testing addItemFilm()");
		
		// <=> test n°1

		// check if incorrect parameters cause addItemFilm() to throw BadEntry
		// exception
		
		// 1.1 : Test with non instantiated login
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,null, "password", "title","kind", "director", "scriptwriter", 10, "1.1", "addItemFilms() doesn't reject null login.");
		
		//1.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn," ", "password", "title","kind", "director", "scriptwriter", 10, "1.2", "addItemFilms() doesn't reject logins that don't contain at least one character other than space.");
		
		//1.3: Test with non instantiated password
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", null, "title","kind", "director", "scriptwriter", 10, "1.3", "addItemFilms() doesn't reject null password.");
		
		//1.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", "B", "title","kind", "director", "scriptwriter", 10, "1.4", "addItemFilms() doesn't reject password that contains less than 4 characters.");
		
		//1.5: Test with a non instantiated title
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", "password", null,"kind", "director", "scriptwriter", 10, "1.5", "addItemFilms() doesn't reject non instanciated titles.");
		
		//1.6: Test with a non instantiated kind
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", "password", "title",null, "director", "scriptwriter", 10, "1.6", "addItemFilms() doesn't reject non instanciated kinds.");
		
		//1.7: Test with a non instantiated film director
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", "password", "title","kind", null, "scriptwriter", 10, "1.7", "addItemFilms() doesn't reject non instanciated film directors names.");
		
		//1.8: Test with a non instantiated scenarist 
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", "password", "title","kind", "director", null, 10, "1.8", "addItemFilms() doesn't reject non instaciated scenarist.");
		
		//1.9: Test with a negative duration
		nbTests++;
		nbErrors+=addItemFilmBadEntryTest(sn,"login", "password", "title","kind", "director", "scriptwriter", -10, "1.9", "addItemFilms() doesn't reject negative film duration.");

		
		// <=> test n°2
		
		//Creating a member to add films
		try {
			sn.addMember("login", "password", "profile");
		} catch (BadEntryException | MemberAlreadyExistsException e1) {
			e1.printStackTrace();
		}
		
		//2.1: Adding 3 films
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "login", "password", "title","kind", "director", "scriptwriter", 10, "2.1a");
		
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, new String("login"), new String("password"), "title1", new String("kind"), new String("director"), new String("scriptwriter"), 10, "2.1b");
		
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, new String("login"), new String("password"), "title2", new String("kind"), new String("director"), new String("scriptwriter"), 10, "2.1c");
		
		nbFilms += 3;
		
		//2.2: Test with an existing title
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, new String("login"), new String("password"), "title", new String("kind1"), new String("director1"), new String("scriptwriter1"), 1, "2.2", "The title of the first film was accepted as title for a new film");
		
		//2.3: Test with an existing title
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, new String("login"), new String("password"), "title2", "kind2", "director2", "scriptwriter2", 2, "2.3", "The title of the last film was accepted as title for a new film");
		
		//2.4: Test with an existing title with different case
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, new String("login"), new String("password"), "TiTlE1","kind3", "director3", "scriptwriter3", 3, "2.4", "An already registered title, but with different case, was accepted as title for a new film");
		
		//2.5: Test with leading/trailing blanks
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn,new String("login"), new String("password"), " title1 ","kind4", "director4", "scriptwriter4", 4, "2.5", "An already registered title, surrounded by leading/trailing blanks, was accepted as title for a new film");
		
		//2.6: Test with not existing login
		nbTests++;
		nbErrors += addItemFilmNotMemberExceptionTest(sn, new String("login1"), new String("password"), "title5", "kind5", "director5", "scriptwriter5", 5, "2.6", "The login not existing was accepted as login to add a new film");
		
		//2.7: Test with wrong password
		nbTests++;
		nbErrors += addItemFilmNotMemberExceptionTest(sn, new String("login"), "password1", " title6 ","kind6", "director6", "scriptwriter6", 1, "2.7", "A password not corresponding to login was accepted to add a new film");

		// check that 'sn' was not modified
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by addItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out
					.println("Error : the number of books was unexepectedly changed by addMember()");
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
	
	public static void main(String[] args) {
		test();
	}
}
