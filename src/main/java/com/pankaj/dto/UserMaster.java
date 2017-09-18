package com.pankaj.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true)
	private short userId;
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name = "phone", unique = true, nullable = false)
	private String phone;
	private String password;
	@Column(name = "reg_date")
	private Date registrationDate;

	public UserMaster(String userName, String email, String phone, String password) {
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.registrationDate = new Date();
	}

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UserMaster() {

	}

}
