package com.Spring.PractFinal.controller;


import com.Spring.PractFinal.model.DomicilioModel;
import com.Spring.PractFinal.service.DomicilioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DomicilioController {

  @Autowired
  private DomicilioService domicilioService;

    @PostMapping(path="/domicilios-post")
    public ResponseEntity<DomicilioModel> create(@RequestBody DomicilioModel domicilio) throws Exception{
        domicilioService.postDomicilio(domicilio);

        return ResponseEntity.ok().body(domicilio);
    }
}

