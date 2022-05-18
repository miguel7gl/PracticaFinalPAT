package com.Spring.PractFinal.join;

import java.util.Objects;

public class CustomerElectroJoin {
  private Long customerID;
  private String customerName;
  private String password;
  private Long electroId;
  private String electroTipo;
  private Integer tiempoUso;

  public CustomerElectroJoin(Long customerID, String customerName, String password, Long electroId, String electroTipo, Integer tiempoUso) {
    this.customerID = customerID;
    this.customerName = customerName;
    this.password = password;
    this.electroId = electroId;
    this.electroTipo = electroTipo;
    this.tiempoUso = tiempoUso;
  }
  public Long getCustomerID() {
    return this.customerID;
  }

  public void setCustomerID(Long customerID) {
    this.customerID = customerID;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getElectroID() {
    return this.electroId;
  }

  public void setElectroID(Long electroId) {
    this.electroId = electroId;
  }

  public String getelectroTipo() {
    return this.electroTipo;
  }

  public void setelectroTipo(String electroTipo) {
    this.electroTipo = electroTipo;
  }

  public Integer getTiempoUso() {
    return this.tiempoUso;
  }

  public void setTiempoUso(Integer tiempoUso) {
    this.tiempoUso = tiempoUso;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerElectroJoin)) {
            return false;
        }
        CustomerElectroJoin customerElectroJoin = (CustomerElectroJoin) o;
        return Objects.equals(customerID, customerElectroJoin.customerID) && Objects.equals(customerName, customerElectroJoin.customerName) && Objects.equals(password, customerElectroJoin.password) && Objects.equals(electroId, customerElectroJoin.electroId) && Objects.equals(electroTipo, customerElectroJoin.electroTipo) && Objects.equals(tiempoUso, customerElectroJoin.tiempoUso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerID, customerName, password, electroId, electroTipo, tiempoUso);
  }

}