package com.edu.proyect.Facturacion.controller;

import com.edu.proyect.Facturacion.model.Cliente;
import com.edu.proyect.Facturacion.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ClienteCtrl {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("listarClientes")
    public ResponseEntity< List<Cliente>> obtenerLista() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("crearCliente")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente c) {
        return new ResponseEntity<>(clienteService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("eliminarCliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer idCliente) {
        clienteService.delete(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("actualizarCliente/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cli, @PathVariable Integer idCliente) {
        Cliente current = clienteService.findById(idCliente);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            current.setNombre(cli.getNombre());
            current.setApellido(cli.getApellido());
            return new ResponseEntity<>(clienteService.save(current), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
