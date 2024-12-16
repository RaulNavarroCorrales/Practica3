package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImpl;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ClienteEntity;
import org.hibernate.Session;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    //TODO: Método de login
    public ClienteEntity login(String dni, String password) {
        try (Session session = DAOSession.getSession()) {
            ClienteEntity cliente = clienteDAO.login(dni, session);
            if (cliente == null) {
                return null;
            } else {
                if (cliente.getPass().equals(password)) {
                    return cliente;
                } else {
                    return null;
                }
            }
        }
    }
}
