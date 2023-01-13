package com.edu.proyect.Facturacion.service;

import com.edu.proyect.Facturacion.model.Detalle_Factura;
import com.edu.proyect.Facturacion.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends GenericServiceImpl<Detalle_Factura, Integer> implements DetalleService {

    @Autowired
    DetalleRepository detalleRepository;

    @Override
    public CrudRepository<Detalle_Factura, Integer> getDao() {
        return detalleRepository;
    }

    public Detalle_Factura buscarDetalle(Integer idDetalle) {
        return detalleRepository.searchDetail(idDetalle);
    }
}
