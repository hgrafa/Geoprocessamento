package com.geoprocessamento2.geo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "setoresfiscais")
@Data @NoArgsConstructor
public class SetorFiscalPoligono implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "geom")
  private Polygon polygon;


  private String name;

//  private String description;

  private String stcodigo;

//  private String stid;

//  private String stsituac;



}
