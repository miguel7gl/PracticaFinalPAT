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
public class InfoElectroModel {
  private @Column("ELECTRO_ID") Long electroId;
	private @Column("MARCA") String marca;
	private @Column("EFICIENCIA") String eficiencia;
	
	public Long getElectroId() {
		return electroId;
	}
	public void setElectroid(Long electroId) {
		this.electroId = electroId;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getEficiencia() {
		return eficiencia;
	}
	public void setEficiencia(String eficiencia) {
		this.eficiencia = eficiencia;
	}
  
}
