package com.Spring.PractFinal.model;


import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("PRECIOS")
public class PrecioModel {
  private @Column("ELECTRO_TIPO") String electroTipo;
	private @Column("CONSUMO_MEDIO_HORA") Float consumo;
	private @Column("PRECIO_CONSUMO") Float precioConsumo;
  
}
