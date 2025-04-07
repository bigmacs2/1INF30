using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones
{
    public interface AbstractFactoryPublicacion
    {
        Publicacion crearArticulo(string nombre, string nombre_completo_autor, int año, string revista, int volumen, int numero, string mes);

        Publicacion crearArticulo(string nombre, string[] nombres_completos_autores, int año, string revista, int volumen, int numero, string mes);

        Publicacion crearLibro(string nombre, string nombre_completo_autor, int año, string edicion, string lugar, string editorial);

        Publicacion crearLibro(string nombre, string[] nombres_completos_autores, int año, string edicion, string lugar, string editorial);

        Publicacion crearTesis(string nombre, string nombre_completo_autor, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado);

        Publicacion crearTesis(string nombre, string[] nombres_completos_autores, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado);
    }
}
