package com.service;

import java.util.HashMap;

import com.beans.User;

public class LoginService {

	HashMap<String, String> users= new HashMap<String, String>();
	
	public LoginService() {
		users.put("johndoe", "John Doe");
		users.put("janedoe", "Jane Doe");
		users.put("jguru", "Java Guru");
	}
	
	//validation the userName and password
	public boolean authenticate(String userName, String password) {
		
		if (password == null || password.trim() == "") {
			return false;
		}
		return true;
	}
	
	public User getUserDetails(String userName) {
		User user = new User();
		user.setUserName(users.get(userName));
		return user;
	}
}
