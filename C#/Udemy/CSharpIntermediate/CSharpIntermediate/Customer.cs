using System.Collections.Generic;
using System.Threading;

namespace CSharpIntermediate
{
    public class Customer
    {
        public int Id;
        public string Name;
        public readonly List<Order> Orders = new List<Order>();

        public Customer(int id)
        {
            Orders = new List<Order>();
        }

        public Customer(int id, string name): this(id)
        {
            this.Name = name;
        }

        public void Promot()
        {
            //Orders = new List<Order>();
        }
    }
}