/*
 * @(#WebSecurityConfiguration.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.configuration;


// JDK 8 Imports.
import javax.annotation.Resource;


// Packages and classes to import of springframework 4.x
import com.raulgpena.application.security.AuthenticationTokenFilter;
import com.raulgpena.application.security.EntryPointUnauthorizedHandler;
import com.raulgpena.application.security.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;

// Packages and classes to import of spring security 4.x
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
    // Private class fields declarations.
    private EntryPointUnauthorizedHandler unauthorizedHandler;
    
    private UserDetailsService userDetailsService;

    private ISecurityService securityService;
    
    
    // Public constructor declarations.
    /**
     * 
     *  <p>Constructor declarations without parameters.
     * */
    public WebSecurityConfiguration () {
    	
    	// Call to super class.
    	super ();
    }
    
    /**
     * 
     *  <p>Constructor declarations with parameters.
     *  
     *  @param unauthorizedHandler Mandler unauthorize request.
     *  @param userDetailsService User deatils service.
     *  @param securityService User service.
     * */
    public WebSecurityConfiguration (EntryPointUnauthorizedHandler unauthorizedHandler, UserDetailsService userDetailsService,
    		                         ISecurityService securityService) {
    	
    	// Call to super class.
    	super ();
    	
    	// Set internal values.
    	this.unauthorizedHandler = unauthorizedHandler;
    	this.userDetailsService  = userDetailsService;
    	this.securityService     = securityService;
    }
    
    
    // Protected instance method declarations.
    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception {
    	
        httpSecurity
            .csrf ()
            .disable ()
            .exceptionHandling ()
            .authenticationEntryPoint(this.unauthorizedHandler)
            .and ()
                .sessionManagement ()
                .sessionCreationPolicy (SessionCreationPolicy.STATELESS)
            .and ()
                .authorizeRequests ()
                .antMatchers (HttpMethod.OPTIONS, "/**").permitAll ()
                .antMatchers ("/auth/**").permitAll ()
                .anyRequest ().authenticated ();

          // Custom JWT based authentication
          httpSecurity.addFilterBefore (authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
         
    
    // Public instance method declarations. (get/Set)
    @Autowired
    public void setUnauthorizedHandler (EntryPointUnauthorizedHandler unauthorizedHandler) {
    	
    	this.unauthorizedHandler = unauthorizedHandler;
    }
    
    @Resource
    public void setUserDetailsService (UserDetailsService userDetailsService) {
    	
    	this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setSecurityService (ISecurityService securityService) {
    	
    	this.securityService = securityService;
    }
    
    
    // Public instance method declarations.
    @Override
    public void configure (WebSecurity web) throws Exception {

        web.ignoring ().antMatchers ("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**");
    }

    @Autowired
    public void configureAuthentication (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    
    	authenticationManagerBuilder.userDetailsService (this.userDetailsService).passwordEncoder(passwordEncoder ());
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        
    	return new BCryptPasswordEncoder ();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean () throws Exception {
        
    	return super.authenticationManagerBean ();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean () throws Exception {
        
    	AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter ();
        authenticationTokenFilter.setAuthenticationManager (authenticationManagerBean ());
        return authenticationTokenFilter;
    }

    @Bean
    public ISecurityService securityService () {
    
    	return this.securityService;
    }
}