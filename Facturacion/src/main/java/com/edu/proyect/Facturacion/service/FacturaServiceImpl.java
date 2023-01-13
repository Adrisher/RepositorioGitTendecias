package com.edu.proyect.Facturacion.service;


import com.edu.proyect.Facturacion.model.Factura;
import com.edu.proyect.Facturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Integer> implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public CrudRepository<Factura, Integer> getDao() {
        return facturaRepository;
    }
    
     public Factura buscarFactura(Integer idFactura) {
        return facturaRepository.searchFactura(idFactura);
    }

}
