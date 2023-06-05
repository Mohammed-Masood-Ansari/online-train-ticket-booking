package com.irctc.onlinetrainticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.onlinetrainticketbooking.dto.User;
import com.irctc.onlinetrainticketbooking.response.ResponseStructure;
import com.irctc.onlinetrainticketbooking.service.UserService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	/*
	 * saveMethod for user
	 */
	@PostMapping("/userSave")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		
		return service.saveUser(user);
	}
	
	/*
	 * userLogin
	 */
	@GetMapping("/loginUser/{userName}/{userPassword}")
	public ResponseStructure<User> loginUser(@PathVariable String userName,@PathVariable String userPassword) {
	
		return service.loginUser(userName, userPassword);
	}
}
