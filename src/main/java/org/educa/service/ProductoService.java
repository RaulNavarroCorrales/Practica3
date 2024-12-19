package org.educa.service;

import org.educa.dao.ProductoDAO;
import org.educa.dao.ProductoDAOImpl;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ProductoEntity;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;

public class ProductoService {
    private final ProductoDAO productoDAO = new ProductoDAOImpl();

    public List<ProductoEntity> findAllProducts() throws SQLException {
        try (Session session = DAOSession.getSession()) {
            List<ProductoEntity> productos = productoDAO.findAllProducts(session);
            for (ProductoEntity producto : productos) {
                calcularPrecioFinal(producto);
            }
            return productos;
        }
    }

    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color) throws SQLException {
        try (Session session = DAOSession.getSession()) {
            return productoDAO.getFirstProductoByNameTallaAndColor(nombre, talla, color, session);
        }
    }

    public List<ProductoEntity> findByName(ProductoEntity producto) throws SQLException {
        try (Session session = DAOSession.getSession()) {
            return productoDAO.findByName(producto, session);
        }
    }

    private void calcularPrecioFinal(ProductoEntity producto) {
        if (producto.getDescuento() != null) {
            producto.setPrecioFinal(producto.getPrecio().subtract(producto.getPrecio().multiply(producto.getDescuento().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP))).setScale(2, RoundingMode.HALF_UP));
        } else producto.setPrecioFinal(producto.getPrecio().setScale(2, RoundingMode.HALF_UP));
    }

    public void marcarProductoVendido(ProductoEntity producto) {
        productoDAO.marcarProductoVendido(producto);
    }
}