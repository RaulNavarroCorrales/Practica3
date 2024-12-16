package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the producto database table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Column(name = "color")
    private String color;
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private BigDecimal precio;
    //Variable para guardar el precio final aplicado los descuentos
    @Transient
    private BigDecimal precioFinal;
    @Column(name = "talla")
    private String talla;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    @ManyToOne
    @JoinColumn(name = "coleccion")
    private ColeccionEntity coleccionBean;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoProductoEntity estadoProducto;
    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoProductoEntity tipoProducto;
    @ManyToMany(mappedBy = "productos")
    private List<PedidoEntity> pedidos;
}