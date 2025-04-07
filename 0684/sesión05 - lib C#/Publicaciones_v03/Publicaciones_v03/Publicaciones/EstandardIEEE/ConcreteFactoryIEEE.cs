using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones.EstandardIEEE
{
    public class ConcreteFactoryIEEE : AbstractFactoryPublicacion
    {
        public Publicacion crearArticulo(string nombre, string nombre_completo_autor, int año, string revista, int volumen, int numero, string mes)
        {
            return new Articulo(nombre,  nombre_completo_autor,  año,  revista,  volumen,  numero,  mes);
        }

        public Publicacion crearArticulo(string nombre, string[] nombres_completos_autores, int año, string revista, int volumen, int numero, string mes)
        {
            return new Articulo( nombre, nombres_completos_autores,  año,  revista,  volumen,  numero,  mes);
        }

        public Publicacion crearLibro(string nombre, string nombre_completo_autor, int año, string edicion, string lugar, string editorial)
        {
            return new Libro(nombre, nombre_completo_autor,  año,  edicion,  lugar,  editorial);
        }

        public Publicacion crearLibro(string nombre, string[] nombres_completos_autores, int año, string edicion, string lugar, string editorial)
        {
            return new Libro(nombre,  nombres_completos_autores,  año,  edicion,  lugar,  editorial);
        }

        public Publicacion crearTesis(string nombre, string nombre_completo_autor, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado)
        {
            return new Tesis(nombre,  nombre_completo_autor,  año,  clase,  departamento,  institucion,  ciudad,  estado);
        }

        public Publicacion crearTesis(string nombre, string[] nombres_completos_autores, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado)
        {
            return new Tesis(nombre, nombres_completos_autores,  año,  clase,  departamento,  institucion,  ciudad,  estado);
        }
    }
}
