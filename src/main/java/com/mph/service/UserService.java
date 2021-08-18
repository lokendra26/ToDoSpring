package com.mph.service;

import java.util.List;

import com.mph.entity.Users;

public interface UserService {

	public void createUser(Users user);

	public Users getUser(Users user);

	public List<Users> updateUser(Users User);

	public Users getUserByEmailId(String emailId);

}
