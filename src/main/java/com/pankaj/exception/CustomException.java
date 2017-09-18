package com.pankaj.exception;

public class CustomException extends Exception {

	private int errorCode;
	private String errorMsg;
	public CustomException(int errorCode, String errorMsg) {
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
	}

	public CustomException(String genHibernateException, Throwable genHibernateException2) {
		// TODO Auto-generated constructor stub
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
