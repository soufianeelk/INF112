//V5

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
	
	private LinkedList<Member> MembersList = new LinkedList<Member>();
	private LinkedList<Film> FilmsList = new LinkedList<Film>();
	private LinkedList<Book> BooksList = new LinkedList<Book>();


	@Override
	public int nbMembers() {
		return MembersList.size();
	}

	@Override
	public int nbFilms() {
		return FilmsList.size();
	}

	@Override
	public int nbBooks() {
		return BooksList.size();
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
		for (int i=0; i < MembersList.size(); i++) {
			if (MembersList.get(i).compareLogin(login)) {
				throw new MemberAlreadyExistsException("Login already used"); //Throws the MemberAlreadyExistsException if the login isn't available
			}
		}
		
		// Add a new member in the MembersList after checking all is ok
		MembersList.add(new Member(login, password, profile));
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
		if (this.authenticateMember(login, password) == null) throw new NotMemberException("Unknown login");	//Throws NotMemberException if login provided is unknown
		if (this.searchFilmByTitle(title) == null) FilmsList.add(new Film(title, kind, director, scenarist, duration));	//Add a new film in the FilmsList after checking all is ok
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
		if (this.authenticateMember(login, password) == null) throw new NotMemberException("Unknown login");
		if (this.searchBookByTitle(title) == null) BooksList.add(new Book(title, kind, author,nbPages));
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
		
		Book theBook = searchBookByTitle(title);
		theBook.addReview(authenticateMember(login,password),comment, mark); //Adding or editing a review 
		return searchBookByTitle(title).getMeanReviews();
		
	}

	@Override
	public LinkedList<String> consultItems(String title)
			throws BadEntryException {
		
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		Film thePotentialFilm=searchFilmByTitle(title); //Researching a film
		Book thePotentialBook=searchBookByTitle(title); //Researching a book
		
		
		if (thePotentialFilm!=null || thePotentialBook!=null) { 	//Checking if one item (book or film) is found
			LinkedList<String> ItemList = new LinkedList<String>();
			if (thePotentialFilm!=null) ItemList.add(thePotentialFilm.getTitle()) ; //Adding the film found in the list
			if (thePotentialBook!=null) ItemList.add(thePotentialBook.getTitle()); //Adding the book found in the list
			return ItemList;
		}
		else return null; //No item with a matching title was found
		
	}
	
	/**
	 * Search a film among the film list of the social network using the given title. 
	 * 
	 * @param title
	 *           
	 * @return Film object if the film is found, else null. 
	 */
	public Film searchFilmByTitle(String title) {
		if (title==null) {
			return null;
		}
		int i=0;
		for (i=0;i<FilmsList.size();i++) {
			if (FilmsList.get(i).compareTitle(title)) return FilmsList.get(i);
		}
		return null;
	}
	
	/**
	 * Search a book among the book list of the social network using the given title. 
	 * 
	 * @param title
	 *           
	 * @return Book object if the book is found, else null. 
	 */
	public Book searchBookByTitle(String title) {
		if (title == null ) {
			return null;
		}
		for (int i=0; i<BooksList.size();i++) {
			if (BooksList.get(i).compareTitle(title)) return BooksList.get(i);
		}
		return null;
	}
		
	/**
	 * Authenticate a member among the members list of the social network by using the given credentials (login, password). 
	 * 
	 * @param login
	 * 
	 * @param password
	 *           
	 * @return Member object if the the member is found, else null. 
	 */
	public Member authenticateMember(String login, String password) throws NotMemberException{
        for (int i=0;i<MembersList.size();i++) {
        	if (MembersList.get(i).checkCredentials(login, password) == 1) throw new NotMemberException("Wrong Password !"); //Throws a NotMemberException if the password doesn't match
        	else if (MembersList.get(i).checkCredentials(login, password) == 2) return MembersList.get(i); //Else return the Member
        }
        return null;
	}
	
	/**
	 * @param args
	 * @throws BadEntryException 
	 */
	public static void main(String[] args) {
	}
	

}
