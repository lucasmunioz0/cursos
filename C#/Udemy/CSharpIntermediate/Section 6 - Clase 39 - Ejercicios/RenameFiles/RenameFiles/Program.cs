using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RenameFiles
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            FrmMain filesInterface = new FrmMain();
            FileController fileController = new FileController(filesInterface);
            filesInterface.SetController(fileController);
            Application.Run(filesInterface);
        }
    }
}
