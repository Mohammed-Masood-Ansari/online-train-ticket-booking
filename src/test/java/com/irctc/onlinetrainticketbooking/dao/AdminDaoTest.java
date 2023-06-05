package com.irctc.onlinetrainticketbooking.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.irctc.onlinetrainticketbooking.dto.Admin;
import com.irctc.onlinetrainticketbooking.repository.AdminRepository;

import junit.framework.Assert;

@DataJpaTest
class AdminDaoTest {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	@Qualifier
	@MockBean
	private AdminDao adminDao;
	
	@BeforeEach
	void test() {
		
		Admin admin = new Admin(123,"mayur","mayur@12");
		adminRepository.save(admin);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSaveAdmin() {
		
		Admin admin=adminRepository.getByAdminName("mayur");
		
		Assert.assertEquals("mayur",admin.getAdminName());
	}
	
	@Test
	public void testAdminLogin() {
		
		Admin admin=adminDao.loginWithAdmin("mayur");
		
		Assert.assertEquals("mayur@12", admin.getAdminPassword());
	}
	
	
}
