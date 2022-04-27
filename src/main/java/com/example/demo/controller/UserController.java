package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.UserNotfoundException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserServiceImpl userObj;
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/One")
	public String getUserWithBooking() {
		//return "from UserOne";
		
		String booking=restTemplate.getForObject("http://BOOKING-MICROSERVICE/HotelBooking/getBookingById?id=2",String.class);
		return booking;
	}
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserModel>> getAllUsers(){
		List<UserModel> list = userObj.getAllUsers();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	

	@GetMapping("/getUserById")
	public ResponseEntity<UserModel> getSingleUser(@PathVariable("id") int id) {
		UserModel user = userObj.getSingleUser(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}

	@PostMapping("/addUser")
	public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
		UserModel model = null;
		try {
			model = this.userObj.saveUser(user);
			System.out.println(user.getUserId()+"has been successfully inserted");
			return ResponseEntity.of(Optional.of(model));
			//return ResponseEntity<String>(user.getUserId() + "has been inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/deleteUserById")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		try {
			this.userObj.deleteUser(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/updateUserById")
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user, @PathVariable("id") int id) {
		try {
			this.userObj.updateUser(user, id);
			user.setUserId(id);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
