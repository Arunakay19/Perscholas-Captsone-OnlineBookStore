package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin@gmail.com")
                .password(encoder.encode("pass"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user@gmail.com")
                .password(encoder.encode("pass"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/",
                "/user_form",
                "/user_login",
                "/js/**", "/css/**", "/images/**",
                "/assets/**"
                ).permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/admin", "/available_books").authenticated()
                .and()
                .formLogin( (form) ->form
                        .loginPage("/user_login")
                        .usernameParameter("emailId")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login_process")
                        .defaultSuccessUrl("/available_books")
                    .permitAll()
                );
        return http.build();
    }
}
