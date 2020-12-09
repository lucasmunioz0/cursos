package com.testinterceptor.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestInterceptor2 {

    private final MockHttpServletResponse response = new MockHttpServletResponse();

    private final WebContentInterceptor interceptor = new WebContentInterceptor();

    private final Object handler = new Object();
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void throwsExceptionWithNullPathMatcher() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "lucas");
//        testRestTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, map)
        //ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/hello", String.class);
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/hello", String.class, map);
        assertEquals(400, responseEntity.getStatusCodeValue());
//        System.out.println(responseEntity.getStatusCode());
        
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isEqualTo(RESPONSE);
        
    }
}
