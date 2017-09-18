package com.pankaj.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pankaj.controller.UserMgmtController;
import com.pankaj.dto.UserMaster;
import com.pankaj.exception.CustomException;

public class UserMgmtAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short userId;
	private String userName;
	private String email;
	private String phone;
	private String password;

	public String userRegistration() {
		UserMgmtController um = null;
		try {
			um = new UserMgmtController();
			um.checkAvailability(userName, email, phone);
			short userId = um.userRegistration(userName, email, phone, password);
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("userName", userName);
			session.put("userId", userId);
			return SUCCESS;
		} catch (CustomException ce) {
			ce.printStackTrace();
			return INPUT;
		} catch (Exception ex) {
			ex.printStackTrace();
			return INPUT;
		}
	}

	public String userLogin() {
		try {
			if (userName != null && password != null) {
				UserMaster userMaster = new UserMgmtController().userLogin(userName, password);
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("userName", userMaster.getUserName());
				session.put("userId", userMaster.getUserId());
				System.out.println(session);
			}

		} catch (CustomException cx) {
			System.out.println(cx.getErrorCode() + " , " + cx.getErrorMsg());
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

	public String checkLogin() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("userName") != null && session.get("userId") != null) {
			UserMaster userMaster = new UserMgmtController().checkLogin(session.get("userName"));
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public String forgotPassword() {
		try {
			new UserMgmtController().forgotPassword(email);

		} catch (CustomException ce) {
			ce.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public static void main(String[] args) throws Exception {
		UserMgmtAction uma = new UserMgmtAction();
		uma.setUserName("admin");
		uma.setPassword("password");
		System.out.println(uma.userLogin());
	}
}
