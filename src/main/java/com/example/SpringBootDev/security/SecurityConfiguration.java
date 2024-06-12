package com.example.SpringBootDev.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {
    //     UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
    //     UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
    //     UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
    //
    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // }

    // Uses JDBC authentication for Spring Security
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/employees/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                                .requestMatchers("/api").permitAll()
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                //Login page
                .formLogin(form ->
                        form.loginPage("/login").loginProcessingUrl("/authenticate").permitAll())
                //Logout page
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"))
                .build();
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}
