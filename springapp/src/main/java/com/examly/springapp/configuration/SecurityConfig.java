//  package com.examly.springapp.configuration;
 
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
 
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//     @Bean
//     public securityFilterChain securityFilterChain(HttpSecurity hhtp) throws Exception{
//         return hhtp.csrf().disable()
//             .authorizeHttpRequests()
//             .requestMatchers("api/user/regiter","api/user/login","api/user").permitAll()
//             .and()
//             .formLogin()
//             .and()
//             .build();
//     }
   
// }