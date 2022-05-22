package com.Spring.PractFinal.service.impl;

import com.Spring.PractFinal.join.ElectroPrecioJoin;
import com.Spring.PractFinal.model.ElectroModel;
import com.Spring.PractFinal.repository.ElectroRepository;
import com.Spring.PractFinal.service.ElectroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ElectroServiceImpl implements ElectroService{
    @Autowired
    private ElectroRepository repository;

    @Autowired
    private JdbcTemplate template;

    @Override
    public Iterable<ElectroModel> getAllElectro() {
        return repository.findAll();
    }

    @Override
    public Iterable<ElectroPrecioJoin> getJoin(String usuario) {
        if (usuario == null){
            String query="""
            SELECT ELECTRODOMESTICOS.ELECTRO_ID, ELECTRODOMESTICOS.ELECTRO_TIPO, ELECTRODOMESTICOS.CUSTOMER_ID, ELECTRODOMESTICOS.TIEMPO_USO, PRECIOS.CONSUMO_MEDIO_HORA, PRECIOS.PRECIO_CONSUMO  
            FROM ELECTRODOMESTICOS
            INNER JOIN PRECIOS
            ON ELECTRODOMESTICOS.ELECTRO_TIPO=PRECIOS.ELECTRO_TIPO
            """;
            Iterable<ElectroPrecioJoin> resultado=template.query(query,
            (rs, rowNum) ->
                new ElectroPrecioJoin(rs.getLong("ELECTRO_ID"), rs.getString("ELECTRO_TIPO"), rs.getLong("CUSTOMER_ID"), rs.getInt("TIEMPO_USO"),rs.getInt("CONSUMO_MEDIO_HORA"), rs.getFloat("PRECIO_CONSUMO")) 
            );
            return resultado;
        } else {
            String query="""
            SELECT ELECTRODOMESTICOS.ELECTRO_ID, ELECTRODOMESTICOS.ELECTRO_TIPO, ELECTRODOMESTICOS.CUSTOMER_ID, ELECTRODOMESTICOS.TIEMPO_USO, PRECIOS.CONSUMO_MEDIO_HORA, PRECIOS.PRECIO_CONSUMO, CUSTOMER.CUSTOMER_NAME
            FROM ELECTRODOMESTICOS
            INNER JOIN PRECIOS
            WHERE CUSTOMER.CUSTOMER_ID = """ + usuario +"""
            ON ELECTRODOMESTICOS.ELECTRO_TIPO=PRECIOS.ELECTRO_TIPO
            """;
            Iterable<ElectroPrecioJoin> resultado=template.query(query,
            (rs, rowNum) ->
                new ElectroPrecioJoin(rs.getLong("ELECTRO_ID"), rs.getString("ELECTRO_TIPO"), rs.getLong("CUSTOMER_ID"), rs.getInt("TIEMPO_USO"),rs.getInt("CONSUMO_MEDIO_HORA"), rs.getFloat("PRECIO_CONSUMO")) 
            );
            return resultado;
        }
    }
  
}
