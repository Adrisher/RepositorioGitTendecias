package com.edu.proyect.Facturacion.controller;


import com.edu.proyect.Facturacion.model.Producto;
import com.edu.proyect.Facturacion.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api4/")
public class ProductoCtrl {

    @Autowired
    private ProductoService productoService;

    @GetMapping("listarProductos")
    public ResponseEntity< List<Producto>> obtenerLista() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("crearProducto")
    public ResponseEntity<Producto> crear(@RequestBody Producto p) {
        return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
    }

    @DeleteMapping("eliminarProducto/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer idProdcuto) {
        productoService.delete(idProdcuto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("actualizarProducto/{id}")
    public ResponseEntity<Producto> actualizarArticulo(@RequestBody Producto pro, @PathVariable Integer idProducto) {
        Producto current = productoService.findById(idProducto);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            current.setNombre(pro.getNombre());
            current.setPrecio(pro.getPrecio());
            current.setStock(pro.getStock());
            return new ResponseEntity<>(productoService.save(current), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
