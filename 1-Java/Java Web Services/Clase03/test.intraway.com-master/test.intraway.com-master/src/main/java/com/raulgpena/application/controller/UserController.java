/*
 * @(#UserController.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.controller;


// JDK 1.8 Imports.
import java.net.URI;
import java.util.List;

// Springframework imports.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// My Classes to import.
import com.raulgpena.application.model.User;
import com.raulgpena.application.services.IUserService;


/**
 *
 *  <p>The class <code>com.raulgpena.application.controller.UserController</code> is a web controller
 *  that define the user rest operations.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   12/30/2018
 *  @see     org.springframework.web.bind.annotation.RequestMapping
 *  @see     org.springframework.web.bind.annotation.RestController
 * */
@RequestMapping ("users")
@RestController
public class UserController {


    // Private instance fields declarations.

    // User service.
	private IUserService<User, Long> userService;


    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (UserController.class);


	// Constructor declarations.

    /**
     *
     * <p>Constructor declarations without parameters.
     * */
    public UserController () {


        // Call to super class.
        super ();
    }

    /**
     *
     * <p>Constructor declarations with parameters.
     *
     * @param userService User service component.
     * */
    public UserController (IUserService<User, Long> userService) {


        // Call to super class.
        super ();

        this.userService = userService;
    }


    // Private instance methods.

    /*
     *
     *  <p>Method that return all users.
     *
     * @return User list.
     * */
    private ResponseEntity<?> get () {


        // Get all users.
        logger.info ("Finding all users !!!");
        List<User> list = this.userService.findAll ();

        // Return the values.
        if (list == null || list.isEmpty ()) {

            logger.warn ("Users not found !!!");
            return ResponseEntity.notFound ().build ();

        } else {

            logger.info ("Users found !!!");
            return ResponseEntity.ok (list);
        }
    }

    /*
     *
     *  <p>Method that find a user.
     *
     *  @param id User id.
     *  @return User object.
     * */
    private ResponseEntity<?> get (Long id) {


        // Get the users.
        logger.info (String.format ("Finding a user by id %d", id));
        User user = this.userService.findById (id);

        // Return the values.
        if (user == null) {

            logger.warn (String.format ("User id %d not found!", id));
            return ResponseEntity.notFound ().build ();

        } else {

            logger.info (String.format ("User by id %d found!", id));
            return ResponseEntity.ok (this.userService.findById (id));
        }
    }

    /*
     *
     *  <p>Method that create a new user.
     *
     *  @param model User data.
     *
     *  @return Response entity.
     * */
    private ResponseEntity<?> create (final User model) {

        // Build the new user.
        logger.info (String.format ("Creating new user %s", model));
        this.userService.create (model);
        logger.debug (String.format ("User %s created!", model));

        // Build the response.
        logger.debug ("Creating Headers Response!");
        final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping ().path ("/".concat ("users").concat ("/{id}")).build ().expand (model.getId ()).toUri ();
        final HttpHeaders headers = new HttpHeaders ();
        headers.setLocation (location);

        // Return the response.
        return new ResponseEntity<> (headers, HttpStatus.CREATED);
    }

