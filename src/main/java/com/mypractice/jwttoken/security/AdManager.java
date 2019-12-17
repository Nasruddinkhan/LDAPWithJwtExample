/**
 * 
 */
package com.mypractice.jwttoken.security;

import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.stereotype.Component;

import com.mypractice.jwttoken.bean.LoginBean;

/**
 * @author NK5050747
 * Dec 3, 2018
 * AdManager
 */
@Component
public final  class AdManager {
	public static boolean authorizedUser(String username, String password) {
		boolean isError = false;
		LdapContext ctx = null;
		Hashtable<String, String> env = null;
		try {
			env = new Hashtable<String, String>();
			env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
			env.put(javax.naming.Context.SECURITY_AUTHENTICATION, "Simple");
			env.put(javax.naming.Context.SECURITY_PRINCIPAL, "directory and username");
			env.put(javax.naming.Context.SECURITY_CREDENTIALS, password);
			env.put(javax.naming.Context.PROVIDER_URL,"ldapserver");
			ctx = new InitialLdapContext(env, null);
			isError =  true;
		} catch (NamingException e) {
			System.out.println("Test.authorizedUser() ["+e.getMessage()+"]");
			isError =  false;
			//throw new RuntimeException(e.getMessage());
		}
		return isError;
	}


}
