package com.edu.proyect.Facturacion.controller;

import com.edu.proyect.Facturacion.model.Factura;
import com.edu.proyect.Facturacion.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api3/")
public class FacturaCtrl {
    
    @Autowired
    private FacturaService facturaService;

    @GetMapping("listarFacturas")
    public ResponseEntity< List<Factura>> obtenerLista() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("crearFactura")
    public ResponseEntity<Factura> crear(@RequestBody Factura f) {
        return new ResponseEntity<>(facturaService.save(f), HttpStatus.CREATED);
    }

    @DeleteMapping("eliminarFactura/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer idFactura) {
        facturaService.delete(idFactura);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("actualizarFactura/{id}")
    public ResponseEntity<Factura> actualizarArticulo(@RequestBody Factura fac, @PathVariable Integer idFactura) {
        Factura current = facturaService.findById(idFactura);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            current.setFecha(fac.getFecha());
            return new ResponseEntity<>(facturaService.save(current), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
