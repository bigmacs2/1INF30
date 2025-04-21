package pe.edu.pucp.softven.bo;

import pe.edu.pucp.softven.dao.ProductoDAO;
import pe.edu.pucp.softven.dao.daoImpl.ProductoDAOImpl;
import pe.edu.pucp.softven.model.ProductosDTO;


public class ProductoBO {

    private ProductoDAO productoDAO;
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public Integer insertar(String nombre, String descripcion, Double precio){
        ProductosDTO producto = new ProductosDTO();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        return this.productoDAO.insertar(producto);
    }
}
