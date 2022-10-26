package com.toysground.todaytodo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final Logger log = LoggerFactory.getLogger(getClass());
/*
    private final OAuth2ResourceServerConfigurer.JwtConfigurer jwtConfigurer;

    public SecurityConfig(OAuth2ResourceServerConfigurer.JwtConfigurer jwtConfigurer) {
        this.jwtConfigurer = jwtConfigurer;
    }*/
/*

    private final ObjectMapper objectMapper;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
*/

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().mvcMatchers(
                "/resources/**"
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/","/**").permitAll()
                .anyRequest().permitAll()
                .and().build();
/*
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .build();*/
        /*.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/api/v1/**").hasAuthority(USER.name())
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling()
                .authenticationEntryPoint(((request, response, authException) -> {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    objectMapper.writeValue(
                            response.getOutputStream(),
                            ExceptionResponse.of(ExceptionCode.FAIL_AUTHENTICATION)
                    );
                }))
                .accessDeniedHandler(((request, response, accessDeniedException) -> {
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    objectMapper.writeValue(
                            response.getOutputStream(),
                            ExceptionResponse.of(ExceptionCode.FAIL_AUTHORIZATION)
                    );
                })).and().build();*/
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

   /* @Bean
    public Jwt jwt() {
        return new Jwt(
                this.jwtConfigure.issuer(),
                this.jwtConfigure.clientSecret(),
                this.jwtConfigure.accessToken(),
                this.jwtConfigure.refreshToken()
        );
    }

    public JwtAuthenticationFilter jwtAuthenticationFilter(Jwt jwt, TokenService tokenService) {
        return new JwtAuthenticationFilter(
                this.jwtConfigure.accessToken().header(),
                this.jwtConfigure.refreshToken().header(),
                jwt,
                tokenService
        );
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        log.warn("accessDeniedHandler");
        return (request, response, e) -> {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("ACCESS DENIED");
            response.getWriter().flush();
            response.getWriter().close();
        };
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, e) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("UNAUTHORIZED");
            response.getWriter().flush();
            response.getWriter().close();
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, Jwt jwt, TokenService tokenService) throws
            Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/members/signup", "/api/members/signin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .disable()
                .csrf()
                .disable()
                .headers()
                .disable()
                .httpBasic()
                .disable()
                .rememberMe()
                .disable()
                .logout()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .addFilterBefore(jwtAuthenticationFilter(jwt, tokenService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }*/
}
