using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab02_C_
{
    public class ObraTeatral : Evento
    {
        private int numeroActo;
        private bool requiereEscenografia;

        public int NumeroActo { get => numeroActo; set => numeroActo = value; }
        public bool RequiereEscenografia { get => requiereEscenografia; set => requiereEscenografia = value; }

        public ObraTeatral(string nombre, double costo, char publico, int numeroActo, bool requiereEscenografia): base(nombre, costo, publico)
        {
            this.NumeroActo = numeroActo;
            this.RequiereEscenografia= requiereEscenografia;
        }

        public override string ToString()
        {
            string cadena = base.ToString();
            cadena += "OBRA TEATRAL - NUM. ACTOS: ";
            cadena += this.NumeroActo.ToString();
            cadena += "\n";
            cadena += "REQ. ESCENOGRAFIA: ";
            cadena += this.RequiereEscenografia ? "SI" : "NO";
            cadena += "\n";
            cadena += "".PadLeft(50, 'X').Replace("X", "-"); //en java "-".repeat(50);
            cadena += "\n";
            return cadena;
        }
    }
}
