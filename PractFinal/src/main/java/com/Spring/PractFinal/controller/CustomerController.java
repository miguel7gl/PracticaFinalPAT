package com.Spring.PractFinal.controller;


import com.Spring.PractFinal.join.CustomerDomicilioJoin;
import com.Spring.PractFinal.join.CustomerElectroJoin;
import com.Spring.PractFinal.join.Registro;
import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.model.DomicilioModel;
import com.Spring.PractFinal.service.CustomerService;
import com.Spring.PractFinal.service.DomicilioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @Autowired
  private DomicilioService domicilioService;
  
  @GetMapping(path="/customers",produces= MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<CustomerModel>> getAllCustomers() {

    var orders = customerService.getAllCustomers();
    return ResponseEntity.ok().body(orders);
}

@GetMapping(path="/ElectroJoin",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Iterable<CustomerElectroJoin>> getCustomerElectroJoin() {

  var orders = customerService.getCustomerElectroJoin();
  return ResponseEntity.ok().body(orders);
}

@GetMapping(path="/DomicilioJoin",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Iterable<CustomerDomicilioJoin>> getCustomerDomicilioJoin() {

  var orders = customerService.getCustomerDomicilioJoin();
  return ResponseEntity.ok().body(orders);
}

  @Modifying
  @DeleteMapping(path="/customers")
  public String delete(@RequestBody CustomerModel usuario){
    String result=customerService.deleteCustomer(usuario);
    return result;
  }

 //-------------------------AUTH--------------------------------------------------------------------------------//
@GetMapping("/datos")// en /datos se van a mostrar los datos de inicio de sesion del usuario
public ResponseEntity<Authentication> getDatos(Authentication authentication) {
  return new ResponseEntity<>(authentication, HttpStatus.OK);
}

}

