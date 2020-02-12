/*
 * @(#ILoginRepository.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.repository.jpa;


// Springframework Imports.
import org.springframework.stereotype.Repository;

// Packages and classes to import of spring data 4.x
import org.springframework.data.jpa.repository.JpaRepository;

// My Classes.
import com.raulgpena.application.repository.entity.Login;


/**
 * 
 *  <p>The abstract class <code>com.raulgpena.application.repository.jpa.IUserRepository</code> is a interface for define
 *     the CRUD operations for login entity.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     org.springframework.data.jpa.repository.JpaRepository
 *  @see     com.raulgpena.application.repository.entity.Login
 *  @see     org.springframework.stereotype.Repository
 * */
@Repository
public interface ILoginRepository extends JpaRepository<Login, Long> {

	
	// Method declarations.
	/**
	 * 
	 *  <p>Method that find a user by user name.
	 *  
	 *  @param username User name
	 *  @return User name object.
	 * */
    Login findByUserName (String username);
}