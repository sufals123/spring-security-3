package com.db.service;

import com.db.entites.User;

public interface UserService {
	
	public User saveUser(User user);
	public void removeSessionMessage();
}
