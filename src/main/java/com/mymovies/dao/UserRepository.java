package com.mymovies.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mymovies.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findById(long id);
	
	User findByUsername(String username);

}
