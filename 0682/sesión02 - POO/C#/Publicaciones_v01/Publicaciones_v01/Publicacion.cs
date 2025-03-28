using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v01
{
    public class Publicacion
    {
        private string nombre;
        private string[] autores;
        private int cantidad_autores;
        private int año;

        public string Nombre { get => nombre; set => nombre = value; }
        public string[] Autores { get => autores; set => autores = value; }
        public int Cantidad_autores { get => cantidad_autores; set => cantidad_autores = value; }
        public int Año { get => año; set => año = value; }

        public Publicacion(string nombre, string autor, int año)
        {
            this.Nombre = nombre;
            this.Autores = new string[1];
            this.Autores[0] = autor;
            this.Cantidad_autores = 1;
            this.Año = año;
        }

        public Publicacion(string nombre, string[] autores, int año) {
            this.Nombre = nombre;
            this.Autores = autores;
            this.Cantidad_autores = autores.Length;
            this.Año = año;
        }

        public Publicacion(Publicacion publicacion)
        {
            this.Nombre = publicacion.Nombre;
            this.Autores = publicacion.Autores;
            this.Cantidad_autores = publicacion.Cantidad_autores;
            this.Año = publicacion.Año;
        }

        public void Referenciar()
        {
            Console.WriteLine(this);
        }

        public override string ToString()
        {
            string referencia = "[1] ";
            for (int i = 0; i < this.Autores.Length; i++)
            {
                if (i != 0)
                {
                    if (i == this.Cantidad_autores - 1)
                        referencia += " and ";
                    else
                        referencia += ", ";
                }
                referencia += this.Autores[i];
            }
            referencia += ". ";
            referencia += this.Nombre;
            referencia += ". ";
            referencia += this.Año;
            referencia += ".";
            return referencia;
        }
    }
}
