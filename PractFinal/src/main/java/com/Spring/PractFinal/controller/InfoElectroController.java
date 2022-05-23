package com.Spring.PractFinal.controller;

import com.Spring.PractFinal.config.SecurityConfig;
import com.Spring.PractFinal.join.CustomerDomicilioJoin;
import com.Spring.PractFinal.join.CustomerElectroJoin;
import com.Spring.PractFinal.join.Registro;
import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.model.DomicilioModel;
import com.Spring.PractFinal.model.InfoElectroModel;
import com.Spring.PractFinal.model.PrecioModel;
import com.Spring.PractFinal.repository.CustomerRepository;
import com.Spring.PractFinal.service.CustomerService;
import com.Spring.PractFinal.service.DomicilioService;
import com.Spring.PractFinal.service.InfoElectroService;
import com.Spring.PractFinal.service.PrecioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InfoElectroController {

  @Autowired
  private InfoElectroService infoElectroService;

    @Modifying
    @PostMapping(path="/info-post")
    public ResponseEntity<InfoElectroModel> create(@RequestBody InfoElectroModel info) throws Exception{
        infoElectroService.postInfo(info);

        return ResponseEntity.ok().body(info);
    }
}

