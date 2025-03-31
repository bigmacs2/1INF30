using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab2_C_
{
    public class ObraTeatral : Evento
    {
        private int numeroActos;
        private bool requiereEscenografia;

        public int NumeroActos { get => numeroActos; set => numeroActos = value; }
        public bool RequiereEscenografia { get => requiereEscenografia; set => requiereEscenografia = value; }

        public ObraTeatral(string nombre, double costo, char publico, int numeroActos, bool requiereEscenografia): base(nombre, costo, publico)
        {
            this.NumeroActos = numeroActos;
            this.RequiereEscenografia= requiereEscenografia;
        }

        public override string ToString()
        {
            string cadena = base.ToString();
            cadena += "OBRA TEATRAL - NUM. ACTOS: ";
            cadena += this.NumeroActos.ToString();
            cadena += "\n";
            cadena += "REQ ESCENOGRAFIA: ";
            cadena += this.RequiereEscenografia ? "SI" : "NO";
            cadena += "\n";
            cadena += "".PadLeft(50, 'X').Replace("X", "-"); //en java es "-".repeat(50);  
            cadena += "\n";
            return cadena;
        }
    }
}
