using System;
using System.Windows.Forms;

namespace RenameFiles
{


    public partial class FrmMain : Form, IFilesInterface
    {
        private FileController _fileController;
        private OrderByEnum _orderBy;

        public FrmMain()
        {
            InitializeComponent();
        }

        private void FrmMain_Load(object sender, EventArgs e)
        {

        }

        private void btnStart_Click(object sender, EventArgs e)
        {
            try
            {
                var startPosition = Convert.ToInt32(txtNumber.Text);
                var directoryPath = txtPath.Text;
                var filesName = txtName.Text;
                OrderByChecked();
                _fileController.EnteredData(directoryPath, filesName, startPosition, _orderBy);
            }
            catch (Exception f)
            {
                ShowMessage(f.Message, TypeMessageEnum.ERROR);
            }
        }

        private void OrderByChecked()
        {
            if (rbName.Checked) _orderBy = OrderByEnum.NAME;
            if (rbCreationTime.Checked) _orderBy = OrderByEnum.CREATION_TIME;
            if (rbLastWriteTime.Checked) _orderBy = OrderByEnum.LAST_WRITE_TIME;
        }

        private void txtNumber_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar)) e.Handled = true;
        }

        public void ShowMessage(string message, TypeMessageEnum type)
        {
            switch (type)
            {
                case TypeMessageEnum.ERROR:
                    MessageBox.Show(message, $"Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    break;
                case TypeMessageEnum.INFORMATION:
                    MessageBox.Show(message, $"Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    break;
            }
        }

        public void RequestConfirmation()
        {
            var option = MessageBox.Show($"Confirm process.", $"Confirmation", MessageBoxButtons.YesNo, MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1, MessageBoxOptions.RightAlign, false);
            if (option == DialogResult.Yes) _fileController.Confirmed();
        }

        public void SetController(FileController fileController)
        {
            _fileController = fileController;
        }

        public void CleanAll()
        {
            txtPath.Text = "";
            txtName.Text = "";
            txtNumber.Text = "";
        }
    }
}
