package com.example.spring.aop.integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * In this integration test:
 * <p>
 * We use @SpringBootTest with a random port to start the application in a real server environment.
 * We use TestRestTemplate to make an actual GET request to /books/1.
 * You can add assertions to validate both the response and the logs in your application.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestLoggingInterceptorIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testInterceptorLogsRequest() {
        String url = "http://localhost:" + port + "/books/1";
        String response = restTemplate.getForObject(url, String.class);

        // Add assertions here to validate the response and logs.
    }
}
