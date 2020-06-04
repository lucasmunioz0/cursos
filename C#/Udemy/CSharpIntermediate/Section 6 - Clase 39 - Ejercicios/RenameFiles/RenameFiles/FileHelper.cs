using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RenameFiles
{
    public static class FileHelper
    {

        public static bool ValidateDirectoryPath(string path)
        {
            if(string.IsNullOrEmpty(path))
                throw new ArgumentException("The path cannot be empty.");
            return Directory.Exists(path);
        }
    }
}
