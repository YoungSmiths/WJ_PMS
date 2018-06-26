package com.wj.pms.config;

import com.wj.pms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    protected static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfigurer.class);

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().and()
                .formLogin()
                .loginPage("/api/user/login_info").permitAll()
                .loginProcessingUrl("/api/user/login_info").permitAll()
                .successHandler((request, response, authentication) -> {
                    LOGGER.info("Login success, the response is: {}", response);
                })
                .failureHandler((request, response, exception) -> {
                    LOGGER.info("Login failed, request={}, response={}", request, response);
                }).and()
                .logout()
                .logoutUrl("/api/user/logout").permitAll()
                .logoutSuccessHandler((request, response, authentication) -> {
                }).and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                });
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}

