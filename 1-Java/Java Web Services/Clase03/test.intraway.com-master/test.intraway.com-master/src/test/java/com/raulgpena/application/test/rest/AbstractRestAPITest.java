/*
 * @(#UserJSONRestAPITest.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.test.rest;


// Packages and classes to import of jdk 1.8
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

// Packages and classes to import of jackson api.
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// Packages and classes to import of gson api.
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// Packages and classes to import of slf4j api.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Packages and classes to import of spring boot 1.5.x
import org.springframework.boot.test.web.client.TestRestTemplate;

// Packages and classes to import of springframework 4.x
import org.springframework.http.*;



/**
 *
 *  <p>The class <code>com.raulgpena.application.test.rest.AbstractRestAPITest</code> is a base class for integration test
 *  rest service.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 * */
public abstract class AbstractRestAPITest {


    // Private instance fields declarations.
    // Rest client.
    private TestRestTemplate restTemplate = new TestRestTemplate ();


    // Private class fields declarations.

    // Logger object.
    private static final Logger logger = LoggerFactory.getLogger (AbstractRestAPITest.class);


    // Protected class fields declarations.
    // Server.
    protected static final String   SERVER = "http://localhost:";
    protected static final String ENDPOINT_T = "/api/auth";
    protected static final String ENDPOINT_U = "/api/users";

    // User admin role.
    protected static final String   USER_ADMIN_ROLE = "admin";
    protected static final String USER_ADMIN_ROLE_P = "qwerty";

    // User role.
    protected static final String       USER_ROLE = "raulgpena";
    protected static final String     USER_ROLE_P = "qwerty";


    // Public constructor declarations.
    /**
     *
     *  <p>Unique constructor without arguments.
     * */
    public AbstractRestAPITest () {

        // Call to super class.
        super ();
    }


    // Private instance method declarations.
    /**
     *
     *  <p>Method that build the string json response to object array.
     *
     *  @param src Source
     *  @return Array object.
     **/
    protected List<Map<String, Object>> buildObjects (String src) {


        List<Map<String, Object>> list;

        Gson gson = new Gson();
        Type typeOfList = new TypeToken<List<Map<String, Object>>>() {}.getType();
        list = gson.fromJson (src, typeOfList);

        return list;
    }

    /**
     *
     *  <p>Method that set the initial values for execute the test.
     *
     *  @param url Endpoint.
     *  @param user User.
     *  @param pw password.
     *  @return Http headers.
     **/
    protected HttpHeaders getApiKey (String content, String url, String user,
                                     String pw) throws Exception {


        HttpHeaders headersResult = new HttpHeaders ();

        ObjectMapper mapper = new ObjectMapper ();
        Map<String, String> map;

        HttpHeaders headers = new HttpHeaders ();
        headers.setContentType (MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(String.format ("{\"username\":\"%s\",\"password\":\"%s\"}", user, pw), headers);
        ResponseEntity<String> response = restTemplate.postForEntity (url, entity, String.class);

        String r = response.getBody();
        map = mapper.readValue (r, new TypeReference<Map<String, String>>(){});

        headersResult.setContentType (MediaType.APPLICATION_JSON);
        headersResult.set ("X-API-TYPE", content);
        headersResult.set ("X-Auth-Token", map.get ("token"));

        return headersResult;
    }
}