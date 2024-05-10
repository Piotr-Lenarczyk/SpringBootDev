package com.example.SpringBootDev.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    //JDBC Auth
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    //@Bean
    //public InMemoryUserDetailsManager userDetailsManager() {
    //    UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();

    //    UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();

    //    UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

    //    return new InMemoryUserDetailsManager(john, mary, susan);
    //}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/students").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/students/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/hello").hasRole("EMPLOYEE"));

        //Use Basic Auth
        httpSecurity.httpBasic(Customizer.withDefaults());

        //Disable Cross Site Request Forgery
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
}
