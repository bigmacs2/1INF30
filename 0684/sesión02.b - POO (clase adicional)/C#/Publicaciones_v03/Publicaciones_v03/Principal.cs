using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v02
{
    public class Principal
    {
        static void Main(string[] args)
        {
            //no se puede instanciar una publicación pues ahora es una clase abstracta
            //Publicacion prueba = new Publicacion("xyz", "pedro", 2025);
            //prueba.Referenciar();
        
            //Publicacion publicacion = new Articulo("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970, "ACM Comm", 13, 6, "junio");
            //publicacion.Referenciar();

            //string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
            //publicacion = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1994, "1era edición", "Massachussets", "Wesley");
            //publicacion.Referenciar();

            //publicacion = new Tesis("Systems of Logic Based on Ordinals", "Alan Turing", 1938, "Tesis de doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");
            //publicacion.Referenciar();

            string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides" };
            Publicacion[] publicaciones = new Publicacion[3];
            publicaciones[0] = new Articulo("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970, "ACM Comm", 13, 6, "junio");
            publicaciones[1] = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1994, "1era edición", "Massachussets", "Wesley");
            publicaciones[2] = new Tesis("Systems of Logic Based on Ordinals", "Alan Turing", 1938, "Tesis de doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");

            for (int i = 0; i < publicaciones.Length; i++)
            {
                publicaciones[i].Referenciar();
                Publicacion.ORDEN_PRESENTACION++;
            }
        }
    }
}
