package org.educa.dao;

import org.educa.entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public interface ProductoDAO {
    List<ProductoEntity> findAllProducts(Session session);

    ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color, Session session);

    List<ProductoEntity> findByName(ProductoEntity producto, Session session);
}
