/*
 * @(#User.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.model;


// JDK Imports.
import java.io.Serializable;

// Apache commons Imports.
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Jackson Imports.
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


/**
 *
 *  <p>The class <code>com.raulgpena.application.model.User</code> is a dto for management
 *     the user information.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   12/30/2018
 *  @see     java.io.Serializable
 * */
@JacksonXmlRootElement(localName = "User")
public class User implements Serializable {


    // Properties fields declarations.

    // User id.
    @JacksonXmlProperty (isAttribute = true)
	private Long id;

	// User name.
    @JacksonXmlProperty (isAttribute = true)
	private String userName;

	// User first name.
    @JacksonXmlProperty (isAttribute = true)
	private String firstName;

	// User last name.
    @JacksonXmlProperty (isAttribute = true)
	private String lastName;

	// User email.
    @JacksonXmlProperty (isAttribute = true)
    private String email;

    // User password.
    @JacksonXmlProperty (isAttribute = true)
    private String password;

    // User password.
    @JacksonXmlProperty (isAttribute = true)
    private String phone;

    // User status.
    @JacksonXmlProperty (isAttribute = true)
    private String userStatus;


    // Constructor declarations.

    /**
     *
     * <p>Constructor declarations without parameters.
     * */
	public User () {

	    // Call to super class.
	    super ();
	}

    /**
     *
     * <p>Constructor declarations with parameters.
     *
     * @param id User id.
     * @param userName User name.
     * @param firstName User first name.
     * @param lastName User last name.
     * @param email User email.
     * @param password User password.
     * @param phone User phone.
     * @param userStatus User status.
     * */
	public User (Long id, String userName, String firstName,
                 String lastName, String email, String password,
                 String phone, String userStatus) {

        // Call to super class.
	    super ();

		this.id = id;
		this.userName   = userName;
		this.firstName  = firstName;
		this.lastName   = lastName;
		this.email      = email;
		this.password   = password;
		this.phone      = phone;
		this.userStatus = userStatus;
	}


    // Get/Set methods declarations.

    /**
     *
     *  <p>Method that return the user id.
     *
     *  @return User id.
     */
    public Long getId () {

        // Return the value.
        return this.id;
    }

    /**
     *
     *  <p>Method that set the user id.
     *
     *  @param id User id.
     */
    public void setId (Long id) {

        // Set the value.
	    this.id = id;
    }

    /**
     *
     *  <p>Method that return the user name.
     *
     *  @return User name.
     */
    public String getUserName () {

        // Return value.
	    return this.userName;
    }

    /**
     *
     *  <p>Method that set the user name.
     *
     *  @param userName User name.
     */
    public void setUserName (String userName) {

        // Set value.
        this.userName = userName;
    }

    /**
     *
     *  <p>Method that return the user first name.
     *
     *  @return User first name.
     */
    public String getFirstName () {

        // Return the value.
	    return this.firstName;
    }

    /**
     *
     *  <p>Method that set the user first name.
     *
     *  @param firstName User first name.
     */
    public void setFirstName (String firstName) {

        // Set the value.
	    this.firstName = firstName;
    }

    /**
     *
     *  <p>Method that return the user last name.
     *
     *  @return User last name.
     */
    public String getLastName () {

        // Return the value.
	    return this.lastName;
    }

    /**
     *
     *  <p>Method that set the user last name.
     *
     *  @param lastName User last name.
     */
    public void setLastName (String lastName) {

        // Set the value.
	    this.lastName = lastName;
    }

    /**
     *
     *  <p>Method that return the user email.
     *
     *  @return User email.
     */
    public String getEmail () {

        // Return the value.
	    return this.email;
    }

    /**
     *
     *  <p>Method that set the user email.
     *
     *  @param email User email.
     */
    public void setEmail (String email) {

        // Set the value.
        this.email = email;
    }

    /**
     *
     *  <p>Method that return the user password.
     *
     *  @return User password.
     */
    public String getPassword () {

        // Return the value.
	    return this.password;
    }

    /**
     *
     *  <p>Method that set the user password.
     *
     *  @param password User password.
     */
    public void setPassword (String password) {

        // Set the value.
        this.password = password;
    }

    /**
     *
     *  <p>Method that return the user phone.
     *
     *  @return User phone.
     */
    public String getPhone () {

        // Return the value.
        return this.phone;
    }

    /**
     *
     *  <p>Method that set the user phone.
     *
     *  @param phone User phone.
     */
    public void setPhone (String phone) {

        // Set the value.
	    this.phone = phone;
    }

    /**
     *
     *  <p>Method that return the user status.
     *
     *  @return User status.
     */
    public String getUserStatus () {

        // Return the value.
        return this.userStatus;
    }

    /**
     *
     *  <p>Method that set the user status.
     *
     *  @param userStatus User status.
     */
    public void setUserStatus (String userStatus) {

        // Set the value.
        this.userStatus = userStatus;
    }


    // Methods extended of java lang Object.

    @Override
    public String toString() {

        // Return the value.
        return new ToStringBuilder (this, ToStringStyle.MULTI_LINE_STYLE)
                .append ("id", this.id)
                .append ("userName", this.userName)
                .append ("firstName", this.firstName)
                .append ("lastName", this.lastName)
                .append ("email", this.email)
                .append ("phone", this.phone)
                .toString();
    }
}