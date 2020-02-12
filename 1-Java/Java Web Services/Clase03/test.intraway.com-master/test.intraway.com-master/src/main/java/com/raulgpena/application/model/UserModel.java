/*
 * @(#UserModel.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */
package com.raulgpena.application.model;

// Packages and classes to import of jdk 1.8
import java.util.Collection;
import java.util.Date;

// Packages and classes to import of spring security 4.x
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Packages and classes to import of jackson api.
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * <p>
 * The class <code>com.raulgpena.application.model.UserModel</code> is the model
 * for management the user's information.
 *
 *
 * @author Raul Geomar Pena (raul.pena@gmail.com)
 * @version 1.0.0
 * @since jdk 1.8
 * @since 01/01/2019
 * @see {@link org.springframework.security.core.userdetails.UserDetails}
 *
 */
public class UserModel implements UserDetails {

    // Private instance fields declarations.
    // Id.
    private Integer id;

    // User name.
    private String username;

    // User password.
    private String password;

    // User email.
    private String email;

    // Last password reset.
    private Date lastPasswordReset;

    // Authorities.
    private Collection<? extends GrantedAuthority> authorities;

    // Account do not expire.
    private Boolean accountNonExpired = true;

    // Account do not lock.
    private Boolean accountNonLocked = true;

    // Credentials do not expire.
    private Boolean credentialsNonExpired = true;

    // Account is enabled.
    private Boolean enabled = true;

    // Private class fields declarations.
    // Id serialization version.
    private static final long serialVersionUID = 1983562674858523l;

    // Public constructor declarations.
    /**
     *
     * <p>
     * Constructor without parameters.
	 *
     */
    public UserModel() {

        // Call to super class.
        super();
    }

    /**
     *
     * <p>
     * Constructor with parameters.
     *
     * @param id User id
     * @param username user name.
     * @param password user password.
     * @param email user email.
     * @param lastPasswordReset last password reset.
     * @param authorities User authorities.
	 *
     */
    public UserModel(Integer id, String username, String password,
            String email, Date lastPasswordReset, Collection<? extends GrantedAuthority> authorities) {

        // Call to super class.
        super();

        // Set internal values.
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastPasswordReset = lastPasswordReset;
        this.authorities = authorities;
    }

    // Public instance method declarations. (Get/Set)
    /**
     *
     * <p>
     * Method that return the id entity.
     *
     * @return id The id entity.
     */
    public Integer getId() {

        // Return the value.
        return this.id;
    }

    /**
     *
     * <p>
     * Method that set the id entity.
     *
     * @param id The id entity.
     */
    public void setId(Integer id) {

        // Set the value.
        this.id = id;
    }

    /**
     *
     * <p>
     * Method that return the user name.
     *
     * @return Return the user name.
     */
    public String getUsername() {

        // Return the value.
        return this.username;
    }

    /**
     *
     * <p>
     * Method that set user name.
     *
     * @param username The user name.
     */
    public void setUsername(String username) {

        // Set the value.
        this.username = username;
    }

    /**
     *
     * <p>
     * Method that return the password.
     *
     * @return Return the password.
     */
    @JsonIgnore
    public String getPassword() {

        // Return the value.
        return this.password;
    }

    /**
     *
     * <p>
     * Method that set the password.
     *
     * @param password The password.
     */
    public void setPassword(String password) {

        // Set the value.
        this.password = password;
    }

    /**
     *
     * <p>
     * Method that return the email.
     *
     * @return Return the email.
     */
    public String getEmail() {

        // Return the value.
        return this.email;
    }

    /**
     *
     * <p>
     * Method that set the email.
     *
     * @param email the email.
     */
    public void setEmail(String email) {

        // Set the value.
        this.email = email;
    }

    /**
     *
     * <p>
     * Method that return the last password reset.
     *
     * @return Return the last password reset.
     */
    @JsonIgnore
    public Date getLastPasswordReset() {

        // Return the value.
        return this.lastPasswordReset;
    }

