namespace RenameFiles
{
    partial class FrmMain
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblPath = new System.Windows.Forms.Label();
            this.txtPath = new System.Windows.Forms.TextBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
            this.txtNumber = new System.Windows.Forms.TextBox();
            this.lblNumbers = new System.Windows.Forms.Label();
            this.btnStart = new System.Windows.Forms.Button();
            this.lblOrderBy = new System.Windows.Forms.Label();
            this.rbName = new System.Windows.Forms.RadioButton();
            this.rbCreationTime = new System.Windows.Forms.RadioButton();
            this.rbLastWriteTime = new System.Windows.Forms.RadioButton();
            this.SuspendLayout();
            // 
            // lblPath
            // 
            this.lblPath.AutoSize = true;
            this.lblPath.Location = new System.Drawing.Point(69, 13);
            this.lblPath.Name = "lblPath";
            this.lblPath.Size = new System.Drawing.Size(60, 13);
            this.lblPath.TabIndex = 0;
            this.lblPath.Text = "Insert path:";
            // 
            // txtPath
            // 
            this.txtPath.Location = new System.Drawing.Point(136, 10);
            this.txtPath.Name = "txtPath";
            this.txtPath.Size = new System.Drawing.Size(294, 20);
            this.txtPath.TabIndex = 1;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(136, 36);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(294, 20);
            this.txtName.TabIndex = 3;
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(41, 39);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(88, 13);
            this.lblName.TabIndex = 2;
            this.lblName.Text = "Insert file\'s name:";
            // 
            // txtNumber
            // 
            this.txtNumber.Location = new System.Drawing.Point(136, 62);
            this.txtNumber.Name = "txtNumber";
            this.txtNumber.Size = new System.Drawing.Size(100, 20);
            this.txtNumber.TabIndex = 5;
            this.txtNumber.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtNumber_KeyPress);
            // 
            // lblNumbers
            // 
            this.lblNumbers.AutoSize = true;
            this.lblNumbers.Location = new System.Drawing.Point(32, 65);
            this.lblNumbers.Name = "lblNumbers";
            this.lblNumbers.Size = new System.Drawing.Size(97, 13);
            this.lblNumbers.TabIndex = 4;
            this.lblNumbers.Text = "Insert file\'s number:";
            // 
            // btnStart
            // 
            this.btnStart.Location = new System.Drawing.Point(355, 110);
            this.btnStart.Name = "btnStart";
            this.btnStart.Size = new System.Drawing.Size(75, 23);
            this.btnStart.TabIndex = 6;
            this.btnStart.Text = "Start";
            this.btnStart.UseVisualStyleBackColor = true;
            this.btnStart.Click += new System.EventHandler(this.btnStart_Click);
            // 
            // lblOrderBy
            // 
            this.lblOrderBy.AutoSize = true;
            this.lblOrderBy.Location = new System.Drawing.Point(59, 93);
            this.lblOrderBy.Name = "lblOrderBy";
            this.lblOrderBy.Size = new System.Drawing.Size(71, 13);
            this.lblOrderBy.TabIndex = 7;
            this.lblOrderBy.Text = "Order files by:";
            // 
            // rbName
            // 
            this.rbName.AutoSize = true;
            this.rbName.Checked = true;
            this.rbName.Location = new System.Drawing.Point(136, 91);
            this.rbName.Name = "rbName";
            this.rbName.Size = new System.Drawing.Size(53, 17);
            this.rbName.TabIndex = 8;
            this.rbName.TabStop = true;
            this.rbName.Text = "Name";
            this.rbName.UseVisualStyleBackColor = true;
            // 
            // rbCreationTime
            // 
            this.rbCreationTime.AutoSize = true;
            this.rbCreationTime.Location = new System.Drawing.Point(195, 91);
            this.rbCreationTime.Name = "rbCreationTime";
            this.rbCreationTime.Size = new System.Drawing.Size(90, 17);
            this.rbCreationTime.TabIndex = 9;
            this.rbCreationTime.Text = "Creation Time";
            this.rbCreationTime.UseVisualStyleBackColor = true;
            // 
            // rbLastWriteTime
            // 
            this.rbLastWriteTime.AutoSize = true;
            this.rbLastWriteTime.Location = new System.Drawing.Point(291, 91);
            this.rbLastWriteTime.Name = "rbLastWriteTime";
            this.rbLastWriteTime.Size = new System.Drawing.Size(99, 17);
            this.rbLastWriteTime.TabIndex = 10;
            this.rbLastWriteTime.Text = "Last Write Time";
            this.rbLastWriteTime.UseVisualStyleBackColor = true;
            // 
            // FrmMain
            // 
            this.AcceptButton = this.btnStart;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(442, 136);
            this.Controls.Add(this.rbLastWriteTime);
            this.Controls.Add(this.rbCreationTime);
            this.Controls.Add(this.rbName);
            this.Controls.Add(this.lblOrderBy);
            this.Controls.Add(this.btnStart);
            this.Controls.Add(this.txtNumber);
            this.Controls.Add(this.lblNumbers);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.lblName);
            this.Controls.Add(this.txtPath);
            this.Controls.Add(this.lblPath);
            this.MaximizeBox = false;
            this.Name = "FrmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Rename Files";
            this.Load += new System.EventHandler(this.FrmMain_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblPath;
        private System.Windows.Forms.TextBox txtPath;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.TextBox txtNumber;
        private System.Windows.Forms.Label lblNumbers;
        private System.Windows.Forms.Button btnStart;
        private System.Windows.Forms.Label lblOrderBy;
        private System.Windows.Forms.RadioButton rbName;
        private System.Windows.Forms.RadioButton rbCreationTime;
        private System.Windows.Forms.RadioButton rbLastWriteTime;
    }
}

