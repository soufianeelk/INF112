package tests;
import exceptions.BadEntryException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import exceptions.ItemBookAlreadyExistsException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addItemFilm()</i> method.
 * 
 * @author S. EL KALDAOUI, H. MEZAZIGH
 * @version V2.0 - April 2020
 */

public class AddItemBookTest {
	
	/**
	 * Check that trying to add this new book (login, password, title, kind, author,nbPages) raises a
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
	 *            - book's title
	 * @param kind
	 *            - book's kind            
	 * @param author
	 *            - book's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemBookBadEntryTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String author, int nbPages, String testId, String errorMessage) {
		
		int nbBooks = sn.nbBooks();		//Get the nbBooks before addItemFilm to compare after
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);; //Trying to add the book
			System.out.println("Err " + testId + " : " + errorMessage);	//If the film is added print error message
			return 1;

		} catch (BadEntryException e) {		//Check if the BadEntryException is correctly caught
			if (sn.nbBooks() != nbBooks) {	//Check if no films were added by comparing nbBooks before and now
				System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of books was changed");	//If yes print error message
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
	 * Check that trying to add this new book (login, password, title, kind, author,nbPages) raises a
	 * ItemBookAlreadyExists Exception and does not change content of the
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
	 *            - book's title
	 * @param kind
	 *            - book's kind            
	 * @param author
	 *            - book's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemBookAlreadyExistsTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String author, int nbPages, String testId, String errorMessage) {
		int nbBooks = sn.nbBooks();
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			System.out.println("Err " + testId + " : " + errorMessage);
			return 1;

		} catch (ItemBookAlreadyExistsException e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err "+ testId+ " : ItemFilmAlreadyExistsException was thrown but the number of books was changed");
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "+ e);
			e.printStackTrace();
			return 1;
		}
	}
	

	/**
	 * Check that trying to add this new book (login, password, title, kind, author, nbPages) raises an
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
	 *            - book's title
	 * @param kind
	 *            - book's kind            
	 * @param author
	 *            - book's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemFilmNotMemberExceptionTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String author, int nbPages, String testId, String errorMessage) {
		
		int nbBooks = sn.nbBooks(); // Number of books when starting to run this method
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			System.out.println("Err " + testId + " : " + errorMessage);
			return 1;

		} catch (NotMemberException e) {
			if (sn.nbBooks() != nbBooks) {
				System.out.println("Err "+ testId+ " : NotMemberException was thrown but the number of books was changed");
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "+ e);
			e.printStackTrace();
			return 1;
		}
	}
			
	/**
	 * Check that this new book (login, password, title, kind, author, nbPages) can be (and <i>is</i>)
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
	 *            - book's title
	 * @param kind
	 *            - book's kind            
	 * @param author
	 *            - book's director	 
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int addItemBookOKTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String author, int nbPages, String testId) {
		
		int nbBooks = sn.nbBooks();
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			
			if (sn.nbBooks() != nbBooks + 1) {
				System.out.println("Err " + testId + " : the number of books (" + nbBooks + ") was not incremented");
				return 1;
			} else
				return 0; 
		} catch (Exception e) {
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
		
	
		try {
			sn.addMember("user","password", "profile");
		}
		
		catch (Exception e) {
			
		}
		
		
		System.out.println("Testing addItemBook()");
		
		// <=> test n°1

		// check if incorrect parameters cause addItemBook() to throw BadEntry
		// exception
		
		// 1.1 : Test with non instantiated login
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,null, "password", "title","kind", "author", 100, "1.1", "addItemBook() doesn't reject null login.");
		
		//1.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn," ", "password", "title","kind", "author", 100, "1.2", "addItemBook() doesn't reject logins that don't contain at least one character other than space.");
		
		//1.3: Test with non instantiated password
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,"user", null, "title","kind", "author", 100, "1.3", "addItemBook() doesn't reject null password.");
		
		//1.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,"user", "B", "title","kind", "author", 100, "1.4", "addItemBook() doesn't reject password that contains less than 4 characters.");
		
		//1.5: Test with a non instantiated title
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,"user", "password", null,"kind", "author", 100, "1.5", "addItemBook() doesn't reject non instanciated titles.");
		
		//1.6: Test with a non instantiated kind
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,"user", "password", "title",null, "author", 100, "1.6", "addItemBook() doesn't reject non instanciated kinds.");
		
		//1.7: Test with a non instantiated film author
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,"user", "password", "title","kind", null, 100, "1.7", "addItemBook() doesn't reject non instanciated film directors names.");
		
		//1.8: Test with a negative duration
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,"user", "password", "title","kind", "author", -100, "1.8", "addItemBook() doesn't reject negative film duration.");

		
		// <=> test n°2
		
		//Creating a member to add films
		try {
			sn.addMember("login", "password", "profile");
		} catch (BadEntryException | MemberAlreadyExistsException e1) {
			e1.printStackTrace();
		}
		
		//2.1: Adding a Book
		nbTests++;
		nbErrors += addItemBookOKTest(sn, "user", "password", "title","kind","author", 100, "2.1a");
		nbBooks++;
		
		
		//2.2: Test with an existing title
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "user", "password", "title", "kind","author", 100, "2.2", "The title of the first book was accepted as title for a new book");
		
		//2.3: Test with an existing title
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "user", "password", "title", "kind","author",100, "2.3", "The title of the last book was accepted as title for a new book");
		
		//2.4: Test with an existing title with different case
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "user", "password", "TiTlE","kind", "author", 100, "2.4", "An already registered title, but with different case, was accepted as title for a new book");
		
		//2.5: Test with leading/trailing blanks
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn,"user", "password", " title ","kind", "author", 100, "2.5", "An already registered title, surrounded by leading/trailing blanks, was accepted as title for a new book");
		
		//2.6: Test with not existing login
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "user", "password", "title", "kind","author", 100, "2.6", "The login not existing was accepted as login to add a new book");
		
		//2.7: Test with wrong password
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "user", "false_password", "title","kind", "author", 100, "2.7", "A password not corresponding to login was accepted to add a new book");

		//3.1: 
		
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
					.println("Error : the number of books was unexepectedly changed by addItemBook()");
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
			System.out.println("Unexpected error in addItemBookTest test code - Can't return valuable test results");
			return null;
			}
	}
	
	public static void main(String[] args) {
		test();
	}
}
