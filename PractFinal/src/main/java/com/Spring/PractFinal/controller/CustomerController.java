package com.Spring.PractFinal.controller;


import com.Spring.PractFinal.join.CustomerElectroJoin;
import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.service.CustomerService;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  
  @GetMapping(path="/customers",produces= MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<CustomerModel>> getAllCustomers() {

    var orders = customerService.getAllCustomers();
    return ResponseEntity.ok().body(orders);
  }

  @GetMapping(path="/customerElectroJoin",produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<CustomerElectroJoin>> getJoin() {

    var orders = customerService.getJoin();
    return ResponseEntity.ok().body(orders);
  }

  @Modifying
  @PostMapping(path="/customers")
  public ResponseEntity<CustomerModel> create(@RequestBody CustomerModel usuario){

    CustomerModel customer=customerService.postCustomer(usuario);
    return ResponseEntity.ok().body(customer);
  }

  @Modifying
  @PutMapping(path="/customers")
  public ResponseEntity<CustomerModel> update(@RequestBody CustomerModel usuario){

    CustomerModel customer=customerService.updateCustomer(usuario);
    return ResponseEntity.ok().body(customer);
  }
  @Modifying
  @DeleteMapping(path="/customers")
  public String delete(@RequestBody CustomerModel usuario){
    String result=customerService.deleteCustomer(usuario);
    return result;
  }

}

