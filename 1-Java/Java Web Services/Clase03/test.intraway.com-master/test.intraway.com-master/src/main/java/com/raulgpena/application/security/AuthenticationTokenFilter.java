/*
 * @(#AuthenticationTokenFilter.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */
package com.raulgpena.application.security;

// Packages and classes to import of jdk 1.8
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// Packages and classes to import of J2EE.
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// Packages and classes to import of springframework 4.x
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

// Packages and classes to import of spring security.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * <p>
 * The class
 * <code>com.raulgpena.application.security.AuthenticationTokenFilter</code> is
 * a filter for management the token filter.
 *
 *
 * @author Raul Geomar Pena (raul.pena@gmail.com)
 * @version 1.0.0
 * @since jdk 1.8
 * @since 01/01/2018
 * @see
 * org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
 *
 */
public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    // Private instance fields declarations.
    // Token header.
    private String tokenHeader;

    // Token utils.
    private TokenUtils tokenUtils = null;

    // User detail service.
    private UserDetailsService userDetailsService = null;

    // Private class fields declarations.
    // Logger.
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

    // Public constructor declarations.
    /**
     *
     * <p>
     * Constructor without parameters.
     *
     */
    public AuthenticationTokenFilter() {

        // Call to super class.
        super();
    }

    /**
     *
     * <p>
     * Constructor with parameters.
     *
     * @param tokenUtils tokenUtils bean.
     * @param tokenHeader token header.
     * @param userDetailsService userDetailsService bean.
     * @see org.springframework.security.core.userdetails.UserDetailsService
     *
     */
    public AuthenticationTokenFilter(TokenUtils tokenUtils, String tokenHeader, UserDetailsService userDetailsService) {

        // Call to super class.
        super();

        // Set the internal values.
        this.tokenUtils = tokenUtils;
        this.tokenHeader = tokenHeader;
        this.userDetailsService = userDetailsService;
    }

    // Public instance methods declarations. (Get/Set)
    /**
     *
     * <p>
     * Method that set the tokenUtils bean.
     *
     * @param tokenUtils tokenUtils bean.
     * @see org.springframework.beans.factory.annotation.Autowired
     *
     */
    @Autowired
    public void setTokenUtils(TokenUtils tokenUtils) {

        // Set the value.
        this.tokenUtils = tokenUtils;
    }

    /**
     *
     * <p>
     * Method that set the token header.
     *
     * @param tokenHeader token header.
     * @see org.springframework.beans.factory.annotation.Value
     *
     */
    @Value("${api.security.token.header}")
    public void setTokenHeader(String tokenHeader) {

        // Set the value.
        this.tokenHeader = tokenHeader;
   }

    /**
     *
     * <p>
     * Method that set the userDetailsService bean.
     *
     * @param userDetailsService userDetailsService bean.
     * @see org.springframework.beans.factory.annotation.Autowired
     * @see org.springframework.security.core.userdetails.UserDetailsService
     *
     */
    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {

        // Set the value.
        this.userDetailsService = userDetailsService;
    }

    // Public instance method declarations extended of org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
    /* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#doFilter (javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fil) throws IOException, ServletException {

        logger.debug("Getting user details...");
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        final String authToken = httpRequest.getHeader(this.tokenHeader);
        final String username = this.tokenUtils.getUsernameFromToken(authToken);

        logger.debug("Checking user details...");
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            logger.debug(String.format("Loading user details for '%s'", username));
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            logger.debug(String.format("Validating token '%s'", authToken));
            if (this.tokenUtils.validateToken(authToken, userDetails)) {

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        logger.debug("Calling the next filter.");
        fil.doFilter(req, res);
    }
}
