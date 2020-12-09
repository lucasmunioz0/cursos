/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testinterceptor.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ClienteInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = (String) request.getParameter("name");
        if(name != null && name.equalsIgnoreCase("lucas")){
            System.out.println("HOLAAAAAAAAAAAAA: " + name);
            response.setStatus(HttpStatus.OK.value());
            return true;
        }
        System.out.println("CHAAAAUUU");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return false;
    }
    
    
}
