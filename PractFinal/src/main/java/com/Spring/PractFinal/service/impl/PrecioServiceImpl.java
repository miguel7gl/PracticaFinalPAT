package com.Spring.PractFinal.service.impl;

import com.Spring.PractFinal.model.PrecioModel;
import com.Spring.PractFinal.repository.PrecioRepository;
import com.Spring.PractFinal.service.PrecioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PrecioServiceImpl implements PrecioService {
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private PrecioRepository repository;

    @Override
    public PrecioModel postPrecio(PrecioModel precio) {
        return repository.save(precio);
    }
    
    
}
