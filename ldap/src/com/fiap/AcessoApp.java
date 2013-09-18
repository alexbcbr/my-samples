package com.fiap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.Attributes;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class AcessoApp {

	public static void main(String[] args) {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "uid=thiago,ou=sp,dc=fiapldap,dc=com");
		
		BaseSHA senhac = new BaseSHA();
		env.put(Context.SECURITY_CREDENTIALS, senhac.encriptar("password"));
		//env.put(Context.SECURITY_CREDENTIALS, "password");

		Control[] connectionControls = null;
		try {
			LdapContext ctx = new InitialLdapContext(env, connectionControls);
			Attributes attrs = ctx.getAttributes("uid=felipe,ou=sp,dc=fiapldap,dc=com");
			System.out.println("sn: " + attrs.get("cn").get());
			
			byte[] senha = (byte[])attrs.get("userPassword").get();
			String senhan = new String(senha);
			System.out.println("senha: " + senhan);
			System.out.println(senhac.encriptar("password"));
			
			if (attrs.get("userPassword").get().equals(senhac.encriptar("password"))) System.out.println("ok");
			else System.out.println("erro");
			
			System.out.println("fim");
			ctx.close();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
