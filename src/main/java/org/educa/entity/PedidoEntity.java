package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class PedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha")
    private Timestamp fecha;
    @Column(name = "id_cliente")
    private ClienteEntity cliente;
    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private DireccionEntity direccion;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPedidoEntity estadoPedido;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido"))
    private List<ProductoEntity> productos;
}