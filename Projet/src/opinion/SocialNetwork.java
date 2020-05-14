//V2
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
	private LinkedList<Film> booksList = new LinkedList<Book>();
	private LinkedList<String> itemList = new LinkedList<String>();


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
		
		// Check parameters content (if they aren't empty, if password contains higher than 4 characters...)
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (profile == null) throw new BadEntryException("The profile must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 characters");
		
		// Check if the login is available
		for (int i=0; i < membersList.size(); i++) {
			if (membersList.get(i).checkExistingLogin(login)) {
				
				throw new MemberAlreadyExistsException("Login already used"); // Throw the exception if the login isn't available
			}
		}
		
		// Add a new member in the membersList
		membersList.add(new Member(login, password, profile));
	}

	@Override
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scenarist, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		

		// Check parameters content (if they aren't empty, if password contains higher than 4 characters, if duration is positive...)
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 character");
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		if (kind == null) throw new BadEntryException("The kind must be instanciated");
		if (director == null) throw new BadEntryException("The director must be instanciated");
		if (scenarist == null) throw new BadEntryException("The scenarist must be instanciated");
		if (duration < 0) throw new BadEntryException("The duration must be positive");
		
		// Check Authentication and check that the film doesn't already exist
		if (this.authenticateMember(login, password) == null) throw new NotMemberException("Unknown login");
		if (this.searchFilmByTitle(title) == null) filmsList.add(new Film(title, kind, director, scenarist, duration));
		else throw new ItemFilmAlreadyExistsException("This film already exists !");
	
	}

	@Override
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {
		
		// Check parameters content (if they aren't empty, if password contains higher than 4 characters, if duration is positive...)
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 character");
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		if (kind == null) throw new BadEntryException("The kind must be instanciated");
		if (author == null) throw new BadEntryException("The author must be instanciated");
		if (nbPages < 0) throw new BadEntryException("The number of pages must be positive");
		
		// Check Authentication 
		if (this.authenticateMember(login, password) == null) throw new NotMemberException("Unknown login");
		if (this.searchBookByTitle(title) == null) booksList.add(new Book(title, kind, author,nbPages));
		else throw new ItemFilmAlreadyExistsException("This book already exists !");


	}

	@Override
	public float reviewItemFilm(String login, String password, String title,float mark, String comment) throws BadEntryException,NotMemberException, NotItemException {
	
		// Check Parameters content (if they aren't empty, if password contains higher than 4 characters, if mark is between 0 and 5...)
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5"); //Throw a new BadEntryException if the title is empty
		if (comment==null) throw new BadEntryException("The comment is null."); // Throw a new BadEntryException if the comment is null
		
		// Check Authentication and check that the film exists
		if (this.authenticateMember(login, password) == null) throw new NotMemberException("Unknown login");
		if (this.searchBookByTitle(title) == null) throw new NotItemException("The title doesn't exists"); 
		
		Film theBook = searchBookByTitle(title);
		theBook.addReview(authenticateMember(login,password),comment, mark); //Adding or editing a review 
		return searchBookByTitle(title).getMeanReviews();
		
	}
	

	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		
		// Check Parameters content (if they aren't empty, if password contains higher than 4 characters, if mark is between 0 and 5...)
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5"); //Throw a new BadEntryException if the title is empty
		return 0;
	}

	@Override
	public LinkedList<String> consultItems(String title)
			throws BadEntryException {
		
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		
		Film thePotentialFilm=searchFilmByTitle(title);
		Book thePotentialBook=searchBookByTitle(title);
		
		if (thePotentialFilm!=null) itemList.add(thePotentialFilm.getTitle()) ;
		if (thePotentialBook!=null) itemList.add(thePotentialBook.getTitle());

		
		return itemList;
	}
	/**
	 * Search a film among the film list of the social network using the given title. 
	 * 
	 * @param title
	 *           
	 * @return Film object if the the film is found, else null. 
	 */
	public Film searchFilmByTitle(String title) {
		int i=0;
		for (i=0;i<filmsList.size();i++) {
			if (filmsList.get(i).getTitle().equalsIgnoreCase(title.trim())) return filmsList.get(i);
		}
		return null;
	}
	
	// 
	
	/**
	 * Authenticate a member in the social network with its login. 
	 * 
	 * @param login
	 *  
	 * @param password 
	 *           
	 * @return Return the member if a member in membersList , corresponds to those credentials, else null
	 */
	public Member authenticateMember(String login, String password) throws NotMemberException{
        for (int i=0;i<membersList.size();i++) {
        	if (membersList.get(i).checkCredentials(login, password) == 1) throw new NotMemberException("Wrong Password !");
        	else if (membersList.get(i).checkCredentials(login, password) == 2) return membersList.get(i);
        }
        return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
