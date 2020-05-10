package opinion;

import java.util.LinkedList;

/** 
 * @author - V. Tritarelli
 * @author - H. Houillon
 * @date 2019 - 2020
 * @version V2020.1
 */

public class Film {

	private String title; // Title of the film
	private String kind; // Kind of the film
	private String director; // Film director's name
	private String scriptwriter; // Film scriptwriter's name
	private int duration; // Film's duration
	
	private LinkedList<Review> reviews = new LinkedList<Review>(); // LinkedList of Review which correspond to this film
	
	/**
	 * Film's constructor
	 * 
	 * @param title
	 *            the film title
	 * @param kind
	 *            the film kind
	 * @param director
	 *            the film director
	 * @param scriptwriter
	 *            the film scriptwriter
	 * @param duration
	 *            the film duration
	 * 
	 */
	public Film(String title, String kind, String director, String scriptwriter, int duration)
	{
		this.title = title; // Initialize film's title
		this.kind = kind; // Initialize film's kind
		this.director = director; // Initialize film's director
		this.scriptwriter = scriptwriter; // Initialize film's scriptwriter
		this.duration = duration; // Initialize film's duration
	}
	
	/**
	 * Allows to get the number of reviews for this film
	 * 
	 * @return The number of reviews
	 * 
	 */
	public int nbReviews()
	{
		return reviews.size(); // Returns the size of reviews list
	}
	
	/**
	 * Check if a review already exists with a given member's login
	 * 
	 * @param login
	 *            the member login
	 * @return If yes or no a review already exists on this film a given member's login
	 * 
	 */
	public boolean reviewItemFilmALreadyExists(String login)
	{
		for(Review review : reviews) // For each review in reviews list
		{
			if(review.checkMemberLogin(login)) return true; // If the member's login of the review is equal to the login given in parameters, returns true
		}
		return false; // If no review with this member's login, returns false
	}
	
	/**
	 * Allows to edit an existing review done by given user
	 * 
	 * @param login
	 *            the member login
	 * @param comment
	 * 			  the review comment
	 * @param mark
	 * 			  the review mark
	 * 
	 */
	public void editReview(String login, String comment, float mark)
	{
		for(Review review : reviews) // For each review in reviews list
		{
			if(review.getMember().checkLogin(login)) // If review member's login corresponds to given login
			{
				review.setComment(comment); // Edit the review's comment with the new one
				review.setMark(mark); // Edit the review's mark with the new one
			}
		}
	}
	
	/**
	 * Add a review to film reviews list
	 * 
	 * @param theReview
	 *            the review to add to the list
	 * 
	 */
	public void addReview(Review theReview)
	{
		this.reviews.add(theReview);
	}
	
	/**
	 * Check if the film's name is equal to the given title
	 * 
	 * @param title
	 *            the film title
	 * @return true if the film's title is equal to title given in parameters
	 * 
	 */
	public boolean filmAlreadyExists(String title)
	{
		if(this.title.toLowerCase().replaceAll("\\s+", "").equals(title.toLowerCase().replaceAll("\\s+", ""))) return true;
			
		return false;
	}
	
	/**
	 * Calculate the mean rate of the film
	 * 
	 * @return the mean rate of the film
	 * 
	 */
	public float calculateReviewMean()
	{
		float sum = 0;
		
		for(Review review : reviews) // For each review in reviews list
		{
			sum += review.getMark(); // Get the mark of the review and add it to the mark sum
		}
		
		return (sum/(float)reviews.size()); // Returns the mean rate
	}
	
}
