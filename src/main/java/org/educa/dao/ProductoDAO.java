package org.educa.dao;

import org.educa.entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public interface ProductoDAO {
    List<ProductoEntity> findAllProducts(Session session);
}
