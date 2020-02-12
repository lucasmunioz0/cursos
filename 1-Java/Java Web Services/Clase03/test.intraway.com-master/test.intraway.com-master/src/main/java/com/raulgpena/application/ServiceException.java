/*
 * @(#ServiceException.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */


package com.raulgpena.application;


// Springframework imports.
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 *
 *  <p>The class <code>com.raulgpena.application.ServiceException</code> is a base exception
 *  for failures.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     java.lang.RuntimeException
 *  @see     org.springframework.web.bind.annotation.ResponseStatus
 * */
@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceException extends RuntimeException {


    // Constructor declarations.

    /**
     *
     * <p>Constructor declarations without parameters.
     * */
    public ServiceException (String message) {

        // Call to super class.
        super (message);
    }
}