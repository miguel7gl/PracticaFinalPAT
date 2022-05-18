package com.Spring.PractFinal.repository;

import com.Spring.PractFinal.model.CustomerModel;

import org.springframework.data.repository.CrudRepository;



public interface CustomerRepository extends CrudRepository<CustomerModel,Long>{
  
}
