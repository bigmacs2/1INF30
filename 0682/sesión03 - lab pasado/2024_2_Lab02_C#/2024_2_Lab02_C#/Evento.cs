using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab02_C_
{
    public abstract class Evento
    {
        private static int secuencial = 1;
        private int identificador;
        private string nombre;
        private double costo;
        private char publico;

        private BindingList<Artista> listaArtistas;
        private Local local;
        private BindingList<Funcion> listaFunciones;

        public static int Secuencial { get => secuencial; set => secuencial = value; }
        public int Identificador { get => identificador; set => identificador = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public double Costo { get => costo; set => costo = value; }
        public char Publico { get => publico; set => publico = value; }
        public Local Local { get => local; set => local = value; }

        public Evento(string nombre, double costo, char publico)
        {
            this.Identificador = Evento.Secuencial++;
            this.Nombre = nombre;
            this.Costo = costo;
            this.Publico = publico;
            this.listaArtistas = new BindingList<Artista>();
            this.listaFunciones = new BindingList<Funcion>();
        }

        public void AgregarArtista(Artista artista)
        {
            this.listaArtistas.Add(artista);
        }

        public void AgregarFuncion(Funcion funcion)
        {
            this.listaFunciones.Add(funcion);
        }

        public override string ToString()
        {
            string cadena = "EVENTO Nro ";
            cadena += this.Identificador;
            cadena += "\n";
            cadena += "".PadLeft(50, 'X').Replace("X", "-"); //en java es repeat(50);
            cadena += "\n";
            cadena += "NOMBRE: ";
            cadena += this.Nombre;
            cadena += " - TIPO PUBLICO: ";
            cadena += this.Publico.ToString();
            cadena += "\n";
            for (int i = 0; i < this.listaArtistas.Count; i++)
            {
                cadena += "ARTISTA ";
                cadena += (i + 1);
                cadena += ": ";
                cadena += this.listaArtistas[i].ToString();
                cadena += "\n";
            }
            cadena += this.Local.ToString();
            cadena += "\n";
            for (int i = 0; i < this.listaFunciones.Count; i++)
            {
                cadena += "FUNCION ";
                cadena += (i + 1);
                cadena += ": ";
                cadena += this.listaFunciones[i].ToString();
                cadena += "\n";
            }
            return cadena;
        }
    }
}
