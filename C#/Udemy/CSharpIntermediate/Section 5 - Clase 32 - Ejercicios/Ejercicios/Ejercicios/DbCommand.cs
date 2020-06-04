using System;

namespace Ejercicios
{
    public class DbCommand
    {
        public DbConnection DbConnection { get; private set; }
        public string Command { get; private set; }

        public DbCommand(DbConnection dbConnection, string command)
        {
            if(dbConnection == null)
                throw new ArgumentException("La conexión no puede ser nula.");
            if (command == null)
                throw new ArgumentException("El comando no puede ser nulo.");
            DbConnection = dbConnection;
            Command = command;
        }

        public void Execute()
        {
            DbConnection.Open();
            Console.WriteLine("Corriendo la instrucción");
            DbConnection.Close();
        }
    }
}