package com.fiap;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BaseSHA {

	public static void main(String[] args) {
		BaseSHA sha = new BaseSHA();
		System.out.println(sha.encriptar("password"));
	}
	
	public String encriptar(String palavra){
		String senhaCriptografada = null;
		try{  
			MessageDigest md = MessageDigest.getInstance("MD5");//MD5 ou SHA  
			byte[] buf = palavra.getBytes();  
			md.update(buf);
			
			byte[] digest = md.digest();  
			senhaCriptografada = new String(digest);  
			
		} catch(NoSuchAlgorithmException nsae){  
			System.out.println("Exceção: "+ nsae);  
		}
		return senhaCriptografada;
	}  
}
