package com.my.test.MD5;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		byte[] arrayOfByte = b;
		int j = b.length;
		for (int i = 0; i < j; i++) {
			byte aB = arrayOfByte[i];
			resultSb.append(byteToHexString(aB));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static String getSign(Map<String, String> reqMap) {
		String[] keys = reqMap.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		StringBuffer reqStr = new StringBuffer();
		for (String key : keys) {
			String v = reqMap.get(key);
			if (v != null && !v.equals("")) {
				reqStr.append(key).append("=").append(v).append("&");
			}
		}
		return MD5Util.MD5Encode(reqStr.toString()).toUpperCase();
	}

	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(origin.getBytes("UTF-8"));
			resultString = byteArrayToHexString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	public static String MD5Encode(String salt, String origin) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt.getBytes("UTF-8"));
			md.update(origin.getBytes("UTF-8"));
			resultString = byteArrayToHexString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}
	
	public static String MD5Encode(File file) throws NoSuchAlgorithmException, IOException {
		FileInputStream in = new FileInputStream(file);
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer, 0, 1024)) != -1) {
			messageDigest.update(buffer, 0, length);
		}
		BigInteger result = new BigInteger(1, messageDigest.digest());
		return result.toString(16);
	}
	
	public static void main(String[] args) {
		File file = new File("D:\\apache-tomcat-8.5.32-windows-x64.zip");
		try {
			System.out.println(MD5Encode(file));
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}
	
	public static String bytesToMD5(byte[] input) {
		String md5str = null;
		try {
			//创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//计算后获得字节数组
			byte[] buff = md.digest(input);
			//把数组每一字节换成16进制连成md5字符串
			md5str = bytesToHex(buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5str;
	}
	/**
	 * 把字符串转换成md5
	 * @param str
	 * @return
	 */
	public static String strToMD5(String str) {
		byte[] input = str.getBytes();
		
		return bytesToMD5(input);
	}
	
	/**
	 * 把字节数组转成16进位制数
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		//把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			 digital = bytes[i];
			if(digital < 0) {
				digital += 256;
			}
			if(digital < 16){
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString();
	}
}