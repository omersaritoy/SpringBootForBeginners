package com.example.security.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails leyla = User.builder()
                .username("leyla")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();


        return new InMemoryUserDetailsManager(john, mary, susan, leyla);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(configure ->
                        configure
                                .requestMatchers(HttpMethod.GET, "/api/employee").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employee/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.POST, "/api/employee").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employee").hasRole("MANAGER"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());

        return http.build();

    }
}
