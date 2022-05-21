package com.Spring.PractFinal.service.impl;

import com.Spring.PractFinal.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.Spring.PractFinal.join.CustomerElectroJoin;
import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
  @Autowired
  private JdbcTemplate template;

  @Autowired
  private CustomerRepository repository;

  @Override 
  public Iterable<CustomerModel> getAllCustomers(){
      return repository.findAll();
  }

  @Override//METODO PARA EL GET INNER JOIN
  public  Iterable<CustomerElectroJoin> getJoin(){
      String query="""
        SELECT CUSTOMERS.CUSTOMER_ID,CUSTOMERS.CUSTOMER_NAME,CUSTOMERS.CONTRASENA,ELECTRODOMESTICOS.ELECTRO_ID,ELECTRODOMESTICOS.ELECTRO_TIPO,ELECTRODOMESTICOS.TIEMPO_USO  
        FROM CUSTOMERS
        INNER JOIN ELECTRODOMESTICOS
        ON CUSTOMERS.CUSTOMER_ID=ELECTRODOMESTICOS.CUSTOMER_ID
        """;
      Iterable<CustomerElectroJoin> resultado=template.query(query,
      (rs, rowNum) ->
      new CustomerElectroJoin(rs.getLong("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("CONTRASENA"), rs.getLong("ELECTRO_ID"), rs.getString("ELECTRO_TIPO"), rs.getInt("TIEMPO_USO")) 
      );
      return resultado;
  }

  @Override 
  public CustomerModel postCustomer(CustomerModel customer){ //METODO PARA EL POST
     return repository.save(customer);
  }
  @Override 
  public CustomerModel updateCustomer(CustomerModel customer){ //METODO PARA EL POST
     return repository.save(customer);
  }
  @Override
  public String deleteCustomer(CustomerModel customer){
   Optional <CustomerModel> usuario=repository.findById(customer.getCustomerId());
    if (usuario.isPresent()){
      repository.deleteById(customer.getCustomerId());
      return "Borrado exitoso";
    }else{
      return "No existe el usuario a borrar";
    }
  }



  @Override
  public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
    CustomerModel customer= repository.findByCustomerName(customerName);
   
    List<GrantedAuthority> authorities= new ArrayList<>();
    UserDetails customerNuevo=new User(customer.getCustomerName(),customer.getPassword(),authorities);
    return customerNuevo;
  }

}