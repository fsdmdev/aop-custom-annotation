package com.example.spring.aop;

import com.example.spring.aop.interceptor.RequestLoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AopCustomAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopCustomAnnotationApplication.class, args);
    }

    /**
     * In this configuration, we add our RequestLoggingInterceptor to the interceptor registry.
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new RequestLoggingInterceptor());
            }
        };
    }

}
