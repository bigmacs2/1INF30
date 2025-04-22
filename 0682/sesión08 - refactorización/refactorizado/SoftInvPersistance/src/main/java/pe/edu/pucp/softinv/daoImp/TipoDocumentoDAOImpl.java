package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import pe.edu.pucp.softinv.dao.TipoDocumentoDAO;
import pe.edu.pucp.softinv.daoImp.util.Columna;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.TiposDocumentosDTO;

public class TipoDocumentoDAOImpl extends DAOImplBase implements TipoDocumentoDAO {

    public TipoDocumentoDAOImpl(){
        super("INV_TIPOS_DOCUMENTOS");
    }
    
    @Override
    protected void configurarListaDeColumna() {
        this.listaColumnas.add(new Columna("TIPO_DOCUMENTO_ID", true, false));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
    }
    
    @Override
    public Integer insertar(TiposDocumentosDTO tipoDocumento) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = this.generarSQLParaInsercion();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
            this.statement.setString(2, tipoDocumento.getNombre());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
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
    public Integer eliminar(TiposDocumentosDTO tipoDocumento) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = this.generarSQLParaEliminacion();
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
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
