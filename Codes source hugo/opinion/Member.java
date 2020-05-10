package opinion;

import java.util.LinkedList;

/** 
 * @author - V. Tritarelli
 * @author - H. Houillon
 * @date 2019 - 2020
 * @version V2020.1
 */


public class Member {

	private String login; // Member's login
	private String password; // Member's password
	private String profile; // Member's profile
	
	/**
	 * Member's constructor
	 * 
	 * @param login
	 *            the film login
	 * @param password
	 *            the film password
	 * @param profile
	 *            the film profile
	 * 
	 */
	public Member(String login, String password, String profile)
	{
		this.login = login;
		this.password = password;
		this.profile = profile;
	}
	
	/**
	 * Check if the given login is equal to member's login
	 * 
	 * @param login
	 *            the member login
	 * @return if the given login is equal to member's login returns true
	 * 
	 */
	public boolean checkLogin(String login)
	{
		if(this.login.toLowerCase().replaceAll("\\s+", "").equals(login.toLowerCase().replaceAll("\\s+", ""))) // Replace spaces by nothing and put string to lower
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Check if the given login is equal to member's login and given password is equal to member's password
	 * 
	 * @param login
	 *            the member login
	 * @param password
	 *            the member password
	 * @return if the given login is equal to member's login and given password is equal to member's passwords returns true
	 * 
	 */
	public boolean checkPassword(String login, String password)
	{
		if(this.password.toLowerCase().replaceAll("\\s+", "").equals(password.toLowerCase().replaceAll("\\s+", "")) && this.login.toLowerCase().replaceAll("\\s+", "").equals(login.toLowerCase().replaceAll("\\s+", "")))
		{
			return true;
		}
		return false;
	}
}
