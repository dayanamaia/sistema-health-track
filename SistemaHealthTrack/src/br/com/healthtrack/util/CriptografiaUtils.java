package br.com.healthtrack.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtils {
	public static String criptografar(String senha) throws Exception {
		MessageDigest md= MessageDigest.getInstance("MD5");
		
		md.update(senha.getBytes("ISO-8859-1"));
		
		BigInteger hash = new BigInteger(1, md.digest());
		
		return hash.toString(16);
	}
}
