/*
 * @(#AuthenticationResponse.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.model.json.response;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.model.json.response.AuthenticationResponse</code> is the model for management
 *     the authentication response's information.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 * */
public class AuthenticationResponse {

	
	// Private instance fields declarations.
	// Token
	private String token = null;

	
	// Public constructor declarations.
    /**
     * 
     *  <p>Constructor without parameters.
     * */
	public AuthenticationResponse () {
		
		// Call to super class.
		super ();
	}
    
	/**
     * 
     *  <p>Constructor with parameters.
     *  
     *  @param token token.
     * */
	public AuthenticationResponse (String token) {
		
		// Call to super class.
		super ();
		this.token = token;
	}
    
	
	// Public instance methode declarations.
	/**
	 * 
	 *  <p>Method that return the token.
	 *  
	 *  @return Return the token.
	 */
	public String getToken () {
		
		// Return the value.
		return this.token;
	}

	/**
	 * 
	 *  <p>Method that set the token.
	 *  
	 *  @param token the token.
	 */
	public void setToken (String token) {
		
		// Set the value.
		this.token = token;
	}
}