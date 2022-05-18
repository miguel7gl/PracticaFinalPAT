package com.Spring.PractFinal.join;

import java.util.Objects;

public class ElectroPrecioJoin {
  private Long electroId;
  private String electroTipo;
  private Long customerId;
  private Integer tiempoUso;
  private Integer consumo;
  private Float precioConsumo;

  public ElectroPrecioJoin() {
  }

  public ElectroPrecioJoin(Long electroId, String electroTipo, Long customerId, Integer tiempoUso, Integer consumo, Float precioConsumo) {
    this.electroId = electroId;
    this.electroTipo = electroTipo;
    this.customerId = customerId;
    this.tiempoUso = tiempoUso;
    this.consumo = consumo;
    this.precioConsumo = precioConsumo;
  }

  public Long getElectroId() {
    return this.electroId;
  }

  public void setElectroId(Long electroId) {
    this.electroId = electroId;
  }

  public String getElectroTipo() {
    return this.electroTipo;
  }

  public void setElectroTipo(String electroTipo) {
    this.electroTipo = electroTipo;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Integer getTiempoUso() {
    return this.tiempoUso;
  }

  public void setTiempoUso(Integer tiempoUso) {
    this.tiempoUso = tiempoUso;
  }

  public Integer getConsumo() {
    return this.consumo;
  }

  public void setConsumo(Integer consumo) {
    this.consumo = consumo;
  }

  public Float getPrecioConsumo() {
    return this.precioConsumo;
  }

  public void setPrecioConsumo(Float precioConsumo) {
    this.precioConsumo = precioConsumo;
  }

  public ElectroPrecioJoin electroId(Long electroId) {
    setElectroId(electroId);
    return this;
  }

  public ElectroPrecioJoin electroTipo(String electroTipo) {
    setElectroTipo(electroTipo);
    return this;
  }

  public ElectroPrecioJoin customerId(Long customerId) {
    setCustomerId(customerId);
    return this;
  }

  public ElectroPrecioJoin tiempoUso(Integer tiempoUso) {
    setTiempoUso(tiempoUso);
    return this;
  }

  public ElectroPrecioJoin consumo(Integer consumo) {
    setConsumo(consumo);
    return this;
  }

  public ElectroPrecioJoin precioConsumo(Float precioConsumo) {
    setPrecioConsumo(precioConsumo);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ElectroPrecioJoin)) {
            return false;
        }
        ElectroPrecioJoin electroPrecioJoin = (ElectroPrecioJoin) o;
        return Objects.equals(electroId, electroPrecioJoin.electroId) && Objects.equals(electroTipo, electroPrecioJoin.electroTipo) && Objects.equals(customerId, electroPrecioJoin.customerId) && Objects.equals(tiempoUso, electroPrecioJoin.tiempoUso) && Objects.equals(consumo, electroPrecioJoin.consumo) && Objects.equals(precioConsumo, electroPrecioJoin.precioConsumo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(electroId, electroTipo, customerId, tiempoUso, consumo, precioConsumo);
  }

  @Override
  public String toString() {
    return "{" +
      " electroId='" + getElectroId() + "'" +
      ", electroTipo='" + getElectroTipo() + "'" +
      ", customerId='" + getCustomerId() + "'" +
      ", tiempoUso='" + getTiempoUso() + "'" +
      ", consumo='" + getConsumo() + "'" +
      ", precioConsumo='" + getPrecioConsumo() + "'" +
      "}";
  }
  
}