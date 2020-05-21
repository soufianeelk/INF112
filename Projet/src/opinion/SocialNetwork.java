//V8

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
	
	private LinkedList<Member> membersList = new LinkedList<Member>();
	private LinkedList<Film> filmsList = new LinkedList<Film>();
	private LinkedList<Book> booksList = new LinkedList<Book>();


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
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (profile == null) throw new BadEntryException("The profile must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 characters");
		
		// Check if the login is available
		for (int i=0; i < membersList.size(); i++) {
			if (membersList.get(i).compareLogin(login)) {
				throw new MemberAlreadyExistsException("Login already used"); //Throws the MemberAlreadyExistsException if the login isn't available
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
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 character");
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
		else throw new ItemFilmAlreadyExistsException("This film already exists !"); //Throw ItemFilmAlreadyExistsException if the film already exists
	
	}

	@Override
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {
		
		//Check parameters content (if they aren't empty, if password contains higher than 4 characters, if duration is positive...)
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 character");
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty");
		if (kind == null) throw new BadEntryException("The kind must be instanciated");
		if (author == null) throw new BadEntryException("The author must be instanciated");
		if (nbPages < 0) throw new BadEntryException("The number of pages must be positive");
		
		//Check if the book already exists in the list 
		if (this.searchBookByTitle(title)!=null) throw new ItemBookAlreadyExistsException("The book already exists !");
		
		//Check Authentication 
		Member thePotentialMember=this.authenticateMember(login, password);
		if (thePotentialMember== null) throw new NotMemberException("Unknown login");
		if (this.searchBookByTitle(title) == null) booksList.add(new Book(thePotentialMember,title, kind, author,nbPages));
		else throw new ItemBookAlreadyExistsException("This book already exists !");
		


	}

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
	
	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		
		// Check Parameters content (if they aren't empty, if password contains higher than 4 characters, if mark is between 0 and 5...)
		if (login==null) throw new BadEntryException("The login is null.");
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space");
		if (password==null) throw new BadEntryException("The password is null.");
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); 
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); 
		if (title==null) throw new BadEntryException("The password is null."); 
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); 
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5"); 
		
		//Check Authentication and check that the film exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		if (this.searchBookByTitle(title) == null) throw new NotItemException("The title doesn't exists");  //Throws a NotItemException if the title doesn't exist
		
		
		
		Book theBook = searchBookByTitle(title);
		theBook.addReview(authenticateMember(login,password),comment, mark); //Adding or editing a review 
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
	public Member authenticateMember(String login, String password) throws NotMemberException{

        for (int i=0;i<membersList.size();i++) {
        	if (membersList.get(i).checkCredentials(login, password) == 1) throw new NotMemberException("Wrong Password !"); //Throws a NotMemberException if the password doesn't match
        	else if (membersList.get(i).checkCredentials(login, password) == 2) return membersList.get(i); //Else return the Member
        }
        return null;
	}
	
	/**
	 * Removing a member among the members list of the social network by using the given credentials (login, password). 
	 * 
	 * @param login
	 *            member's login.
	 * @param password
	 *            member's password.           
	 * @return void;
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than one
	 *             non-space character or contains less than 4 characters</li>
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 */
	
	public void removeMember(String login, String password) throws BadEntryException,NotMemberException {
		
		if (login==null) throw new BadEntryException("The login is null.");
		if (login.trim().equals("")) throw new BadEntryException("The login doesn't contains character other than space");
		if (password==null) throw new BadEntryException("The password is null.");
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); 
		if (password.trim().length()<4) throw new BadEntryException("The password contains less than 4 characters");
		
		//Check Authentication and check that the member exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		
		//Removing the member
        for (int i=0;i<membersList.size();i++) {
        	if (membersList.get(i)==thePotentialMember) membersList.remove(i);
        }
		System.out.println("The member was successfully removed from the social network.");

	}
	
	/**
	 * Removing a review given by a member on a specific film. 
	 * 
	 * @param title 
	 *            film's title
	 * 
	 * @param login
	 *            member's login
	 * 
	 * @param password
	 *            member's password
	 *             
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than one
	 *             non-space character or contains less than 4 characters</li>
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 *             
	 * @throws NotMemberException
	 *             if the review item doesn't exists for a specific member. 
	 */
	
	
	public void removeReviewItemFilm(String title,String login, String password) throws BadEntryException,NotMemberException,NotItemException {
		
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instantiated with at least one non-space character");
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		//Checking Authentication 
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		
		//Checking the film 
		Film thePotentialFilm = this.searchFilmByTitle(title);
		if (thePotentialFilm==null) throw new NotItemException("The film doesn't exist exists !");

		
		//Checking if review exist for this member 
		Review thePotentialReviewToRemove=thePotentialFilm.checkMemberExistingReview(thePotentialMember);
		if (thePotentialReviewToRemove == null) throw new NotItemException("No review exists for this member");  //Throws a NotItemException if the title doesn't exist
		else 
			thePotentialFilm.removeReview(thePotentialMember);
			System.out.println("The review of this member for this film was successfully removed.");
		
	}
	
	/**
	 * Removing a review given by a member on a specific book. 
	 * 
	 * @param title 
	 *            film's title
	 * 
	 * @param login
	 *            member's login
	 * 
	 * @param password
	 *            member's password 
	 *            
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than one
	 *             non-space character or contains less than 4 characters</li>
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 *             
	 * @throws NotMemberException
	 *             if the review item doesn't exists for a specific member.        
	 */
	
	public void removeReviewItemBook(String title,String login, String password) throws BadEntryException,NotMemberException,NotItemException {
		
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instantiated with at least one non-space character");
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		//Checking Authentication 
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		
		//Checking the book 
		Book thePotentialBook = this.searchBookByTitle(title);
		if (thePotentialBook==null) throw new NotItemException("The film doesn't exist exists !");

		
		//Checking if review exist for this member 
		Review thePotentialReviewToRemove=thePotentialBook.checkMemberExistingReview(thePotentialMember);
		if (thePotentialReviewToRemove == null) throw new NotItemException("No review exists for this member");  //Throws a NotItemException if the title doesn't exist
		else 
			thePotentialBook.removeReview(thePotentialMember);
			System.out.println("The review of this member for this book was successfully removed.");
		
	}
	
	
	public void removeItemFilm(String title,String login, String password) throws BadEntryException,NotMemberException,NotItemException,Exception {
		
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instantiated with at least one non-space character");
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		//Check Authentication and check that the book exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		
		Film thePotentialFilmToRemove=searchFilmByTitle(title);
		if (thePotentialFilmToRemove == null) throw new NotItemException("The title doesn't exists");  //Throws a NotItemException if the title doesn't exist
		
		if (thePotentialFilmToRemove.getPublisher().compareLogin(login)) {
			if(filmsList.remove(thePotentialFilmToRemove)) System.out.println("The book was successfully removed.");
			else throw new Exception("Fail to remove the film.");
		}
		else throw new Exception("Fail to remove the film. The given login mismatch with the book publishers' login.");
	
	}
	
	public void removeItemBook(String title,String login, String password) throws BadEntryException,NotMemberException,NotItemException,Exception {
		
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instantiated with at least one non-space character");
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		//Check Authentication and check that the book exists
		Member thePotentialMember = this.authenticateMember(login, password);
		if (thePotentialMember == null) throw new NotMemberException("Unknown login"); //Throws a NotMemberException if the member is not registered
		
		Book thePotentialBookToRemove=searchBookByTitle(title);
		if (thePotentialBookToRemove == null) throw new NotItemException("The title doesn't exists");  //Throws a NotItemException if the title doesn't exist
		
		if (thePotentialBookToRemove.getPublisher().compareLogin(login)) {
			if(booksList.remove(thePotentialBookToRemove)) System.out.println("The book was successfully removed.");
			else throw new Exception("Fail to remove the book.");
		}
		else throw new Exception("Fail to remove the book. The given login mismatch with the book publishers' login.");
	
	}
	
	
	/*public void editMember(String login, String password, String newPassword, String newProfile) 
			throws BadEntryException, NotMemberException {
		
		if (this.authenticateMember(login, password) == null) throw new NotMemberException("Unknown login");
		
		//Check parameters content (if they aren't empty, if password contains higher than 4 characters...) throws the BadEntryException if wrong
		if (newPassword == null) throw new BadEntryException("The password must be instantiated");
		if (newProfile == null) throw new BadEntryException("The profile must be instantiated");
		if (newPassword.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 characters");
		
	}*/
	
	public void editItemFilm() {
		
	}
	
	public void editReviewItemFilm() {
		
	}
	
	public void editItemBook() {
		
	}
	
	public void editReviewItemBook() {
		
	}
	
	public static void main(String[] args) {
	}
	

}
