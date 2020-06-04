using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RenameFiles
{
    public interface IFilesInterface
    {
        void ShowMessage(string message, TypeMessageEnum type);
        void RequestConfirmation();
        void SetController(FileController fileController);
        void CleanAll();
    }
}
