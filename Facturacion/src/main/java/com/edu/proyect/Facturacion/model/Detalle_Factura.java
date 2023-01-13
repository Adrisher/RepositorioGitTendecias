package com.edu.proyect.Facturacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Detalle_Factura implements Serializable  {

    @Id
    @Column(name = "idDetalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;
    
    @Column(name = "numDetalle")
    private Integer numDetalle;
    
    @Column(name = "numFactura")
    private Integer numDefactura;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    
    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    private Factura id_factura;
    
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    private Producto id_producto;
    
    
}
