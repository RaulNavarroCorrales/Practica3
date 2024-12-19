package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
    @ManyToOne
    @JoinColumn(name = "direccion")
    private DireccionEntity direccion;
    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoPedidoEntity estadoPedido;
    @ManyToMany
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<ProductoEntity> productos = new ArrayList<>();
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HistoricoPedidoEntity historicoPedido;

}