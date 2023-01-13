package com.edu.proyect.Facturacion.service;


import com.edu.proyect.Facturacion.model.Producto;
import com.edu.proyect.Facturacion.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }
    
    public Producto buscarProducto(Integer idProducto) {
        return productoRepository.searchProduct(idProducto);
    }
}
