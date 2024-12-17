package org.educa.dao;

import org.educa.entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
    public List<ProductoEntity> findAllProducts(Session session) {
        List<ProductoEntity> productos;
        return session.createNativeQuery("SELECT distinct on (nombre) * " +
                "FROM producto", ProductoEntity.class).getResultList();

    }

    @Override
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color, Session session) {
        return session.createQuery("FROM ProductoEntity WHERE " +
                "UPPER(nombre) LIKE UPPER(:nombre) " +
                "AND estadoProducto = 1 " +
                "AND UPPER(talla) LIKE UPPER(:talla) " +
                "AND UPPER(color) LIKE UPPER(:color)", ProductoEntity.class)
                .setParameter("nombre", nombre)
                .setParameter("talla", talla)
                .setParameter("color", color).setMaxResults(1).uniqueResult();
    }

    @Override
    public List<ProductoEntity> findByName(ProductoEntity producto, Session session) {
        Query<ProductoEntity> query = session.createNativeQuery("SELECT distinct on (nombre, talla) * " +
                        "FROM producto " +
                        "where upper(nombre) like upper(:nombre) ", ProductoEntity.class)
                .setParameter("nombre", producto.getNombre());
        return query.getResultList();
    }
}
