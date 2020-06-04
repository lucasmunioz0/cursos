using System;
using System.Collections;
using System.Collections.Generic;
using Amazon;

namespace Ejercicios
{
    public class Program
    {
        static void Main(string[] args)
        {
            var list = new ArrayList();
            list.Add(1);
            list.Add("Lucas");
            list.Add(DateTime.Today);

            var anotherList = new List<int>();
            var nombres = new List<string>();
            nombres.Add("");
        }

        private static void Post()
        {
            var opcion = 0;
            var post = new Post("Hola Mundo", "Esto es un hola mundo en C#");
            do
            {
                try
                {
                    Console.WriteLine("1 - Votar positivo.");
                    Console.WriteLine("2 - Votar negativo.");
                    Console.WriteLine("3 - Fecha de alta.");
                    Console.WriteLine("4 - Salir.");
                    Console.Write("Ingrese opción: ");
                    opcion = int.Parse(Console.ReadLine());

                    switch (opcion)
                    {
                        case 1:
                            post.UpVote();
                            Console.WriteLine($"Estado de votos del post: {post.Vote}");
                            break;
                        case 2:
                            post.DownVote();
                            Console.WriteLine($"Estado de votos del post: {post.Vote}");
                            break;
                        case 3:
                            Console.WriteLine(post.CreationDate);
                            break;
                        case 4:
                            Console.WriteLine("Programa finalizado.");
                            break;
                        default:
                            Console.WriteLine("Opción incorrecta.");
                            break;
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine("Exepción: " + e.Message);
                }

            } while (opcion != 4);
        }

        private static void Cronometro()
        {
            int? opcion = 0;
            var cronometro = new Cronometro();
            do
            {
                try
                {
                    Console.WriteLine("1 - Iniciar.");
                    Console.WriteLine("2 - Parar.");
                    Console.WriteLine("3 - Calcular tiempo");
                    Console.WriteLine("4 - Salir.");
                    Console.Write("Ingrese opción: ");
                    opcion = int.Parse(Console.ReadLine());

                    switch (opcion)
                    {
                        case 1:
                            cronometro.Start();
                            break;
                        case 2:
                            cronometro.Stop();
                            break;
                        case 3:
                            Console.WriteLine(cronometro.Duracion());
                            break;
                        case 4:
                            Console.WriteLine("Programa finalizado.");
                            break;
                        default:
                            Console.WriteLine("Opción incorrecta.");
                            break;
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine("Exepción: " + e.Message);
                }

            } while (opcion != 4);
        }
    }
}
