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
	 * @version V2.0 - April 2018
	 */
	
	private static int consultItemBadEntryTest(SocialNetwork sn, String title,String testId, String errorMessage) {
		try {
			sn.consultItems(title); //Try to consult item by its title
			// Reaching this point means that no exception was thrown by
			// addMember()
			System.out.println("Err " + testId + " : " + errorMessage); // display
																		// the
																		// error
																		// message
			return 1; // and return the "error" value
		}
		catch (BadEntryException e) { // BadEntry exception was thrown by
									// consultItem() : this is a good start!
									// Let's now check if 'sn' was not
			
			if (sn.consultItems(title)!=null) {
				System.out.println("Err " + testId
						+ " : No item was found but an non-null result was returned"); // Error message displayed
				return 1; // return error code
			}
																								
			return 0; // return "error" value
	}
	
		catch (Exception e) { // An exception was thrown by consultItem(), but
							// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "
			+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
}

}
	
	private static int consultItemOKTest(SocialNetwork sn, String title,String testId) {
		try {
			LinkedList<String> testConsultItems = sn.consultItems(title); 
			
			if (testConsultItems!=null && testConsultItems.size()!=0) return 0; //The item list was														
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
		
		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests
		
		try {
		sn.addMember("user", "password", "profile");
		sn.addItemBook("user", "password", "title", "kind", "author", 100);
		sn.addItemFilm("user", "password", "title", "kind", "director", "scenarist",120);
		}
		catch (Exception e) {
			
		}
		
		
		// <=> test n�1 : BadEntry
		
		nbTests++;
		nbErrors+=consultItemBadEntryTest(sn,null,"1.1", "consultItem() doesn't reject non instanciated titles.");
		
		nbTests++;
		nbErrors+=consultItemBadEntryTest(sn,"","1.2", "consultItem() doesn't reject an empty title.");
		
		// <=> test n�2 : Consulting an Item
		nbTests++;
		nbErrors+=consultItemOKTest(sn,null,"1.3");
		
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
	


