package com.Spring.PractFinal.repository;

import com.Spring.PractFinal.model.CustomerModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;



public interface CustomerRepository extends CrudRepository<CustomerModel,Long>{
  public CustomerModel findByCustomerName(String customerName);


  @Modifying
  @Query("INSERT INTO CUSTOMERS (CUSTOMER_NAME, CONTRASENA) VALUES ('Anuel', '1234')")
  public CustomerModel postCustomer(String customerName, String password);
}
