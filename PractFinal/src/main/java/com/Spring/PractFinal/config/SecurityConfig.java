// package com.Spring.PractFinal.config;

// import java.util.HashMap;
// import java.util.Map;

// import com.Spring.PractFinal.service.CustomerService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import lombok.Builder.Default;



// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter{
  
//   @Autowired
//   private CustomerService customerService;
  
//   @Bean
//   public PasswordEncoder passwordEncoder(){
//       PasswordEncoder defaultEncoder=NoOpPasswordEncoder.getInstance();

//       Map<String,PasswordEncoder> encoders=new HashMap();
//       encoders.put("noop",NoOpPasswordEncoder.getInstance());
//       encoders.put("bcrypt",new BCryptPasswordEncoder());

//       DelegatingPasswordEncoder passwordEncoder= new DelegatingPasswordEncoder("noop", encoders);
//       passwordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);

//      return passwordEncoder();
//   }

//   @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
   
//       auth.userDetailsService(customerService).passwordEncoder(passwordEncoder());
//   }
// }
