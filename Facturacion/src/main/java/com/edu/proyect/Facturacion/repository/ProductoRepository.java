package com.edu.proyect.Facturacion.repository;


import com.edu.proyect.Facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "Select * from producto p where p.id_producto = id_producto", nativeQuery = true)
    public Producto searchProduct(Integer idProducto);
    

}
