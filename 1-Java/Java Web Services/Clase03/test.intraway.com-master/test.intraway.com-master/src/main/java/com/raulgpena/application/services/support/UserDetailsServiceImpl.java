/*
 * @(#UserDetailsServiceImpl.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.services.support;


// Packages and classes to import of springframework 4.x
import com.raulgpena.application.model.factory.LoginFactory;
import com.raulgpena.application.repository.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Packages and classes to import of spring security 4.x
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// My Classes.
import com.raulgpena.application.repository.jpa.ILoginRepository;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.services.support.UserDetailsServiceImpl</code> is a service bean
 *     for management user details options.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     org.springframework.stereotype.Service
 *  @see     org.springframework.security.core.userdetails.UserDetailsService
 * */
@Service ("userDetailsServiceBean")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	// Private instance fields declarations.
	// Login repository
    private ILoginRepository loginRepository = null;
  
    
    //Private class fields declarations.
    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (UserDetailsServiceImpl.class);
  
	
	// Public constructor declarations.
	/**
	 * 
	 *  <p>Constructor with parameters.
	 * */
	public UserDetailsServiceImpl () {
		
		// Call to super class.
		super ();
	}
	
	/**
	 * 
	 *  <p>Constructor with parameters.
	 *  
	 *  @param loginRepository Login repository object.
	 * */
	public UserDetailsServiceImpl (ILoginRepository loginRepository) {
		
		// Call to super class.
		super ();
		
		// Set the internal values.
		this.loginRepository = loginRepository;
	}
	
	
	// Public instance method declarations. (Get/Set)
	/**
	 * 
	 *  <p>Method that set the login repository.
	 *  
	 *  @param loginRepository Login repository
	 *  @see   org.springframework.beans.factory.annotation.Autowired
	 * */
	@Autowired
	public void setUserRepository (ILoginRepository loginRepository) {
		
		// Set the value.
		this.loginRepository = loginRepository;
	}
	
	
	// Public instance method declarations extended of org.springframework.security.core.userdetails.UserDetailsService  
    /* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername (java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername (final String username) throws UsernameNotFoundException {
		
		// Method setup.
		logger.debug (String.format ("Finding user ['%s']", username));
		final Login login = this.loginRepository.findByUserName (username);
		

		logger.debug (String.format ("Validating user ['%s']", username));
	    if (login == null) {
	    	
	    	logger.error (String.format ("User ['%s'] not found.", username));
	        throw new UsernameNotFoundException (String.format("No user found with username '%s'.", username));
	        
	    } else {
	    	
	    	logger.debug (String.format ("Creating new user bean model ['%s']", username));
	        return LoginFactory.create (login);
	    }
	}
}