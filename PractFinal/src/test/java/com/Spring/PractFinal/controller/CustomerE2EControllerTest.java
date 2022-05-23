package com.Spring.PractFinal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Spring.PractFinal.join.CustomerDomicilioJoin;
import com.Spring.PractFinal.join.CustomerElectroJoin;
import com.Spring.PractFinal.model.CustomerModel;
import com.Spring.PractFinal.repository.CustomerRepository;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerE2EControllerTest{
  @Autowired
  private CustomerRepository repository;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  @Test
  public void getCustomersTest(){
    Iterable<CustomerModel> customers =repository.findAll();

    String url="http://localhost:"+Integer.toString(port)+"/api/v1/customers"; 
    HttpHeaders headers= new HttpHeaders();
    HttpEntity<String> entity=new HttpEntity<>(headers);

    ResponseEntity<Iterable<CustomerModel>> result =testRestTemplate.exchange(
      url,
      HttpMethod.GET,
      entity,
      new ParameterizedTypeReference<Iterable<CustomerModel>>() {}

    );
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    then(result.getBody()).isEqualTo(customers);
  }

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void getCustomersElectroJoin(){
    
    String query="""
      SELECT CUSTOMERS.CUSTOMER_ID,CUSTOMERS.CUSTOMER_NAME,CUSTOMERS.CONTRASENA,ELECTRODOMESTICOS.ELECTRO_ID,ELECTRODOMESTICOS.ELECTRO_TIPO,ELECTRODOMESTICOS.TIEMPO_USO  
      FROM CUSTOMERS
      INNER JOIN ELECTRODOMESTICOS
      ON CUSTOMERS.CUSTOMER_ID=ELECTRODOMESTICOS.CUSTOMER_ID
      """;

      Iterable<CustomerElectroJoin> customerElectroJoin=jdbcTemplate.query(query,
      (rs, rowNum) ->
      new CustomerElectroJoin(rs.getLong("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("CONTRASENA"), rs.getLong("ELECTRO_ID"), rs.getString("ELECTRO_TIPO"), rs.getInt("TIEMPO_USO")) 
      );

    String url="http://localhost:"+Integer.toString(port)+"/api/v1/ElectroJoin";
    HttpHeaders headers= new HttpHeaders();
    HttpEntity<String> entity=new HttpEntity<>(headers);

    ResponseEntity<Iterable<CustomerElectroJoin>> result =testRestTemplate.exchange(
      url,
      HttpMethod.GET,
      entity,
      new ParameterizedTypeReference<Iterable<CustomerElectroJoin>>() {}

    );
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    then(result.getBody()).isEqualTo(customerElectroJoin);
  }
  @Test
  public void getCustomersDomicilioJoin(){
    
    String query="""
      SELECT CUSTOMERS.CUSTOMER_ID,CUSTOMERS.CUSTOMER_NAME,DOMICILIOS.CALLE,DOMICILIOS.NUM_PISO,DOMICILIOS.PROVINCIA,DOMICILIOS.CIUDAD,DOMICILIOS.CODIGO_POSTAL,DOMICILIOS.PAIS
      FROM CUSTOMERS
      INNER JOIN DOMICILIOS
      ON CUSTOMERS.CUSTOMER_ID=DOMICILIOS.CUSTOMER_ID
      """;
    Iterable<CustomerDomicilioJoin> domicilioJoin=jdbcTemplate.query(query,
    (rs, rowNum) ->
    new CustomerDomicilioJoin(rs.getLong("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("CALLE"), rs.getString("NUM_PISO"), rs.getString("PROVINCIA"), rs.getInt("CODIGO_POSTAL"),rs.getString("PAIS")) 
    );

    String url="http://localhost:"+Integer.toString(port)+"/api/v1/DomicilioJoin";
    HttpHeaders headers= new HttpHeaders();
    HttpEntity<String> entity=new HttpEntity<>(headers);

    ResponseEntity<Iterable<CustomerDomicilioJoin>> result =testRestTemplate.exchange(
      url,
      HttpMethod.GET,
      entity,
      new ParameterizedTypeReference<Iterable<CustomerDomicilioJoin>>() {}

    );
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    then(result.getBody()).isEqualTo(domicilioJoin);
  }

}