/*
 * @(#CorsFilter.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.configuration;


// Packages and classes to import of jdk 1.8
import java.io.IOException;

// Packages and classes to import of J2EE.
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

// Packages and classes to import of springframework 4.x
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.configuration.CorsFilter</code> is a web component (filter)
 *     for management the CORS operations.
 *     
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2018
 *  @see     javax.servlet.Filter
 * */
@Component
public class CorsFilter implements Filter {
	
	
	// Private instance fields declarations.
	// Token header.
    private String tokenHeader = null;


    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (CorsFilter.class);
    
    
    // Public constructor declarations.
    /**
     * 
     *  <p>Constructor declarations without parameters.
     * */
    public CorsFilter () {
    	
    	// Call to super class.
    	super ();
    }
    
    /**
     * 
     *  <p>Constructor declarations with parameters.
     *  
     *  @param tokenHeader token header.
     * */
    public CorsFilter (String tokenHeader) {
    	
    	// Call to super class.
    	super ();
    }
    
    
    // Public instance methods declarations. (Get/Set)
    /**
     * 
     *  <p>Method that set the token header.
     *  
     *  @param tokenHeader Token header.
     *  @see   org.springframework.beans.factory.annotation.Value
     * */
    @Value ("${api.security.token.header}")
    public void setTokenHeader (String tokenHeader) {
    	
    	// Set the value.
    	this.tokenHeader = tokenHeader;
    }

	
	// Public instance methods declarations extended of javax.servlet.Filter.
    /* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy ()
	 */
	@Override
	public void destroy () { }
    
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter (javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter (ServletRequest req, ServletResponse res, FilterChain fil) throws IOException, ServletException {
		
		// Method setup.
		logger.debug ("Adding CORS headers...");
		HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader ("Access-Control-Allow-Origin", "*");
	    response.setHeader ("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
	    response.setHeader ("Access-Control-Max-Age", "3600");
	    response.setHeader ("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, X-API-TYPE, " + tokenHeader);
	    logger.debug ("CORS headers added...");
	    fil.doFilter (req, res);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init (javax.servlet.FilterConfig)
	 */
	@Override
	public void init (FilterConfig config) throws ServletException { }
}