package pe.edu.pucp.softven.daoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softven.dao.ProductoDAO;
import pe.edu.pucp.softven.db.DBManager;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoDAOImpl implements ProductoDAO {

    private Connection conexion;
    private CallableStatement statement;
    protected ResultSet resultSet;

    @Override
    public Integer insertar(ProductosDTO producto) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO VEN_PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO) VALUES (?,?,?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, producto.getNombre());
            this.statement.setString(2, producto.getDescripcion());
            this.statement.setDouble(3, producto.getPrecio());
            //resultado = this.statement.executeUpdate();
            this.statement.executeUpdate();
            resultado = this.retornarUltimoAutoGenerado();
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

    public Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        try {
            String sql = "select @@last_insert_id as id";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar retornarUltimoAutoGenerado - " + ex);
        }
        return resultado;
    }

    @Override
    public ProductosDTO obtenerPorId(Integer productoId) {
        ProductosDTO producto = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT PRODUCTO_ID, NOMBRE, DESCRIPCION, PRECIO FROM VEN_PRODUCTOS WHERE PRODUCTO_ID = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, productoId);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                producto = new ProductosDTO();
                producto.setProductoId(this.resultSet.getInt("PRODUCTO_ID"));
                producto.setNombre(this.resultSet.getString("NOMBRE"));
                producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                producto.setPrecio(this.resultSet.getDouble("PRECIO"));
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
        return producto;
    }

    @Override
    public ArrayList<ProductosDTO> listarTodos() {
        ArrayList<ProductosDTO> listaProductos = new ArrayList<>();
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT PRODUCTO_ID, NOMBRE, DESCRIPCION, PRECIO FROM VEN_PRODUCTOS";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                ProductosDTO producto = new ProductosDTO();
                producto.setProductoId(this.resultSet.getInt("PRODUCTO_ID"));
                producto.setNombre(this.resultSet.getString("NOMBRE"));
                producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                producto.setPrecio(this.resultSet.getDouble("PRECIO"));
                listaProductos.add(producto);
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
        return listaProductos;
    }

    @Override
    public Integer modificar(ProductosDTO producto) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "UPDATE VEN_PRODUCTOS SET NOMBRE=?, DESCRIPCION=?, PRECIO=? WHERE PRODUCTO_ID=?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, producto.getNombre());
            this.statement.setString(2, producto.getDescripcion());
            this.statement.setDouble(3, producto.getPrecio());
            this.statement.setInt(4, producto.getProductoId());

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
    public Integer eliminar(ProductosDTO producto) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "DELETE FROM VEN_PRODUCTOS WHERE PRODUCTO_ID=?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, producto.getProductoId());
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