    /*
     *
     *  <p>Method that update a User by id.
     *
     *  @param id User id
     *  @param mode User data.
     *  @return Response with the user information.
     * */
    private ResponseEntity<?> update (final Long id, final User model) {

        // Check user.
        logger.info (String.format ("Finding user by id %d ", id));
        final User u = this.userService.findById (id);

        if (u == null) {

            logger.warn (String.format ("User by id %d not found.", id));
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
        logger.debug (String.format ("User by id %d found %s", id, u));

        // Update the user.
        logger.info (String.format ("Updating the user %s", model));
        model.setId (id);
        this.userService.update (model);
        logger.debug (String.format ("User %s updated!", model));

        // Return the user updated.
        return ResponseEntity.ok (model);
    }


    // Public instance methods. Set/Get)

    /**
     *
     *  <p>Method that set the user service component.
     *
     *  @param userService User service.
     *  @see   org.springframework.beans.factory.annotation.Autowired
     * */
    @Autowired
    public void setUserService (IUserService<User, Long> userService) {

        // Set the value.
        this.userService = userService;
    }


    // Public instance methods declarations. (Endpoints)
    /**
     *
     *  <p>Method that create a new user. (JSON)
     *
     *  @param model User data.
     *
     *  @return Response entity. (201)
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.web.bind.annotation.RequestBody
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (method = RequestMethod.POST, headers = {"X-API-TYPE=json", "X-Auth-Token"},
                     consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> createAsJson (@RequestBody final User model) {


        // Build the new user.
        return this.create (model);
    }

    /**
     *
     *  <p>Method that create a new user. (XML)
     *
     *  @param model User data.
     *
     *  @return Response entity. (201)
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.web.bind.annotation.RequestBody
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (method = RequestMethod.POST, headers = "X-API-TYPE=xml",
                     consumes = {MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> createAsXml (@RequestBody final User model) {


        // Build the new user.
        return this.create (model);
    }

    /**
     *
     *  <p>Method that update a User by id. (JSON)
     *
     *  @param id User id.
     *  @param model User information.
     *  @return Response with the user information.
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.web.bind.annotation.RequestBody
     *  @see org.springframework.web.bind.annotation.PathVariable
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.PUT, headers = "X-API-TYPE=json",
                     consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> updateAsJson (@PathVariable("id") final Long id, @RequestBody final User model) {


        // Return the user updated.
        return this.update (id, model);
    }

    /**
     *
     *  <p>Method that update a User by id. (XML)
     *
     *  @param id User id.
     *  @param model User information.
     *  @return Response with the user information.
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.web.bind.annotation.RequestBody
     *  @see org.springframework.web.bind.annotation.PathVariable
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.PUT, headers = "X-API-TYPE=xml",
                     consumes = {MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> updateAsXml (@PathVariable("id") final Long id, @RequestBody final User model) {


        // Return the user updated.
        return this.update (id, model);
    }

    /**
     *
     *  <p>Method that delete a User by id.
     *
     *  @param id User id
     *  @return Response with if the user was deleted or not.
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.web.bind.annotation.PathVariable
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> delete (@PathVariable("id") final Long id) {


        // Check user.
        logger.info (String.format ("Finding user by id %d ", id));
        final User u = this.userService.findById (id);

        if (u == null) {

            logger.warn (String.format ("User by id %d not found.", id));
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
        logger.debug (String.format ("User by id %d found %s", id, u));

        // Delete the user.
        logger.info (String.format ("Deleting the user id %d", id));
        this.userService.delete (id);
        logger.debug (String.format ("User id %d deleted!", id));

        // Return the response.
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

    /**
     *
     *  <p>Method that return all users. (JSON)
     *
     * @return User list.
     *
     * @see org.springframework.web.bind.annotation.RequestMapping
     * @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (method = RequestMethod.GET, headers = {"X-API-TYPE=json"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> getAsJson () {


        // Get all users.
        return this.get ();
	}

    /**
     *
     *  <p>Method that return all users. (XML)
     *
     * @return User list.
     *
     * @see org.springframework.web.bind.annotation.RequestMapping
     * @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (method = RequestMethod.GET, headers = "X-API-TYPE=xml", produces = {MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> getAsXml () {


        // Get all users.
        return this.get ();
    }

    /**
     *
     *  <p>Method that find a user. (JSON)
     *
     *
     *  @param id User id.
     *  @return User object.
     *
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.GET, headers = "X-API-TYPE=json", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> getAsJson (@PathVariable Long id) {


        // Get the users.
        return this.get (id);
    }

    /**
     *
     *  <p>Method that find a user. (XML)
     *
     *  @param id User id.
     *  @return User object.
     *
     *  @see org.springframework.web.bind.annotation.RequestMapping
     *  @see org.springframework.security.access.prepost.PreAuthorize
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.GET, headers = "X-API-TYPE=xml", produces = {MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("@securityService.hasProtectedAccess ()")
    public ResponseEntity<?> getAsXml (@PathVariable Long id) {


        // Get the users.
        return this.get (id);
    }
}
