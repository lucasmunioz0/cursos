using System;

namespace Ejercicios
{
    public class SqlConnection : DbConnection
    {
        public SqlConnection(string connectionString) : base(connectionString)
        {
        }

        public override void Open()
        {
            Console.WriteLine("Abriendo conexión con SqlServer");
        }

        public override void Close()
        {
            Console.WriteLine("Cerrando conexión con SqlServer");
        }
    }
}