package com.mph.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {

	@Id
	private String emailId;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private int phoneNumber;
	
	//@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	//private List<Task> task;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(String emailId, String userName, String password, int phoneNumber) {
		super();
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	

}
