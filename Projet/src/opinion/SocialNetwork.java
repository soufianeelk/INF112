//V13

package opinion;

import java.util.LinkedList;

import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

/**
 * Skeleton for the SocialNetwork
 * 
 */
public class SocialNetwork implements ISocialNetwork {
	
	protected LinkedList<Member> membersList = new LinkedList<Member>();
	protected LinkedList<Film> filmsList = new LinkedList<Film>();
	protected LinkedList<Book> booksList = new LinkedList<Book>();


	@Override
	public int nbMembers() {
		return membersList.size();
	}

	@Override
	public int nbFilms() {
		return filmsList.size();
	}

	@Override
	public int nbBooks() {
		return booksList.size();
	}
	
	@Override
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		
		// Check parameters content (if they aren't empty, if password contains higher than 4 characters...) throws the BadEntryException if wrong
		checkCredentialEntries(login,password);
		if (profile == null) throw new BadEntryException("The profile must be instanciated");
		
		// Check if the login is available
		for (int i=0; i < membersList.size(); i++) {
			if (membersList.get(i).compareLogin(login)) {
				throw new MemberAlreadyExistsException(); //Throws the MemberAlreadyExistsException if the login isn't available
			}
		}
		
		// Add a new member in the membersList after checking all is ok
		membersList.add(new Member(login, password, profile));
	}

	@Override
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scenarist, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		

		// Check parameters content (if they aren't empty, if password contains higher than 4 characters, if duration is positive...) throws the BadEntryException if wrong
		checkCredentialEntries(login,password);
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (kind == null) throw new BadEntryException("The kind must be instanciated");
		if (director == null) throw new BadEntryException("The director must be instanciated");
		if (scenarist == null) throw new BadEntryException("The scenarist must be instanciated");
		if (duration < 0) throw new BadEntryException("The duration must be positive");
		
		// Check Authentication and check that the film doesn't already exist
		Member thePotentialMember=this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login");	//Throws NotMemberException if login provided is unknown
		if (this.searchFilmByTitle(title) == null) filmsList.add(new Film(thePotentialMember,title, kind, director, scenarist, duration));	//Add a new film in the filmsList after checking all is ok
		else throw new ItemFilmAlreadyExistsException(); //Throw ItemFilmAlreadyExistsException if the film already exists
	
	}

	@Override
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {
		
		//Check parameters content (if they aren't empty, if password contains higher than 4 characters, if duration is positive...)
		checkCredentialEntries(login,password);
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (kind == null) throw new BadEntryException("The kind must be instanciated");
		if (author == null) throw new BadEntryException("The author must be instanciated");
		if (nbPages < 0) throw new BadEntryException("The number of pages must be positive");
		
		//Check if the book already exists in the list 
		if (this.searchBookByTitle(title)!=null) throw new ItemBookAlreadyExistsException();
		
		//Check Authentication 
		Member thePotentialMember=this.authenticateMember(login, password);
		if (thePotentialMember== null) throw new NotMemberException("Unknown login");
		if (this.searchBookByTitle(title) == null) booksList.add(new Book(thePotentialMember,title, kind, author,nbPages));
		else throw new ItemBookAlreadyExistsException();
		


	}

	@Override
	public float reviewItemFilm(String login, String password, String title,float mark, String comment) throws BadEntryException,NotMemberException, NotItemException {
	
		// Check Parameters content (if they aren't empty, if password contains higher than 4 characters, if mark is between 0 and 5...)
		checkCredentialEntries(login,password);
		if (title==null) throw new BadEntryException("The password is null.");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5");
		if (comment==null) throw new BadEntryException("The comment is null.");
		
		//Check Authentication and check that the film exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		if (this.searchFilmByTitle(title) == null) throw new NotItemException("The title doesn't exists");  //Throws a NotItemException if the title doesn't exist
		
		Film theFilm = searchFilmByTitle(title); 
		return theFilm.addReview(thePotentialMember,comment, mark); //Adding a new review or editing an existing review. 

	}
		
	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		
		// Check Parameters content (if they aren't empty, if password contains higher than 4 characters, if mark is between 0 and 5...)
		checkCredentialEntries(login,password);
		if (title==null) throw new BadEntryException("The password is null."); 
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); 
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5"); 
		if (comment==null) throw new BadEntryException("The comment is null.");
		
		//Check Authentication and check that the film exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		if (this.searchBookByTitle(title) == null) throw new NotItemException("The title doesn't exists");  //Throws a NotItemException if the title doesn't exist
		
		
		
		Book theBook = searchBookByTitle(title);
		theBook.addReview(thePotentialMember,comment, mark); //Adding or editing a review 
		return searchBookByTitle(title).getMeanReviews();
		
	}

	@Override
	public LinkedList<String> consultItems(String title) throws BadEntryException {
		
		if (title == null) throw new BadEntryException("The title must be instantiated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		Film thePotentialFilm=searchFilmByTitle(title); //Researching a film
		Book thePotentialBook=searchBookByTitle(title); //Researching a book
		
		
		if (thePotentialFilm!=null || thePotentialBook!=null) { 	//Checking if one item (book or film) is found
			LinkedList<String> ItemList = new LinkedList<String>();
			if (thePotentialFilm!=null) ItemList.add("Film: "+thePotentialFilm.getTitle()+" / Score: "+thePotentialFilm.getMeanReviews()); //Adding the film found in the list
			if (thePotentialBook!=null) ItemList.add("Book: "+thePotentialBook.getTitle()+" / Score: "+thePotentialBook.getMeanReviews()); //Adding the book found in the list
			return ItemList;
		}
		else return null; //No item with a matching title was found
		
	}
	
	/**
	 * Search a film among the film list of the social network using the given title. 
	 * 
	 * @param title
	 *            film's title
	 *           
	 * @return Film object if the film is found, else null. 
	 */
	public Film searchFilmByTitle(String title) {
		if (title==null) {
			return null;
		}
		int i=0;
		for (i=0;i<filmsList.size();i++) {
			if (filmsList.get(i).compareTitle(title)) return filmsList.get(i);
		}
		return null;
	}
	
	/**
	 * Search a book among the book list of the social network using the given title. 
	 * 
	 * @param title
	 *            book's title. 
	 *           
	 * @return Book object if the book is found, else null. 
	 */
	public Book searchBookByTitle(String title) {
		if (title == null) {
			return null;
		}
		for (int i=0; i<booksList.size();i++) {
			if (booksList.get(i).compareTitle(title)) return booksList.get(i);
		}
		return null;
	}
		
	/**
	 * Authenticate a member among the members list of the social network by using the given credentials (login, password). 
	 * 
	 * @param login
	 *            member's login.
	 * 
	 * @param password
	 *            member's password.  
	 *                
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.           
	 *             
	 * @return Member object if the the member is found, else null. 
	 */
	protected Member authenticateMember(String login, String password) throws NotMemberException{

        if (login==null || password==null) return null;
		
        for (int i=0;i<membersList.size();i++) {
        	if (membersList.get(i).checkCredentials(login, password) == 1) throw new NotMemberException("Wrong Password !"); //Throws a NotMemberException if the password doesn't match
        	else if (membersList.get(i).checkCredentials(login, password) == 2) return membersList.get(i); //Else return the Member
        }
        return null;
	}
	
	
	/**
	 * Check if the credentials given in parameters doesn't throw bad entry exception. 
	 * 
	 * @param login
	 *            member's login.
	 * 
	 * @param password
	 *            member's password.  
	 *                
	 * @throws BadEntryException
	 *            <br> -if login is not instantiated or doesn't contain at least one non-space characters.<br> 
	 *             -if password is not instantiated or is empty or contains less than 4 characters.
	 *             
	 */	
	protected void checkCredentialEntries(String login,String password) throws BadEntryException {
		
		if (login==null) throw new BadEntryException("The login is null.");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password==null) throw new BadEntryException("The password is null.");
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty");
		if (password.trim().length()<4) throw new BadEntryException("The password contains less than 4 characters");
		
	}
	
	public String toString() {
		
		String result = null;
		
		result="Members ("+nbMembers()+"):\n";
		
		for (Member theMember : membersList) {
			result+="			"+theMember.toString()+"\n";
		}
		
		result+="Films ("+nbFilms()+"):\n";

		for (Film theFilm : filmsList) {
			result+="			"+theFilm.toString()+"\n";
		}
		
		result+="Books ("+nbBooks()+"):\n";

		for (Book theBook : booksList) {
			result+="			"+theBook.toString()+"\n";
		}
		return result;

	}
		
}
