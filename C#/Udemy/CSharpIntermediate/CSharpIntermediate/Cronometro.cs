using System;

namespace CSharpIntermediate
{
    public class Cronometro
    {
        public DateTime FechaInicio { get; private set; }
        public DateTime FechaFin { get; private set; }
        public bool Iniciado {get; private set; }

        public Cronometro()
        {
            Iniciado = false;
        }

        public void Start()
        {
            if (Iniciado) throw new InvalidOperationException("El cronómetro ya fue inicializado.");
            FechaInicio = DateTime.Now;
            Iniciado = true;
        }

        public void Stop()
        {
            if(!Iniciado) throw new InvalidOperationException("El cronómetro no fue inicializado.");
            FechaFin = DateTime.Now;
            Iniciado = false;
        }

        public TimeSpan Duracion()
        {
            if(Iniciado) throw new InvalidOperationException("El cronómetro no fue parado.");
            return (FechaFin - FechaInicio).Duration();
        }
       
    }
}