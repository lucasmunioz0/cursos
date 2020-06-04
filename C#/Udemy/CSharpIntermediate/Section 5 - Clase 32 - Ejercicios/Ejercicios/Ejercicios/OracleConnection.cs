using System;

namespace Ejercicios
{
    public class OracleConnection : DbConnection
    {
        public OracleConnection(string connectionString) : base(connectionString)
        {
        }

        public override void Open()
        {
            Console.WriteLine("Abriendo conexión con Oracle");
        }

        public override void Close()
        {
            Console.WriteLine("Cerrando conexión con Oracle");
        }
    }
}