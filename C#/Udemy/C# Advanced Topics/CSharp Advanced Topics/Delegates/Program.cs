using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegates
{
    /*
     * Un delegado es un puntero que sabe como llamar a un método (o a un grupo de métodos).
     * Los delegados nos permiten crear aplicaciones o frameworks que son extensibles y muy flexibles.
     * Los métodos agregados a un delegado, deben respetar la firma con la cual se creo.
     * Cuando se crea un delegado, este hereda de la clase System.MulticastDelegate, a su vez
     * dicha clase hereda de System.Delegate en la cual tiene 2 propiedades públicas:
     *  - Method: Representa un método al cual apunta el delegado.
     *  - Target: Es la clase que contiene al método.
     *  
     * En vez de crear delegados propios, se pueden utilizar los que estan incluídos en el framework .Net:
     *  - System.Action: Tiene hasta 16 parámetros y se utiliza para métodos con retorno "void"
     *  - System.Func: Tiene alrededor de 18 parámetros y se utiliza para métodos que devuelven valores.
     *
    */
    class Program
    {
        //Versión utilizando delegado nativo de .Net
        static void Main(string[] args)
        {
            var processor = new PhotoProcessor();
            var filters = new PhotoFilters();

            Action<Photo> filterHandler = filters.ApplyBrightness;
            filterHandler += filters.ApplyConstrast;
            filterHandler += RemoveRedEyeFilter;

            processor.Process("photo.jpg", filterHandler);
            //processor.Process("photo.jpg");
        }

        //Creo un método propio respetando la firma del delegado y poder extender el framework.
        static void RemoveRedEyeFilter(Photo photo)
        {
            Console.WriteLine("Apply Remove Red Eye");
        }

        //Versión utilizando delegado propio.
        private static void MethodOne()
        {
            var processor = new PhotoProcessor();
            var filters = new PhotoFilters();

            PhotoProcessor.PhotoFilterHandler filterHandler = filters.ApplyBrightness;
            filterHandler += filters.ApplyConstrast;
            filterHandler += RemoveRedEyeFilter;

            processor.Process("photo.jpg", filterHandler);
            //processor.Process("photo.jpg");
        }
    }
}
