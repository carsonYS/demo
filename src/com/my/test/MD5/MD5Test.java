package com.my.test.MD5;

import java.security.MessageDigest;

import com.sun.mail.util.BASE64EncoderStream;

public class MD5Test {
	public static void main(String[] args) {
		// beb9c1075213efbbf7ccf77b2ec9f3a0
		 System.out.println(MD5("jys20170921","XML19930823"));
	}
	
	private static String MD5(String salt,String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(s.getBytes("utf-8"));
	        md.update(salt.getBytes("utf-8"));
	        
	        byte[] bytes = md.digest();
	        return toHex(bytes);
	    }
	    catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	private static String toHex(byte[] bytes) {

	    final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
	        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
	    }
	    return ret.toString();
	}

}
