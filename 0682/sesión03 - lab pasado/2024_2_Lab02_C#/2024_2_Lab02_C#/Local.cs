using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab02_C_
{
    public class Local
    {
        private string nombre;
        private string direccion;
        private int capacidad;
        private TipoLocal tipo;

        public string Nombre { get { return nombre; } set { nombre = value; } }
        public string Direccion { get => direccion; set => direccion = value; }
        public int Capacidad { get => capacidad; set => capacidad = value; }
        public TipoLocal Tipo { get => tipo; set => tipo = value; }

        public Local(string nombre, string direccion, int capacidad, TipoLocal tipo)
        {
            this.Nombre = nombre;
            this.Direccion = direccion;
            this.Capacidad = capacidad;
            this.Tipo = tipo;
        }

        public override string ToString()
        {
            string cadena = "LOCAL: ";
            cadena += this.Nombre;
            cadena += " - CAPACIDAD: ";
            cadena += this.Capacidad.ToString();
            return cadena;
        }
    }
}
