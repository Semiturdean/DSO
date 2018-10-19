package com.intproject.DSOtool;

import com.intproject.DSOtool.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; */

@SpringBootApplication
public class DsoToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsoToolApplication.class, args);
	}

}
