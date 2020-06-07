package opinion;
import exceptions.*;

public class SocialNetworkPremium extends SocialNetwork implements ISocialNetworkPremium {

	/**
	 * Add in the <i>SocialNetworkPremium</i> a new review for a review on behalf of a
	 * specific member.</br> If this member has already given a review for this
	 * same book before, the new review replaces the previous one.
	 * 
	 * @param login
	 *            login of the member adding the review
	 * @param password
	 *            password of the member adding the review
	 * @param title
	 *            the reviewed item's title
	 * @param theItemReviewPublisher
	 *            the item review publisher's login.
	 * @param type 
	 * 			  type of the item (film or book)           
	 *
	 * @param mark 
	 *            the mark given by the member for this review
	 * @param comment
	 *            the comment given by the member for this review
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than
	 *             four characters (not taking into account leading or trailing
	 *             blanks)</li>
	 *             <li>if title is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if login of the item reviewer is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if mark is not greater or equals to 0.0 and lesser or
	 *             equals to 5.0.</li>
	 *             <li>if comment is not instantiated</li>
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 * 	           if login of the member of the does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 *             
	 *             if login of the item reviewer does not match with the login of a registered member
	 *             in <i>SocialNetwork</i>. 
	 *             
	 * @throws NotItemException
	 *             if title is not registered as a book's title in the
	 *             <i>SocialNetwork</i>
	 * 
	 * @return karma of the item publisher if not null. 
	 */
	public float reviewOpinion(String login, String password, String title, String theItemReviewer, String type, float mark, String comment) throws BadEntryException, NotMemberException,NotItemException, NotReviewException  { 
		
		// Check parameters content (if they aren't empty, if password contains higher than 4 characters...) throws the BadEntryException if wrong
		checkCredentialEntries(login,password);
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (login.equals(theItemReviewer)) throw new NotReviewException("The login to review can't be the same as yours.");
		if (theItemReviewer == null) throw new BadEntryException("The login of the item reviewer must be instanciated");
		if (theItemReviewer.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login of the item reviewer must be instantiated with at least one non-space character");
		if (type.equalsIgnoreCase("film")==false && type.equalsIgnoreCase("book")==false)  throw new BadEntryException("Type must be a 'film' or a 'book'.");
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5");
		if (comment==null) throw new BadEntryException("The comment can't be none.");

		Member thePotentialItemReviewer = null;
		
		Member thePotentialMember=this.authenticateMember(login,password);
		if (thePotentialMember==null) throw new NotMemberException("The member was not found.");
		
		//Checking if the item is a film
		if (type.trim().equalsIgnoreCase("film")) {
			
			Film thePotentialFilm = searchFilmByTitle(title);
			if (thePotentialFilm==null) throw new NotItemException("The film was not found.");
			
			thePotentialItemReviewer=this.locateMember(theItemReviewer);
			if (thePotentialItemReviewer==null) throw new NotMemberException("The publisher was not found.");

			Review thePotentialReview = thePotentialFilm.checkMemberExistingReview(thePotentialItemReviewer);
			if (thePotentialReview==null) throw new NotReviewException("The review was not found.");
			
			//Adding the new review of the review in the attribute reviewsList 
			thePotentialReview.addToReviewsList(thePotentialMember, thePotentialItemReviewer,mark,comment); //Adding or Editing a Review of a Review. 
			
			//Updating all the item's mean review because the karma of the item reviewer changed
			updateItemsMeanReviews(thePotentialItemReviewer); 
		}
		
		//Checking if the item is a book
		if (type.trim().equalsIgnoreCase("book"))  {
			
			Book thePotentialBook = searchBookByTitle(title);
			if (thePotentialBook==null) throw new NotItemException("The book was not found.");
			
			thePotentialItemReviewer=this.locateMember(theItemReviewer);
			if (thePotentialItemReviewer==null) throw new NotMemberException("The publisher was not found.");
			
			Review thePotentialReview = thePotentialBook.checkMemberExistingReview(thePotentialItemReviewer);
			if (thePotentialReview==null) throw new NotReviewException("The review was not found.");
		
			//Adding the new review of the review in the attribute reviewsList 
			thePotentialReview.addToReviewsList(thePotentialMember, thePotentialItemReviewer, mark, comment); //Adding or Editing a Review of a Review. 
			
			//Updating all the item's mean review because the karma of the item reviewer changed
			updateItemsMeanReviews(thePotentialItemReviewer); //Updating values of all items reviewed by the reviewer whom karma has changed. 
		}
		return thePotentialItemReviewer.getKarma();
		}
	
	/**
	 * Updating in the <i>SocialNetworkPremium</i> all the items means (films or book) reviewed by
	 * specific member.</br>
	 * 
	 * @param thePublisher
	 *            Member object of the item reviewer.
	 *            
	 * @param thePublisherKarma
	 *            Item reviewer's karma.
	 * 
	 */
	private void updateItemsMeanReviews(Member theItemReviewer) {
		
		Review theMemberReview;
		
		for (Film theFilm: filmsList) {
			
			theMemberReview = theFilm.checkMemberExistingReview(theItemReviewer);
			
			if (theMemberReview!=null) {
				theFilm.updateMeanReview();
			}
			
		}
		
		for (Book theBook: booksList) {
			
			theMemberReview = theBook.checkMemberExistingReview(theItemReviewer);
			
			if (theMemberReview!=null) {
				theBook.updateMeanReview();
			}
			
		}
	
	}
	
	/**
	 * Locating in the <i>SocialNetworkPremium</i> a member thanks to its login
	 * 
	 * @param login
	 *          - login of the member to search.
	 *          
	 * @return  the member object of the user found, else null.
	 */
	public Member locateMember(String login) throws NotMemberException{
	       
		if (login==null) return null;

        for (int i=0;i<membersList.size();i++) {
        	if (membersList.get(i).compareLogin(login)) return membersList.get(i);
        }
        return null;
	}
	
	public static void main(String args[]) {

        try {
        SocialNetworkPremium sn = new SocialNetworkPremium();
        sn.addMember("login", "password", "profile");
        sn.addMember("login1", "password", "profile");
        sn.addMember("login2", "password", "profile");
        sn.addItemBook("login", "password", "title", "kind", "author", 120);
        sn.reviewItemBook("login2", "password", "title", (float) 4, "comment");
        //Mean = 4
        sn.reviewItemBook("login1", "password", "title", (float) 2, "comment");
        //Mean = 3
        sn.reviewOpinion("login1", "password", "title", "login2", "book", (float) 0.1, "comment");
        //Karma login2 = 0.55
        //Mean = (0.554 + 21)/(0.55+1) = 2.71
        sn.reviewOpinion("login2", "password", "title", "login1", "book", (float) 2, "comment");
        //karma login1 = 1.5
        //Mean = (0.554 + 21.5)/(0.55+1.5) = 2.53
        sn.reviewOpinion("login", "password", "title", "login2", "book", (float)4, "comment");
        //karma login2 = 1.7
        //Mean = (1.74 + 21.5)/(1.7+1.5) = 3.0625
        System.out.println(sn.searchBookByTitle("title").getMeanReviews());
        }

        catch (Exception e) {
        }
    }
	
}
