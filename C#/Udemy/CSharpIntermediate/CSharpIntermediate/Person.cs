using System;

namespace CSharpIntermediate
{
    public class Person
    {
        public DateTime FechaNacimiento { get; private set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }

        public Person(DateTime fechaNacimiento)
        {
            FechaNacimiento = fechaNacimiento;
        }
        public int Edad
        {
            get
            {
                var timeSpan = DateTime.Today - FechaNacimiento;
                var anios = timeSpan.Days / 365;
                return anios;
            }
        }
    }
}