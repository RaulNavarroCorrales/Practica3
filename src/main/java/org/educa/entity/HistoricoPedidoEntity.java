package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historico_pedido")

public class HistoricoPedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cambios")
    private String cambios;
    @Column(name = "usu_mod")
    private String usuMod;
    @Column(name = "fec_mod")
    private Timestamp fecMod;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private PedidoEntity pedido;
}
