using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    class Program
    {
        static void Main(string[] args)
        {
            System.Data.Common.DbConnection con = new System.Data.SqlClient.SqlConnection();
            System.Data.Common.DbCommand command = new SqlCommand();
            command.ExecuteReader();
        }
    }
}
