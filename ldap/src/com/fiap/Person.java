package com.fiap;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameNotFoundException;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class Person implements DirContext {
	
	 protected Attributes myAttrs;
	
	public Person(String uid, String cn, String sn,String mail) {

		myAttrs = new BasicAttributes(true);  //Basic Attributes
	    Attribute objectClass = new BasicAttribute("objectClass"); //Adding Object Classes
	    
	    objectClass.add("inetOrgPerson");
	    objectClass.add("organizationalPerson");
	    objectClass.add("person");
	    objectClass.add("top");

	    Attribute ouSet = new BasicAttribute("ou");
	    ouSet.add("usuarios");
	    //ouSet.add(ou);
	   
	    myAttrs.put(objectClass);
	    myAttrs.put(ouSet);
	    myAttrs.put("uid",uid);
   	    myAttrs.put("cn",cn);
	    myAttrs.put("sn",sn);
	    myAttrs.put("mail",mail);
	    myAttrs.put("userPassword","password");
	    
	}
	

	@Override
	public void bind(Name name, Object obj, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void bind(String name, Object obj, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public DirContext createSubcontext(Name name, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirContext createSubcontext(String name, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attributes getAttributes(Name name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attributes getAttributes(String name) throws NamingException {
		if (! name.equals("")) {
    	    throw new NameNotFoundException();
    	}
    	return myAttrs;
	}

	@Override
	public Attributes getAttributes(Name name, String[] attrIds)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attributes getAttributes(String name, String[] attrIds)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirContext getSchema(Name name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirContext getSchema(String name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirContext getSchemaClassDefinition(Name name)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirContext getSchemaClassDefinition(String name)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyAttributes(Name name, ModificationItem[] mods)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyAttributes(String name, ModificationItem[] mods)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyAttributes(Name name, int modOp, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyAttributes(String name, int modOp, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rebind(Name name, Object obj, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rebind(String name, Object obj, Attributes attrs)
			throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public NamingEnumeration<SearchResult> search(Name name,
			Attributes matchingAttributes) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(String name,
			Attributes matchingAttributes) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(Name name,
			Attributes matchingAttributes, String[] attributesToReturn)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(String name,
			Attributes matchingAttributes, String[] attributesToReturn)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(Name name, String filter,
			SearchControls cons) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(String name, String filter,
			SearchControls cons) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(Name name, String filterExpr,
			Object[] filterArgs, SearchControls cons) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<SearchResult> search(String name,
			String filterExpr, Object[] filterArgs, SearchControls cons)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object addToEnvironment(String propName, Object propVal)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bind(Name name, Object obj) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void bind(String name, Object obj) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Name composeName(Name name, Name prefix) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String composeName(String name, String prefix)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context createSubcontext(Name name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Context createSubcontext(String name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroySubcontext(Name name) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroySubcontext(String name) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Hashtable<?, ?> getEnvironment() throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameInNamespace() throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NameParser getNameParser(Name name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NameParser getNameParser(String name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<NameClassPair> list(Name name)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<NameClassPair> list(String name)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<Binding> listBindings(Name name)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamingEnumeration<Binding> listBindings(String name)
			throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object lookup(Name name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object lookup(String name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object lookupLink(Name name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object lookupLink(String name) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rebind(Name name, Object obj) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rebind(String name, Object obj) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object removeFromEnvironment(String propName) throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rename(Name oldName, Name newName) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rename(String oldName, String newName) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void unbind(Name name) throws NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void unbind(String name) throws NamingException {
		// TODO Auto-generated method stub

	}

}
