package pe.edu.pucp.softven.bo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoBOTest {
    
    private ProductoBO productoBO;
    
    public ProductoBOTest() {
        this.productoBO = new ProductoBO();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer resultado = this.productoBO.insertar("Mi nuevo prodicto 1", "Descripción BO 1", 123.45);
        assertTrue(resultado >0);
        System.out.println(resultado);
        
        resultado = this.productoBO.insertar("Mi nuevo prodicto 2", "Descripción BO 2", 423.85);
        assertTrue(resultado >0);
        System.out.println(resultado);
    }
    
}
