/*
 * @(#ISecurityService.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.security;



/**
 * 
 *  <p>The abstract class <code>com.raulgpena.application.security.ISecurityService</code> is a interface that
 *     define security options.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 * */
public interface ISecurityService {

	
	// Method declarations.
	/**
	 * 
	 *  <p>Method that check if a role has permissions.
	 *  
	 *  @return Boolean that indicate if the operation has permissions.
	 * */
    Boolean hasProtectedAccess ();
}