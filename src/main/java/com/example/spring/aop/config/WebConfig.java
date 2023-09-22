package com.example.spring.aop.config;

import com.example.spring.aop.interceptor.RequestLoggingInterceptor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@ServletComponentScan
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * In this configuration, we add our RequestLoggingInterceptor to the interceptor registry.
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new RequestLoggingInterceptor());
    }
}
