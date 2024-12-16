package org.educa.dao;

import org.educa.entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public List<ProductoEntity> findAllProducts(Session session) {
        Query<ProductoEntity> query = session.createQuery("FROM ProductoEntity", ProductoEntity.class);
        return query.getResultList();
    }
}
