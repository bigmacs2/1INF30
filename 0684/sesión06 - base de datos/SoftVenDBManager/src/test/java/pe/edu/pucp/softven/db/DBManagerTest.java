package pe.edu.pucp.softven.db;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DBManagerTest {
    
    public DBManagerTest() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
//        DBManager dbManager = new DBManager();
//        dbManager = new DBManager();
        DBManager dbManager = DBManager.getInstance();
        assertNotNull(dbManager);
        System.out.println(dbManager);
        DBManager dbManager2 = DBManager.getInstance();
        assertNotNull(dbManager2);
        System.out.println(dbManager2);
        assertEquals(dbManager, dbManager2);
    }
    
     @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DBManager dbManager = DBManager.getInstance();
        Connection conexion = dbManager.getConnection();
        assertNotNull(conexion);
    }
}
