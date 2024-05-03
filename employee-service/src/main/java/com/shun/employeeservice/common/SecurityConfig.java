package com.shun.employeeservice.common;

import com.shun.employeeservice.config.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>
 * Configuration class for defining security settings in the application.
 * This class is responsible for configuring the security filter chain,
 * which defines security rules and filters for incoming HTTP requests.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * <p>
     * Configures the security filter chain for the application.
     * This method defines the security rules and filters for incoming HTTP requests.
     * It disables CSRF protection, allows unrestricted access to certain API endpoints
     * and requires authentication for all other requests.
     * </p>
     *
     * @param http The HttpSecurity object to configure the security settings.
     * @return A SecurityFilterChain object representing the configured security filter chain.
     * @throws Exception If an error occurs while configuring the security settings.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable).authorizeRequests()
                .requestMatchers("/api/user/login", "/api/user/signup").permitAll().anyRequest().authenticated()
                .and().addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class).build();
    }
}
