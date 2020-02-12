/*
 * @(#IUserRepository.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.repository.jpa;


// Springframework Imports.
import org.springframework.stereotype.Repository;

// Spring Data Imports.
import org.springframework.data.jpa.repository.JpaRepository;

// Our Classes.
import com.raulgpena.application.repository.entity.User;


/**
 *
 *  <p>The abstract class <code>com.raulgpena.application.repository.jpa.IUserRepository</code> is a interface
 *  that define the CRUD operations.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   12/30/2018
 *  @see     org.springframework.stereotype.Repository
 * */
@Repository
public interface IUserRepository extends JpaRepository<User, Long>{


    // Methods declarations.
}