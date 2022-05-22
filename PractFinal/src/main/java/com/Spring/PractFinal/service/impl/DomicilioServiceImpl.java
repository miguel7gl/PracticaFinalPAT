package com.Spring.PractFinal.service.impl;

import com.Spring.PractFinal.service.DomicilioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;


import com.Spring.PractFinal.model.DomicilioModel;

import com.Spring.PractFinal.repository.DomicilioRepository;

@Service
public class DomicilioServiceImpl implements DomicilioService{
  @Autowired
  private JdbcTemplate template;

  @Autowired
  private DomicilioRepository repository;

  @Override 
  public Iterable<DomicilioModel> getAllDomicilios(){
      return repository.findAll();
  }

  @Override 
  public DomicilioModel postDomicilio(DomicilioModel domicilio){ //METODO PARA EL POST
     return repository.save(domicilio);
  }
 
  }