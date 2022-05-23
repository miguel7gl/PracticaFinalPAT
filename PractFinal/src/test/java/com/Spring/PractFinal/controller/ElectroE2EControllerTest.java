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

import static org.assertj.core.api.BDDAssertions.then;

import com.Spring.PractFinal.join.ElectroPrecioJoin;
import com.Spring.PractFinal.model.ElectroModel;
import com.Spring.PractFinal.repository.ElectroRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ElectroE2EControllerTest {
  @Autowired
  private ElectroRepository repository;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  @Test
  public void getAllElectroTest(){
    Iterable<ElectroModel> electros =repository.findAll();

    String url="http://localhost:"+Integer.toString(port)+"/api/v1/electro";
    HttpHeaders headers= new HttpHeaders();
    HttpEntity<String> entity=new HttpEntity<>(headers);

    ResponseEntity<Iterable<ElectroModel>> result =testRestTemplate.exchange(
      url,
      HttpMethod.GET,
      entity,
      new ParameterizedTypeReference<Iterable<ElectroModel>>() {}

    );
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    then(result.getBody()).isEqualTo(electros);
  }
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void getElectroPrecioJoinTest(){
    String query="""
        SELECT ELECTRODOMESTICOS.ELECTRO_ID, ELECTRODOMESTICOS.ELECTRO_TIPO, ELECTRODOMESTICOS.CUSTOMER_ID, ELECTRODOMESTICOS.TIEMPO_USO, PRECIOS.CONSUMO_MEDIO_HORA, PRECIOS.PRECIO_CONSUMO  
        FROM ELECTRODOMESTICOS
        INNER JOIN PRECIOS
        ON ELECTRODOMESTICOS.ELECTRO_TIPO=PRECIOS.ELECTRO_TIPO
        """;
        Iterable<ElectroPrecioJoin> resultado=jdbcTemplate.query(query,
        (rs, rowNum) ->
            new ElectroPrecioJoin(rs.getLong("ELECTRO_ID"), rs.getString("ELECTRO_TIPO"), rs.getLong("CUSTOMER_ID"), rs.getInt("TIEMPO_USO"),rs.getInt("CONSUMO_MEDIO_HORA"), rs.getFloat("PRECIO_CONSUMO")) 
        );

    String url="http://localhost:"+Integer.toString(port)+"/api/v1/electroPrecioJoin";
    HttpHeaders headers= new HttpHeaders();
    HttpEntity<String> entity=new HttpEntity<>(headers);

    ResponseEntity<Iterable<ElectroPrecioJoin>> result =testRestTemplate.exchange(
      url,
      HttpMethod.GET,
      entity,
      new ParameterizedTypeReference<Iterable<ElectroPrecioJoin>>() {}

    );
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    then(result.getBody()).isEqualTo(resultado);
  }
}
