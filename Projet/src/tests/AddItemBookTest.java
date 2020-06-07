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
		
		int nbBooks = sn.nbBooks();		//Get the nbBooks before addItemBook to compare after
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);  //Trying to add the book
			System.out.println("Err " + testId + " : " + errorMessage);		//If the book is added print error message
			return 1;

		} catch (BadEntryException e) {		//Check if the BadEntryException is correctly caught
			if (sn.nbBooks() != nbBooks) {	//Check if no books were added by comparing nbBooks before and now
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
		
		int nbBooks = sn.nbBooks();		//Get the nbBooks before addItemBook to compare after
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);	//Trying to add the book
			System.out.println("Err " + testId + " : " + errorMessage);		//If the book is added print error message
			return 1;

		} catch (ItemBookAlreadyExistsException e) {	//Check if the ItemBookAlreadyExistsException is correctly caught
			if (sn.nbBooks() != nbBooks) {		//Check if no books were added by comparing nbBooks before and now
				System.out.println("Err "+ testId+ " : ItemFilmAlreadyExistsException was thrown but the number of books was changed");	//If yes print error message
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
	private static int addItemBookNotMemberExceptionTest(ISocialNetwork sn, String login, String password, String title,
			String kind, String author, int nbPages, String testId, String errorMessage) {
		
		int nbBooks = sn.nbBooks(); // Number of books when starting to run this method
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);	//Trying to add the book
			System.out.println("Err " + testId + " : " + errorMessage);		//If the book is added print error message
			return 1;

		} catch (NotMemberException e) {		//Check if the ItemBookAlreadyExistsException is correctly caught
			if (sn.nbBooks() != nbBooks) {		//Check if no books were added by comparing nbBooks before and now
				System.out.println("Err "+ testId+ " : NotMemberException was thrown but the number of books was changed");		//If yes print error message
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
		
		int nbBooks = sn.nbBooks();		//Get the nbBooks before addItemBook to compare after
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);		//Trying to add the book
			
			if (sn.nbBooks() != nbBooks + 1) {		//Check if the book was correctly added by comparing nbBooks before +1 and now
				System.out.println("Err " + testId + " : the number of books (" + nbBooks + ") was not incremented");		//If no print error message
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
		
		System.out.println("Testing addItemBook()");
		
		//Creating a member to add books
		try {
			sn.addMember("login", "password", "profile");
		} catch (BadEntryException | MemberAlreadyExistsException e1) {
			e1.printStackTrace();
		}
		
		
		// <=> test n 5

		// check if incorrect parameters cause addItemBook() to throw BadEntry
		// exception
		
		// 5.1 : Test with non instantiated login
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,null, new String("password"),new String("title"),"kind", "author", 100, "5.1", "addItemBook() doesn't reject null login.");
		
		//5.2 : Test with login which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn," ", new String("password"), new String("title"),"kind", "author", 100, "5.2", "addItemBook() doesn't reject logins that don't contain at least one character other than space.");
		
		//5.3: Test with non instantiated password
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("user"), null, new String("title"),"kind", "author", 100, "5.3", "addItemBook() doesn't reject null password.");
		
		//5.4: Test with password which contains less than 4 characters '
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("user"), new String("B"),new String("title"),"kind", "author", 100, "5.4", "addItemBook() doesn't reject password that contains less than 4 characters.");
		
		//5.5: Test with a non instantiated title
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("user"),new String("password"), null,"kind", "author", 100, "5.5", "addItemBook() doesn't reject non instanciated titles.");
		
		//5.6: Test with a title which don't contains at least one character other than space
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("login"), new String("password"), new  String(""), "kind", "author", 100, "5.6", "addItemFilms() doesn't reject titles that don't contain at least one character other than space.");
		
		
		//5.7: Test with a non instantiated kind
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("user"),new String("password"), new String("title"),null, "author", 100, "5.7", "addItemBook() doesn't reject non instanciated kinds.");
		
		//5.8: Test with a non instantiated author
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("user"),new String("password"), new String("title"),"kind", null, 100, "5.8", "addItemBook() doesn't reject non instanciated film directors names.");
		
		//5.9: Test with a negative duration
		nbTests++;
		nbErrors+=addItemBookBadEntryTest(sn,new String("user"),new String("password"), new String("title"),"kind", "author", -100, "5.9", "addItemBook() doesn't reject negative film duration.");

		
		// <=> test n 6
		
		//2.1: Adding a Book
		nbTests++;
		nbErrors += addItemBookOKTest(sn, new String("login"), new String("password"), "title","kind", "author", 10, "6.1a");
		
		nbTests++;
		nbErrors += addItemBookOKTest(sn, new String("login"), new String("password"), "title10", "kind", "author", 10, "6.1b");
		
		nbTests++;
		nbErrors += addItemBookOKTest(sn, new String("login"), new String("password"), "title20", "kind", "author", 10, "6.1c");
		
		nbBooks += 3;
		
		
		//6.2: Test with an existing title
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, new String("login"),new String("password"), new String("title"), "kind","author", 100, "6.2", "The title of the first book was accepted as title for a new book");
		
		//6.3: Test with an existing title
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn,new String("login"), new String("password"), new String("title"), "kind","author",100, "6.3", "The title of the last book was accepted as title for a new book");
		
		//6.4: Test with an existing title with different case
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, new String("login"), new String("password"),new String("TiTlE"),"kind", "author", 100, "6.4", "An already registered title, but with different case, was accepted as title for a new book");
		
		//6.5: Test with leading/trailing blanks
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn,new String("login"),new String("password"), new String(" title "),"kind", "author", 100, "6.5", "An already registered title, surrounded by leading/trailing blanks, was accepted as title for a new book");
		
		//6.6: Test with not existing login
		nbTests++;
		nbErrors += addItemBookNotMemberExceptionTest(sn, new String("login1"),new String("password"),new String("title1"), "kind","author", 100, "6.6", "The login not existing was accepted as login to add a new book");
		
		//6.7: Test with wrong password
		nbTests++;
		nbErrors += addItemBookNotMemberExceptionTest(sn,new String("login"),new String("false_password"),new String("title1"),"kind", "author", 100, "6.7", "A password not corresponding to login was accepted to add a new book");
		
		// check that 'sn' was not modified
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by addItemBook()");
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
			System.out.println("AddItemBook : " + tr);
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
