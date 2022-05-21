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

	public String getElectroTipo() {
		return electroTipo;
	}
	public void setElectroTipo(String electroTipo) {
		this.electroTipo = electroTipo;
	}
	public Float getConsumo() {
		return consumo;
	}
	public void setConsumo(Float consumo) {
		this.consumo = consumo;
	}
	public Float getPrecioConsumo() {
		return precioConsumo;
	}
	public void setPrecioConsumo(Float precioConsumo) {
		this.precioConsumo = precioConsumo;
	}
  
}
