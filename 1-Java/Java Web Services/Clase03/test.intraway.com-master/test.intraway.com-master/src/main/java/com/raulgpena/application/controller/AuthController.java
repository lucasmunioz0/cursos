/*
 * @(#AuthController.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */


package com.raulgpena.application.controller;


// Packages and classes to import of J2EE.
import javax.annotation.Resource;

// Packages and classes to import of springframework 4.x
import com.raulgpena.application.model.json.request.AuthenticationRequest;
import com.raulgpena.application.model.json.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Packages and classes to import of spring mobile.
import org.springframework.mobile.device.Device;

// Packages and classes to import of spring security 4.x
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

// Packages and classes to import of slf4j.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//My Classes.
import com.raulgpena.application.security.ISecurityService;
import com.raulgpena.application.security.TokenUtils;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.controller.AuthController</code> is a component
 *     of spring MVC for management http operations over security resources.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     RestController
 *  @see     RequestMapping
 * */
@RestController
@RequestMapping ("auth")
public class AuthController {


	// Private instance fields declarations.
	// Token header.
    @Value("${api.security.token.header}")
    private String tokenHeader;

    // Authentication manager.
    private AuthenticationManager authenticationManager;

    // Token service.
    private TokenUtils tokenUtils;

    // User detail service.
    private UserDetailsService userDetailsService;

    // Security service.
    private ISecurityService securityService;


	// Private class fields declarations.
	// Logger object.
	private static final Logger logger = LoggerFactory.getLogger (AuthController.class);


    // Public constructor declarations.
    /**
 	 *
 	 *  <p>Constructor without parameters.
 	 * */
 	public AuthController () {

 	// Call to super class.
 		super ();
 	}

 	/**
 	 *
 	 *  <p>Constructor with parameters.
 	 *
 	 *  @param authenticationManager Authentication manager
 	 *  @param tokenUtils Token service.
 	 *  @param userDetailsService User detail service.
 	 * */
 	public AuthController (AuthenticationManager authenticationManager, TokenUtils tokenUtils, UserDetailsService userDetailsService) {

 		// Call to super class.
 		super ();

 		// Set the internal values.
 		this.authenticationManager = authenticationManager;
 		this.tokenUtils = tokenUtils;
 		this.userDetailsService = userDetailsService;
 	}


 	// Public instance methods declarations. (Get/Set)
 	/**
 	 *
 	 *  <p>Method that set the user detail service.
 	 *
 	 *  @param userDetailsService security service component.
 	 *  @see   UserDetailsService
 	 *  @see   javax.annotation.Resource
 	 * */
 	@Resource
 	public void setUserDetailsService (UserDetailsService userDetailsService) {

 		// Set the value.
 		this.userDetailsService = userDetailsService;
 	}

 	/**
 	 *
 	 *  <p>Method that set the token utils.
 	 *
 	 *  @param tokenUtils token utils.
 	 *  @see   TokenUtils
 	 *  @see   Autowired
 	 * */
 	@Autowired
 	public void setTokenUtils (TokenUtils tokenUtils) {

 		// Set the value.
 		this.tokenUtils = tokenUtils;
 	}

 	/**
 	 *
 	 *  <p>Method that set the authentication manager.
 	 *
 	 *  @param authenticationManager Authentication manager.
 	 *  @see   TokenUtils
 	 *  @see   Autowired
 	 * */
 	@Autowired
 	public void setAuthenticationManager (AuthenticationManager authenticationManager) {

 		// Set the value.
 		this.authenticationManager = authenticationManager;
 	}


    // Public instance method declarations.
    /**
     *
     *  <p>Method for authenticate a user.
     *
     *  @param authenticationRequest authentication request.
     *  @param device Device.
     *  @see RequestMapping
     *  @see RequestBody
     *
     * */
    @RequestMapping (method = RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE},
            									  consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticationRequest (@RequestBody AuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

    	// Perform the authentication
    	logger.info (String.format ("Authenticating user %s", authenticationRequest.getUsername ()));
    	Authentication authentication = this.authenticationManager.authenticate (

    			new UsernamePasswordAuthenticationToken (authenticationRequest.getUsername (),
                                                         authenticationRequest.getPassword())
        );

    	logger.info (String.format ("Set security context for  %s", authenticationRequest.getUsername ()));
    	SecurityContextHolder.getContext ().setAuthentication (authentication);

    	// Reload password post-authentication so we can generate token.
    	logger.debug (String.format ("Reload password post-authentication so we can generate token to %s", authenticationRequest.getUsername ()));
    	UserDetails userDetails = this.userDetailsService.loadUserByUsername (authenticationRequest.getUsername ());

    	logger.info (String.format ("Building token to %s", authenticationRequest.getUsername ()));
    	String token = this.tokenUtils.generateToken(userDetails, device);
    	logger.debug (String.format ("Token built to %s", token));


        // Return the token
        return ResponseEntity.ok (new AuthenticationResponse(token));
    }
}