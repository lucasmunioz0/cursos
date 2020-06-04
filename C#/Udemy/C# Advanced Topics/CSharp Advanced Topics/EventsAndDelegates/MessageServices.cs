using System;

namespace EventsAndDelegates
{
    public class MessageServices
    {
        public void OnVideoEncoded(object source, VideoEventArgs e)
        {
            Console.WriteLine($"MessageServices: Sending a text message... {e.Video.Title}");
        }
    }
}