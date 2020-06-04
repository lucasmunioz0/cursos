using System;

namespace Delegates
{
    public class PhotoProcessor
    {
        //Se crea un delegado con la firma "void Nombre(Parametros)"
        public delegate void PhotoFilterHandler(Photo photo);


        //Versión utilizando un delegado propio.
        public void Process(string path, PhotoFilterHandler filterHandler)
        {
            var photo = Photo.Load(path);

            filterHandler(photo);

            //Esto sin utilizar delegados.
            //var filters = new PhotoFilters();
            //filters.ApplyBrightness(photo);
            //filters.ApplyConstrast(photo);
            //filters.Resize(photo);

            photo.Save();
        }


        //Versión utilizando delegado nativo de .Net
        public void Process(string path, Action<Photo> filterHandler)
        {
            var photo = Photo.Load(path);

            filterHandler(photo);

            photo.Save();
        }
    }
}