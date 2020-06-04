using System;

namespace Ejercicios
{
    public class ChangeStatus : IActivity
    {
        public void Execute()
        {
            Console.WriteLine("Changing status of the video to \"Processing\"");
        }
    }
}