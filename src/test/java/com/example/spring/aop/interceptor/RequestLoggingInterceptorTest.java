package com.example.spring.aop.interceptor;

import com.example.spring.aop.controller.BookController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * In this unit test:
 * <p>
 * We use @WebMvcTest to narrow down the context to only the BookController and the RequestLoggingInterceptor bean.
 * We use MockMvc to simulate a GET request to /books/1.
 * We mock the RequestLoggingInterceptor to verify that its preHandle method is called once.
 */
@WebMvcTest(controllers = BookController.class)
public class RequestLoggingInterceptorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequestLoggingInterceptor requestLoggingInterceptor;

    @Test
    public void testInterceptorLogsRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(requestLoggingInterceptor, times(1)).preHandle(any(), any(), any());
    }
}