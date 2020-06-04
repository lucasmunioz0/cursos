
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Reflection;
using System.Runtime.InteropServices;

namespace CSharpIntermediate
{
    public class EnumHelper
    {
        public static string GetDescription<T>(T enumerationValue)
            where T : struct
        {
            Type type = enumerationValue.GetType();
            if (!type.IsEnum)
            {
                throw new ArgumentException("EnumerationValue must be of Enum type", "enumerationValue");
            }

            //Tries to find a DescriptionAttribute for a potential friendly name
            //for the enum
            MemberInfo[] memberInfo = type.GetMember(enumerationValue.ToString());
            if (memberInfo != null && memberInfo.Length > 0)
            {
                object[] attrs = memberInfo[0].GetCustomAttributes(typeof(DescriptionAttribute), false);

                if (attrs != null && attrs.Length > 0)
                {
                    //Pull out the description value
                    return ((DescriptionAttribute)attrs[0]).Description;
                }
            }
            return enumerationValue.ToString();
        }
    }

    public enum PruebaEnum
    {
        HOLA = 1,
        [Description("Esto es un chau")]
        CHAU = 2,
        PEPE = 3,
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(EnumHelper.GetDescription(PruebaEnum.CHAU));



            //var shapes = new List<Shape>();
            //shapes.Add(new Circle() {Width = 100, Height = 100 });
            //shapes.Add(new Rectangle() { Width = 100, Height = 100 });
            //shapes.Add(new Triangle() { Width = 100, Height = 100 }); 
            //var canvas = new Canvas();
            //canvas.DrawShapes(shapes);

            //var logger = new Logger();
            //var dbMigrator = new DbMigrator(logger);
            //var installer = new Installer(logger);

            //dbMigrator.Migrate();
            //installer.Install();

            //var presentation = new PresentactionObject();
            //var text = new Text();
            //text.Width = 100;
            //text.Copy();
        }


        private static void UseOrders()
        {
            var customer = new Customer(1);
            customer.Orders.Add(new Order());
            customer.Orders.Add(new Order());

            customer.Promot();
            Console.WriteLine(customer.Orders.Count);
        }

        private static void UseParams()
        {
            var calculator = new Calculator();
            Console.WriteLine(calculator.Add(1, 2));
            Console.WriteLine(calculator.Add(1, 2, 3));
            Console.WriteLine(calculator.Add(1, 2, 3, 4));
            Console.WriteLine(calculator.Add(new int[] { 1, 2, 3, 4, 5 }));
        }

        static void UsePoints()
        {
            try
            {
                var point = new Point(10, 20);
                point.Move(null);
                Console.WriteLine("Point is at ({0}, {1})", point.X, point.Y);

                point.Move(100, 200);
                Console.WriteLine("Point is at ({0}, {1})", point.X, point.Y);
                Console.ReadLine();
            }
            catch (Exception)
            {
                Console.WriteLine("Ocurrió un error no esperado.");
            }
        }

        
    }
}
