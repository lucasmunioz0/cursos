using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicios
{
    public class Stack
    {
        private readonly List<object> _stack = new List<object>();

        public Stack()
        {
            
        }

        public void Push(object obj)
        {
            if(obj == null) throw new InvalidOperationException("No se puede insertar un valor nulo a la pila");
            _stack.Add(obj);
        }

        public object Pop()
        {
            if(_stack.Count == 0) throw new InvalidOperationException("La pila está vacía");
            var result = _stack[_stack.Count - 1];
            _stack.RemoveAt(_stack.Count - 1);

            return result;
        }

        public void Clear()
        {
            _stack.Clear();
        }
    }
}
