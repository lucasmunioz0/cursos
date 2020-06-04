using System;
using System.Reflection.Emit;

namespace Ejercicios
{
    public class Post
    {
        public string Title { get; private set; }
        public string Descripction { get; private set; }
        public DateTime CreationDate { get; private set; }
        public int Vote { get; private set; }

        public Post(string title, string description)
        {
            CreationDate = DateTime.Now;
            Title = title;
            Descripction = description;
            Vote = 0;
        }

        public void UpVote()
        {
            Vote += 1;
        }

        public void DownVote()
        {
            Vote -= 1;
        }
    }
}