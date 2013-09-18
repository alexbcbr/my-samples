package com.fiap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.Control;
import javax.naming.ldap.LdapContext;

public class PesquisarIncluirApp {


	public static DirContext getLDAPDirContext() throws NamingException{
	    final Hashtable envValues = new Hashtable();
	    // Assign the JNDI environment values in Map
	    envValues.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
	    envValues.put(Context.PROVIDER_URL, "ldap://192.168.1.102:389");
	    envValues.put(Context.SECURITY_AUTHENTICATION,"simple");
	    envValues.put(Context.SECURITY_PRINCIPAL,"cn=Manager,dc=desenv,dc=ibm,dc=com"); // specify the username
	    envValues.put(Context.SECURITY_CREDENTIALS,"password");           // specify the password
	    return new InitialDirContext(envValues);

	}
	
	public static void main(String[] args) {
		
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://192.168.1.102:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=desenv,dc=ibm,dc=com");
		env.put(Context.SECURITY_CREDENTIALS, "password");

		Control[] connectionControls = null;
		
		LdapContext ctx;
		DirContext ctxd;
		try {
//			ctx = new InitialLdapContext(env, connectionControls);
			ctxd = PesquisarIncluirApp.getLDAPDirContext();
//			Attributes attrs = ctxd.getAttributes("uid=alexbc,ou=usuarios,dc=desenv,dc=ibm,dc=com");
//			System.out.println("sn: " + attrs.get("cn").get());
			
			//ctxd.destroySubcontext("uid=alexbc,ou=usuarios,dc=desenv,dc=ibm,dc=com");
			
		    Person p = new Person("edsonlo", "Edson", "Oliveira", "edsonlo@desenv.ibm.com");
			ctxd.bind("uid=edsonlo,ou=usuarios,dc=desenv,dc=ibm,dc=com", p);
		
		} catch (NamingException e) {
			e.printStackTrace();
		}

		System.out.println("fim");
	}
}
