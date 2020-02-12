package com.educacionit.java.web.test;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.educacionit.java.web.Employee;

public class EmployeeRestTest {

    private Client client;

    private WebResource webResource;

    private static final String SERVER = "http://localhost:8080/employee-service/api/employees";

    private static final String CONTENT_TYPE = "application/json";

    private static final Logger logger = Logger.getLogger(EmployeeRestTest.class);

    public EmployeeRestTest() {

        super();
    }

    @Before
    public void setUp() {

        this.client = Client.create();
        this.webResource = client.resource(SERVER);
    }

    @Test
    public void testGet() {

        logger.info("Starting test...");

        // Arrange and act.
        logger.debug("Setting test values...");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        // Assert.
        logger.debug("Executing request...");
        logger.debug("Checking response...");
        assertTrue(String.format("Response status [%d] from server %s is invalid, expected 200.", response.getStatus(), SERVER),
                response.getStatus() == 200);

        String output = response.getEntity(String.class);
        assertEquals(String.format("Response content type [%s] from server %s [%s], is invalid, expected json.", SERVER, response.getType().toString(), CONTENT_TYPE),
                CONTENT_TYPE, response.getType().toString());
        assertNotNull(String.format("Response content body from server %s is empty !!!", SERVER, output), output);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Employee>>() {}.getType();
        List<Employee> list = gson.fromJson(output, type);
        assertFalse(String.format("Response content body from server %s is empty !!!", SERVER, output), list.isEmpty());

        list.forEach(e -> logger.debug(e.getFirstName().concat(" ").concat(e.getLastName())));

        logger.info("Finishing test...");
    }

    @Test
    public void testPost() {

        logger.info("Starting test...");

        // Arrange.
        logger.debug("Setting test values...");
        String input = String.format("{\"firstName\": \"%s\", \"lastName\": \"%s\", \"title\": \"%s\",\"city\": \"%s\",\"officePhone\": \"%s\","
                + "\"cellPhone\": \"%s\", \"email\": \"%s\",\"picture\": \"%s\",\"department\": \"%s\"}",
                randomAlphabetic(10),
                randomAlphabetic(10),
                randomAlphabetic(10),
                randomAlphabetic(10),
                randomNumeric(12),
                randomNumeric(12),
                randomAlphabetic(10) + "@gmail.com",
                randomAlphabetic(10),
                randomAlphabetic(10));

        // Act.
        logger.debug("Executing request...");
        logger.debug(String.format("Sending %s", input));
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

        // Assert.
        logger.debug("Checking response...");
        assertTrue(String.format("Response status [%d] from server %s is invalid, expected 201.", response.getStatus(), SERVER),
                response.getStatus() == 201);
        logger.debug(String.format("Response status received [%d]", response.getStatus()));

        assertTrue(String.format("Response header locations not found !!!"), response.getHeaders().containsKey("Location"));
        logger.debug(String.format("Response headers received ==> %s", response.getHeaders()));

        logger.info("Finishing test...");
    }

    @Test
    public void testDelete() {

        logger.info("Starting test...");

        // Arrange.
        logger.debug("Setting test values...");
        this.webResource = client.resource(SERVER.concat("/2"));

        // Act.
        logger.debug("Executing request...");
        ClientResponse response = webResource.delete(ClientResponse.class);

        // Assert.
        logger.debug("Checking response...");
        assertTrue(String.format("Response status [%d] from server %s is invalid, expected 204.", response.getStatus(), SERVER),
                response.getStatus() == 204);

        logger.info("Finishing test...");
    }

    @Test
    public void testPut() {

        logger.info("Starting test...");

        // Arrange.
        logger.debug("Setting test values...");
        String input = String.format("{\"firstName\": \"%s\", \"lastName\": \"%s\", \"title\": \"%s\",\"city\": \"%s\",\"officePhone\": \"%s\","
                + "\"cellPhone\": \"%s\", \"email\": \"%s\",\"picture\": \"%s\",\"department\": \"%s\"}",
                randomAlphabetic(10),
                randomAlphabetic(10),
                randomAlphabetic(10),
                randomAlphabetic(10),
                randomNumeric(12),
                randomNumeric(12),
                randomAlphabetic(10) + "@gmail.com",
                randomAlphabetic(10),
                randomAlphabetic(10));

        // Act.
        logger.debug("Executing request...");
        logger.debug(String.format("Sending %s", input));
        this.webResource = client.resource(SERVER.concat("/1"));
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, input);

        // Assert.
        logger.debug("Checking response...");
        assertTrue(String.format("Response status [%d] from server %s is invalid, expected 200.", response.getStatus(), SERVER),
                response.getStatus() == 200);
        logger.debug(String.format("Response status received [%d]", response.getStatus()));

        String output = response.getEntity(String.class);
        assertEquals(String.format("Response content type [%s] from server %s [%s], is invalid, expected json.", SERVER, response.getType().toString(), CONTENT_TYPE),
                CONTENT_TYPE, response.getType().toString());
        assertNotNull(String.format("Response content body from server %s is empty !!!", SERVER, output), output);

        logger.info("Finishing test...");
    }
}
