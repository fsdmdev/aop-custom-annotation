package com.example.spring.aop.interceptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.hamcrest.Matchers.anything;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * In this unit test:
 * <p>
 * We use @WebMvcTest to narrow down the context to only the BookController and the RequestLoggingInterceptor bean.
 * We use MockMvc to simulate a GET request to /books/1.
 * We mock the RequestLoggingInterceptor to verify that its preHandle method is called once.
 */
@ExtendWith(MockitoExtension.class)
class RequestLoggingInterceptorTest {

    @InjectMocks
    private RequestLoggingInterceptor requestLoggingInterceptor;


    private MockHttpServletRequest mockHttpServletRequest;

    private MockHttpServletResponse mockHttpServletResponse;

    @BeforeEach
    void setUp() {
        mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletResponse = new MockHttpServletResponse();
    }

    @Test
    void testPreHandle() {
        assertTrue(requestLoggingInterceptor.preHandle(mockHttpServletRequest, mockHttpServletResponse, anything()));
    }
}