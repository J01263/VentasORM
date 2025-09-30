package com.empresa.dao;

import com.empresa.modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClienteDAO {

    private SessionFactory factory;

    public ClienteDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void guardar(Cliente cliente) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        session.close();
    }

    public Cliente buscarPorNombre(String nombre) {
        Session session = factory.openSession();
        Cliente resultado = session.createQuery("FROM Cliente WHERE nombre = :nombre", Cliente.class)
                .setParameter("nombre", nombre)
                .uniqueResult();
        session.close();
        return resultado;
    }
}
