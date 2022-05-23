package com.Spring.PractFinal.config;

import java.util.HashMap;
import java.util.Map;

import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.repository.CustomerRepository;
import com.Spring.PractFinal.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  CustomerService customerService;
  @Autowired
  CustomerRepository repository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
    .antMatchers("/","/registro.html","/login.html","/api/v1/customers-post","/api/v1/customers","/api/v1/ElectroJoin","/api/v1/DomicilioJoin","/api/v1/electro","/api/v1/electroPrecioJoin").permitAll()
    .antMatchers("/libs/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
    .loginPage("/login.html").permitAll()
    .defaultSuccessUrl("/precioDia.html");
	}

	@Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
   Iterable<CustomerModel> listaUsuarios=repository.findAll();

    for (CustomerModel i:listaUsuarios){
      auth.inMemoryAuthentication()
      .withUser(i.getCustomerName())
      .password(encoder.encode(i.getPassword()))
      .roles("CUSTOMER"); 
      }
   }

}



