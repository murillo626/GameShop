package com.gameshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SegurityConfig extends WebSecurityConfigurerAdapter{
    //El siguiente metodo funciona para hacer la autorizacion del usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth
                .inMemoryAuthentication()
                .withUser("Jeff")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("Isaac")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("I")
                .password("{noop}456")
                .roles("VENDEDOR","USER")
                .and()
                .withUser("J")
                .password("{noop}789")
                .roles("USER");
    }
    //el siguiente metodo es [ara realizar autorizacion de los accesos
    @Override
    protected  void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
            .antMatchers("/articulo/nuevo","/articulo/guardar",
                    "/articulo/modificar/**","/articulo/eliminar",
                    "/categoria/nuevo", "/categoria/guardar",
                    "/categoria/modificar/**", "/categoria/eliminar",
                    "/cliente/nuevo","/cliente/guardar",
                    "/cliente/modificar/**","/clientes/eliminar")
            .hasRole("ADMIN")
            .antMatchers("/articulo/listado",
                    "/categoria/listado",
                    "/cliente/listado")
            .hasAnyRole("ADMIN","VENDEDOR")
            .antMatchers("/")
            .hasAnyRole("ADMIN","VENDEDOR","USER")
            .and()
            .formLogin()
            .loginPage("/login")
            .and()
            .exceptionHandling().accessDeniedPage("/errores/403");
    }
}   
