package tests;

import exceptions.BadEntryException;
import exceptions.NotTestReportException;

import java.util.LinkedList;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

public class ConsultItemsTest {
	
	/**
	 * Tests for the SocialNetwork.<i>consultItems()</i> method.
	 * 
	 * @author S. EL KALDAOUI, H. MEZAZIGH
	 * @version V2.0 - May 2020
	 */
	
	/**
	 * Check that consulting an item (title) raises a BadEntry exception
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 * 
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int consultItemBadEntryTest(SocialNetwork sn, String title,String testId, String errorMessage) {
		
		LinkedList <String> PotentialListOfItem=new LinkedList();
		
		try {
			
			PotentialListOfItem= sn.consultItems(title);
			
			// Reaching this point means that no exception was thrown by consultItem()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error												// message
			return 1; // and return the "error" value
		}
		catch (BadEntryException e) { // BadEntry exception was thrown by consultItem() : this is a good start!
			
			if(PotentialListOfItem.size()!=0) {
				System.out.println("Err "+ testId+ " : BadEntry was thrown but a non null list of item was returned");	//If yes print error message
				return 1;
			}
			return 0; // return "error" value
			}
																								
		catch(Exception e) { // An exception was thrown by consultItem(), but
							// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "
			+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value


}
}

	/**
	 * Check that consulting an existing item (title) return the list of item
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 * 
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int consultItemOKTest(SocialNetwork sn, String title,String testId) {
		
		LinkedList <String> PotentialListOfItem=new LinkedList();
		
		try {
			PotentialListOfItem = sn.consultItems(title); 
			
			if (PotentialListOfItem!=null && PotentialListOfItem.size()!=0) return 0; //The item list was returned correctly with at least one item.												
			return 1; // return the "error" value
		}
		catch (Exception e) {
			System.out
			.println("Err " + testId + " : unexpected exception " + e); // Error
																		// message
																		// displayed
				e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error code
		}
	}

	public static TestReport test(){
		
		SocialNetwork sn = new SocialNetwork();
		
		int nbBooks = sn.nbBooks(); // total number of performed tests
		int nbFilms = sn.nbFilms();  // total number of failed tests
		
		int nbTests = 0;
		int nbErrors = 0;
		
		System.out.println("Testing consultItems()");
		
		try {
		//Adding a member
		sn.addMember(new String("user"),new String("password"), "profile");
		
		//Adding a book to the social network and reviewing it. 
		sn.addItemBook(new String("user"),new String("password"),new String("title"), "kind", "author", 100);
		nbBooks++;
		sn.reviewItemBook(new String("user"),new String("password"), new String("title"), (float) 5.0, new String("comment for the book"));
		
		//Adding a film to the social network and reviewing it. 
		sn.addItemFilm(new String("user"), new String("password"),new String("title"), "kind", "director", "scenarist",120);
		nbFilms++;
		sn.reviewItemFilm(new String("user"), new String("password"),new String("title"), (float) 4.0, new String("comment for the film"));
		}
		catch (Exception e) {
			
		}
		
		
		// <=> test n°1 : BadEntry Test
		
		nbTests++;
		nbErrors+=consultItemBadEntryTest(sn,null,"1.1", "consultItem() doesn't reject non instanciated titles.");
		
		nbTests++;
		nbErrors+=consultItemBadEntryTest(sn,"","1.2", "consultItem() doesn't reject an empty title.");
		
		// <=> test n°2 : Consulting an Item 
		nbTests++;
		nbErrors+=consultItemOKTest(sn,"title","1.3");
		
		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("consultItem() : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in consultItem() test code - Can't return valuable test results");
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
	


