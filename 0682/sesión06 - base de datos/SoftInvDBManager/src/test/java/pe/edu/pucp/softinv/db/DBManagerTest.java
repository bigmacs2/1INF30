package pe.edu.pucp.softinv.db;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DBManagerTest {
    
    public DBManagerTest() {
        //DBManager dbManager = new DBManager();
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DBManager dbManager = DBManager.getInstance();
        assertNotNull(dbManager);
        System.out.println(dbManager);
        DBManager dbManagerClone = DBManager.getInstance();
        System.out.println(dbManager);
        assertEquals(dbManager, dbManagerClone);
    }
    
    @Test
    public void testGetConnection(){
        System.out.println("getConnection");
        DBManager dbManager = DBManager.getInstance();
        Connection conexion = dbManager.getConnection();
        assertNotNull(conexion);
        System.out.println(conexion);
        conexion = dbManager.getConnection();
        assertNotNull(conexion);
        System.out.println(conexion);
    }
}
