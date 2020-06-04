using System;

namespace Ejercicios
{
    public class Vehicule
    {
        private readonly string _registrationNumber;

        //public Vehicule()
        //{
        //    Console.WriteLine("Vehicule is being initialized.");
        //}

        public Vehicule(string registrationNumber)
        {
            _registrationNumber = registrationNumber;
            Console.WriteLine($"Vehicule is being initialized. {registrationNumber}");
        }
    }
}