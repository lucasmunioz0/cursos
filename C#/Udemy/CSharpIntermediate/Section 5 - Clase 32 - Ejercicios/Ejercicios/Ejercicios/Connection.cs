using System;

namespace Ejercicios
{
    public abstract class DbConnection
    {
        public string ConnectionString { get; private set; }
        public TimeSpan Timeout { get; private set; }

        protected DbConnection(string connectionString)
        {
            if(string.IsNullOrEmpty(connectionString))
                throw new ArgumentException("La conexión no puede ser nula o estar vacía");
            ConnectionString = connectionString;
        }

        public abstract void Open();

        public abstract void Close();
    }
}