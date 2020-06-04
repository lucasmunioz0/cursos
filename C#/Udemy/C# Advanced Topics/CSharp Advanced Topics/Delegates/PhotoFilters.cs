using System;

namespace Delegates
{
    //public static delegate Photo;
    public class PhotoFilters
    {
        public void ApplyBrightness(Photo potho)
        {
            Console.WriteLine("Apply brightness");
        }

        public void ApplyConstrast(Photo potho)
        {
            Console.WriteLine("Apply constrast");
        }

        public void Resize(Photo potho)
        {
            Console.WriteLine("Apply resize");
        }
    }
}