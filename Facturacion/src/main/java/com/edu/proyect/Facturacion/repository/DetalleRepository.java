package com.edu.proyect.Facturacion.repository;

import com.edu.proyect.Facturacion.model.Detalle_Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle_Factura, Integer> {

   @Query(value = "Select * from detalle_factura d where d.id_detalle = id_detalle", nativeQuery = true)
    public Detalle_Factura searchDetail(Integer idDetalle);
    

}
