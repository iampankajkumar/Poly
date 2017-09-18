package com.pankaj.exception;

public class CustomErrorMessage {

	// related to user details existence
	public static final String PLR_MOBILE_NO_EXIST = "mobile number already exists";
	public static final String PLR_EMAIL_MOBILE_EXIST = "email and mobile already exists";
	public static final String PLR_USER_NAME_EXIST = "username already exists";
	public static final String PLR_EMAIL_EXIST = "email already exist";
	public static final String PLR_USER_NAME_MOBILE_EXIST = "username and mobile number already exists";
	public static final String PLR_USER_NAME_EMAIL_EXIST = "username and email already exists";
	public static final String PLR_USER_NAME_EMAIL_MOBILE_EXIST = "username,email and mobile number already exist";

	// other errors
	public static final String GEN_HIBERNATE_EXCEPTION = "hibernate exception";
	public static final String GEN_SOME_INTERNAL_ERROR = "some internal error";

	public static final String INVALID_USERNAME_OR_PASSWORD = "Invalid user name or password";
	public static final String INCORRECT_EMAIL="Incorrect email address";

}
