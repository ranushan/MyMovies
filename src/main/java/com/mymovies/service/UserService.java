package com.mymovies.service;

import java.util.List;

import com.mymovies.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public void removeUser(User user);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(long id);

	public String encryptPassword(String originalPassword);
	
	public void validatePassword(User user);

	public boolean alreadyUse(User user);
	
}
