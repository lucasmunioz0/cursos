/*
 * @(#TokenUtils.java 01/01/2019
 * Copyright 2018 Raul Pena, Inc. All rights reserved.
 * RAULGPENA/CONFIDENTIAL
 * */

package com.raulgpena.application.security;


// Packages and classes to import of jdk 1.8
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;

// Packages and classes to import of springframework 4.x
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

// Packages and classes to import of jwt.
import io.jsonwebtoken.*;

// Loggers imports.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// My Classes.
import com.raulgpena.application.model.UserModel;


/**
 * 
 *  <p>The class <code>com.raulgpena.application.security.TokenUtils</code> is a component
 *     for management tokens.
 *  
 *  
 *  @author  Raul Geomar Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since   jdk 1.8
 *  @since   01/01/2019
 *  @see     org.springframework.stereotype.Component
 * */
@Component ("tokenUtilsBean")
public class TokenUtils {
	
	
	// Private instance fields declarations.
	// Secret password token.
	private String secret;

	// Expiration token.	
	private Long expiration;

	
	// Private class fields declarations.
	// Device types.
    private final String AUDIENCE_UNKNOWN   = "unknown";
    private final String AUDIENCE_WEB       = "web";
    private final String AUDIENCE_MOBILE    = "mobile";
    private final String AUDIENCE_TABLET    = "tablet";

    // Logger.
    private static final Logger logger = LoggerFactory.getLogger (TokenUtils.class);
    
    
    // Public constructor declarations.
    /**
     * 
     *  <p>Constructor without parameters.
     * */
    public TokenUtils () {
    	
    	// Call to super class.
    	super ();
    }
    
    /**
     * 
     *  <p>Constructor with parameters.
     *  
     *  @param secret Secret password.
     *  @param expiration expiration time.
     * */
    public TokenUtils (String secret, Long expiration) {
    	
    	// Call to super class.
    	super ();
    	
    	// Set internal values.
    	this.secret     = secret;
    	this.expiration = expiration;
    }


    // Private instance methods dealcrations.
    private Claims getClaimsFromToken(String token) {

        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret.getBytes("UTF-8"))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateCurrentDate() {

        return new Date(System.currentTimeMillis());
    }

    private Date generateExpirationDate() {

        return new Date(System.currentTimeMillis() + this.expiration * 1000);
    }

    private Boolean isTokenExpired (String token) {

        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(this.generateCurrentDate());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    private String generateAudience(Device device) {

        String audience = this.AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = this.AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }

    private Boolean ignoreTokenExpiration(String token) {

        String audience = this.getAudienceFromToken(token);
        return (this.AUDIENCE_TABLET.equals(audience) || this.AUDIENCE_MOBILE.equals(audience));
    }

    private String generateToken(Map<String, Object> claims) {

        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(this.generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, this.secret.getBytes("UTF-8"))
                    .compact();
        } catch (UnsupportedEncodingException ex) {

            final String m = ex.getMessage ();

            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(this.generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, this.secret)
                    .compact();
        }
    }
    
    
    // Public instance methods declarations. Get/Set)
    /**
     * 
     *  <p>Method that set the secret password.
     *  
     *  @param secret The secret password.
     * */
    @Value("${api.security.token.secret}")
    public void setSecret (String secret) {
    	
    	// Set the value.
    	this.secret = secret;
    }
    
    /**
     * 
     *  <p>Method that set the expiration.
     *  
     *  @param expiration The expiration.
     * */
    @Value("${api.security.token.expiration}")
    public void setExpiration (Long expiration) {
    	
    	// Set the value.
    	this.expiration = expiration;
    }
    
    
    // Public instance methods declarations.
    public String getUsernameFromToken (String token) {
    
    	String username;
        	    
    	try {
	        
    		final Claims claims = this.getClaimsFromToken (token);
	        username = claims.getSubject ();
	        
	    } catch (Exception e) {
	      username = null;
	    }
        
    	return username;
    }

    public Date getCreatedDateFromToken (String token) {
    
    	Date created;
    	
	    try {
	    	
	        final Claims claims = this.getClaimsFromToken (token);
	        created = new Date((Long) claims.get ("created"));
	        
	    } catch (Exception e) {
	      created = null;
	    }
        
	    return created;
    }
    
    public Date getExpirationDateFromToken(String token) {
    
    	Date expiration;
        
    	try {
      
    		final Claims claims = this.getClaimsFromToken (token);
            expiration = claims.getExpiration ();
        } catch (Exception e) {
            
        	expiration = null;
        }
        
    	return expiration;
    }

    public String getAudienceFromToken(String token) {

        String audience;
        try {
          final Claims claims = this.getClaimsFromToken(token);
          audience = (String) claims.get("audience");
        } catch (Exception e) {
          audience = null;
        }
        return audience;
    }

    public String generateToken(UserDetails userDetails, Device device) {

       Map<String, Object> claims = new HashMap<String, Object>();
       claims.put("sub", userDetails.getUsername());
       claims.put("audience", this.generateAudience(device));
       claims.put("created", this.generateCurrentDate());
       return this.generateToken(claims);
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {

        final Date created = this.getCreatedDateFromToken(token);
        return (!(this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset)) && (!(this.isTokenExpired(token)) || this.ignoreTokenExpiration(token)));
    }

    public String refreshToken(String token) {

        String refreshedToken;

        try {

            final Claims claims = this.getClaimsFromToken(token);
            claims.put("created", this.generateCurrentDate());
            refreshedToken = this.generateToken(claims);

        } catch (Exception e) {

            refreshedToken = null;
        }

        return refreshedToken;
     }

    public Boolean validateToken(String token, UserDetails userDetails) {

        UserModel user = (UserModel) userDetails;
        final String username = this.getUsernameFromToken(token);
        final Date created = this.getCreatedDateFromToken(token);
        return (username.equals(user.getUsername()) && !(this.isTokenExpired(token)) && !(this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset())));
    }
}
