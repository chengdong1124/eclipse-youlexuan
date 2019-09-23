package com.ujiuye.crmpro.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	// 使用MD加密
	public static String getMD5(String s) {

		// 获取对数据加密的那个对象
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("md5");
			// 使用MessageDigest类对传递进来的数据进行加密
			byte[] bs = digest.digest(s.getBytes());
			/*
			 * 开发中需要对加密的结果进行优化 使用MessageDigest对数据加密之后，得到的是-128到127之间的数字 需要对这些数字进行优化。
			 * 
			 * 取出每个数字中的最低8位二进制数字，将这个数字转成十六进制。把这个十六进制保存起来。 0000 0000 0000 0000 0000 0000 1110
			 * 1100 & 0000 0000 0000 0000 0000 0000 1111 1111
			 * --------------------------------------------- 0000 0000 0000 0000 0000 0000
			 * 1110 1100
			 * 
			 * 将转后后的十六进制数据存储起来，最后转成一个字符串
			 */
			StringBuilder sb = new StringBuilder();
			for (byte b : bs) {
				// 取出当前数字的最低8位二进制数字
				int x = b & 255;
				String s2 = Integer.toHexString(x);
				if (x >= 0 && x <= 15) {
					sb.append("0");
					sb.append(s2);
				} else {
					sb.append(s2);
				}
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
