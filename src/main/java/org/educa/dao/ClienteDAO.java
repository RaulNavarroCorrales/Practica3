package org.educa.dao;

import org.educa.entity.ClienteEntity;
import org.hibernate.Session;

public interface ClienteDAO {
    ClienteEntity login(String dni, Session session);
}
