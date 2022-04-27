package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserService {

	List<UserModel> getAllUsers();

	UserModel getSingleUser(int book_id);

	UserModel saveUser(UserModel obj);

	UserModel updateUser(UserModel obj,int id);

	void deleteUser(int book_id);

	void deleteAllUsers(UserModel user);

}
