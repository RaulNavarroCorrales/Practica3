package org.educa.dao;

import org.educa.entity.PedidoEntity;
import org.hibernate.Session;

public interface PedidoDAO {
    void insertarPedido(PedidoEntity pedido, Session session);
}
