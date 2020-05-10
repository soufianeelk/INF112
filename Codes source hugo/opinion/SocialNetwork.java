package opinion;

import java.util.LinkedList;

import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

/** 
 * @author - V. Tritarelli
 * @author - H. Houillon
 * @date 2019 - 2020
 * @version V2020.1
 */

public class SocialNetwork implements ISocialNetwork {

	
	private LinkedList<Member> members = new LinkedList<Member>(); // LinkedList which contains the list of members in the socialNetwork
	private LinkedList<Film> films = new LinkedList<Film>(); // LinkedList which contains the list of films in the socialNetwork
	
	@Override
	public int nbMembers() {
		
		return members.size(); // Return the size of the LinkedList members
	}

	@Override
	public int nbFilms() {
		
		return films.size(); // Return the size of the linkedlist films
	}

	@Override
	public int nbBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		
		if(login == null) throw new BadEntryException("Login must be instancied."); // If login not instancied, throws a badentryexception
		if(login.replaceAll("\\s+", "").length() < 1) throw new BadEntryException("Login must contains at least 1 character"); // If size of the login is lower than 1 character, throws badentryexception
		if(password == null) throw new BadEntryException("Password must be instancied."); // If password not instancied, throws badentryexception
		if(password.replaceAll("\\s+", "").length() < 4) throw new BadEntryException("Password must contain at least 4 character."); // If size of the password is lower than 4 characters, throws badentryexcption
		if(profile == null) throw new BadEntryException("Profile must be instancied."); // If profile not instancied, throws badentryexception

		if(memberAlreadyExists(login)) throw new MemberAlreadyExistsException("Login already used."); // If login is already used, throws memberAlreadyExistsException
		
