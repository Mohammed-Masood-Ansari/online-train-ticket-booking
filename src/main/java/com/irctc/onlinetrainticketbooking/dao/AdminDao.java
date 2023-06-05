package com.irctc.onlinetrainticketbooking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.irctc.onlinetrainticketbooking.dto.Admin;
import com.irctc.onlinetrainticketbooking.repository.AdminRepository;

/*
 * 
 * @author Mohammad Masood Ansari
 *
 *admin Dao is reponsible for all the crud operation of admin class
 *
 */

@Component
@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;
	
	/*
	 * register admin methods where i will register admin details in tables
	 */
	public Admin registerAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	/*
	 * login Admin with adminName and Password
	 * 
	 */
	public Admin loginWithAdmin(String adminName) {
		
		return adminRepository.getByAdminName(adminName);
	}
}
