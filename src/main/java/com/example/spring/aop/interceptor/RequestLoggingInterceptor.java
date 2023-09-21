package com.example.spring.aop.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * Interceptor to log incoming requests
 * The HandlerInterceptor interface requires the implementation of preHandle, postHandle, and afterCompletion methods.
 * <p>
 * The @Component annotation should be present on the interceptor class or a package scan should include its package.
 *
 * @author felipeMello
 */
@Component
@Slf4j
public class RequestLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("Request received for URL: " + request.getRequestURI());
        return true; // Continue processing the request
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // This method can be used for post-processing after the execution of the handler method
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // This method can be used for cleanup after the response has been sent
    }
}