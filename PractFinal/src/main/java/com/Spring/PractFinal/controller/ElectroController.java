package com.Spring.PractFinal.controller;

import com.Spring.PractFinal.join.ElectroPrecioJoin;
import com.Spring.PractFinal.model.ElectroModel;
import com.Spring.PractFinal.service.ElectroService;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ElectroController {
    @Autowired
    private ElectroService electroService;

    @GetMapping(path="/electro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ElectroModel>> getAllElectro() {
        var result = electroService.getAllElectro();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(path="/electroPrecioJoin",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ElectroPrecioJoin>> getJoin(@RequestParam(required = false) String usuario) {

        var orders = electroService.getJoin(usuario);
        return ResponseEntity.ok().body(orders);
    }
    
}
