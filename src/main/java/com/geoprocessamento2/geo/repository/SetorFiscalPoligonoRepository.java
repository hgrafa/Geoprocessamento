package com.geoprocessamento2.geo.repository;

import com.geoprocessamento2.geo.entity.SetorFiscalPoligono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SetorFiscalPoligonoRepository extends JpaRepository<SetorFiscalPoligono, Long> {
  @Query(value = "Select sf.Id, sf.geom, sf.name, sf.stcodigo " +
          "from setoresfiscais sf where sf.stcodigo = :codigo", nativeQuery = true)
  Optional<SetorFiscalPoligono> encontrarByStcodigo(@Param("codigo")String codigo);

}
