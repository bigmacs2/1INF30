package pe.edu.pucp.softinv.db.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CifradoTest {
    
    public CifradoTest() {
    }
    
    @Test
    public void testCifrarMD5() {
        System.out.println("cifrarMD5");
        String texto = "Programacion3!";
        String resultado = Cifrado.cifrarMD5(texto);
        String resultado_esperado = "GFvzT/oALwhgBEPlFFB2EA==";
        assertEquals(resultado, resultado_esperado);
    }

    @Test
    public void testDescifrarMD5() {
        System.out.println("descifrarMD5");
        String texto = "GFvzT/oALwhgBEPlFFB2EA==";
        String resultado = Cifrado.descifrarMD5(texto);
        String resultado_esperado = "Programacion3!";
        assertEquals(resultado, resultado_esperado);
    }
    
}
