package com.gameshop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameshopApplication.class, args);
	}
}
            //datos para iniciar sesion
                /*.inMemoryAuthentication()
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
                .roles("USER");*/