package com.example.demo.serviceImpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository UserRepo;

	@Override
	public List<UserModel> getAllUsers() {
		return UserRepo.findAll();
	}

//	@Override
//	public UserModel getSingleUser(int id) {
//		return UserRepo.findById(id).get();
//	}

	@Override
	public UserModel saveUser(UserModel obj) {
		return UserRepo.save(obj);
	}

	@Override
	public UserModel updateUser(UserModel obj,int id) {
		return UserRepo.save(obj);
	}

	@Override
	public void deleteUser(int id) {
		UserRepo.deleteById(id);

	}
	
	public UserModel getSingleUser(int id) {
		UserModel user=null;
		List<UserModel> list=new ArrayList<>();
		user=list.stream().filter(e->e.getUserId()==id).findFirst().get();
		return user;
	}
@Override
public void deleteAllUsers(UserModel user) {
	UserRepo.deleteAll();
}

}
