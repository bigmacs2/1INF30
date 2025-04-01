using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab02_C_
{
    public class Funcion
    {
        private DateTime fechaHora;

        public DateTime FechaHora { get => fechaHora; set => fechaHora = value; }

        public Funcion(DateTime fechaHora)
        {
            this.FechaHora = fechaHora;
        }

        public override string ToString()
        {
            string cadena = "FECHA: ";
            cadena += this.FechaHora;
            return cadena;
        }
    }
}
