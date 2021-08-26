package com.mph.dao;

import java.util.List;

import com.mph.entity.Users;
/*Mahendra*/
public interface UserDao {
	
	public void createUser(Users user);

	public Users getUser(Users user);

	//public List<Users> updateUser(Users User);
	public Users updateUser(Users User);

	public Users getUserByEmailId(String emailId);

	public List<Users> getAllUser();


}
