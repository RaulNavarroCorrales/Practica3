package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.EstadoPedidoEntity;
import org.educa.entity.HistoricoPedidoEntity;
import org.educa.entity.PedidoEntity;
import org.hibernate.Session;

import java.sql.Timestamp;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public void insertarPedido(PedidoEntity pedido) {
        try (Session session = DAOSession.getSession()){
            EstadoPedidoEntity estadoPedido = new EstadoPedidoEntity();
            estadoPedido.setId(1);
            pedido.setEstadoPedido(estadoPedido);
            pedido.setFecha(new Timestamp(System.currentTimeMillis()));

            session.persist(pedido);
            crearHistorico(pedido, session);
            session.getTransaction().commit();
        }
    }

    private void crearHistorico(PedidoEntity pedido, Session session) {
        HistoricoPedidoEntity historicoPedido = new HistoricoPedidoEntity();
        historicoPedido.setPedido(pedido);
        historicoPedido.setCambios("Pedido creado");
        historicoPedido.setUsuMod("postgres");
        historicoPedido.setFecMod(new Timestamp(System.currentTimeMillis()));
        session.persist(historicoPedido);
    }
}
