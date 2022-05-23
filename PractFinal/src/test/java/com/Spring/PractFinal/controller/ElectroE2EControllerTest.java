package com.Spring.PractFinal.controller;

import com.Spring.PractFinal.model.ElectroModel;
import com.Spring.PractFinal.model.InfoElectroModel;
import com.Spring.PractFinal.repository.ElectroRepository;
import com.Spring.PractFinal.repository.InfoElectroRepository;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ElectroE2EControllerTest {

    @Autowired
    private ElectroRepository repository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void ElectroTest() {
        Iterable<ElectroModel> documents = repository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/electro";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<ElectroModel>> result = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<ElectroModel>>() {
                });

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(documents);
    }
}
