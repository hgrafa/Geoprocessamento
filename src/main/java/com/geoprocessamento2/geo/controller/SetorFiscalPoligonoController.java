package com.geoprocessamento2.geo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geoprocessamento2.geo.entity.SetorFiscalPoligono;
import com.geoprocessamento2.geo.service.SetorFiscalPoligonoService;
import lombok.AllArgsConstructor;
import org.postgis.Polygon;
import org.postgis.geojson.PostGISModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/setoresFiscais")
@AllArgsConstructor
public class SetorFiscalPoligonoController {
  
  private SetorFiscalPoligonoService service;

  @GetMapping("/buscar/stCodigo")
  public ResponseEntity<SetorFiscalPoligono> getByStcodigo(@RequestParam("codigo") String codigo) throws JsonProcessingException {
    System.out.println("codigo =" + codigo);
    SetorFiscalPoligono setorFiscalPoligono = service.pegarPorCodigo(codigo);

    if(setorFiscalPoligono == null){
      return ResponseEntity.badRequest().build();
    }
    ObjectMapper om = new ObjectMapper();
    om.registerModule(new PostGISModule());
    String json = om.writeValueAsString(setorFiscalPoligono.getPolygon());
    System.out.println(json);
    return ResponseEntity.ok().body(setorFiscalPoligono);
  }

}
