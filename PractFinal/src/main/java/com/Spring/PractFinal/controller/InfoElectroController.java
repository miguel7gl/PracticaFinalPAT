package com.Spring.PractFinal.controller;


import com.Spring.PractFinal.model.InfoElectroModel;
import com.Spring.PractFinal.service.InfoElectroService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

