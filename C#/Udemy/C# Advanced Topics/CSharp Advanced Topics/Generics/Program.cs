using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Generics
{
    /*
     * Las clases genéricas reciben parámetros entre los paréntesis angulares. 
     * Se puede aplicar generics a un método, sin necesidad de que la clase sea genérica.
     * Hay 5 tipos de restricciones:
     *  where T : IComparable  -> Aplicando la restricción a que T implementa una interfaz.
     *  where T : Product      -> Aplicando la restricción a que T es de una clase o subclases.
     *  where T : struct       -> Aplicando la restricción a que T debe ser un tipo de valor.
     *  where T : class        -> Aplicando la restricción a una T debe ser una clase, o tipo de referencia.
     *  where T : new()        -> Aplicando la restricción a que T es un objeto que tiene el constructor por defecto.
     *  
    */
    class Program
    {
        static void Main(string[] args)
        {
            var number = new Nullable<int>();
            Console.WriteLine($"Has Value? {number.HasValue}");
            Console.WriteLine($"Value: {number.GetValueOrDefault()}");
        }

        private static void MethodOne()
        {
            var numbers = new GenericList<int>();
            numbers.Add(10);

            var books = new GenericList<Book>();
            books.Add(new Book());

            var dictionary = new GenericDictionary<string, Book>();
            dictionary.Add("1234", new Book());


        }
    }
}
