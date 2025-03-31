using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab2_C_
{
    public class Productora
    {
        private string nombre;
        private BindingList<Evento> listaEventos;

        public string Nombre { get { return nombre; } set { nombre = value; } }

        public Productora(string nombre) 
        {
            this.Nombre = nombre;
            this.listaEventos = new BindingList<Evento>();
        }

        internal void agregarEvento(Evento evento)
        {
            this.listaEventos.Add(evento);
        }

        public string ConsultarDatosEvento(int i)
        {
            return this.listaEventos[i].ToString();
        }

        public string ConsultarObrasTeatrales()
        {
            string textoReporte = "";
            foreach(Evento evento in this.listaEventos)
            {
                if (evento is ObraTeatral)
                    textoReporte += evento.ToString();
            }
            return textoReporte;
        }
    }
}
