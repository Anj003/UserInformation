package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

/*import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;*/
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelInformation1ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Autowired
	UserServiceImpl impl;
	@Autowired
	UserRepository user;
	
	@Test
	void contextLoads() {
		
	}
	
	
	/*
	 * @Test public void saveUsers() {
	 * 
	 * UserModel u=new UserModel(); u.setUserId(1); u.setName("Sai");
	 * u.setEmailId("dsai@gmail.com"); u.setPhNo("9989283678"); u.setAddress("kdr");
	 * u.setUserPass("ker123");
	 * 
	 * 
	 * user.save(u); assertNotNull(user.findById(1).get());
	 * 
	 * }
	 */
	/*
	 * @Test
	 * 
	 * @Order(1) public void getAllUsers() { List<UserModel>list=user.findAll();
	 * assertThat(list).size().isGreaterThan(0); }
	 */
//	@Test
//	@Order(2)
//	public void getSingleUser() {
//		UserModel u=user.findById(1).get();
//	assertEquals("Sai",u.getName());	
//	}
//	
//	@Test
//	@Order(2)
//	public void updateUser() {
//		UserModel um=user.findById(1).get();
//		um.setName("SaiKiran");
//		user.save(um);
//		assertNotEquals("Kiran",user.findById(1).get().getName());
//	}
//	@Test
//	@Order(2)
//	public void deleteUser() {
//		user.deleteById(1);
//		assertThat(user.existsById(1)).isFalse();
//	}

}
