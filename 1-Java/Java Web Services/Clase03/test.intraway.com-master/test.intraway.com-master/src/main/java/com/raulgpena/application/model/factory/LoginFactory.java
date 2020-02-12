/*
 * @(#LoginFactory.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.model.factory;


// Packages and classes to import of jdk 1.8
import java.util.Collection;

// Packages and classes to import of spring security 4.x
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

// My Classes to import.
import com.raulgpena.application.model.UserModel;
import com.raulgpena.application.repository.entity.Login;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.model.factory.LoginFactory</code> is a factory object
 *     for create login's beans.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 * */
public class LoginFactory {
	
	
	// Private constructors declarations.
	/*
	 * 
	 *  <p>Unique constructor without parameters.
	 * */
	private LoginFactory() {
		
		// Call to super class;
		super ();
	}
	
	
	// Public classes methods declarations.
	/**
	 * 
	 *  <p>Method that create a new user bean.
	 *  
	 *  @param login User entity object.
	 *  @return User model bean.
	 * */
    public static UserModel create (Login login) {
        
    	// Method setup.
    	// Authorities.
    	Collection<? extends GrantedAuthority> authorities;
    	
    	
    	try {
            
    		// Get the authorities.
    		authorities = AuthorityUtils.commaSeparatedStringToAuthorityList (login.getAuthorities ());
        } catch (Exception e) {
        /*
         * Catch the problems. 
         * */
        	authorities = null;
        }
    	
    	
    	// Return the new model.
        return new UserModel (login.getId (),
                              login.getUserName (),
                              login.getPassword (),
                              login.getEmail (),
                              login.getLastPasswordReset (),
                              authorities);
    }
}