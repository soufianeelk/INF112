package opinion;
import exceptions.*;

public class SocialNetworkPremium extends SocialNetwork implements ISocialNetworkPremium {

	public float reviewOpinion(String login, String password, String title, String type, String mark, String comment) throws NotMemberException,NotItemException  { 
		
		if (type.trim().equalsIgnoreCase("film")) {
			
			Film thePotentialFilm = searchFilmByTitle(title);
			if (thePotentialFilm==null) throw new NotItemException("The film was not found.");
			
			Member thePotentialMember=this.authenticateMember(login, password);
			if (thePotentialFilm==null) throw new NotItemException("The member was not found.");
			
			Review thePotentialReview = thePotentialFilm.checkMemberExistingReview(thePotentialMember);
			if (thePotentialReview==null) throw new NotItemException("The review was not found.");

			
		}
		
		if (type.trim().equalsIgnoreCase("book")) {
			
		}
		return 0;
		
	}
		
}
