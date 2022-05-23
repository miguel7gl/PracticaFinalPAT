package com.Spring.PractFinal.controller;


import com.Spring.PractFinal.model.PrecioModel;
import com.Spring.PractFinal.service.PrecioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PrecioController {

  @Autowired
  private PrecioService precioService;

    @Modifying
    @PostMapping(path="/precio-post")
    public ResponseEntity<PrecioModel> create(@RequestBody PrecioModel precio){
        precioService.postPrecio(precio);

        return ResponseEntity.ok().body(precio);
    }
}

