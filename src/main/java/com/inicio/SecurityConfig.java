package com.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	//Usuarios y sus roles
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetails() throws Exception {
		List<UserDetails> users = List.of(
					User.withUsername("user1")
					.password("{noop}user1")
					.roles("Cliente")
					.build(),
					User.withUsername("user2")
					.password("{noop}user2")
					.roles("Administrador")
					.build());
		return new InMemoryUserDetailsManager(users);
	}
	// Permisos de acceso por roles	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET,"/reservas/*")
			.hasRole("Administrador")
		.requestMatchers(HttpMethod.POST,"/reserva")
			.authenticated()
		.anyRequest()
			.permitAll()
		.and()
		.httpBasic();
		return httpSecurity.build();
	}		
	
	

}
