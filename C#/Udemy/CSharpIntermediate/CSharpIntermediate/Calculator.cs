using System.Linq;

namespace CSharpIntermediate
{
    public class Calculator
    {
        public int Add(params int[] numbers)
        {
            var sum = 0;
            var sum2 = 0;
            numbers.ToList().ForEach(x => sum2 += x);
            foreach (var number in numbers)
            {
                sum += number;
            }

            return sum2;
        }
    }
}