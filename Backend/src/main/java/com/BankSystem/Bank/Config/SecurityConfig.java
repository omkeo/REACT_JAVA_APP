package com.BankSystem.Bank.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.BankSystem.Bank.Service.UserService1;

@Configuration
@EnableWebMvc
public class SecurityConfig {
	@Autowired
	private UserService1 userService;
	
	public SecurityConfig(UserService1 userService) {
		super();
		this.userService = userService;
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://localhost:5173") // Frontend port
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // HTTP methods to allow
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow cookies or authentication headers
            }
        };
    }
	@Bean
	@Order(1)
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/users/login", "/api/users/register").permitAll()
	                .requestMatchers("/api/**").hasAnyRole("ADMIN", "MANAGER", "ACCOUNTANT", "CLERK", "USER")
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form.permitAll());

	        return http.build();
	    }
	
	@Bean
    public UserDetailsService userDetailsService() {
        return username -> userService.loadUserDetails(username);
    }
	
	
 
}
	
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Authentication provider
//    }
    




