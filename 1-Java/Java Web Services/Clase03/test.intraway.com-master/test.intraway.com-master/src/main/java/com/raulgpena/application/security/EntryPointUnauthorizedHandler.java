/*
 * @(#EntryPointUnauthorizedHandler.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.security;


// Package and classes to import of jdk 1.8
import java.io.IOException;

// Package and classes to import of J2EE
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Package and classes to import of springframework 4.x
import org.springframework.stereotype.Component;

// Package and classes to import of spring security 4.x
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.security.EntryPointUnauthorizedHandler</code> is spring bean
 *     for management unauthorized request.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     org.springframework.stereotype.Component
 *  @see     org.springframework.security.web.AuthenticationEntryPoint
 * */
@Component ("entryPointUnauthorizedHandlerBean")
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
	
	
	// Private class fields declarations.
    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (EntryPointUnauthorizedHandler.class);
	
	
	// Public constructor declarations.
    /**
     * 
     *  <p>Unique constructor without parameters.
     * */
    public EntryPointUnauthorizedHandler () {
    	
    	// Call to super class.
    	super ();
    }


    // Public instance method declarations extended of org.springframework.security.web.AuthenticationEntryPoint.
	/* (non-Javadoc)
	 * @see org.springframework.security.web.AuthenticationEntryPoint#commence (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void commence (HttpServletRequest req, HttpServletResponse res, AuthenticationException ex) throws IOException, ServletException {
        
		// Method setup.
		logger.error (String.format ("Access Denied to '%s'", res.toString ()));
		res.sendError (HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
	}
}