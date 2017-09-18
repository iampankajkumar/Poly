package com.pankaj.exception;

public class CustomErrorCode {

	// related to user details existence
	public static final int PLR_MOBILE_NO_EXIST = 101;
	public static final int PLR_EMAIL_MOBILE_EXIST = 102;
	public static final int PLR_USER_NAME_EXIST = 103;
	public static final int PLR_EMAIL_EXIST = 104;
	public static final int PLR_USER_NAME_MOBILE_EXIST = 105;
	public static final int PLR_USER_NAME_EMAIL_EXIST = 106;
	public static final int PLR_USER_NAME_EMAIL_MOBILE_EXIST = 107;

	// other errors
	public static final int GEN_HIBERNATE_EXCEPTION = 301;
	public static final int GEN_SOME_INTERNAL_ERROR = 302;

	public static final int INVALID_USERNAME_OR_PASSWORD = 108;
	public static final int INCORRECT_EMAIL = 109;

}
