package com.Spring.PractFinal.service;

import com.Spring.PractFinal.model.DomicilioModel;

public interface DomicilioService {
  
  Iterable<DomicilioModel> getAllDomicilios();

  
  DomicilioModel postDomicilio(DomicilioModel domicilio);
}
