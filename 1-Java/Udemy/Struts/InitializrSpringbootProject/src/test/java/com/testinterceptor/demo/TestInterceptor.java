package com.testinterceptor.demo;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootTest
public class TestInterceptor {

    private final MockHttpServletResponse response = new MockHttpServletResponse();

    private final WebContentInterceptor interceptor = new WebContentInterceptor();

    private final Object handler = new Object();
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void throwsExceptionWithNullPathMatcher() throws Exception {
        RequestMappingHandlerMapping mapping = (RequestMappingHandlerMapping) applicationContext
                .getBean("requestMappingHandlerMapping");

        MockHttpServletRequest request = new MockHttpServletRequest("GET",
                "/hello");
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setParameter("name", "lucas");

        HandlerExecutionChain chain = mapping.getHandler(request);
        for (HandlerInterceptor interceptor1 : chain.getInterceptors()) {
            System.out.println(interceptor1);
        }

        System.out.println(request.getParameter("name"));
        
    }
}
