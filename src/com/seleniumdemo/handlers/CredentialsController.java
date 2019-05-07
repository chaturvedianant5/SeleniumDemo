/**
 * 
 */
package com.seleniumdemo.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.seleniumdemo.model.User;

/**
 * @author Anant
 *
 */
public class CredentialsController {

	private static volatile CredentialsController instance;
	private static final File CREDENTIALS_FILE = new File("credentialsDataFile.txt");
	//private static final String DEFAULT_ACCESS_KEY = "12345";

	private static ArrayList<User> CREDENTIALS_LIST = new ArrayList<User>();

	private CredentialsController() {}

	public static CredentialsController getInstance() {
		if(instance == null) {
			synchronized(CredentialsController.class) {
				if(instance == null) {
					instance = new CredentialsController();
					return instance;
				}
			}
		}
		return instance;
	}

	public ArrayList<User> getCredentialsList() {
		if(CREDENTIALS_LIST.isEmpty()) {
			synchronized(CredentialsController.class) {
				if(CREDENTIALS_LIST.isEmpty()) {
					populateList();
					return CREDENTIALS_LIST;
				}
			}
		}
		return CREDENTIALS_LIST;
	}

	private void populateList() {
		try{
			BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE));
			String rawCredentials = br.readLine();

			while(rawCredentials!=null) {
				// Following two lines to handle space separated username password in input txt file.
				// Use as necessary
				String[] credentialParts = rawCredentials.split(" ");
				User currentCredentials = new User(credentialParts[0], credentialParts[1]);
				
				// Current implementation only lists the vendor usernames separated by new line.
				// Above logic could be implemented where both username and password are in the credentials file.
				// Comment out the following line if the above logic is implemented.
				//User currentCredentials = new User(rawCredentials, DEFAULT_ACCESS_KEY);
				
				CREDENTIALS_LIST.add(currentCredentials);
				rawCredentials = br.readLine();
			}
			br.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
