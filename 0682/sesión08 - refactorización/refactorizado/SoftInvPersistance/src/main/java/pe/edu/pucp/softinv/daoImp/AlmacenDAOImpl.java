package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.daoImp.util.Columna;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOImpl extends DAOImplBase implements AlmacenDAO {

    private AlmacenesDTO almacen;

    public AlmacenDAOImpl() {
        super("INV_ALMACENES");
        this.retornarLlavePrimaria = true;
        this.almacen = null;
    }

    @Override
    protected void configurarListaDeColumna() {
        this.listaColumnas.add(new Columna("ALMACEN_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("ALMACEN_CENTRAL", false, false));
    }

    @Override
    public Integer insertar(AlmacenesDTO almacen) {
        this.almacen = almacen;
        return super.insertar();
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() {
        try {
            this.statement.setString(1, this.almacen.getNombre());
            this.statement.setInt(2, this.almacen.getAlmacen_central()?1:0);
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        AlmacenesDTO almacen = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = this.generarSQLParaObtenerPorId();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, almacenId);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                almacen = new AlmacenesDTO();
                almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
                almacen.setNombre(this.resultSet.getString("NOMBRE"));
                almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return almacen;
    }

    @Override
    public ArrayList<AlmacenesDTO> listarTodos() {
        ArrayList<AlmacenesDTO> listaAlmacenes = new ArrayList<>();
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = this.generarSQLParaListarTodos();
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                AlmacenesDTO almacen = new AlmacenesDTO();
                almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
                almacen.setNombre(this.resultSet.getString("NOMBRE"));
                almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
                listaAlmacenes.add(almacen);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return listaAlmacenes;
    }

    @Override
    public Integer modificar(AlmacenesDTO almacen) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = this.generarSQLParaModificacion();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, almacen.getNombre());
            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
            this.statement.setInt(3, almacen.getAlmacenId());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

    @Override
    public Integer eliminar(AlmacenesDTO almacen) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = this.generarSQLParaEliminacion();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, almacen.getAlmacenId());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

}
