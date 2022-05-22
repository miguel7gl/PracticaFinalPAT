package com.Spring.PractFinal.join;
// Se va a crear una clase para poder pasar los atributos de domicilio y ciustomer en un solo post al request body

import java.util.Objects;

public class Registro {
  private String  customerName;
  private String  password;
  private String  calle;
  private String  numPiso;
  private String  ciudad;
  private String  provincia;
  private Integer codigopostal;
  private String  pais;

  public Registro() {
  }

  public Registro(String customerName, String password, String calle, String numPiso, String ciudad, String provincia, Integer codigopostal, String pais) {
    this.customerName = customerName;
    this.password = password;
    this.calle = calle;
    this.numPiso = numPiso;
    this.ciudad = ciudad;
    this.provincia = provincia;
    this.codigopostal = codigopostal;
    this.pais = pais;
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

  public String getCiudad() {
    return this.ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getProvincia() {
    return this.provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public Integer getCodigopostal() {
    return this.codigopostal;
  }

  public void setCodigopostal(Integer codigopostal) {
    this.codigopostal = codigopostal;
  }

  public String getPais() {
    return this.pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public Registro customerName(String customerName) {
    setCustomerName(customerName);
    return this;
  }

  public Registro password(String password) {
    setPassword(password);
    return this;
  }

  public Registro calle(String calle) {
    setCalle(calle);
    return this;
  }

  public Registro numPiso(String numPiso) {
    setNumPiso(numPiso);
    return this;
  }

  public Registro ciudad(String ciudad) {
    setCiudad(ciudad);
    return this;
  }

  public Registro provincia(String provincia) {
    setProvincia(provincia);
    return this;
  }

  public Registro codigopostal(Integer codigopostal) {
    setCodigopostal(codigopostal);
    return this;
  }

  public Registro pais(String pais) {
    setPais(pais);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Registro)) {
            return false;
        }
        Registro registro = (Registro) o;
        return Objects.equals(customerName, registro.customerName) && Objects.equals(password, registro.password) && Objects.equals(calle, registro.calle) && Objects.equals(numPiso, registro.numPiso) && Objects.equals(ciudad, registro.ciudad) && Objects.equals(provincia, registro.provincia) && Objects.equals(codigopostal, registro.codigopostal) && Objects.equals(pais, registro.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerName, password, calle, numPiso, ciudad, provincia, codigopostal, pais);
  }

  @Override
  public String toString() {
    return "{" +
      " customerName='" + getCustomerName() + "'" +
      ", password='" + getPassword() + "'" +
      ", calle='" + getCalle() + "'" +
      ", numPiso='" + getNumPiso() + "'" +
      ", ciudad='" + getCiudad() + "'" +
      ", provincia='" + getProvincia() + "'" +
      ", codigopostal='" + getCodigopostal() + "'" +
      ", pais='" + getPais() + "'" +
      "}";
  }
}