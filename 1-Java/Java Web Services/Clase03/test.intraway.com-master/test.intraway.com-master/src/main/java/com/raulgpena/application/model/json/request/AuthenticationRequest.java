/*
 * @(#AuthenticationRequest.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.model.json.request;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.model.json.request.AuthenticationRequest</code> is the model for management
 *     the authentication request's information.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 * */
public class AuthenticationRequest {

	
	// Private instance fields declarations.
	// User name.
	private String username = null;
	
	// User password.
	private String password = null;
	
	
	// Public constructor declarations.
    /**
     * 
     *  <p>Constructor without parameters.
     * */
	public AuthenticationRequest () {
		
		// Call to super class.
		super ();
	}

	/**
     * 
     *  <p>Constructor with parameters.
     *  
     *  @param username user name.
     *  @param password password.
     * */
	public AuthenticationRequest (String username, String password) {
		
		// Call to super class.
		super ();
		
		// Set the internal values.
		this.username = username;
		this.password = password;
	}
	
	
	// Public instance method declarations.
    /**
     * 
     *  <p>Method that return the user name.
     *  
     *  @return The user name.
     * */
	public String getUsername () {
		
		// Return the value.
		return this.username;
	}

	/**
     * 
     *  <p>Method that set the user name.
     *  
     *  @param username The user name.
     * */
	public void setUsername (String username) {
		
		// Set the value.
		this.username = username;
	}

	/**
     * 
     *  <p>Method that return the user password.
     *  
     *  @return The user password.
     * */
	public String getPassword () {
		
		// Return the value.
		return this.password;
	}

	/**
     * 
     *  <p>Method that set the user password.
     *  
     *  @param password The user password.
     * */
	public void setPassword (String password) {
		
		// Set the value.
		this.password = password;
	}
}