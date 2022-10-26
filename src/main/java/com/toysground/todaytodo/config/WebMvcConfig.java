package com.toysground.todaytodo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 60 * 60; //3600초 1시간

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("*")                                        // 허용 URL
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")             // 허용 Method
                .allowedHeaders("*")                                        // 허용 헤더
                .allowCredentials(true)                                     // 자격증명 허용
                .maxAge(MAX_AGE_SECS);                                      // 허용시간
    }
}
