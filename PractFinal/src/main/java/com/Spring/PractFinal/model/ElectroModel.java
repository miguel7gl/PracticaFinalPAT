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
  
  public Long getElectroId() {
    return electroId;
  }
  public void setElectroId(Long electroId) {
    this.electroId = electroId;
  }
  public String getElectroTipo() {
    return electroTipo;
  }
  public void setElectroTipo(String electroTipo) {
    this.electroTipo = electroTipo;
  }
  public Long getCustomerId() {
    return customerId;
  }
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
  public Integer getTiempoUso() {
    return tiempoUso;
  }
  public void setTiempoUso(Integer tiempoUso) {
    this.tiempoUso = tiempoUso;
  }
}
