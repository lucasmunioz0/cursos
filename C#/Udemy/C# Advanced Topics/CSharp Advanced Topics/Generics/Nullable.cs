namespace Generics
{
    //Aplicando restricción de tipo de dato.
    public class Nullable<T> where T : struct
    {
        private object _value;

        public Nullable()
        {
            
        }
        public Nullable(T value)
        {
            _value = value;
        }

        public bool HasValue
        {
            get { return _value != null; }
        }

        public T GetValueOrDefault()
        {
            return HasValue ? (T) _value : default(T);
        }
    }
}