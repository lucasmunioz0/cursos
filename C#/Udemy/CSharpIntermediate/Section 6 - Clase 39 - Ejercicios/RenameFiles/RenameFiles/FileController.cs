using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RenameFiles
{
    public class FileController
    {
        private readonly IFilesInterface _filesInterface;
        private string _directoryPath;
        private string _filesName;
        private int _startPosition;
        private OrderByEnum _orderBy;
        private IList<FileInfo> _files;


        public FileController(IFilesInterface filesInterface)
        {
            _filesInterface = filesInterface;
            filesInterface.SetController(this);
            _files = new List<FileInfo>();
        }

        public void EnteredData(string directoryPath, string filesName, int startPosition, OrderByEnum orderBy)
        {
            _directoryPath = directoryPath;
            _filesName = filesName;
            _startPosition = startPosition;
            _orderBy = orderBy;

            _filesInterface.RequestConfirmation();
        }

        public void Confirmed()
        {
            var result = ValidateEnteredData();

            if (!result.Ok())
            {
                _filesInterface.ShowMessage(result.ToString(), TypeMessageEnum.ERROR);
                return;
            }

            try
            {
                OrderFilesBy();

                foreach (var file in _files)
                {
                    var newName = file.DirectoryName + @"\" + _filesName + " " + _startPosition + file.Extension;
                    if (!File.Exists(newName))
                    {
                        File.Move(file.FullName, newName);
                        _startPosition++;
                    }
                }
                _filesInterface.ShowMessage($"Completed", TypeMessageEnum.INFORMATION);
                _filesInterface.CleanAll();
            }
            catch (Exception e)
            {
                _filesInterface.ShowMessage(e.Message, TypeMessageEnum.ERROR);
            }

        }

        private Result<bool> ValidateEnteredData()
        {
            var result = new Result<bool>();
            try
            {
                if (!FileHelper.ValidateDirectoryPath(_directoryPath))
                    result.AddErrorMessage($"The {_directoryPath} is not a Directory.");
            }
            catch (ArgumentException exception)
            {
                result.AddErrorMessage(exception.Message);
            }
            if (string.IsNullOrEmpty(_filesName))
                result.AddErrorMessage(@"The file's name cannot be empty.");

            return result;
        }

        private void OrderFilesBy()
        {
            _files.Clear();
            var directory = Directory.GetFiles(_directoryPath);
            directory.ToList().ForEach(x => 
            _files.Add(new FileInfo(x)));
            switch (_orderBy)
            {
                case OrderByEnum.NAME:
                    _files = _files.OrderBy(x => x.Name).ToList();
                    break;
                case OrderByEnum.CREATION_TIME:
                    _files = _files.OrderBy(x => x.CreationTime).ToList();
                    break;
                case OrderByEnum.LAST_WRITE_TIME:
                    _files = _files.OrderBy(x => x.LastWriteTime).ToList();
                    break;
            }
        }
    }
}
