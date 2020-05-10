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
	public LinkedList<Film> filmsList = new LinkedList<Film>();

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
		return 0;
	}

	@Override
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (profile == null) throw new BadEntryException("The profile must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 character");
		
		for (int i=0; i < membersList.size(); i++) {
			if (membersList.get(i).checkExistingLogin(login)) {
				
				throw new MemberAlreadyExistsException("Login already used");
			}
		}
		membersList.add(new Member(login, password, profile));
	}

	@Override
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scenarist, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		

		//Elements which catch BadEntryException
		if (login == null) throw new BadEntryException("The login must be instanciated");
		if (login.replaceAll("\\s", "").length() < 1) throw new BadEntryException("The login must be instanciated with at least one non-space character");
		if (password == null) throw new BadEntryException("The password must be instanciated");
		if (password.trim().length() < 4) throw new BadEntryException("Password must contain at least 4 character");
		if (title == null) throw new BadEntryException("The title must be instanciated");
		if (kind == null) throw new BadEntryException("The kind must be instanciated");
		if (director == null) throw new BadEntryException("The director must be instanciated");
		if (scenarist == null) throw new BadEntryException("The scenarist must be instanciated");
		if (duration < 0) throw new BadEntryException("The duration must be positive");
		
		//Elements which catch NotMemberException
		for (int i=0; i<membersList.size(); i++) {
			int flag=0;
			switch (membersList.get(i).checkCredentials(login, password)) {
				
				case 1: throw new NotMemberException("Wrong Password !");
						
				case 2: if (this.searchFilmByTitle(title) == null) filmsList.add(new Film(title, kind, director, scenarist, duration));
						else throw new ItemFilmAlreadyExistsException("This film already exists !");
						flag=1;
						break;
										
			}
			 if (flag==0) {
			 throw new NotMemberException("Unknown login");
			 }
		}
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
		for (int i=0; i<membersList.size(); i++) {
			switch (membersList.get(i).checkCredentials(login, password)) {
				
				
			
				case 1: throw new NotMemberException("Wrong Password !");
				
				case 2: 		
					//Check Existing Film 
					
					// NotItemException checks 
					if (searchFilmByTitle(title)==null) throw new NotItemException("The title doesn't exists"); //Throw a new NotItemException if the title doesn't exist
					
					Film theFilm=searchFilmByTitle(title);
					if(!theFilm.checkMemberExistingReview(login)){
						theFilm.addReview(membersList.get(i),comment, mark);
					}
					break;
					
				default: throw new NotMemberException("The member doesn't exists"); //Throw a new NotMemberException if the member doesn't exist. 
			}

			}
		return searchFilmByTitle(title).MeanReviews();
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
			if (filmsList.get(i).getTitle().equalsIgnoreCase(title.trim())) return filmsList.get(i);
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
