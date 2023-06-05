package com.irctc.onlinetrainticketbooking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irctc.onlinetrainticketbooking.dto.User;
import com.irctc.onlinetrainticketbooking.repository.UserRepository;




/**
 * @author asus
 *
 */
@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;
	
	/*
	 * saveMethod for user
	 */
	public User saveUser(User user) {
		
		return repository.save(user);
	}
	
	/*
	 * userLogin
	 */
	public User loginUser(String userName) {
	
		return repository.getByUserName(userName);
	}
}
