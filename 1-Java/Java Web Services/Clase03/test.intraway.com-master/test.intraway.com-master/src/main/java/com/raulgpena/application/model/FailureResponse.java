/*
 * @(#FailureResponse.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */


package com.raulgpena.application.model;


// JDK 8 Imports.
import java.io.Serializable;
import java.util.Date;

// Apache commons Imports.
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 *
 *  <p>The class <code>com.raulgpena.application.model.FailureResponse</code> is a model for
 *  the failure responses.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     java.io.Serializable
 * */
public class FailureResponse implements Serializable {


    // Private class fields declarations.

    // Time operation.
    private Date timestamp;

    // Message response.
    private String message;

    // Message detail response.
    private String details;

    // Http code response.
    private String httpCodeMessage;


    // Constructor declarations.

    /**
     *
     * <p>Constructor declarations with parameters.
     *
     * @param timestamp Time.
     * @param message Message response.
     * @param details Message details response.
     * @param httpCodeMessage Http code response.
     *
     * */
    public FailureResponse (Date timestamp, String message, String details,
                            String httpCodeMessage) {

        // Call to super class.
        super ();

        // Set internal values.
        this.timestamp = timestamp;
        this.message   = message;
        this.details   = details;
        this.httpCodeMessage=httpCodeMessage;
    }


    // Get / Set Methods.
    /**
     *
     *  <p>Method that return the http code.
     *
     * @return The http code.
     * */
    public String getHttpCodeMessage () {

        // Return the value.
        return this.httpCodeMessage;
    }

    /**
     *
     *  <p>Method that return the time
     *
     * @return The time
     * */
    public Date getTimestamp () {

        // Return the value.
        return this.timestamp;
    }

    /**
     *
     *  <p>Method that return the message.
     *
     * @return The message
     * */
    public String getMessage () {

        // Return the value.
        return this.message;
    }

    /**
     *
     *  <p>Method that return the details.
     *
     * @return The details
     * */
    public String getDetails () {

        // Return the value.
        return this.details;
    }


    // Methods extended of java lang Object.

    @Override
    public String toString() {

        // Return the value.
        return new ToStringBuilder (this, ToStringStyle.MULTI_LINE_STYLE)
                .append ("details", this.details)
                .append ("httpCodeMessage", this.httpCodeMessage)
                .append ("message", this.message)
                .toString ();
    }
}