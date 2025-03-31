using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab2_C_
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
            this.Nacionalidad= nacionalidad;
            this.integrantes = new BindingList<Artista>();
        }

        private Artista (Artista artista)
        {
            this.Nombre = artista.nombre;
            this.Nacionalidad = artista.nacionalidad;
            this.integrantes = new BindingList<Artista>();
            foreach(Artista artista1 in artista.integrantes)
            {
                Artista integrante = new Artista(artista1);
                this.integrantes.Add(integrante);
            }
        }

        public void agregarArtista(Artista artista)
        {
            //ojo ojo artista es una instancia (referencia)
            //this.integrantes.Add(artista);
            Artista artista_copia = new Artista(artista);
            this.integrantes.Add(artista_copia);
        }        

        public override string ToString()
        {
            string cadena = "ARTISTA: ";
            cadena += this.Nombre;
            return cadena;
        }
    }
    
}
