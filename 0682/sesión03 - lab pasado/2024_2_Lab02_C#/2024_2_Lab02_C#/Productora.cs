using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2024_2_Lab02_C_
{
    public class Productora
    {
        private string nombre;
        private BindingList<Evento> listaEventos;

        public string Nombre { get => nombre; set => nombre = value; }

        public Productora(string nombre)
        {
            this.Nombre = nombre;
            this.listaEventos = new BindingList<Evento>();
        }

        public void AgregarEvento(Evento evento)
        {
            this.listaEventos.Add(evento);
        }

        public Evento ConsultarDatosEvento(int indice)
        {
            return this.listaEventos[indice];
        }

        public string ConsultarObrasTeatrales()
        {
            string texto = "";
            foreach(Evento evento in this.listaEventos)
            {
                if (evento is ObraTeatral)
                    texto += evento.ToString();
            }
            return texto;
        }
    }
}
