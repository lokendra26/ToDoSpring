package com.mph.service;

import java.util.List;

import com.mph.entity.Users;
/*Lokendra*/
public interface UserService {

	public void createUser(Users user);

	public Users getUser(Users user);

	//public List<Users> updateUser(Users User);
	public Users updateUser(Users User);
	
	
	public Users getUserByEmailId(String emailId);
	
	public List<Users> getAllUser();

}
