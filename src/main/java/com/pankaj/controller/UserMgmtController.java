package com.pankaj.controller;

import com.pankaj.dao.UserMgmtDao;
import com.pankaj.dto.UserMaster;
import com.pankaj.exception.CustomException;

public class UserMgmtController {

	public short userRegistration(String userName, String email, String phone, String password) {
		short userId = 0;
		try {
			UserMaster userMaster = new UserMaster(userName, email, phone, password);
			userId = new UserMgmtDao().registerUser(userMaster);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

	public void checkAvailability(String userName, String email, String phone) throws CustomException {
		new UserMgmtDao().checkAvailability(userName, email, phone);
	}

	public UserMaster userLogin(String userName, String password) throws CustomException {
		return new UserMgmtDao().userLogin(userName, password);
	}

	public void forgotPassword(String email) throws CustomException {
		new UserMgmtDao().forgotPassword(email);
	}

	public static void main(String[] args) {
		short x = new UserMgmtController().userRegistration("pankaj125", "mail2.com", "12345680", "12345680");
		System.out.println(x);
	}

	public UserMaster checkLogin(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
