/*
 * @(#Application.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application;


// Springframework Imports.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 *  <p>The class <code>com.raulgpena.application.Application</code> is a boot class
 *  for this application.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   12/30/2018
 *  @see     org.springframework.boot.autoconfigure.SpringBootApplication
 * */
@SpringBootApplication
public class Application {


    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (Application.class);


    // Private class methods declarations.
	public static void main(String[] args) {

	    // Start the app.
        logger.info ("Starting the User Rest Service.");
		SpringApplication.run(Application.class, args);
        logger.info ("User Rest Service started !!!");
	}
}
