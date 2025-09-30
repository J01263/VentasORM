package com.empresa.dao;

import com.empresa.modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClienteDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Cliente buscarPorNombre(String nombre) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Cliente WHERE nombre = :nombre", Cliente.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
        }
    }
}
