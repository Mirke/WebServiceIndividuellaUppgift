package com.mikael.bloggheavencode.config;
import com.mikael.bloggheavencode.jwt.JwtAuthConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

/**
 * <code>SecurityConfig</code> - Security configurations for the project.
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // -----------------------------------------------------------------------------------------------------------------
    //   Authentication Converter Property
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private JwtAuthConverter jwtAuthConverter;

    // -----------------------------------------------------------------------------------------------------------------
    //   Session and FilterChain
    // -----------------------------------------------------------------------------------------------------------------

    @Bean
    protected SessionAuthenticationStrategy strategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated();

        http
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);


        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS);

        return http.build();
    }

}