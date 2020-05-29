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
	 * @return mean of the marks for this book
	 */	
	public void reviewOpinion(String login, String password, String title, String theItemReviewPublisher, String type, float mark, String comment) throws BadEntryException, NotMemberException,NotItemException, NotReviewException  { 
		
		// Check parameters content (if they aren't empty, if password contains higher than 4 characters...) throws the BadEntryException if wrong
 		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 characters");
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (theItemReviewPublisher == null) throw new BadEntryException("The login of the item reviewer must be instanciated");
		if (theItemReviewPublisher.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login of the item reviewer must be instantiated with at least one non-space character");
		if (type.equalsIgnoreCase("film")==false && type.equalsIgnoreCase("book")==false)  throw new BadEntryException("Type must be a 'film' or a 'book'.");
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5");
		if (comment==null) throw new BadEntryException("The comment can't be none.");
		
		//Checking if the item is a film
		if (type.trim().equalsIgnoreCase("film")) {
			
			Film thePotentialFilm = searchFilmByTitle(title);
			if (thePotentialFilm==null) throw new NotItemException("The film was not found.");
			
			Member thePotentialMember=this.authenticateMember(login,password);
			if (thePotentialMember==null) throw new NotMemberException("The member was not found.");
			
			Member thePotentialPublisher=this.locateMember(theItemReviewPublisher);
			if (thePotentialPublisher==null) throw new NotMemberException("The publisher was not found.");

			Review thePotentialReview = thePotentialFilm.checkMemberExistingReview(thePotentialPublisher);
			if (thePotentialReview==null) throw new NotReviewException("The review was not found.");
			
			//Adding the new review of the review in the attribute reviewsList 
			thePotentialReview.addToReviewsList(thePotentialMember, new SimpleReview(thePotentialMember,mark,comment), thePotentialPublisher); //Adding or Editing a Review of a Review. 
			
			//Updating all the item's mean review because the karma of the item reviewer changed
			updateItemsMeanReviews(thePotentialPublisher, thePotentialPublisher.getKarma()); 
		}
		
		//Checking if the item is a book
		if (type.trim().equalsIgnoreCase("book"))  {
			
			Book thePotentialBook = searchBookByTitle(title);
			if (thePotentialBook==null) throw new NotItemException("The book was not found.");
			
			Member thePotentialMember=this.authenticateMember(login,password);
			if (thePotentialMember==null) throw new NotMemberException("The member was not found.");
			
			Member thePotentialPublisher=this.locateMember(theItemReviewPublisher);
			if (thePotentialPublisher==null) throw new NotMemberException("The publisher was not found.");
			
			Review thePotentialReview = thePotentialBook.checkMemberExistingReview(thePotentialPublisher);
			if (thePotentialReview==null) throw new NotReviewException("The review was not found.");
		
			//Adding the new review of the review in the attribute reviewsList 
			thePotentialReview.addToReviewsList(thePotentialMember, new SimpleReview(thePotentialMember,mark,comment), thePotentialPublisher); //Adding or Editing a Review of a Review. 
			
			//Updating all the item's mean review because the karma of the item reviewer changed
			updateItemsMeanReviews(thePotentialPublisher, thePotentialPublisher.getKarma()); //Updating values of all items reviewed by the reviewer whom karma has changed. 
		}
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
	private void updateItemsMeanReviews(Member thePublisher, float thePublisherKarma) {
		
		Review theMemberReview;
		
		for (Film theFilm: filmsList) {
			
			theMemberReview = theFilm.checkMemberExistingReview(thePublisher);
			
			if (theMemberReview!=null) {
				theFilm.updateMeanReview(theFilm.meanReview());
			}
			
		}
		
		for (Book theBook: booksList) {
			
			theMemberReview = theBook.checkMemberExistingReview(thePublisher);
			
			if (theMemberReview!=null) {
				theBook.updateMeanReview(theBook.meanReview());
			}
			
		}
	
	}
	
	/**
	 * Locating in the <i>SocialNetworkPremium</i> a member thanks to its login
	 * 
	 * @param login
	 *          - login of the member to search.
	 * 
	 */
	
	public Member locateMember(String login) throws NotMemberException{
	       
		if (login==null) return null;

        for (int i=0;i<membersList.size();i++) {
        	if (membersList.get(i).compareLogin(login)) return membersList.get(i);
        }
        return null;
	}
		
}
