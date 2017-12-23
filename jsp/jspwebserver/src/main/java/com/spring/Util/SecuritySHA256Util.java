package com.spring.Util;

import java.security.MessageDigest;

public class SecuritySHA256Util {
	
	public String encryptSHA256(String s)
	{
		String sha = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(s.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<byteData.length; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			sha = sb.toString();
		}catch (Exception e) {
			// TODO: handle exception
			sha = null;
		}
		
		return sha;
	}
}
