using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RenameFiles
{
    public class Result<T>
    {
        public IList<string> Messages { get; set; }
        public T Return { get; set; }

        public Result()
        {
            Messages = new List<string>();
        }

        public void AddErrorMessage(string message)
        {
            Messages.Add(message);
        }

        public bool Ok()
        {
            return !(Messages.Count > 0);
        }

        public override string ToString()
        {
            var sb = new StringBuilder();
            Messages.ToList().ForEach(x => sb.Append(x).Append("\n"));
            return sb.ToString();
        }
    }
}
