package com.mymovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovies.dao.UserRepository;
import com.mymovies.entity.Password;
import com.mymovies.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void addUser(User user) {
		
		boolean statut = alreadyUse(user);
		
		System.out.println(statut);
		if(statut == false) {
		
			System.out.println("je save ");
			user.setPassword(encryptPassword(user.getPassword()));
			userRepository.save(user);
		
		}else {
		
			System.out.println("pas de duplication accepter");
		
		}
		
	}

	@Override
	public void removeUser(User user) {
		
		userRepository.delete(user);
		
	}

	@Override
	public void updateUser(User user) {
		
		userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> user = (List<User>) userRepository.findAll();
		
		return user;
		
	}

	@Override
	public User getUser(long id) {
		
		User user = userRepository.findById(id);
		
		return user;
		
	}

	@Override
	public String encryptPassword(String originalPassword) {
		

        // Generate Salt. The generated value can be stored in DB. 
        String salt = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = Password.generateSecurePassword(originalPassword, salt);
        
        return mySecurePassword;
     
        // Print out protected password 
        //System.out.println("From encryptPassword Methode => My secure password = " + mySecurePassword);
        //System.out.println("From encryptPassword Methode => Salt value = " + salt);
		
	}

	@Override
	public void validatePassword(User user) {
	
		User userDb = userRepository.findByUsername(user.getUsername());
		
		// User provided password to validate
        String providedPassword = user.getPassword();
                
        // Encrypted and Base64 encoded password read from database
        String securePassword = userDb.getPassword();
        
        if(providedPassword.equals(securePassword)) {
	        	
	        System.out.println("Provided user password " + providedPassword + " is correct.");
	    } else {
	        System.out.println("Provided password is incorrect");
	    }
	
	}

	@Override
	public boolean alreadyUse(User user) {
		
		List<User> listUsers = getAllUsers();
		
		String usernameForm = user.getUsername();
		
		String emailForm = user.getEmail();
		
		for(User u : listUsers) {
			
			String getUsernameDb = u.getUsername();
			
			String getEmailDb = u.getEmail();
			
			if(usernameForm.equals(getUsernameDb) || emailForm.equals(getEmailDb)) {
				
				System.out.println("Username ou Email deja existant");
				return true;
				
			}
			
		}
		
		System.out.println("Username ou Email non cree");
		return false;
		
	}

}
