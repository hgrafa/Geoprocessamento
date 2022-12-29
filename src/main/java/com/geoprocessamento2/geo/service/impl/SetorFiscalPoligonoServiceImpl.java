package com.geoprocessamento2.geo.service.impl;

import com.geoprocessamento2.geo.entity.SetorFiscalPoligono;

import com.geoprocessamento2.geo.repository.SetorFiscalPoligonoRepository;
import com.geoprocessamento2.geo.service.SetorFiscalPoligonoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SetorFiscalPoligonoServiceImpl implements SetorFiscalPoligonoService {

  private SetorFiscalPoligonoRepository repository;

  @Override
  public SetorFiscalPoligono pegarPorCodigo(String stcodigo){
    return repository
      .encontrarByStcodigo(stcodigo)
      .get();
  }

}
