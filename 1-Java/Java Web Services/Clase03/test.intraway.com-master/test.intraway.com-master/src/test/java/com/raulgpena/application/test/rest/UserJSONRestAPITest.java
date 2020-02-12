/*
 * @(#UserJSONRestAPITest.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.test.rest;


// Packages and classes to import of jdk 1.8
import java.util.List;
import java.util.Map;

// Packages and classes to import of slf4j api.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Packages and classes to import of springframework 4.x
import org.springframework.http.*;

// Packages and classes to import of spring boot 1.5.x
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

// Packages and classes to import of junit api.
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.skyscreamer.jsonassert.JSONAssert;

// My classes.
import com.raulgpena.application.Application;


/**
 *
 *  <p>The class <code>com.raulgpena.application.test.rest.UserJSONRestAPITest</code> is a integration test
 *  for test the api rest service.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     AbstractRestAPITest
 *  @see     org.junit.runner.RunWith
 *  @see     org.springframework.test.context.junit4.SpringRunner
 *  @see     org.springframework.boot.test.context.SpringBootTest
 * */
@RunWith (SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserJSONRestAPITest extends AbstractRestAPITest {


    // Private instance fields declarations.
    // Port server.
    @LocalServerPort
    private int port;

    // Rest client.
    private TestRestTemplate restTemplate = new TestRestTemplate ();


    // Private class fields declarations.
    // Logger object.
    private static final Logger logger = LoggerFactory.getLogger (UserJSONRestAPITest.class);


    // Public constructor declarations.
    /**
     *
     *  <p>Unique constructor without arguments.
     * */
    public UserJSONRestAPITest() {

        // Call to super class.
        super ();
    }


    // Public instance method declarations.
    /**
     *
     *  <p>Method that test find all users. (OK)
     *
     *  @see Test
     * */
    @Test
    public void testGetAllLikeJsonOK () {


        logger.info ("Starting Test...");
        String  url = SERVER.concat (String.valueOf (this.port)).concat (ENDPOINT_T);

        try {

            // Get credentials.
            logger.debug ("Getting credentials...");
            HttpHeaders headersSecurity = this.getApiKey ("json", url, USER_ADMIN_ROLE, USER_ADMIN_ROLE_P);

            // Execute the query.
            url = SERVER.concat (String.valueOf (this.port)).concat (ENDPOINT_U);
            logger.debug (String.format ("Executing GET request to %s", url));
            HttpEntity<String> entity = new HttpEntity<>(null, headersSecurity);
            ResponseEntity<String> response = restTemplate.exchange (url, HttpMethod.GET, entity, String.class);

            // Check response.
            Assert.assertTrue (String.format ("Http Code Response, is invalid !!! (%d)", response.getStatusCode ().value ()), response.getStatusCode().is2xxSuccessful ());

            String r = response.getBody ();

            List<Map<String, Object>> result =  buildObjects (r);
            Assert.assertNotNull ("Response content is empty!", result);
            Assert.assertFalse ("Response content is empty!", result.isEmpty ());

        } catch (Exception e) {
         /**
           * Catch the problems.
           **/

            logger.error (e.getMessage ());
            Assert.assertNotNull (e);
        }
    }

    /**
     *
     *  <p>Method that test find user by id. (OK)
     *
     *  @see Test
     * */
    @Test
    public void testGetUserByIdLikeJsonOK () {


        logger.info ("Starting Test...");
        String  url = SERVER.concat (String.valueOf (this.port)).concat (ENDPOINT_T);

        try {

            // Get credentials.
            logger.debug ("Getting credentials...");
            HttpHeaders headersSecurity = this.getApiKey ("json", url, USER_ADMIN_ROLE, USER_ADMIN_ROLE_P);

            // Execute the query.
            url = SERVER.concat (String.valueOf (this.port)).concat (ENDPOINT_U.concat ("/10001"));
            logger.debug (String.format ("Executing GET request to %s", url));
            HttpEntity<String> entity = new HttpEntity<>(null, headersSecurity);
            ResponseEntity<String> response = restTemplate.exchange (url, HttpMethod.GET, entity, String.class);

            // Check response.
            Assert.assertTrue (String.format ("Http Code Response, is invalid !!! (%d)", response.getStatusCode ().value ()), response.getStatusCode().is2xxSuccessful ());

            String expected = "{\n" +
                    "    \"id\": 10001,\n" +
                    "    \"userName\": \"msimpson\",\n" +
                    "    \"firstName\": \"Marge\",\n" +
                    "    \"lastName\": \"Simpson\",\n" +
                    "    \"email\": \"msimpson@gmail.com\",\n" +
                    "    \"password\": \"qwerty\",\n" +
                    "    \"phone\": \"+123123124\",\n" +
                    "    \"userStatus\": \"Active\"\n" +
                    "}";

            JSONAssert.assertEquals("Json Invalid!!!", expected, response.getBody(), false);

        } catch (Exception e) {
            /**
             * Catch the problems.
             **/

            logger.error (e.getMessage ());
            Assert.assertNotNull (e);
        }
    }
}