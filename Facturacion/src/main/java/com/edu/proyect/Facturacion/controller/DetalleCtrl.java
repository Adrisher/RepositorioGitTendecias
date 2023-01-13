package com.edu.proyect.Facturacion.controller;

import com.edu.proyect.Facturacion.model.Detalle_Factura;
import com.edu.proyect.Facturacion.service.DetalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2/")
public class DetalleCtrl {

    @Autowired
    private DetalleService detalleService;

    @GetMapping("listarDetalles")
    public ResponseEntity< List<Detalle_Factura>> obtenerLista() {
        return new ResponseEntity<>(detalleService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("crearDetalle")
    public ResponseEntity<Detalle_Factura> crear(@RequestBody Detalle_Factura d) {
        return new ResponseEntity<>(detalleService.save(d), HttpStatus.CREATED);
    }

    @DeleteMapping("eliminarDetalle/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer idDetalle) {
        detalleService.delete(idDetalle);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("actualizarDetalle/{id}")
    public ResponseEntity<Detalle_Factura> actualizarArticulo(@RequestBody Detalle_Factura det, @PathVariable Integer idDetalle) {
        Detalle_Factura current = detalleService.findById(idDetalle);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            current.setNumDetalle(det.getNumDetalle());
            current.setNumDefactura(det.getNumDefactura());
            current.setCantidad(det.getCantidad());
            return new ResponseEntity<>(detalleService.save(current), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
