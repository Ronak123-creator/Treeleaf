//package com.task.BlogWeb.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Configure security settings
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/api/auth/**").permitAll() // Allow access to registration and login endpoints
////                .anyRequest().authenticated() // All other requests require authentication
////                .and()
////                .httpBasic(); // Use HTTP Basic authentication
////    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Disable CSRF (for simplicity, enable it with proper handling in production)
//                .authorizeRequests(authorize -> authorize
//                .dispatcherTypeMatchers(HttpMethod.valueOf("/api/auth/**")).permitAll() // Permit registration and login endpoints
//                .anyRequest().authenticated() // Authenticate all other requests
//                .and()
//                .httpBasic(); // Use HTTP Basic authentication
//
//        return http.build();
//    }
//}