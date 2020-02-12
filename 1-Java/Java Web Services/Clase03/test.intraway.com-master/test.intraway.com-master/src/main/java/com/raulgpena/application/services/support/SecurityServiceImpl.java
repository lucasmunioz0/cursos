/*
 * @(#SecurityServiceImpl.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.services.support;


// Packages and classes t import of jdk 1.8
import java.util.Collection;

//Packages and classes to import of springframewrok 4.x
import com.raulgpena.application.security.ISecurityService;
import org.springframework.stereotype.Service;

// Packages and classes to import of spring security 4.x
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.services.support.SecurityServiceImpl</code> is a service bean
 *     for management security options.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     org.springframework.stereotype.Service
 *  @see     ISecurityService
 * */
@Service ("securityServiceBean")
public class SecurityServiceImpl implements ISecurityService {


    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (SecurityServiceImpl.class);
	
 	
	// Public constructor declarations.
	/**
	 * 
	 *  <p>Constructor without parameters.
	 * */
	public SecurityServiceImpl () {
		
		// Call to super class.
		super ();
	}
	

	// Public instance methods declarations.
	/* (non-Javadoc)
	 */
	@Override
	public Boolean hasProtectedAccess () {
		
		// Checking authorities.
		final Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext ().getAuthentication ().getAuthorities ();
        logger.debug (String.format ("Checking authorities [%s]", authorities.toString ()));
		return (authorities.contains (new SimpleGrantedAuthority ("ADMIN")));
	}
}