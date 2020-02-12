/*
 * @(#IUserService.java 12/30/2018
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.services;


// JDK Imports.
import java.io.Serializable;
import java.util.List;


/**
 *
 *  <p>The abstract class <code>com.raulgpena.application.services.IUserService</code> is a interface
 *  that define the service operations.
 *
 *
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   12/30/2018
 *  @see     java.io.Serializable
 * */
public interface IUserService<T, I> extends Serializable {


    // Methods declarations.
    /**
     *
     *  <p>Method that create a new user.
     *
     * @param arg value to create.
     * */
    void create (T arg);

    /**
     *
     *  <p>Method that update a user.
     *
     * @param arg value to update.
     * */
    void update (T arg);

    /**
     *
     *  <p>Method that delete a user.
     *
     * @param arg value to delete.
     * */
    void delete (I arg);

    /**
     *
     *  <p>Method that find a user by id.
     *
     * @param arg value found.
     * @return A user.
     * */
    T findById (I arg);

    /**
     *
     *  <p>Method that find all users.
     *
     * @return All values.
     * */
    List<T> findAll ();
}