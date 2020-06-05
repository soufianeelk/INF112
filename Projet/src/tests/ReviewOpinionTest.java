package tests;

import opinion.*;
import exceptions.*;

/**
 * Tests for the SocialNetwork.<i>reviewOpinion()</i> method.
 * 
 * @author S. EL KALDAOUI, H. MEZAZIGH
 * @version V2.0 - April 2020
 */
	
public class ReviewOpinionTest {


	/**
	 * Check that trying to add a new review to a review raises a
	 * BadEntry exception and does not change content of the
	 * <i>SocialNetworkPremium</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>SocialNetworkPremium</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - title's name
	 *    
	 * @param theItemReviewer 
	 * 			  -The Item reviewer's login 
	 * @param type
	 * 			  - type of the item.  
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
	
	private static int reviewOpinionBadEntryTest(ISocialNetworkPremium sn,String login, String password, String title, String theItemReviewer, String type, float mark, String comment,String testId,String errorMessage) {
		
		float memberKarma=0;	
		
		try {
			memberKarma=sn.reviewOpinion(login, password, title, theItemReviewer, type, mark, comment);
			// Reaching this point means that no exception was thrown by reviewOpinion()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		
		catch (BadEntryException e) {
			
			if(memberKarma!=0) {
				System.out.println("Err " + testId + " : the karma of the Item reviewer has changed");
				return 1;
			}
			return 0;
			
		}
		
		catch (Exception e) {
			// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
}

	/**
	 * Check that trying to add a new review to a review raises a
	 * NotMember exception and does not change content of the
	 * <i>SocialNetworkPremium</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>SocialNetworkPremium</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - title's name
	 *    
	 * @param theItemReviewer 
	 * 			  - The Item Reviewer's login 
	 * @param type
	 * 			  - type of the item.  
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
	
	private static int reviewOpinionNotMemberExceptionTest(ISocialNetworkPremium sn,String login, String password, String title, String theItemReviewer, String type, float mark, String comment,String testId,String errorMessage) {
		
		float memberKarma=0;
		try {
			memberKarma=sn.reviewOpinion(login, password, title, theItemReviewer, type, mark, comment);
			// Reaching this point means that no exception was thrown by reviewOpinion()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotMemberException e) {
			
			if(memberKarma!=0) {
				System.out.println("Err " + testId + " : the karma of the Item reviewer has changed");
				return 1;
			}
			return 0;
		}
		
		catch(Exception e) {
			// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}

	}
	
	/**
	 * Check that trying to add a new review to a review raises a
	 * NotItem exception and does not change content of the
	 * <i>SocialNetworkPremium</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>SocialNetworkPremium</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - title's name
	 *    
	 * @param theItemReviewer 
	 * 			  - The item reviewer's login 
	 * @param type
	 * 			  - type of the item.  
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
	private static int reviewOpinionNotItemExceptionTest(ISocialNetworkPremium sn,String login, String password, String title, String theItemReviewer, String type, float mark, String comment,String testId,String errorMessage) {
	
		float memberKarma=0;	
		
		try {
			memberKarma=sn.reviewOpinion(login, password, title, theItemReviewer, type, mark, comment);
			// Reaching this point means that no exception was thrown by reviewOpinion()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotItemException e) {
			
			if(memberKarma!=0) {
				System.out.println("Err " + testId + " : the karma of the Item reviewer has changed");
				return 1;
			}		
			return 0;
		}
		
		catch(Exception e) {
			// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}

	}
	/**
	 * Check that trying to add a new review to a review raises a
	 * NotReview exception and does not change content of the
	 * <i>SocialNetworkPremium</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>SocialNetworkPremium</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - title's name
	 *    
	 * @param theItemReviewer 
	 * 			  - The item reviewer's login 
	 * @param type
	 * 			  - type of the item.  
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
	private static int reviewOpinionNotReviewExceptionTest(ISocialNetworkPremium sn,String login, String password, String title, String theItemReviewer, String type, float mark, String comment,String testId,String errorMessage) {
		
		float memberKarma=0;
		try {
			memberKarma=sn.reviewOpinion(login, password, title, theItemReviewer, type, mark, comment);
			// Reaching this point means that no exception was thrown by reviewOpinion()
			System.out.println("Err " + testId + " : " + errorMessage); // display the error message
			return 1;
		}
		catch (NotReviewException e) {
			if(memberKarma!=0) {
				System.out.println("Err " + testId + " : the karma of the Item reviewer has changed");
				return 1;
			}	
			return 0;
		}
		
		catch(Exception e) {
			// it was not the expected exception BadEntry
			System.out.println("Err " + testId + " : unexpected exception. "+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1; // return error value
		}
	
	}
	
	/**
	 * Check that this new review can be added to the member's item review. If OK, the method just returns 0
	 * : the new review is added.</br> If not OK, an error message is displayed
	 * and 1 is returned ; the new review was not correctly added.
	 * 
	 * @param sn
	 *            - the <i>SocialNetworkPremium</i>
	 * @param login
	 *            - member's login
	 * @param password
	 *            - member's password
	 * @param title
	 *            - title's name
	 *    
	 * @param theItemReviewer 
	 * 			  - The Item Reviewer's login 
	 * @param type
	 * 			  - type of the item.  
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
	private static int reviewOpinionOKTest(SocialNetworkPremium sn,String login, String password, String title, String theItemReviewer, String type, float mark, String comment,String testId) {
		
		if (type.equals("film")) {
			try {
				float karmaForTheMember=0;
				float nbReviewOfOpinion = sn.searchFilmByTitle("title").checkMemberExistingReview(sn.locateMember(theItemReviewer)).getNbReviewsList();
				
				karmaForTheMember=sn.reviewOpinion(login, password, title, theItemReviewer, type, mark, comment);
				
				if (sn.searchFilmByTitle("title").checkMemberExistingReview(sn.locateMember(theItemReviewer)).getNbReviewsList()!=nbReviewOfOpinion+1 || karmaForTheMember==0) {
					System.out.println("Err " + testId + " : the addition of the review failed.");
					return 1;
				}
				else {
					return 0;
				}
			}
			
			catch (Exception e) {
				System.out.println("Err " + testId + " : unexpected exception " + e);
				e.printStackTrace();
				return 1;
			}
		}
		
		if (type.equals("book")) {
			try {
				float karmaForTheMember=0;
				float nbReviewOfOpinion = sn.searchBookByTitle("title").checkMemberExistingReview(sn.locateMember(theItemReviewer)).getNbReviewsList();
				
				karmaForTheMember=sn.reviewOpinion(login, password, title, theItemReviewer, type, mark, comment);
				
				if (sn.searchFilmByTitle("title").checkMemberExistingReview(sn.locateMember(theItemReviewer)).getNbReviewsList()!=nbReviewOfOpinion+1 || karmaForTheMember==0) {
					System.out.println("Err " + testId + " : the addition of the review failed.");
					return 1;
				}
				else {
					return 0;
				}
			}
			
			catch (Exception e) {
				System.out.println("Err " + testId + " : unexpected exception " + e);
				e.printStackTrace();
				return 1;
			}
		}
		
		return 1;
	}

	public static TestReport test() throws NotMemberException{

		SocialNetworkPremium sn = new SocialNetworkPremium();

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests
		
		// Creating a user and a book in order to realize tests
		try {
			sn.addMember("login1","password", "profile");
			sn.addMember("login2","password","profile");
			
			sn.addItemFilm("login1", "password", "title", "kind", "director", "scenarist", 120);
			sn.reviewItemFilm("login1", "password", "title", (float) 4, "Comment about the film. ");
			
			sn.addItemBook("login1","password", "title","kind", "author", 120);
			sn.reviewItemBook("login1", "password", "title", (float) 4, "Comment about the book.");
			

		}
		
		catch (Exception e) {
		
		}
		
		Member login1 = sn.locateMember("login1");
		if(login1==null) throw new NotMemberException("User not found");

		System.out.println("Testing reviewOpinion()");
		//test N°1 
	
		// 1.1a : Test with non instantiated login [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,null, new String("password"), new String("title"), new String("login1"), "film", (float) 4,new String("Comment of login 2"),"1.1a","reviewOpinion() doesn't reject null login.");
		
		// 1.1b : Test with non instantiated login [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,null, new String("password"),new String("title"), new String("login1"), "book", (float) 4, new String("Comment of login 2"), "1.1b","reviewOpinion() doesn't reject null login.");
		
		//1.2a : Test with login which don't contains at least one character other than space [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String(""), new String("password"),new String("title"), new String("login1"), "film", (float) 4, new String("Comment of login 2"), "1.2a","reviewOpinion() doesn't reject logins that don't contain at least one character other than space.");
		
		//1.2b : Test with login which don't contains at least one character other than space [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String(""), new String("password"), new String("title"), new String("login1"), "book", (float) 4, new String("Comment of login 2"), "1.2b","reviewOpinion() doesn't reject logins that don't contain at least one character other than space.");
		
		//1.3a: Test with non instantiated password [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), null, new String("title"), new String("login1"), "film", (float) 4, new String("Comment of login 2"), "1.3a","reviewOpinion() doesn't reject null password.");
		
		//1.3b: Test with non instantiated password [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), null, new String("title"), new String("login1"), "book", (float) 4, new String("Comment of login 2"), "1.3b","reviewOpinion() doesn't reject null password.");
		
		//1.4a: Test with password which contains less than 4 characters [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("pas"), new String("title"), new String("login1"), "film", (float) 4, new String("Comment of login 2"), "1.4a","reviewOpinion() doesn't reject password that contains less than 4 characters.");
		
		//1.4b: Test with password which contains less than 4 characters [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("pas"), new String("title"), new String("login1"), "book", (float) 4, new String("Comment of login 2"), "1.4b","reviewOpinion() doesn't reject password that contains less than 4 characters.");
				
		//1.5a: Test with a non instantiated title [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"), null, new String("login1"), "film", (float) 4, new String("Comment of login 2"), "1.5a","reviewOpinion() doesn't reject non instanciated titles.");
		
		//1.5b: Test with a non instantiated title [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"), null,new String("login1"), "book", (float) 4, new String("Comment of login 2"), "1.5b","reviewOpinion() doesn't reject non instanciated titles.");
		
		//1.6a: Test with a title which contains less than one non-space character [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("password"), new String(""), new String("login1"), "book", (float) 4, "Comment of login 2", "1.6a","reviewOpinion() doesn't reject non instanciated titles.");
		
		//1.6b: Test with a title which contains less than one non-space character [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("password"),new String(""), new String("login1"),new String("book"), (float) 4, new String("Comment of login 2"), "1.6b","reviewOpinion() doesn't reject non instanciated titles.");
	
		// 1.7a : Test with non instantiated review item publisher login [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("password"), new String("title"), null, "film", (float) 4, new String("Comment of login 2"), "1.7a","reviewOpinion() doesn't reject null login for item reviewer.");
		
		// 1.7b : Test with non instantiated review item publisher login [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"), new String("title"), null, "book", (float) 4,new String("Comment of login 2"), "1.7b","reviewOpinion() doesn't reject null login for item reviewer.");
		
		//1.8a : Test with login which don't contains at least one character other than space [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"),new String("title"),new String(""), "film", (float) 4, new String("Comment of login 2"), "1.8a","reviewOpinion() doesn't reject logins that don't contain at least one character other than space for item reviewer.");
		
		//1.8b : Test with login which don't contains at least one character other than space [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"),new String("title"),new String(""), "book", (float) 4,new String("Comment of login 2"), "1.8b","reviewOpinion() doesn't reject logins that don't contain at least one character other than space for item reviewer.");
		
		//1.9a : Test with negative mark [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("password"),new String("title"), new String("login1"), "film", (float) -1, new String("Comment of login 2"), "1.9a","reviewOpinion() doesn't reject negative marks.");
		
		//1.9b : Test with negative mark [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"), new String("password"), new String("title"), new String("login1"), "book", (float) -1, new String("Comment of login 2"), "1.9b","reviewOpinion() doesn't reject negative marks.");
		
		//1.91a: Test with a non instantiated comment [Film]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"),new String("title"),new String("login1"), "film", (float) 4, null, "1.91a","reviewOpinion() doesn't non instantiated comments.");
		
		//1.91b: Test with a non instantiated comment [Book]
		nbTests++;
		nbErrors+=reviewOpinionBadEntryTest(sn,new String("login2"),new String("password"),new String("title"),new String("login1"), "book", (float) 4, null, "1.91b","reviewOpinion() doesn't non instantiated comments.");
		
		//test n°2 : NotMemberException tests
		
		//2.1a: Test with a fake user [Film]
		nbTests++;
		nbErrors+=reviewOpinionNotMemberExceptionTest(sn,new String("false_user"),new String("password"), new String("title"), new String("login1"), "film", (float) 4, new String("Comment of login 2"), "2.1a","reviewOpinion() doesn't reject non registered user.");
		
		//2.1b: Test with a fake user [Book]
		nbTests++;
		nbErrors+=reviewOpinionNotMemberExceptionTest(sn,new String("false_user"),new String("password"),new String("title"),new String("login1"), "book", (float) 4, new String("Comment of login 2"), "2.1b","reviewOpinion() doesn't reject non registered user.");
		
		//2.2a: Test with a false password [Film]
		nbTests++;
		nbErrors+=reviewOpinionNotMemberExceptionTest(sn,new String("login2"),new String("false_password"),new String("title"),new String("login1"),"film", (float) 4,new String("Comment of login 2"), "2.2a","reviewOpinion() doesn't reject users with unmatching password.");
		
		//2.2b: Test with a false password [Film]
		nbTests++;
		nbErrors+=reviewOpinionNotMemberExceptionTest(sn,new String("login2"),new String("false_password"), new String("title"),new String("login1"), "book", (float) 4, new String("Comment of login 2"), "2.2b","reviewOpinion() doesn't reject users with unmatching password.");
		
		//2.3a: Test with a fake item review publisher [Film]
		nbTests++;
		nbErrors+=reviewOpinionNotMemberExceptionTest(sn,new String("login2"), new String("password"),new String("title"),new String("false_user"), "film", (float) 4, new String("Comment of login 2"), "2.3a","reviewOpinion() doesn't reject non registered user for the field Item Review Publisher.");
		
		//2.3b: Test with a fake user [Book]
		nbTests++;
		nbErrors+=reviewOpinionNotMemberExceptionTest(sn,new String("login2"),new String("password"),new String("title"),new String("false_user"), "book", (float) 4, new String("Comment of login 2"), "2.3b","reviewOpinion() doesn't reject non registered user for the field Item Review Publisher.");
		
		//test n°3 : NotItemException tests 		
		
		//3.1a : Test for a non registered item [Film]
		nbTests++;
		nbErrors+=reviewOpinionNotItemExceptionTest(sn,new String("login2"),new String("password"), new String("false_title"), new String("login1"), "film", (float) 4, new String("Comment of login 2"), "3.1a","reviewOpinion() doesn't reject adding review on a review for an unmatching film.");
		
		//3.1b : Test for a non registered item [Book]
		nbTests++;
		nbErrors+=reviewOpinionNotItemExceptionTest(sn,new String("login2"), new String("password"),new String("false_title"),new String("login1"), "book", (float) 4, new String("Comment of login 2"), "3.1b","reviewOpinion() doesn't reject adding review on a review for an unmatching film.");
		
		//3.2a : Test for a non existing item review [Film]
		nbTests++;
		nbErrors+=reviewOpinionNotReviewExceptionTest(sn,new String("login1"),new String("password"),new String("title"),new String("login2"), "film", (float) 4, new String("Comment of login 2"), "3.2a","reviewOpinion() doesn't detect that a review for this member doesn't exists.");

		//3.2b : Test for a non existing item review [Book]
		nbTests++;
		nbErrors+=reviewOpinionNotReviewExceptionTest(sn,new String("login1"),new String("password"), new String("title"),new String("login2"), "book", (float) 4,new String("Comment of login 2"), "3.2b","reviewOpinion() doesn't detect that a review for this member doesn't exists.");

		//OK Test for a Film
		nbTests++;
		nbErrors+=reviewOpinionOKTest(sn,new String("login2"), new String("password"), new String("title"), new String("login1"), "film", (float) 4, new String("Comment of login 2"),"4.1a");
		
		//OK Test for a Book
		nbTests++;
		nbErrors+=reviewOpinionOKTest(sn,new String("login2"),new String("password"), new String("title"), new String("login1"), "book", (float) 4, new String("Comment of login 2"), "4.1b");
		
		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("ReviewOpinionTest : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in addItemFilmTest test code - Can't return valuable test results");
			return null;
			}
		
	}
	
	
	
	
	public static void main(String args[]) {
	try {
		test();
	}
	catch (Exception e) {
	}
}
}
