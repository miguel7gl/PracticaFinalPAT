package com.Spring.PractFinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("ELECTRODOMESTICOS")
public class ElectroModel {
  private @Column("ELECTRO_ID") @Id Long electroId;
	private @Column("ELECTRO_TIPO") String electroTipo;
	private @Column("CUSTOMER_ID") Long customerId;
  private @Column("TIEMPO_USO") Integer tiempoUso;
}
