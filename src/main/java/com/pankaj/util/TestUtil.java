package com.pankaj.util;

import com.pankaj.controller.UserMgmtController;
import com.pankaj.exception.CustomException;

public class TestUtil {
	public static void main(String arg[]){
		System.out.println();
		try {
			new UserMgmtController().checkAvailability("8010215968","mail7@mail.com","8010215968");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getErrorCode()+"\n"+e.getErrorMsg());
		}
	}

}
