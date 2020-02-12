/*
 * @(#UserXMLRestAPITest.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.test.services;


// Packages and classes to import of jdk 1.8

import com.raulgpena.application.Application;
import com.raulgpena.application.model.User;
import com.raulgpena.application.services.IUserService;
import com.raulgpena.application.test.rest.AbstractRestAPITest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.xmlunit.matchers.CompareMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Packages and classes to import of slf4j api.
// Packages and classes to import of springframework 4.x
// Packages and classes to import of spring boot 1.5.x
// Packages and classes to import of junit api.
// My classes.


/**
 *
 *  <p>The class <code>com.raulgpena.application.test.services.ServiceTest</code> is a integration test
 *  for user service.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     RunWith
 *  @see     SpringRunner
 *  @see     SpringBootTest
 *  @see     FixMethodOrder
 * */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
@RunWith (SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {


    // Private instance fields declarations.

    // User service.
    @Autowired
    private IUserService<User, Long> service;


    // Private class fields declarations.
    // Logger object.
    private static final Logger logger = LoggerFactory.getLogger (ServiceTest.class);


    // Public constructor declarations.
    /**
     *
     *  <p>Unique constructor without arguments.
     * */
    public ServiceTest() {

        // Call to super class.
        super ();
    }


    // Public instance method declarations.
    /**
     *
     *  <p>Method that test the create user service. (OK)
     *
     *  @see Test
     * */
    @Test
    public void testACreate () {

        // Create new user.
        User us = new User ();
        us.setFirstName ("Raul");
        us.setLastName ("Pena");
        us.setEmail ("raul.pena@hotmail.com");
        us.setPassword ("ytrewq");
        us.setPhone ("+549111111111");
        us.setUserName ("raul.pena");
        us.setUserStatus ("Enabled");

        // Save the user.
        this.service.create (us);

        // Check the new user.
        Assert.assertTrue ("Problems creating the new user!", us.getId () > 0);
    }

    /**
     *
     *  <p>Method that test the create user service. (KO)
     *
     *  @see Test
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testACreateFail () {

        // Save the user.
        this.service.create (null);
    }

    /**
     *
     *  <p>Method that test the find all users service. (OK)
     *
     *  @see Test
     * */
    @Test
    public void testBReadAll () {

        // Get all users.
        List<User> list = this.service.findAll ();

        // Check the list
        Assert.assertFalse ("User list is empty !!!", list.isEmpty ());
    }

    /**
     *
     *  <p>Method that test the find a user by id service. (OK)
     *
     *  @see Test
     * */
    @Test
    public void testCReadById () {

        // Get a user.
        User us = this.service.findById (Long.valueOf (10001));

        // Check the user.
        Assert.assertNotNull ("User not found!!!", us);
    }

    /**
     *
     *  <p>Method that test the delete user by id service. (OK)
     *
     *  @see Test
     * */
    @Test
    public void testDDelete () {

        // Delete a user.
        this.service.delete (Long.valueOf (10001));

        // Get a user.
        User us = this.service.findById (Long.valueOf (10001));

        // Check the user.
        Assert.assertNull ("User was found!!!", us);
    }
}