package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.PedidoDAOImpl;
import org.educa.entity.EstadoPedidoEntity;
import org.educa.entity.PedidoEntity;
import org.educa.entity.ProductoEntity;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();
    private final ProductoService productoService = new ProductoService();

    //TODO: Crear pedido
    public void insertarPedido(PedidoEntity pedido) {
        pedidoDAO.insertarPedido(pedido);

        for (ProductoEntity producto : pedido.getProductos()) {
            productoService.marcarProductoVendido(producto);
        }
    }
}