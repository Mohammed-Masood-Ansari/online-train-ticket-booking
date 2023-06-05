package com.irctc.onlinetrainticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.onlinetrainticketbooking.dto.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	public User getByUserName(String userName);
}
