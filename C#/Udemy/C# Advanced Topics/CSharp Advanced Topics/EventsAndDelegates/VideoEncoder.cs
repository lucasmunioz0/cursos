using System;
using System.Threading;

namespace EventsAndDelegates
{
    public class VideoEncoder
    {
        //1 - Definir el delegado
        //Convencion de nomenclatura, si el delegado esta contenido en la clase, agregar "EventHandler"
        //2 - Definir un evento basado en ese delegado
        //3 - Raise the event
        //Convencion, en .NET el método de levantar debe ser "protected", "virtual" y "void"
        //En cuanto a la nomenclatura, es "On" y el nombre del evento.


        //Primer paso
        //public delegate void VideoEncodedEventHandler(object source, EventArgs args);
        //public delegate void VideoEncodedEventHandler(object source, VideoEventArgs args);



        //Segundo Paso
        //public event VideoEncodedEventHandler VideoEncoded;
        public event EventHandler<VideoEventArgs> VideoEncoded;

        public void Encode(Video video)
        {
            Console.WriteLine("Encoding Video...");
            Thread.Sleep(3000);

            OnVideoEncoded(video);
        }

        //Tercer paso
        protected virtual void OnVideoEncoded(Video video)
        {
            if (VideoEncoded != null)
                VideoEncoded(this, new VideoEventArgs() {Video = video});
        }
    }
}