    /**
     *
     * <p>
     * Method that set the last password reset.
     *
     * @param lastPasswordReset Return the last password reset.
     */
    public void setLastPasswordReset(Date lastPasswordReset) {

        // Set the value.
        this.lastPasswordReset = lastPasswordReset;
    }

    /**
     *
     * <p>
     * Method that return the authorities.
     *
     * @return Return the authorities.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // Return the value.
        return this.authorities;
    }

    /**
     *
     * <p>
     * Method that set the authorities.
     *
     * @param authorities Set the authorities.
     */
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {

        // Set the value.
        this.authorities = authorities;
    }

    /**
     *
     * <p>
     * Method that indicate if the account does not expired.
     *
     * @return Indicate if the account does not expired.
     * @see {@link org.springframework.security.core.userdetails.UserDetails}
     */
    @JsonIgnore
    public Boolean getAccountNonExpired() {

        // Return the value.
        return this.accountNonExpired;
    }

    /**
     *
     * <p>
     * Method that set if the account does not expired.
     *
     * @param accountNonExpired Indicate if the account does not expired.
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {

        // Set the value.
        this.accountNonExpired = accountNonExpired;
    }

    /**
     *
     * <p>
     * Method that indicate if the account does not expired.
     *
     * @return Indicate if the account does not expired.
     */
    @Override
    public boolean isAccountNonExpired() {

        // Return the value.
        return this.getAccountNonExpired();
    }

    /**
     *
     * <p>
     * Method that indicate if the account does not clocked.
     *
     * @return Indicate if the account does not clocked.
     * @see {@link org.springframework.security.core.userdetails.UserDetails}
     */
    @JsonIgnore
    public Boolean getAccountNonLocked() {

        // Return the value.
        return this.accountNonLocked;
    }

    /**
     *
     * <p>
     * Method that indicate if the account does not clocked.
     *
     * @param accountNonLocked Indicate if the account does not clocked.
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {

        // Set the value.
        this.accountNonLocked = accountNonLocked;
    }

    /**
     *
     * <p>
     * Method that indicate if the account does not clocked.
     *
     * @return Indicate if the account does not clocked.
     */
    @Override
    public boolean isAccountNonLocked() {

        // Return the value.
        return this.getAccountNonLocked();
    }

    /**
     *
     * <p>
     * Method that indicate if the credentials does not expired.
     *
     * @return Indicate if the credentials does not expired.
     * @see {@link org.springframework.security.core.userdetails.UserDetails}
     */
    @JsonIgnore
    public Boolean getCredentialsNonExpired() {

        // Return the value.
        return this.credentialsNonExpired;
    }

    /**
     *
     * <p>
     * Method that set if the credentials does not expired.
     *
     * @param credentialsNonExpired Indicate if the credentials does not
     * expired.
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {

        // Set the value.
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     *
     * <p>
     * Method that indicate if the credentials does not expired.
     *
     * @return Indicate if the credentials does not expired.
     */
    @Override
    public boolean isCredentialsNonExpired() {

        // Return the values.
        return this.getCredentialsNonExpired();
    }

    /**
     *
     * <p>
     * Method that indicate if is enabled.
     *
     * @return Indicate if is enabled.
     * @see {@link org.springframework.security.core.userdetails.UserDetails}
     */
    @JsonIgnore
    public Boolean getEnabled() {

        // Return the value.
        return this.enabled;
    }

    /**
     *
     * <p>
     * Method that set if is enabled.
     *
     * @param enabled Indicate if is enabled.
     */
    public void setEnabled(Boolean enabled) {

        // Set the value.
        this.enabled = enabled;
    }

    /**
     *
     * <p>
     * Method that indicate if is enabled.
     *
     * @return Indicate if is enabled.
     */
    @Override
    public boolean isEnabled() {

        // Return the value.
        return this.getEnabled();
    }
}
