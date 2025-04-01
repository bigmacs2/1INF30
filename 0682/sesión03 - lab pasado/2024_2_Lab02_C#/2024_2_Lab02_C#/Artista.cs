using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab02_C_
{
    public class Artista
    {
        private string nombre;
        private string nacionalidad;
        private BindingList<Artista> integrantes;

        public string Nombre { get => nombre; set => nombre = value; }
        public string Nacionalidad { get => nacionalidad; set => nacionalidad = value; }        

        public Artista(string nombre, string nacionalidad)
        {
            this.Nombre = nombre;
            this.Nacionalidad = nacionalidad;
            this.integrantes = new BindingList<Artista>();
        }

        public void AgregarArtista(Artista artista)
        {
            this.integrantes.Add(artista);
        }

        public override string ToString()
        {
            string cadena = "ARTISTA: ";
            cadena += this.Nombre;
            return cadena;
        }
    }
}
