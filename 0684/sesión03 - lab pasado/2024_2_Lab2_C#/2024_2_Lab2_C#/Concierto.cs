using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab2_C_
{
    public class Concierto: Evento
    {
        private TipoConcierto tipo;
        private bool sePuedeGrabar;

        public TipoConcierto Tipo { get => tipo; set => tipo = value; }
        public bool SePuedeGrabar { get => sePuedeGrabar; set => sePuedeGrabar = value; }

        public Concierto(string nombre, double costo, char publico, TipoConcierto tipo, bool sePuedeGrabar): base(nombre, costo, publico)
        {
            this.Tipo = tipo;
            this.SePuedeGrabar= sePuedeGrabar;
        }

        public override string ToString()
        {
            string cadena = base.ToString();
            cadena += "CONCIERTO - TIPO: ";
            cadena += this.Tipo.ToString();
            cadena += "\n";
            cadena += "PERMISO GRABACION: ";
            cadena += this.SePuedeGrabar ? "SI" : "NO";
            cadena += "\n";
            cadena += "".PadLeft(50, 'X').Replace("X", "-"); //en java es "-".repeat(50);
            cadena += "\n";
            return cadena;
        }
    }
}