		members.add(new Member(login, password, profile)); // If all entries are ok, add the new member to members list
	}

	@Override
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scriptwriter, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		
		if(login == null) throw new BadEntryException("Login must be instancied."); // If login not instancied, throws a badentryexception
		if(login.replaceAll("\\s+", "").length() < 1) throw new BadEntryException("Login must contains at least 1 character");// If size of the login is lower than 1 character, throws badentryexception
		if(password == null) throw new BadEntryException("Password must be instancied."); // If password not instancied, throws badentryexception
		if(password.replaceAll("\\s+", "").length() < 4) throw new BadEntryException("Password must contain at least 4 character.");// If size of the password is lower than 4 characters, throws badentryexcption
		if(title == null) throw new BadEntryException("Title must be instancied"); //If title not instancied, throws BadEntryException
		if(title.replaceAll("\\s+", "").length() < 1) throw new BadEntryException("Title must contain at least 1 character"); // If size of the title is lower than 1 character, throws BadEntryException
		if(kind == null) throw new BadEntryException("Type must be instancied"); // If kind not instancied, throws a badentryexception
		if(director == null) throw new BadEntryException("Director must be instancied");// If director not instancied, throws a badentryexception
		if(scriptwriter == null) throw new BadEntryException("Scenarist must be instancied");// If scriptwriter not instancied, throws a badentryexception
		if(duration <= 0) throw new BadEntryException("Duration must be greater than 0");// If duration is lower or equal to 0, throws BadEntryException
		
		if(!checkPassword(login, password)) throw new NotMemberException("Incorrect login or password"); // If login doesn't exists in members list or password doesn't corresponds to a member's login, throws a NotMemberException
		
		if(itemFilmAlreadyExists(title)) throw new ItemFilmAlreadyExistsException("This title is already used"); // If title of the new film corresponds to an already existing film's title, throws an ItemFilmAlreadyExistsException
		
		films.add(new Film(title, kind, director, scriptwriter, duration)); // If all entries are OK, add the new film to films list
	}

	@Override
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {

	}

	@Override
	public float reviewItemFilm(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		
		Film theFilm;
		
		if(login == null) throw new BadEntryException("Login must be instancied.");// If login not instancied, throws a badentryexception
		if(login.replaceAll("\\s+", "").length() < 1) throw new BadEntryException("Login must contains at least 1 character");// If size of the login is lower than 1 character, throws badentryexception
		if(password == null) throw new BadEntryException("Password must be instancied."); // If password not instancied, throws badentryexception
		if(password.replaceAll("\\s+", "").length() < 4) throw new BadEntryException("Password must contain at least 4 character.");// If size of the password is lower than 4 characters, throws badentryexcption
		if(title == null) throw new BadEntryException("Title can't be null");// If title not instancied, throws a badentryexception
		if(title.replaceAll("\\s+", "").length() < 1) throw new BadEntryException("Title must contains at least 1 character");// If size of the title is lower than 1 character, throws badentryexception
		if((mark < 0) || (mark > 5)) throw new BadEntryException("Mark must be between 0 and 5."); // If mark is lower than 0 or greater than 5, throws BadEntryException
		if(comment == null) throw new BadEntryException("Comment must be instancied");// If comment not instancied, throws a badentryexception
		
		if(!checkPassword(login, password)) throw new NotMemberException("Incorrect login or password");// If login doesn't exists in members list or password doesn't corresponds to a member's login, throws a NotMemberException
		
		if((theFilm = getFilmFromTitle(title)) == null) throw new NotItemException("The specified title's film doesn't exists"); // If the film doesn't exists, throws a NotItemException, else get the instance of the film
		
		if(theFilm.reviewItemFilmALreadyExists(login)) // If this login corresponds to an already existing review's member's login on this film
		{
			theFilm.editReview(login, comment, mark); // Edit the existing review
		}
		else
		{
			Review newReview = new Review(comment, mark, getMemberFromLogin(login)); // Create a new Review
			theFilm.addReview(newReview); // Add this review to film reviews
		}
		
		return theFilm.calculateReviewMean(); // Calculate the film mean rate
	}

	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LinkedList<String> consultItems(String title)
			throws BadEntryException {
		return new LinkedList<String>();
	}
	
	/**
	 * Check if the login already exists in members list
	 * 
	 * @param login
	 *            the member login
	 * @return if member already exists or not
	 * 
	 */
	private boolean memberAlreadyExists(String login)
	{
		for(Member member : members) // For each member in members list
		{
			if(member.checkLogin(login)) return true; // If the member's login is equal to the login in parameters, returns true
		}
		return false; // No member has the same login, so returns false
	}
	
	/**
	 * Check if the film already exists in films list <i>SocialNetwork</i>
	 * 
	 * @param title
	 *            the film title
	 * @return if film already exists or not
	 * 
	 */
	private boolean itemFilmAlreadyExists(String title)
	{
		for(Film film : films) // For each film in films list
		{
			if(film.filmAlreadyExists(title)) return true; // If the film's title is equal to the title in parameters, returns true
		}
		return false; // No film has the same title, so returns false
	}
	
	/**
	 * Check if the login is an existing login and if the password corresponds to a login
	 * 
	 * @param login
	 *            the member login
	 * @param password
	 * 			  the member password
	 * @return if the login is an existing login and if the password corresponds to a login
	 * 
	 */
	private boolean checkPassword(String login, String password)
	{
		for(Member member : members) // for each member in members list
		{
			if(member.checkPassword(login, password)) return true; // Check if the login is an existing login and if the password corresponds to a login and return true
		}
		return false; // Returns false if login dosn't exists or password doesn't corresponds to an existing login 
	}
	
	/**
	 * Allows to find and get an instance of member from its login
	 * 
	 * @param login
	 *            the member login
	 * @return An instance of Member
	 * 
	 */
	private Member getMemberFromLogin(String login)
	{
		for(Member member : members) // For each member in members list
		{
			if(member.checkLogin(login)) return member; // Return the member if the login in parameters is equal to member's login
		}
		return null; // return null if doesn't find corresponding member
	}
	
	/**
	 * Allows to find and get an instance of film from its title
	 * 
	 * @param title
	 *            the film title
	 * @return An instance of Film
	 * 
	 */
	public Film getFilmFromTitle(String title)
	{
		for(Film film : films) // For each film in films list
		{
			if(film.filmAlreadyExists(title)) return film;// Return the film if the title in parameters is equal to film's title
		}
		return null; // return null if doesn't find corresponding film
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
