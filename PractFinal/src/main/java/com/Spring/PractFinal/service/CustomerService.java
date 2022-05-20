package com.Spring.PractFinal.service;

import com.Spring.PractFinal.service.CustomerService;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Spring.PractFinal.join.CustomerElectroJoin;
import com.Spring.PractFinal.model.CustomerModel;

public interface CustomerService extends UserDetailsService {

  Iterable<CustomerModel> getAllCustomers();

  Iterable<CustomerElectroJoin> getJoin();

  CustomerModel postCustomer(CustomerModel customer);

  CustomerModel updateCustomer(CustomerModel customer);

  String deleteCustomer(CustomerModel customer);
}