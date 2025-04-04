package pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones;

import pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.estandardAPA.Tesis;
import pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.estandardAPA.Articulo;

public class Publicaciones_v02 {

    public static void main(String[] args) {
        Publicacion publicaciones[] = new Publicacion[3];
        
//        Esta no es una solución elegante. 
//        Funcionaría pero no es un buen software              
//        if (esEstandarAPA){
//            publicaciones[0] = new pe.edu.pucp.inf30.sesiones.publicaciones01.publicacionesAPA.estandard.Articulo("A relational model of data for large shared data banks", "Codd, Edgar Frank", 1970, "Communications of the ACM", 13, 6, "junio");
//        }
//        else{
//            publicaciones[0] = new pe.edu.pucp.inf30.sesiones.publicaciones01.publicacionesIEEE.estandard.Articulo("A relational model of data for large shared data banks", "Codd, Edgar Frank", 1970, "Communications of the ACM", 13, 6, "junio");
//        }
        
        publicaciones[0] = new Articulo("A relational model of data for large shared data banks", "Codd, Edgar Frank", 1970, "Communications of the ACM", 13, 6, "junio");
        String autores[]= {"Gamma, Erich", "Helm, Richard", "Johnson, Ralph", "Vlissides, John"};        
        publicaciones[1] = new pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.estandardIEEE.Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1970, "1er edición", "Massachusetts", "Addison-Wesley Professional");
        publicaciones[2] = new Tesis("A system of logic based on ordinals", "Turing, Alan Mathison", 1938, Clase_de_Tesis.DOCTORADO, "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");                
        
        for (Publicacion publicacion : publicaciones) {
            publicacion.referenciar();
            Publicacion.orden_presentacion++;
        }
    }

}
