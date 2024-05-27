package com.unir.citas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.unir.citas.security.JwtAuthenticationEntryPoint;
import com.unir.citas.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/api/auth/**").permitAll()
		.requestMatchers(HttpMethod.POST,"/clinica/pacientes/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/pacientes/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/consultaexamenes/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/consultaexamenes/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/consultas/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/consultas/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/usuarios/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/usuarios/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/tipoexamenes/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/tipoexamenes/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/especialidades/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/especialidades/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/medicos/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/medicos/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.POST,"/clinica/horarios/**").hasAnyAuthority("ADMIN","USER")
		.requestMatchers(HttpMethod.GET,"/clinica/horarios/**").hasAnyAuthority("ADMIN","USER")
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
