package com.pankaj.util;

import com.google.gson.Gson;

import sun.misc.BASE64Encoder;

public class Utility {

	public String convertJSON(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static String byteStreamToFile(byte[] bFile, String fileContentType) {
		// BASE64Encoder base64Encoder = new BASE64Encoder();
		StringBuilder imageString = new StringBuilder();
		// imageString.append("data:image/png;base64,");
		imageString.append("data:");
		imageString.append(fileContentType);
		imageString.append(";base64,");
		imageString.append(new BASE64Encoder().encode(bFile));
		return imageString.toString();
	}
}
