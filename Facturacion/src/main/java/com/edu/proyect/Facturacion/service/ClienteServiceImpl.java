package com.edu.proyect.Facturacion.service;

import com.edu.proyect.Facturacion.model.Cliente;
import com.edu.proyect.Facturacion.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Cliente, Integer> getDao() {
        return clienteRepository;
    }

    public Cliente buscarCliente(String cedula) {
        return clienteRepository.searchClient(cedula);
    }

}
