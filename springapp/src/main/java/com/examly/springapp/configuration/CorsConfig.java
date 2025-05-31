package com.examly.springapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebMvc
// public class CorsConfig implements WebMvcConfigurer{
    
//     @SuppressWarnings("null")
//     @Override
// 	public void addCorsMappings(CorsRegistry registry) {
// 		registry.addMapping("/**");
// 	}
// // }

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://ide-bcefcbccbedfab314820188eabbabbffour.premiumproject.examly.io/proxy/8080/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
                
    }
}
