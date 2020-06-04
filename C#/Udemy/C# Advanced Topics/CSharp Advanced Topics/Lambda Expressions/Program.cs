using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LambdaExpressions
{
    class Program
    {
        private static void Main(string[] args)
        {
            var books = new BookRepository().GetBooks();

            var chearpBooks = books.Where(book => book.Price < 10);

            foreach (var book in chearpBooks)
            {
                Console.WriteLine(book.Title);
            }
        }

        #region WithoutLambdaExpression
        static void MethodWithoutLambda()
        {
            var books = new BookRepository().GetBooks();

            var chearpBooks = books.FindAll(IsCheaperThan10Dollars);

            foreach (var book in chearpBooks)
            {
                Console.WriteLine(book.Title);
            }
        }

        static bool IsCheaperThan10Dollars(Book book)
        {
            return book.Price < 10;
        }
        #endregion
        //En vez de escribir el método, se lo puede reemplazar con un delegado y lambda
        static int Square(int number)
        {
            return number * number;
        }

        static void MethodOne()
        {
            //De esta forma decimos: 
            //Func porque debe retornar un valor
            //Primer parametro: es el que recibe el valor
            //Segundo el tipo de valor que va a retornar
            //Se le asigna una expresión lambda que reemplaza el código del método.
            Func<int, int> square = number => number * number;

            Console.WriteLine(square(5));

            const int factor = 5;
            Func<int, int> multipler = n => n * factor;
            var result = multipler(10);
            Console.WriteLine(result);
        }
    }
}
