package com.example.spring.aop.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * In this integration test:
 * <p>
 * We use @SpringBootTest with a random port to start the application in a real server environment.
 * We use TestRestTemplate to make an actual GET request to /books/1.
 * You can add assertions to validate both the response and the logs in your application.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(OutputCaptureExtension.class)
class RequestLoggingInterceptorIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testInterceptorLogsRequest(CapturedOutput output) {
        String url = "http://localhost:" + port + "/books/1";
        String response = restTemplate.getForObject(url, String.class);
        assertTrue(output.getOut().contains("Request received for URL: /books/1"), "This assert is verifying " +
                "that the request has reached the Interceptor pre handle");
        assertThat(response, is("Fetching book with ID: 1"));
    }
}
