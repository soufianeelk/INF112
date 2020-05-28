package opinion;
import exceptions.*;

public class SocialNetworkPremium extends SocialNetwork implements ISocialNetworkPremium {

	@Override
	public float reviewItemFilm(String login, String password, String title,float mark, String comment) throws BadEntryException,NotMemberException, NotItemException {
	
		// Check Parameters content (if they aren't empty, if password contains higher than 4 characters, if mark is between 0 and 5...)
		if (login==null) throw new BadEntryException("The login is null.");
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); 
		if (password==null) throw new BadEntryException("The password is null.");
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty");
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters");
		if (title==null) throw new BadEntryException("The password is null.");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5");
		if (comment==null) throw new BadEntryException("The comment is null.");
		
		//Check Authentication and check that the film exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		if (this.searchFilmByTitle(title) == null) throw new NotItemException("The title doesn't exists");  //Throws a NotItemException if the title doesn't exist
		
		Film theFilm = searchFilmByTitle(title); 
		theFilm.addReview(thePotentialMember,comment, mark); //Adding a new review or editing an existing review. 
		return theFilm.getMeanReviews();

	}
	
	public void reviewOpinion(String login, String password, String title, String theItemReviewPublisher, String type, float mark, String comment) throws BadEntryException, NotMemberException,NotItemException  { 
		
		// Check parameters content (if they aren't empty, if password contains higher than 4 characters...) throws the BadEntryException if wrong
 		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 characters");
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (theItemReviewPublisher == null) throw new BadEntryException("The login of the item reviewer must be instanciated");
		if (theItemReviewPublisher.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login of the item reviewer must be instanciated with at least one non-space character");
		if (type.equalsIgnoreCase("film")==false && type.equalsIgnoreCase("book")==false)  throw new BadEntryException("Type must be a 'film' or a 'book'.");
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5");
		if (comment==null) throw new BadEntryException("The comment can't be none.");
		
		if (type.trim().equalsIgnoreCase("film")) {
			
			Film thePotentialFilm = searchFilmByTitle(title);
			if (thePotentialFilm==null) throw new NotItemException("The film was not found.");
			
			Member thePotentialMember=this.authenticateMember(login,password);
			if (thePotentialMember==null) throw new NotMemberException("The member was not found.");
			
			Member thePotentialPublisher=this.locateMember(theItemReviewPublisher);
			if (thePotentialPublisher==null) throw new NotMemberException("The publisher was not found.");

			Review thePotentialReview = thePotentialFilm.checkMemberExistingReview(thePotentialPublisher);
			if (thePotentialReview==null) throw new NotItemException("The review was not found.");
			
			thePotentialReview.addToReviewsList(thePotentialMember, new SimpleReview(thePotentialMember,mark,comment), thePotentialPublisher); //Adding or Editing a Review of a Review. 
			updateItemsMeanReviews(thePotentialPublisher, thePotentialPublisher.getKarma()); //Updating values of all items reviewed by the reviewer whom karma has changed. 
		}
		
		if (type.trim().equalsIgnoreCase("book"))  {
			
			Book thePotentialBook = searchBookByTitle(title);
			if (thePotentialBook==null) throw new NotItemException("The book was not found.");
			
			Member thePotentialMember=this.authenticateMember(login,password);
			if (thePotentialMember==null) throw new NotMemberException("The member was not found.");
			
			Member thePotentialPublisher=this.locateMember(theItemReviewPublisher);
			if (thePotentialPublisher==null) throw new NotMemberException("The publisher was not found.");
			
			Review thePotentialReview = thePotentialBook.checkMemberExistingReview(thePotentialPublisher);
			if (thePotentialReview==null) throw new NotItemException("The review was not found.");

			thePotentialReview.addToReviewsList(thePotentialMember, new SimpleReview(thePotentialMember,mark,comment), thePotentialPublisher); //Adding or Editing a Review of a Review. 

			updateItemsMeanReviews(thePotentialPublisher, thePotentialPublisher.getKarma()); //Updating values of all items reviewed by the reviewer whom karma has changed. 
		}
		}
	
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
			
/*			if (theMemberReview!=null) {
				theBook.updateMeanReview(theBook.meanReview());
			}
*/			
		}
	
	}
	
	public static void main(String args[]) {
		
		try {
			
			SocialNetworkPremium sn = new SocialNetworkPremium();
			sn.addMember("login", "password", "profile");
			sn.addMember("login2", "password", "profile");
			sn.addMember("login3", "password", "profile");

			
			sn.addItemFilm("login", "password", "title", "kind", "director", "scenarist", 120);
			sn.reviewItemFilm("login", "password", "title", (float) 4.3, "Commentaire de la review principale par login");
			sn.reviewItemFilm("login2", "password", "title", (float) 2.3, "Commentaire de la review principale par login2");
			sn.reviewItemFilm("login3", "password", "title", (float) 1.5, "Commentaire de la review principale par login3");

			sn.reviewOpinion("login2", "password", "title", "login", "film", (float) 0.1, "Tu racontes n'importe quoi!");		
			sn.reviewOpinion("login3", "password", "title", "login", "film", (float) 0.5, "J'avoue");
						
			System.out.println("Fini");

		}
		catch (Exception e) {
			
		}
	}
	

}
