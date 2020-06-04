using System;
using System.Xml;

namespace Ejercicios
{
    public class SendEmail : IActivity
    {
        public void Execute()
        {
            Console.WriteLine("Sending an email.");
        }
    }
}