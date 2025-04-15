package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOImpl implements AlmacenDAO {
    
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;          
    
    public AlmacenDAOImpl(){
        this.conexion = null;
        this.statement = null;
    }

    @Override
    public Integer insertar(AlmacenesDTO almacen) {
        Integer retorno = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO INV_ALMACENES(NOMBRE, ALMACEN_CENTRAL) VALUES (?, ?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, almacen.getNombre());
            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
            this.statement.executeUpdate();
            retorno = this.retornarUltimoAutoGenerado();
            this.conexion.commit();
        } catch (SQLException ex) {
            if (this.conexion != null) {
                try {
                    this.conexion.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (this.conexion != null) {
                try {
                    this.conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    @Override
    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AlmacenesDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(AlmacenesDTO almacen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(AlmacenesDTO almacen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        String sql = "select @@last_insert_id as id";
        try {
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()){
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
