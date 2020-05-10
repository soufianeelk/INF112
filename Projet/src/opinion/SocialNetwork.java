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
	private int nbMembers;
	private int nbFilms;
	public LinkedList<Film> filmsList = new LinkedList<Film>();

	@Override
	public int nbMembers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbFilms() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		this.membersList.add(new Member(login,password,profile));
		this.nbMembers++;
	}

	@Override
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scenarist, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		
		this.filmsList.add(new Film(title, kind, director, scenarist, duration)); //adding a new film in the films list
		this.nbFilms++; //incrementing the film counter

	}

	@Override
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public float reviewItemFilm(String login, String password, String title,float mark, String comment) throws BadEntryException,NotMemberException, NotItemException {

	//Check Parameters 	
		// BadEntryException checks
		if (login==null) throw new BadEntryException("The login is null."); // Throw a new BadEntryException if the login is null
		if (login.equals("")) throw new BadEntryException("The login doesn't contains character other than space"); //Throw a new BadEntryException if the login is empty
		if (password==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the password is null
		if (password.replaceAll("\\s", "").length()<1) throw new BadEntryException("The password is empty"); //Throw a new BadEntryException if the password is empty
		if (password.length()<4) throw new BadEntryException("The password contains less than 4 characters"); //Throw a new BadEntryException if the password contains less than 4 characters
		if (title==null) throw new BadEntryException("The password is null."); // Throw a new BadEntryException if the title is null
		if (title.replaceAll("\\s", "").length()<1) throw new BadEntryException("The title is empty"); //Throw a new BadEntryException if the title is empty
		if (mark<0 || mark>5) throw new BadEntryException("The mark doesn't have a number between 0 and 5"); //Throw a new BadEntryException if the title is empty
		if (comment==null) throw new BadEntryException("The comment is null."); // Throw a new BadEntryException if the comment is null
		
	//Check Authentication 
		
		// NotMemberException checks
		Member theMember=authenticateMember(login,password);
		if (theMember==null) throw new NotMemberException("The member doesn't exists"); //Throw a new NotMemberException if the member doesn't exist. 
		
	//Check Existing Film 
		
		// NotItemException checks 
		if (searchFilmByTitle(title)==null) throw new NotItemException("The title doesn't exists"); //Throw a new NotItemException if the title doesn't exist

		
		Film theFilm=searchFilmByTitle(title);
		if(!theFilm.checkMemberExistingReview(login)){
			theFilm.setReview(theMember,comment, mark);
		}
		return theFilm.getMeanReviews();
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
	 * Search a film among the film list of the social network using the given title. 
	 * 
	 * @param title
	 *           
	 * @return Film object if the the film is found, else null. 
	 */
	public Film searchFilmByTitle(String title) {
		int i=0;
		for (i=0;i<filmsList.size();i++) {
			if (filmsList.get(i).checkExistingTitle(title)) return filmsList.get(i);
		}
		return null;
	}
	
	/**
	 * Authenticate a member among the member list of the social network by using the given credentials (login, password). 
	 * 
	 * @param login
	 * 
	 * @param password
	 *           
	 * @return Member object if the the member is found, else null. 
	 */
	public Member authenticateMember(String login, String password) {
		int i=0;
		for (i=0;i<membersList.size();i++) {
			if (membersList.get(i).checkCredentials(login,password)) return membersList.get(i); //checking credentials on each member in the members list
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
