package com.mph.dao;

import java.util.List;

import com.mph.entity.Users;

public interface UserDao {
	
	public void createUser(Users user);

	public Users getUser(Users user);

	public Users updateUser(Users User);

	public Users getUserByEmailId(String emailId);


}
