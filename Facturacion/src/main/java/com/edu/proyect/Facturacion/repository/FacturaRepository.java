package com.edu.proyect.Facturacion.repository;


import com.edu.proyect.Facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    @Query(value = "Select * from factura f where f.id_factura = id_factura", nativeQuery = true)
    public Factura searchFactura(Integer idFactura);

}
