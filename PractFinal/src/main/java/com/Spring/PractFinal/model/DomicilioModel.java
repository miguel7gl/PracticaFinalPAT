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
@Table("DOMICILIOS")
public class DomicilioModel {
  private @Column("CUSTOMER_ID") @Id Long customerId;
	private @Column("CALLE") String calle;
	private @Column("NUM_PISO") String numPiso;
  private @Column("PROVINCIA") String tiempoUso;
  private @Column("CIUDAD") String ciudad;
  private @Column("CODIGO_POSTAL") Integer codigoPostal;
  private @Column("PAIS") String pais;
}