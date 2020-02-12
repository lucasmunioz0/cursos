/*
 * @(#UserServiceImpl.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.services.support;


// JDK imports.
import java.util.*;
import java.util.stream.Collectors;

// Springframework imports.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

// Apache commons imports.
import org.apache.commons.beanutils.BeanUtils;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Our classes.
import com.raulgpena.application.ServiceException;
import com.raulgpena.application.model.User;
import com.raulgpena.application.services.IUserService;
import com.raulgpena.application.repository.jpa.IUserRepository;


/**
 *
 *  <p>The class <code>com.raulgpena.application.services.support.UserServiceImpl</code> is a service for management
 *     the user information.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   12/30/2018
 *  @see     org.springframework.stereotype.Service
 *  @see     com.raulgpena.application.services.IUserService
 * */
@Service
public class UserServiceImpl implements IUserService<User, Long> {


    // Private instances fields declarations.

    // User service.
    private IUserRepository userRepository;


    // Private class fields declarations.

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (UserServiceImpl.class);


    // Constructor declarations.

    /**
     *
     * <p>Constructor declarations without parameters.
     * */
    public UserServiceImpl () {

        // Call to super class.
        super ();
    }

    /**
     *
     * <p>Constructor declarations with parameters.
     *
     * @param userRepository User repository.
     * */
    public UserServiceImpl (IUserRepository userRepository) {

        // Call to super class.
        super ();

        this.userRepository = userRepository;
    }


    // Methods Get/Set declarations.
    /**
     *
     * <p>Method that set the user repository.
     *
     * @param userRepository User repository.
     * @see   org.springframework.beans.factory.annotation.Autowired;
     * */
    @Autowired
    public void setUserRepository (IUserRepository userRepository) {

        // Set the value.
        this.userRepository = userRepository;
    }


    // User service methods.

    /**
     *
     *  <p>Method that create a new user.
     *
     * @param arg value to create.
     * */
    @Override
    public void create (User arg) {

        Assert.notNull (arg, "User values are invalid, are empties!");

        // Creating the resource indicated.
        com.raulgpena.application.repository.entity.User us = new com.raulgpena.application.repository.entity.User ();

        try {

            // Copy values.
            logger.info (String.format ("Creating user %s", arg));
            BeanUtils.copyProperties (us, arg);

            // Update the target.
            this.userRepository.save (us);
            arg.setId (us.getId ());
            logger.debug (String.format ("User %s created!", us));

        } catch (Exception e) {
            /*
             * Catch the problems.
             * */
            logger.error (String.format ("Problems creating user %s", arg), e);
            throw new ServiceException ("Problems creating new user.");
        }
    }

    /**
     *
     *  <p>Method that update a user.
     *
     * @param arg value to update.
     * */
    @Override
    public void update (User arg) {

        Assert.notNull (arg, "User values are invalid, are empties!");

        // Updating the resource indicated.
        com.raulgpena.application.repository.entity.User us = new com.raulgpena.application.repository.entity.User ();

        try {

            // Copy values.
            logger.info (String.format ("Updating user %s", arg));
            BeanUtils.copyProperties (us, arg);

            // Update the target.
            this.userRepository.save (us);
            logger.debug (String.format ("User %s updated!", arg));

        } catch (Exception e) {
            /*
             * Catch the problems.
             * */
            logger.error (String.format ("Problems updating user %s", arg), e);
            throw new ServiceException ("Problems updating new user.");
        }
    }

    /**
     *
     *  <p>Method that delete a user.
     *
     * @param arg value to delete.
     * */
    @Override
    public void delete (Long arg) {

        Assert.notNull (arg, "User id is invalid, id is empty!");

        try {

            // Deleting the resource indicated.
            logger.info (String.format ("Deleting user by id %d", arg));
            this.userRepository.delete (arg);
            logger.debug (String.format ("User by id %d deleted!", arg));

        } catch (Exception e) {
        /*
         * Catch the problems.
         * */
            logger.error (String.format ("Problems deleting user %s", arg), e);
            throw new ServiceException ("Problems deleting new user.");
        }
    }

    /**
     *
     *  <p>Method that find a user by id.
     *
     * @param arg value found.
     * @return A user.
     * */
    @Override
    public User findById (Long arg) {


        // Check the value.
        if (arg == null || arg.intValue () < 0) {

            logger.warn (String.format ("Id %d invalid!", arg));
            return null;
        }

        User user;
        try {

            // Find the user.
            logger.info (String.format ("Find user by id %d", arg));
            com.raulgpena.application.repository.entity.User us;
            us = this.userRepository.findOne (arg);

            if (us == null) {

                logger.warn (String.format ("User id %d not found!", arg));
                return null;
            }

            logger.info (String.format ("User by id %d found %s", arg, us));

            user = new User ();
            BeanUtils.copyProperties (user, us);

        } catch (Exception e) {
        /*
         * Catch the problems.
         * */
            logger.error (String.format ("Problems finding user by id %d", arg), e);
            throw new ServiceException (String.format ("Problems finding user by id %d", arg));
        }


        // Return the value.
        return user;
    }

    /**
     *
     *  <p>Method that find all users.
     *
     * @return All values.
     * */
    @Override
    public List<User> findAll () {


        // Find the users.
        logger.info (String.format ("Find all users!"));
        List<com.raulgpena.application.repository.entity.User> us;
        us = this.userRepository.findAll ();

        logger.info (String.format ("Users found (%d)", us.size ()));
        List<User> list;

        list = us.stream ().map ( e -> {

            User u;
            try {

                u = new User ();
                BeanUtils.copyProperties (u, e);

            } catch (Exception ex) {

                /*
                 * Catch the problems.
                 * */
                logger.error (String.format ("Problems getting all user information..."), ex);
                throw new ServiceException (String.format ("Problems finding all users"));
            }

            return u;

        }).collect (Collectors.toList ());


        // Return the value.
        logger.debug (String.format ("Users found %s", list));
        return list;
    }
}