package pe.edu.pucp.softven.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softven.dao.daoImpl.ProductoDAOImpl;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoDAOTest {
    
    private ProductoDAO productoDAO;
    
    public ProductoDAOTest() {
        this.productoDAO = new ProductoDAOImpl();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ProductosDTO producto = new ProductosDTO();
        producto.setNombre("curso 1");
        producto.setDescripcion("Descripción del curso 1");
        producto.setPrecio(299.99);
        Integer resultado = this.productoDAO.insertar(producto);
        System.out.println(resultado);
        assertTrue(resultado != 0);
        
        producto = new ProductosDTO();
        producto.setNombre("curso 2");
        producto.setDescripcion("Descripción del curso 2");
        producto.setPrecio(589.34);
        resultado = this.productoDAO.insertar(producto);
        System.out.println(resultado);
        assertTrue(resultado != 0);
        
        producto = new ProductosDTO();
        producto.setNombre("curso 3");
        producto.setDescripcion("Descripción del curso 3");
        producto.setPrecio(875.72);
        resultado = this.productoDAO.insertar(producto);
        System.out.println(resultado);
        assertTrue(resultado != 0);
    }
    
}
