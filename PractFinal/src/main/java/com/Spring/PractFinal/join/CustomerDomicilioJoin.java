package com.Spring.PractFinal.join;

import java.util.Objects;

public class CustomerDomicilioJoin {
  private Long customerid;
  private String calle;
  private String numPiso;
  private String provincia;
  private String ciudad;
  private Integer codigoPostal;
  private String pais;

  public CustomerDomicilioJoin() {
  }

  public CustomerDomicilioJoin(Long customerid,String calle, String numPiso, String provincia, String ciudad, Integer codigoPostal, String pais) {
    this.customerid = customerid;
    this.calle = calle;
    this.numPiso = numPiso;
    this.provincia = provincia;
    this.ciudad = ciudad;
    this.codigoPostal = codigoPostal;
    this.pais = pais;
  }

  public Long getCustomerid() {
    return this.customerid;
  }

  public void setCustomerid(Long customerid) {
    this.customerid = customerid;
  }

  public String getCalle() {
    return this.calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public String getNumPiso() {
    return this.numPiso;
  }

  public void setNumPiso(String numPiso) {
    this.numPiso = numPiso;
  }

  public String getProvincia() {
    return this.provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getCiudad() {
    return this.ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Integer getCodigoPostal() {
    return this.codigoPostal;
  }

  public void setCodigoPostal(Integer codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getPais() {
    return this.pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public CustomerDomicilioJoin customerid(Long customerid) {
    setCustomerid(customerid);
    return this;
  }

  public CustomerDomicilioJoin calle(String calle) {
    setCalle(calle);
    return this;
  }

  public CustomerDomicilioJoin numPiso(String numPiso) {
    setNumPiso(numPiso);
    return this;
  }

  public CustomerDomicilioJoin provincia(String provincia) {
    setProvincia(provincia);
    return this;
  }

  public CustomerDomicilioJoin ciudad(String ciudad) {
    setCiudad(ciudad);
    return this;
  }

  public CustomerDomicilioJoin codigoPostal(Integer codigoPostal) {
    setCodigoPostal(codigoPostal);
    return this;
  }

  public CustomerDomicilioJoin pais(String pais) {
    setPais(pais);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerDomicilioJoin)) {
            return false;
        }
        CustomerDomicilioJoin customerDomicilioJoin = (CustomerDomicilioJoin) o;
        return Objects.equals(customerid, customerDomicilioJoin.customerid) && Objects.equals(calle, customerDomicilioJoin.calle) && Objects.equals(numPiso, customerDomicilioJoin.numPiso) && Objects.equals(provincia, customerDomicilioJoin.provincia) && Objects.equals(ciudad, customerDomicilioJoin.ciudad) && Objects.equals(codigoPostal, customerDomicilioJoin.codigoPostal) && Objects.equals(pais, customerDomicilioJoin.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerid, calle, numPiso, provincia, ciudad, codigoPostal, pais);
  }

  @Override
  public String toString() {
    return "{" +
      " customerid='" + getCustomerid() + "'" +
      ", calle='" + getCalle() + "'" +
      ", numPiso='" + getNumPiso() + "'" +
      ", provincia='" + getProvincia() + "'" +
      ", ciudad='" + getCiudad() + "'" +
      ", codigoPostal='" + getCodigoPostal() + "'" +
      ", pais='" + getPais() + "'" +
      "}";
  }

}