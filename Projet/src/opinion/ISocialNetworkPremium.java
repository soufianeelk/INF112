package opinion;

import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

public interface ISocialNetworkPremium extends ISocialNetwork {
	
	/**
	 * Add in the <i>SocialNetwork</i> a new opinion about a review on behalf of a
	 * specific member.</br>
	 * 
	 * @param login
	 *            login of the member adding the review
	 * @param password
	 *            password of the member adding the review
	 * @param title
	 *            the reviewed book's title
	 *   
	 * @param type
	 * 			  the type of the item.
	 *           
	 * @param mark
	 *            the mark given by the member for this book
	 * @param comment
	 *            the comment given by the member for this book
	 * 
	 * 
	 * @return the karma of the user reviewed. 
	 */
	
	public float reviewOpinion(String login, String password, String title, String type, String mark, String comment) throws NotMemberException,NotItemException;
	
}
