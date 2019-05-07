/**
 * 
 */
package com.seleniumdemo.model;

/**
 * @author OWNER
 *
 */
public class User {

	private String username;

	private String password;

	public User() {}

	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
