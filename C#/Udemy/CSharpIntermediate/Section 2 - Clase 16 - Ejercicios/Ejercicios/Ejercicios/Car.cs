using System;

namespace Ejercicios
{
    public class Car : Vehicule
    {
        public Car(string registrationNumber) : base(registrationNumber)
        {
            Console.WriteLine($"Car is being initialized. {registrationNumber}");
        }
    }
}