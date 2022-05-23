package com.Spring.PractFinal.service;

import com.Spring.PractFinal.join.ElectroPrecioJoin;
import com.Spring.PractFinal.model.ElectroModel;

public interface ElectroService {
  Iterable<ElectroModel> getAllElectro();
  
  Iterable<ElectroPrecioJoin> getJoin();

  ElectroModel postElectro(ElectroModel electrodomestico);
}
