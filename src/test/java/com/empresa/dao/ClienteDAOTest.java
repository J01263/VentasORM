package com.empresa.dao;

import com.empresa.modelo.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteDAOTest {

    @Test
    public void pruebaGuardarYBuscar() {
        ClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");

        dao.guardar(cliente); // Usa el método público

        Cliente resultado = dao.buscarPorNombre("Juan"); // Usa el método público

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }
}
