package com.example.cinemaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().ignoringAntMatchers("/register").and().authorizeRequests()
                .mvcMatchers("/users").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/logout").permitAll()
                .mvcMatchers("/register").permitAll().and().authorizeRequests()
                .mvcMatchers("/movies").permitAll()
                .mvcMatchers("/save").authenticated()
                .mvcMatchers("/update/{id}").authenticated()
                .mvcMatchers("/delete/{id}").authenticated()
                .mvcMatchers("/cinemaHalls").permitAll()
                .mvcMatchers("/saveCinemaHall").authenticated()
                .mvcMatchers("/updateCinemaHall/{id}").authenticated()
                .mvcMatchers("/deleteCinemaHall/{id}").authenticated()
                .mvcMatchers("/screenings}").authenticated()
                .mvcMatchers("/savescreening").authenticated()
                .mvcMatchers("/updatescreening/{id}").authenticated()
                .mvcMatchers("/deletescreening/{id}").authenticated()
                .mvcMatchers("/tickets").authenticated()
                .mvcMatchers("/saveticket").permitAll()
                .mvcMatchers("/updateTicket/{id}").authenticated()
                .mvcMatchers("/deleteTicket/{id}").authenticated()
                .mvcMatchers("/user/registration").authenticated()


                .and().formLogin().and().httpBasic();
    }





}
