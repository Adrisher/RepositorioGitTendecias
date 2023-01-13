package com.edu.proyect.Facturacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Factura implements Serializable  {

    @Id
    @Column(name = "idFactura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente id_cliente;
    
    
    @OneToMany(mappedBy = "idDetalle")
    private List<Detalle_Factura> detalles;
}
