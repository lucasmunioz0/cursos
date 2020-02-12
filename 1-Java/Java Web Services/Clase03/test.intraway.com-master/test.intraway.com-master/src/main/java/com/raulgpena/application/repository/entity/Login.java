/*
 * @(#Login.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.repository.entity;


// Packages and classes to import of jdk 1.8
import java.util.Date;

// Packages and classes to import J2EE
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.repository.entity.Login</code> is the entity for management
 *     the Login's information.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     javax.persistence.Entity
 * */
@Entity (name = "Login")
public class Login {
	

	// Private instance fields declarations.
	// Id.
    @Id
    @GeneratedValue
    private Integer id = null;
	
	// User name.
	private String userName = null;
	
	// User password.
	private String password = null;
	
	// User email.
	private String email = null;
	
	// Last password reset.
	private Date lastPasswordReset = null;
	
	// Authorities.
	private String authorities = null;
	
	// Creation date.
	private Date createdAt = null;

	// Update date.
	private Date updatedAt = null;
	    
	// Indicate if is enabled or not.
	private Integer enabled = 0;
	
	
	// Public constructor declarations.
	/**
	 * 
	 * <p>Constructor declarations without parameters.
	 * */
	public Login() {
		
		// Call to super class.
		super ();
	}
	
	/**
	 * 
	 *  <p>Constructor declarations with parameters.
	 * 
	 *  @param id In entity
	 *  @param userName User name.
	 *  @param password User password.
	 *  @param email User email.
     *  @param lastPasswordReset last password reset
     *  @param authorities Role authorities.
	 *  @param createdAt Creation date.
	 *  @param updatedAt Update date entity
	 *  @param enabled Entity enabled.
	 * */
	public Login (Integer id, String userName, String password,
                  String email, Date lastPasswordReset, String authorities,
                  Date createdAt, Date updatedAt, Integer enabled) {
		
		// Call to super class.
		super ();
		
		// Set the internal values.
		this.id       = id;
		this.userName = userName;
		this.password = password;
		this.email    = email;
		this.lastPasswordReset = lastPasswordReset;
		this.authorities = authorities;
		this.createdAt   = createdAt;
		this.updatedAt   = updatedAt;
		this.enabled     = enabled;
	}

	
	// Public instance methods declarations. (Get/Set)
	/**
	 * 
	 *  <p>Method that return the id entity.
	 *  
	 *  @return id The id entity.
	 */
	public Integer getId () {

		// Return the value.
		return this.id;
	}
	
	/**
	 * 
	 *  <p>Method that set the id entity.
	 *  
	 *  @param id The id entity.
	 */
	public void setId (Integer id) {
		
		// Set the value.
		this.id = id;
	}
	
	/**
	 * 
	 *  <p>Method that return the user name.
	 *  
	 *  @return Return the user name.
	 */
	public String getUserName () {
		
		// Return the value.
		return this.userName;
	}
	
	/**
	 * 
	 *  <p>Method that set user name.
	 *  
	 *  @param userName The user name.
	 */
	public void setUserName (String userName) {
		
		// Set the value.
		this.userName = userName;
	}
	
	/**
	 * 
	 *  <p>Method that return the password.
	 *  
	 *  @return Return the password.
	 */
	public String getPassword () {
		
		// Return the value.
		return this.password;
	}
	
	/**
	 * 
	 *  <p>Method that set the password.
	 *  
	 *  @param password The password.
	 */
	public void setPassword (String password) {
		
		// Set the value.
		this.password = password;
	}
	
	/**
	 * 
	 *  <p>Method that return the email.
	 *  
	 *  @return Return the email.
	 */
	public String getEmail () {
		
		// Return the value.
		return this.email;
	}
	
	/**
	 * 
	 *  <p>Method that set the email.
	 *  
	 *  @param email the email.
	 */
	public void setEmail (String email) {
		
		// Set the value.
		this.email = email;
	}
	
	/**
	 * 
	 *  <p>Method that return the last password reset.
	 *  
	 *  @return Return the last password reset.
	 */
	public Date getLastPasswordReset () {
		
		// Return the value.
		return this.lastPasswordReset;
	}
	
	/**
	 * 
	 *  <p>Method that set the last password reset.
	 *  
	 *  @param lastPasswordReset Return the last password reset.
	 */
	public void setLastPasswordReset (Date lastPasswordReset) {
		
		// Set the value.
		this.lastPasswordReset = lastPasswordReset;
	}
	
	/**
	 * 
	 *  <p>Method that return the authorities.
	 *  
	 *  @return Return the authorities.
	 */
	public String getAuthorities () {
		
		// Return the value.
		return this.authorities;
	}
	
	/**
	 * 
	 *  <p>Method that set the authorities.
	 *  
	 *  @param authorities Set the authorities.
	 */
	public void setAuthorities (String authorities) {
		
		// Set the value.
		this.authorities = authorities;
	}
	
	/**
	 * 
	 *  <p>Method that return the creation date.
	 *  
	 *  @return The creation date.
	 */
	public Date getCreatedAt () {
		
		// Return the value.
		return this.createdAt;
	}

	/**
	 * 
	 *  <p>Method that set the creation date.
	 *  
	 *  @param createdAt The creation date.
	 */
	public void setCreatedAt (Date createdAt) {
		
		// Set the value.
		this.createdAt = createdAt;
	}
	
	/**
	 * 
	 *  <p>Method that return the update date.
	 *  
	 *  @return The update date.
	 */
	public Date getUpdatedAt () {
		
		// Return the value.
		return this.updatedAt;
	}

	/**
	 * 
	 *  <p>Method that set the update date.
	 *  
	 *  @param updatedAt The update date.
	 */
	public void setUpdatedAt (Date updatedAt) {
		
		// Set the value.
		this.updatedAt = updatedAt;
	}

	/**
	 * 
	 *  <p>Method that check if is enabled or not.
	 * 
	 *  @return Indicate if is enabled or not.
	 */
	public Integer getEnabled () {
		
		// Return the value
		return this.enabled;
	}

	/**
	 * 
	 *  <p>Method that set if is enabled or not.
	 * 
	 *  @param enabled Indicate if is enabled or not.
	 */
	public void setEnabled (Integer enabled) {
		
		// Set the value.
		this.enabled = enabled;
	}


	// Public instance method declarations extended of java.lang.Object.
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode ()
	 */
	@Override
	public int hashCode () {

		// Return the value.
		int hash = 0;
        hash += (this.getId () != null ? this.getId ().hashCode () : 0);

        // Return the new value.
        return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals (java.lang.Object)
	 */
	@Override
	public boolean equals (Object object) {

		// Return the value.
		if (this == object)  {
			return true;
		}

        if (object == null) {
        	return false;
        }

        if (getClass () != object.getClass ()) {
        	return false;
        }

        // Check the classes.
        Login other = (Login) object;
        if (!this.id.equals (other.getId ())) {
            return false;
        }

        // Return the value.
        return true;
	}
}