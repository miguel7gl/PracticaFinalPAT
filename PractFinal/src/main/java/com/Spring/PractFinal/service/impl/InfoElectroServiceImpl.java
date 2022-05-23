package com.Spring.PractFinal.service.impl;

import com.Spring.PractFinal.model.InfoElectroModel;

import com.Spring.PractFinal.repository.InfoElectroRepository;

import com.Spring.PractFinal.service.InfoElectroService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InfoElectroServiceImpl implements InfoElectroService {
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private InfoElectroRepository repository;

    @Override
    public InfoElectroModel postInfo(InfoElectroModel info) {
        return repository.save(info);
    }
    
    
}
