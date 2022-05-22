package com.Spring.PractFinal.config;

import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  CustomerRepository repository;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
    .antMatchers("/index.html","/registro.html","/login.html", "/inicio.html").permitAll()
    .antMatchers("/libs/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
    .loginPage("/login.html").permitAll()
    .defaultSuccessUrl("/precioDia.html");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    Iterable<CustomerModel> listaUsuarios=repository.findAll();
    for (CustomerModel i:listaUsuarios){
      auth.inMemoryAuthentication()
      .withUser(i.getCustomerName())
      .password(encoder.encode(i.getPassword()))
      .roles("CUSTOMER"); 
      }
   }

}
