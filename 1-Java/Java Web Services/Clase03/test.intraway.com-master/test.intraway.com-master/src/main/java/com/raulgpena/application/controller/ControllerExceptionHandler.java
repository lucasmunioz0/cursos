/*
 * @(#ControllerExceptionHandler.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.controller;


// JDK 8 Imports.
import java.util.Date;

// Springframework Imports.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// My Classes imports.
import com.raulgpena.application.ServiceException;
import com.raulgpena.application.model.FailureResponse;


/**
 *
 *  <p>The class <code>com.raulgpena.application.controller.ControllerExceptionHandler</code> is a controller
 *  for management the exceptions.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     org.springframework.web.bind.annotation.ControllerAdvice
 *  @see     org.springframework.web.bind.annotation.RestController
 * */
@ControllerAdvice
@RestController
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (ControllerExceptionHandler.class);


    // Constructor declarations.

    /**
     *
     * <p>Constructor declarations without parameters.
     * */
    public ControllerExceptionHandler () {

        // Call to super class.
        super ();
    }


    // Instance methods declarations.

    /**
     *
     *  <p>Method that management the exception executed.
     *
     *
     *  @param ex exception caused.
     *  @param request Request client.
     *  @return Response entity.
     *  @see     org.springframework.web.bind.annotation.ExceptionHandler
     * */
    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<FailureResponse> handleNotFoundException(ServiceException ex, WebRequest request) {


        logger.error (String.format ("Management the failure %s", ex.getMessage ()));
        FailureResponse response = new FailureResponse (new Date(), ex.getMessage (),
                request.getDescription (false), HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase ());

        logger.error (String.format ("Returning the failure response %s", response.getMessage ()));
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
}