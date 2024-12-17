package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.PedidoDAOImpl;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.PedidoEntity;
import org.hibernate.Session;

public class PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();
    //TODO: Crear pedido
    public void insertarPedido(PedidoEntity pedido) {
        try(Session session = DAOSession.getSession()) {
            pedidoDAO.insertarPedido(pedido, session);
        }
    }
}
