package pe.edu.pucp.softinv.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.daoImpl.AlmacenDAOImpl;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOTest {
    
    private AlmacenDAO almacenDAO;
    
    public AlmacenDAOTest() {
        this.almacenDAO = new AlmacenDAOImpl();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer retorno = null;
        AlmacenesDTO almacen = new AlmacenesDTO();
        almacen.setNombre("Almacen central");
        almacen.setAlmacen_central(Boolean.TRUE);
        retorno = almacenDAO.insertar(almacen);
        assertTrue(retorno != 0);
        System.out.println("id: " + retorno);
        
        almacen.setNombre("Almacen PUCP");
        almacen.setAlmacen_central(Boolean.FALSE);
        retorno = almacenDAO.insertar(almacen);
        assertTrue(retorno != 0);
        System.out.println("id: " + retorno);
        
        almacen.setNombre("Almacen Progra3");
        almacen.setAlmacen_central(Boolean.FALSE);
        retorno = almacenDAO.insertar(almacen);
        assertTrue(retorno != 0);
        System.out.println("id: " + retorno);
    }
    
}
