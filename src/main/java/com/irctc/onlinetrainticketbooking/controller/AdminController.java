package com.irctc.onlinetrainticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.onlinetrainticketbooking.dto.Admin;
import com.irctc.onlinetrainticketbooking.response.ResponseStructure;
import com.irctc.onlinetrainticketbooking.service.AdminService;

import jakarta.servlet.http.HttpSession;

/*
 * 
 * @author Mohammad Masood Ansari
 *
 */

@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private ResponseStructure<String> responseStructure;
	
	
	/*
	 * register admin methods where i will register admin details in tables
	 */
	@PostMapping("/registerAdmin")
	public Admin registerAdmin(@RequestBody Admin admin) {
		
		Admin admin2=adminService.registerAdmin(admin);
		
		if(admin2!=null) {
			return admin;
		}else {
			return null;
		}
	}
	
	/*
	 * login Admin with adminName and Password
	 * 
	 */
	@GetMapping("/loginAdmin/{adminName}/{adminPassword}")
	public ResponseStructure<Admin> loginWithAdmin(@PathVariable String adminName,@PathVariable String adminPassword) {
		
		httpSession.setAttribute("password",adminPassword);
		
		return adminService.loginWithAdmin(adminName, adminPassword);
	}
	
	/*
	 * logout admin 
	 */
	@GetMapping(value = "/logoutAdmin")
	public String logoutAdmin(){
		
		if(httpSession.getAttribute("password")!=null) {
			httpSession.invalidate();
			return "Logout successfully";
		}else {
			return "you are not logged in";
		}
	}
}
