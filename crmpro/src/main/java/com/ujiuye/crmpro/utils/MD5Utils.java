package com.ujiuye.crmpro.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	// ʹ��MD����
	public static String getMD5(String s) {

		// ��ȡ�����ݼ��ܵ��Ǹ�����
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("md5");
			// ʹ��MessageDigest��Դ��ݽ��������ݽ��м���
			byte[] bs = digest.digest(s.getBytes());
			/*
			 * ��������Ҫ�Լ��ܵĽ�������Ż� ʹ��MessageDigest�����ݼ���֮�󣬵õ�����-128��127֮������� ��Ҫ����Щ���ֽ����Ż���
			 * 
			 * ȡ��ÿ�������е����8λ���������֣����������ת��ʮ�����ơ������ʮ�����Ʊ��������� 0000 0000 0000 0000 0000 0000 1110
			 * 1100 & 0000 0000 0000 0000 0000 0000 1111 1111
			 * --------------------------------------------- 0000 0000 0000 0000 0000 0000
			 * 1110 1100
			 * 
			 * ��ת����ʮ���������ݴ洢���������ת��һ���ַ���
			 */
			StringBuilder sb = new StringBuilder();
			for (byte b : bs) {
				// ȡ����ǰ���ֵ����8λ����������
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
