package com.offcn.common;

public class SmsCodeUtil {

	
	public static String getCode() {
		String code = (int) (Math.random()*1000000)+"";
		return code;
		
	}
}
