package com.faculdade.tcc.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations{

    @Autowired
    private SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        //ROTAS PUBLICAS
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/email/updatepassword").permitAll()
                        .requestMatchers(HttpMethod.POST,"/email").permitAll()
                        //ROTAS USERS
                        .requestMatchers(HttpMethod.POST,"/answers").hasAnyRole("STUDENT","TEACHER", "TECHNICIANS")
                        .requestMatchers(HttpMethod.GET,"/questions").hasAnyRole("STUDENT", "TEACHER", "TECHNICIANS", "ADMIN")
                        //ROTAS ADMINS

                        //USERS
                        .requestMatchers(HttpMethod.POST,"/users/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/users").hasRole("ADMIN")
                        //QUESTIONS
                        .requestMatchers(HttpMethod.POST,"/questions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/questions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/questions").hasRole("ADMIN")
                        //QUESTIONNAIRE
                        .requestMatchers(HttpMethod.POST, "/questionnaire").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/questionnaire").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/questionnaire").hasRole("ADMIN")
                        //ANSWERS
                        .requestMatchers(HttpMethod.GET,"/answers").hasRole("ADMIN")
                        //QUALQUER OUTRA ROTA: precisa estar autenticada
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


