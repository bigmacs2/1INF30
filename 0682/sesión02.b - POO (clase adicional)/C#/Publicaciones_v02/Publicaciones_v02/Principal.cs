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
            Publicacion publicacion = new Articulo("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970, "ACM Comm", 13, 6, "junio");
            publicacion.Referenciar();

            string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
            publicacion = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1994, "1era edición", "Massachussets", "Wesley");
            publicacion.Referenciar();

            publicacion = new Tesis("Systems of Logic Based on Ordinals", "Alan Turing", 1938, "Tesis de doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");
            publicacion.Referenciar();
        }
    }
}
