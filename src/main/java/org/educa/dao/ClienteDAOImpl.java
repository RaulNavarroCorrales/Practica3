package org.educa.dao;

import org.educa.entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public ClienteEntity login(String dni, Session session) {
        Query<ClienteEntity> query = session.createQuery("FROM ClienteEntity WHERE dni = :dni", ClienteEntity.class)
                .setParameter("dni", dni);
        return query.uniqueResult();
    }
}
